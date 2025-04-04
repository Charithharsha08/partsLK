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

            // Check if response.data is a non-empty object
            if (response.data && Object.keys(response.data).length > 0) {
                console.log(response.data)
                        $("#shop-id").val(response.data.shopId)
                        $("#shop-name").val(response.data.shopName)
                        $("#shop-address").val(response.data.shopAddress)
                        $("#shop-contact").val(response.data.shopContact)
                        $("#shop-email").val(response.data.shopEmail)
                        $("#shop-owner").val(response.data.shopOwner)
                        $("#shop-owner-contact").val(response.data.shopOwnerContact)
                        $("#shop-owner-email").val(response.data.shopOwnerEmail)
                $("#shop-owner-nic").val(response.data.shopOwnerNIC)
                $("#shop-owner-dob").val(response.data.shopOwnerDOB)





            } else {
;
            }
        },
        error: function (error) {
            console.log("Error fetching user:", error);
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