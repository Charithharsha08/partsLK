$(document).ready(function () {
    $.ajax({
        url: 'http://localhost:8082/api/v1/shop/all',
        type: 'GET',
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        success: function (response) {
            console.log("success")
        },
        error: function (xhr) {
            console.log("error")
        }
    });
});


