$("#login").click(function(e) {
    e.preventDefault(); // Prevent form default
    $.ajax({
        url: "http://localhost:8082/api/v1/auth/authenticate",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            email: $("#email").val(),
            password: $("#password").val()
        }),
        success: function (response) {
            if (response.code === 201) {
                Swal.fire({
                    icon: 'success',
                    title: 'Login Successful!',
                    text: 'You have been logged in successfully.',
                    confirmButtonText: 'Okay'
                });
                localStorage.setItem("token", response.data.token);
                window.location.href = "../../index.html";
            }
        },
        error: function (xhr) {
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