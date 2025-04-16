$("#register").click(function(e) {
    e.preventDefault();
    console.log("Register button clicked");
    $.ajax({
        url: "http://localhost:8082/api/v1/user/register",
        method: "POST",
        contentType: "application/json", // Important if you're using @RequestBody in Spring
        data: JSON.stringify({
            name: $("#name").val(),
            email: $("#email").val(),
            mobile: $("#mobile").val(),
            address: $("#address").val(),
            nic: $("#nic").val(),
            dob: $("#dob").val(),
            password: $("#password").val(),
            role: "USER"
        }),
        success: function (response) {
            console.log(response);
            if (response.code === 201) {
                Swal.fire({
                    icon: 'success',
                    title: 'Registration Successful!',
                    text: 'You have been registered successfully.',
                    confirmButtonText: 'Okay'
                }).then((result) => {
                        if (result.isConfirmed) {
                            console.log(response.data.token);
                            localStorage.setItem("token",response.data.token);
                            window.location.href = "../../index.html";
                        }
                    })

            }
        },
        error: function (xhr, status, error, response) {
            let data = xhr.responseJSON.data;
            console.log(data);

            if (data.password != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.password,
                    confirmButtonText: 'Okay'
                });
            } else if (data.email != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.email,
                    confirmButtonText: 'Okay'
                });
            } else if (data.mobile != null) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: data.mobile,
                    confirmButtonText: 'Okay'
                });
            } else if (data.address != null) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Registration Failed!',
                        text: data.address,
                        confirmButtonText: 'Okay'
                    });
                }
            else
                if (data.nic != null) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Registration Failed!',
                        text: data.nic,
                        confirmButtonText: 'Okay'
                    });
                } else if (data.dob != null) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Registration Failed!',
                        text: data.dob,
                        confirmButtonText: 'Okay'
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Registration Failed!',
                        text: 'Something went wrong!',
                        confirmButtonText: 'Okay'
                    });
                }
            if (response.code === 406) {
                Swal.fire({
                    icon: 'error',
                    title: 'Registration Failed!',
                    text: response.message,
                    confirmButtonText: 'Okay'
                });
            }
            }


        });
    });
