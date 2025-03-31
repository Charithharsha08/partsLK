$("#registerShop").click (function(e) {
    e.preventDefault();
    console.log("Register Shop button clicked");
    $.ajax({
        url: "http://localhost:8082/api/v1/shop/save",
        method: "POST",
        contentType: "application/json",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        data: JSON.stringify({
            shopName: $("#shopName").val(),
            shopAddress: $("#shopAddress").val(),
            shopContact: $("#shopContact").val(),
            shopEmail: $("#shopEmail").val(),
            shopOwner: $("#shopOwner").val(),
            shopOwnerContact: $("#shopOwnerContact").val(),
            shopOwnerEmail: $("#shopOwnerEmail").val(),
            shopOwnerNIC: $("#shopOwnerNIC").val(),
            shopOwnerDOB: $("#shopOwnerDOB").val(),


        }),
        success: function (response) {
            console.log(response);
            if (response.code === 201) {
                Swal.fire({
                    icon: 'success',
                    title: 'Registration Successful!',
                    text: 'You have been registered successfully.',
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
                    title: 'Registration Failed!',
                    text: data.shopName,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopAddress != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopAddress,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopContact != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopContact,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopEmail != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopEmail,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwner != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopOwner,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerContact != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopOwnerContact,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerEmail != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopOwnerEmail,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerNIC != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopOwnerNIC,
                    confirmButtonText: 'Okay'
                });
            } else if (data.shopOwnerDOB != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.shopOwnerDOB,
                    confirmButtonText: 'Okay'
                });
            }
        }
    });
});