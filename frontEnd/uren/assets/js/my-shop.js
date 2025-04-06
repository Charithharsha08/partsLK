document.getElementById('itemImage').addEventListener('change', function(event) {
    let fileName = event.target.files[0] ? event.target.files[0].name : "Choose Image";
    this.nextElementSibling.innerText = fileName;
});

$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8082/api/v1/shop/search",
        method: "GET",
        contentType: "application/json",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        success: function (response) {
            console.log(response);

            if (response.data && Object.keys(response.data).length > 0) {
                let shopId = response.data.shopId;

                // Populate the form fields
                $("#shop-id").val(shopId);
                $("#shop-name").val(response.data.shopName);
                $("#shop-address").val(response.data.shopAddress);
                $("#shop-contact").val(response.data.shopContact);
                $("#shop-email").val(response.data.shopEmail);
                $("#shop-owner").val(response.data.shopOwner);
                $("#shop-owner-contact").val(response.data.shopOwnerContact);
                $("#shop-owner-email").val(response.data.shopOwnerEmail);
                $("#shop-owner-nic").val(response.data.shopOwnerNIC);
                $("#shop-owner-dob").val(response.data.shopOwnerDOB);

                $.ajax({
                    url: "http://localhost:8082/api/v1/item/single-shop-all-item?shopId=" + shopId,
                    method: "GET",
                    contentType: "application/json",
                    headers: {
                        "Authorization": "Bearer " + localStorage.getItem("token")
                    },
                    success: function (response) {
                        console.log("Items fetched successfully:", response.data);
                        let productHTML = $(".all-product-in-shop");
                        productHTML.empty(); // Clear previous items

                        response.data.forEach(function (item) {
                            console.log(item.shopId);
                            let productCard = $(`
                                <div class="col-12 col-sm-6 col-md-4 d-flex"> <!-- 3 cards per row -->
            <div class="card shadow-sm border-0 rounded p-2 product-card w-100">
                <div class="text-center">
                    <img src="../${item.itemImage}" class="img-fluid product-image" alt="Product Image">
                </div>
                <div class="card-body">
                    <h5 class="card-title fw-bold">${item.itemName}</h5> <br>
                    <p class="text-muted">Item ID: ${item.itemId}</p>
                    <p class="text-muted"> Description: ${item.itemDescription}</p>
                    <p class="text-muted">Fuel Type: ${item.fuelType}</p>
                    <p class="text-muted">Qty: ${item.itemQty}</p>
                    <p><strong>Price:</strong> ${item.itemPrice}.00</p>
                    <p><strong>Shop ID:</strong> ${item.shopId}</p>
                </div>
                <div class="card-footer bg-white d-grid gap-2">
                    <button type="button" class="btn btn-warning update-btn" data-bs-toggle="modal" data-bs-target="#updateModal"
                        data-id="${item.itemId}" data-name="${item.itemName}" data-desc="${item.itemDescription}"
                        data-model="${item.vehicleModel}" data-fuel="${item.fuelType}" data-price="${item.itemPrice}"
                        data-qty="${item.itemQty}" data-shopid="${item.shopId}">
                        Update
                    </button>
                    <button class="btn btn-danger delete-item" data-id="${item.itemId}">Delete</button>
                </div>
            </div>
        </div>
                            `);

                            productHTML.append(productCard);
                        });

                        // Handle Update Button Click
                        $(".update-btn").on("click", function () {
                            $("#itemId").val($(this).data("id"));
                            $("#itemName").val($(this).data("name"));
                            $("#itemDescription").val($(this).data("desc"));
                            $("#vehicleModel").val($(this).data("model"));
                            $("#itemPrice").val($(this).data("price"));
                            $("#itemQty").val($(this).data("qty"));
                            $("#shopId").val($(this).data("shopid"));


                            let fuelType = $(this).data("fuel");
                            if (fuelType === "Petrol") {
                                $("#petrol").prop("checked", true);
                            } else if (fuelType === "Diesel") {
                                $("#diesel").prop("checked", true);
                            }
                        });
                    },
                    error: function (error) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Error Fetching Items',
                            text: 'An error occurred while fetching items.',
                            confirmButtonText: 'Okay'
                        });
                    }
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Error Fetching Shop Data',
                    text: 'No shop data found.',
                    confirmButtonText: 'Okay'
                });
            }
        },
        error: function (error) {
            Swal.fire({
                icon: 'error',
                title: 'Error Fetching Shop Data',
                text: 'An error occurred while fetching shop data.',
                confirmButtonText: 'Okay'
            });
        }
    });
});



$("#update-shop").click(function (e) {
    e.preventDefault();
    $.ajax({
        url: "http://localhost:8082/api/v1/shop/update",
        method: "PUT",
        contentType: "application/json",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        data: JSON.stringify({
            shopId: $("#shop-id").val(),
            shopName: $("#shop-name").val(),
            shopAddress: $("#shop-address").val(),
            shopContact: $("#shop-contact").val(),
            shopEmail: $("#shop-email").val(),
            shopOwner: $("#shop-owner").val(),
            shopOwnerContact: $("#shop-owner-contact").val(),
            shopOwnerEmail: $("#shop-owner-email").val(),
            shopOwnerNIC: $("#shop-owner-nic").val(),
            shopOwnerDOB: $("#shop-owner-dob").val(),


        }),
        success: function (response) {
            console.log(response);
            if (response.code === 200) {
                Swal.fire({
                    icon: 'success',
                    title: 'Update Successful!',
                    text: 'You have been Updated successfully.',
                    confirmButtonText: 'Okay'
                });
                console.log(response.data.token);
                localStorage.setItem("token", response.data.token);
                window.location.href = "../../index.html";
            }
        },
        error: function (xhr, status, error, response) {
            let data = xhr.responseJSON.data;
            console.log(data);

            if (data.shopName != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopName,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopAddress != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopAddress,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopContact != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopContact,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopEmail != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopEmail,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwner != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopOwner,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerContact != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopOwnerContact,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerEmail != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopOwnerEmail,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerNIC != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopOwnerNIC,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerDOB != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Update Failed!',
                    text: data.shopOwnerDOB,
                    confirmButtonText: 'Okay'
                });
            }
        }
    });
});

$("#shop-all-product").click(function (e) {
    e.preventDefault();

});

$(document).on("click", ".delete-item", function (e) {
    e.preventDefault();

    let itemId = $(this).data("id");  // Get the item ID from the button

    Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#3085d6",
        confirmButtonText: "Yes, delete it!"
    }).then((result) => {
        if (result.isConfirmed) {
            // If user confirms, send DELETE request
            $.ajax({
                url: "http://localhost:8082/api/v1/item/delete/" + itemId,
                method: "DELETE",
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                },
                success: function (response) {
                    Swal.fire({
                        icon: "success",
                        title: "Deleted!",
                        text: "Item has been deleted.",
                        confirmButtonText: "OK"
                    });

                    // Remove the item from UI
                    $(`button[data-id="${itemId}"]`).closest(".product-card").remove();
                },
                error: function (xhr) {
                    let data = xhr.responseJSON?.data;
                    Swal.fire({
                        icon: "error",
                        title: "Delete Failed!",
                        text: data?.itemName || "An error occurred.",
                        confirmButtonText: "Okay"
                    });
                }
            });
        }
    });
});

$(document).on("click", "#update-item", function (e) {
    e.preventDefault();
    const formData = new FormData($('#item-inputs')[0]);
    console.log("shop id "  + $("#shopId").val());

    // Append shopId manually
    formData.append("shopId", $("#shopId").val());

    $.ajax({
        url: "http://localhost:8082/api/v1/item/update",
        method: "PUT",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        data: formData,
        cache: false,
        processData: false,
        contentType: false,

        success: function (response) {
            console.log(response);
            if (response.code === 200) {
                Swal.fire({
                    icon: 'success',
                    title: 'Item Updated!',
                    text: 'Item has been Updated successfully.',
                    confirmButtonText: 'Okay'
                }).then(() => {
                    window.location.href = "../pages/my-shop.html";
                });
            }
        },
        error: function (xhr) {
            console.log("Full Error Response:", xhr);

            console.log(xhr.responseJSON);

            let errorMessage = "Failed to Update item."; // Default message

            // Check if the response contains a message
            if (xhr.responseJSON?.message) {
                errorMessage = xhr.responseJSON.message; // Use the backend message
            } else if (xhr.status === 413) {
                errorMessage = "File size exceeds the maximum upload limit! Please upload a smaller file.";
            } else if (xhr.status === 406) {
                errorMessage = "Not Acceptable! The request could not be processed.";
            } else if (xhr.status === 0) {
                errorMessage = "Failed to connect to the server. Possible CORS issue or server down!";
            } else if (xhr.status === 403) {
                errorMessage = "You are not authorized to perform this action.";
            } else if (xhr.status === 404) {
                errorMessage = "API endpoint not found! Check the server URL.";
            } else if (xhr.status === 500) {
                errorMessage = "Internal Server Error! Please try again later.";
            }
            // Show the error in a SweetAlert popup
            Swal.fire({
                icon: 'error',
                title: 'Item Add Failed!',
                text: errorMessage,
                confirmButtonText: 'Okay'
            });
        }
    });
});
