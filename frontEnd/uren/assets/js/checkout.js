$(document).ready(function () {
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