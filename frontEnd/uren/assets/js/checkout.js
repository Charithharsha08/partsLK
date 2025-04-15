let cartItems = [];

$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8082/api/v1/user/get",
        method: "GET",
        contentType: "application/json",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        success: function (response) {
            console.log(response);
            $("#user-name").val(response.data.name);
            $("#user-email").val(response.data.email);
            $("#user-phone").val(response.data.mobile);
            $("#user-address").val(response.data.address);

             $.ajax({
        url: "http://localhost:8082/api/v1/cart/get",
        method: "GET",
        contentType: "application/json",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        success: function (response) {
            console.log(response);
            $("#cart-list").empty();

            let subtotal = 0;

            response.data.forEach(item => {

                cartItems.push({
                    itemId: item.itemId,
                    itemName: item.name,
                    itemQty: item.qty,
                    itemPrice: item.price
                });

                let total = item.price * item.qty;
                subtotal += total;
                $("#cart-list").append(`
                <tr data-cart-id="${item.cartId}" class="cart_item" >
                                            <td class="cart-product-name"> ${item.name}<strong class="product-quantity">
                                            × ${item.qty}</strong></td>
                                            <td class="cart-product-total"><span class="amount">${total}</span></td>
                                        </tr>
                                        
                `);
            });

            console.log("Subtotal:"+subtotal);

            $("#cart-subtotal").text(subtotal)
            $("#order-total").text(subtotal)


        },
        error: function (error) {
            console.log(error);
        }
    })
        },
        error: function (error) {
            console.log(error);
        }
    })
});

$("#place-order").click( function (e) {
    console.log("Form submitted");
    e.preventDefault();

    const shipToDifferent = $("#ship-box").is(":checked");

    // Common values
    const userDTO = {};
    const serviceDTOS = [];

    let paymentMethod = ""
    let orderStatus = ""

    if ($("#card-holder-name").val() !== "") {
        paymentMethod = "Card";
        orderStatus = "Paid";
    }else {
        paymentMethod = "Direct Bank Transfer";
        orderStatus = "Pending";
    }


    const note = $("#checkout-mess").val();

    let placePaymentDTO = {
        userDTO: userDTO,
        itemDTOS: cartItems,
        serviceDTOS: serviceDTOS,
        note: note,
        paymentMethod: paymentMethod,
        orderStatus: orderStatus
    };

    if (shipToDifferent) {
        placePaymentDTO.customerName = $("#another-user-name").val();
        placePaymentDTO.customerAddress = $("#another-user-address").val();
        placePaymentDTO.apartment = $("#another-apartment").val();
        placePaymentDTO.customerContact = $("#another-phone").val();
        placePaymentDTO.customerEmail = $("#another-email").val();
        placePaymentDTO.postCode = $("#another-postal").val();
        placePaymentDTO.city = $("#another-city").val();
        placePaymentDTO.country = $("#another-country").val();
    } else {
        placePaymentDTO.customerName = $("#user-name").val();
        placePaymentDTO.customerAddress = $("#user-address").val();
        placePaymentDTO.apartment = $("#apartment").val();
        placePaymentDTO.customerContact = $("#user-phone").val();
        placePaymentDTO.customerEmail = $("#user-email").val();
        placePaymentDTO.postCode = $("#postal").val();
        placePaymentDTO.city = $("#city").val();
        placePaymentDTO.country = $("#country").val();
    }

    console.log("Sending DTO:", placePaymentDTO);

    // AJAX request
    $.ajax({
        url: "http://localhost:8082/api/v1/placeOrder/save",
        type: "POST",
        contentType: "application/json",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        data: JSON.stringify(placePaymentDTO),
        success: function (response) {
            console.log("Success:", response);
            alert("Order placed successfully!");
        },
        error: function (xhr, status, error) {
            let data = xhr.responseJSON.data;
            console.log(data);
            console.log("Raw Error: ", xhr.responseText);
        }
    });
});


$("#login").click(function(e) {
    console.log("Login button clicked");
    $.ajax({
        url: "http://localhost:8082/api/v1/auth/authenticate",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            email: $("#email").val(),
            password: $("#password").val()
        }),
        success: function (response) {
            console.log(response);
            if (response.code === 201) {
                Swal.fire({
                    icon: 'success',
                    title: 'Login Successful!',
                    text: 'You have been logged in successfully.',
                    confirmButtonText: 'Okay'
                });
                console.log(response.data.token);
                localStorage.setItem("token", response.data.token);
                location.reload();

            }
        },
        error: function (xhr, status, error, response) {

            console.log(xhr.responseJSON.code)
            let data = xhr.responseJSON.data;


            if (data.email != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Login Failed!',
                    text: data.email,
                    confirmButtonText: 'Okay'
                });
            } else if (data.password != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Login Failed!',
                    text: data.password,
                    confirmButtonText: 'Okay'
                });
            } else if (xhr.responseJSON?.code === 401) {
                Swal.fire({
                    icon: 'error',
                    title: 'Login Failed!',
                    text: xhr.responseJSON.data || 'Unauthorized access!',
                    confirmButtonText: 'Okay'
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Error!',
                    text: 'An unexpected error occurred.',
                    confirmButtonText: 'Okay'
                });
            }
        }
    });
});