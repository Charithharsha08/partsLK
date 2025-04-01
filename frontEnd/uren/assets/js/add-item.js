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
                    window.location.href = "../../index.html";
                });
            }
        },
        error: function (xhr) {
            let data = xhr.responseJSON?.data;
            console.log("Error Response:", data);

            let errorMessage = data?.itemName || data?.itemPrice || data?.itemDescription || "Failed to add item.";

            // Check if the error is due to file size
            if (xhr.status === 413) {
                errorMessage = "File size exceeds the maximum upload limit! Please upload a smaller file.";
            }

            Swal.fire({
                icon: 'error',
                title: 'Item Add Failed!',
                text: errorMessage,
                confirmButtonText: 'Okay'
            });
        }
    });
});

