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
        console.log("Token is null");
        window.location.href = "../../partsLK/frontEnd/pages/register-page.html";
    }
});
$("#my-account-btn").click(function(e) {
    console.log("My Account button clicked");
    const token = localStorage.getItem("token");
    if (token){
        console.log("Token is not null");
        /* window.location.href = "../../partsLK/frontEnd/pages/my-account.html";*/
    }else {
        window.location.href = "../../partsLK/frontEnd/pages/login-page.html";
    }
});