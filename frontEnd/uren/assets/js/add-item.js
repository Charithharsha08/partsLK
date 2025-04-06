$(document).ready(function () {
    let shopId;
    const token = localStorage.getItem("token");

    // Check if token is available
    if (!token || token.trim() === "" || token === "null") {
        Swal.fire({
            icon: 'error',
            title: 'Login Required!',
            text: 'Please login first',
            confirmButtonText: 'Okay'
        }).then(() => {
            window.location.href = "../pages/login-page.html";
        });
        return; // Stop further execution
    }

    // Fetch Shop ID
    $.ajax({
        url: 'http://localhost:8082/api/v1/shop/search',
        type: 'GET',
        headers: {
            "Authorization": "Bearer " + token
        },
        success: function (response) {
            shopId = response.data.shopId;
            console.log("Shop ID:", shopId);
            $("#shopId").val(shopId); // Set shopId in the hidden input
        },
        error: function (xhr) {
            let data = xhr.responseJSON?.data || "Something went wrong";
            console.log("Error fetching shopId:", data);
        }
    });
});

// Submit Form
$("#addItem").click(function (e) {
    e.preventDefault();
    const formData = new FormData($('#item-inputs')[0]);

    // Append shopId manually
    formData.append("shopId", $("#shopId").val());

    $.ajax({
        url: "http://localhost:8082/api/v1/item/save",
        method: "POST",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        data: formData,
        cache: false,
        processData: false,
        contentType: false,

        success: function (response) {
            console.log(response);
            if (response.code === 201) {
                Swal.fire({
                    icon: 'success',
                    title: 'Item Added!',
                    text: 'Item has been added successfully.',
                    confirmButtonText: 'Okay'
                }).then(() => {
                    window.location.href = "../pages/my-shop.html";
                });
            }
        },
        error: function (xhr) {
            console.log("Full Error Response:", xhr);

            console.log(xhr.responseJSON);

            let errorMessage = "Failed to add item."; // Default message

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



