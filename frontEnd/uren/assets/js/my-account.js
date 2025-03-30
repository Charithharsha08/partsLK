$("#login-btn").click(function(e) {
    console.log("Login button clicked");
    const token = localStorage.getItem("token");

    if (token){
        window.location.href = "../../partsLK/frontEnd/pages/my-account.html";
    }else {
        window.location.href = "../../partsLK/frontEnd/pages/login-page.html";
    }
});

$("#register-btn").click(function(e) {
    console.log("Register button clicked");
    const token = localStorage.getItem("token");

    if (token){
        window.location.href = "../../partsLK/frontEnd/pages/my-account.html";
    }else {
        window.location.href = "../../partsLK/frontEnd/pages/register-page.html";
    }
});
$("#my-account-btn").click(function(e) {
    console.log("My Account button clicked");
    const token = localStorage.getItem("token");

    console.log(token);

    if (token){
        window.location.href = "../../partsLK/frontEnd/pages/my-account.html";
    }else {
        window.location.href = "../../partsLK/frontEnd/pages/login-page.html";
    }
});
$("#account-logout-tab").click(function(e) {
    console.log("Logout button clicked");
    localStorage.removeItem("token");
    window.location.href = "../../partsLK/frontEnd/pages/login-page.html";
});

let currentpassword = "";

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
            // Assuming response.username exists
            $(".myaccount-dashboard b").text(response.data.name);
            $(".myaccount-dashboard a").text(response.data.name );
            $(".user-address").text(response.data.address);
            $("#account-details-name").val(response.data.name);
            $("#account-details-email").val(response.data.email);
            $("#account-details-mobile").val(response.data.mobile);
            $("#account-details-address").val(response.data.address);
            $("#account-details-nic").val(response.data.nic);
            $("#account-details-dob").val(response.data.dob);

            currentpassword = response.data.password;
        },
        error: function (error) {
            console.log("Error fetching user:", error);
        }
        })
    })

$("#save-changes").click(function(e) {
    e.preventDefault();
    console.log("Save changes button clicked");
    console.log(currentpassword);
     $.ajax({
            url: "http://localhost:8082/api/v1/user/update",
            method: "PUT",
            contentType: "application/json",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            },
         data: JSON.stringify({
             name: $("#account-details-name").val(),
             email: $("#account-details-email").val(),
             mobile: $("#account-details-mobile").val(),
             address: $("#account-details-address").val(),
             nic: $("#account-details-nic").val(),
             dob: $("#account-details-dob").val(),
             oldPassword: $("#account-details-oldpass").val(),
             newPassword: $("#account-details-newpass").val()
         }),
         success: function (response) {
                console.log(response);
                if (response.code === 200) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Changes Saved!',
                        text: 'Your changes have been saved successfully.',
                        confirmButtonText: 'Okay'
                    });
                }
            },
            error: function (error) {
                console.log("Error saving changes:", error);
            }
        })
});