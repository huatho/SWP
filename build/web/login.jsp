<%-- 
    Document   : login
    Created on : Dec 2, 2022, 2:50:00 PM
    Author     : PC
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--icon-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--icon-->
        <!--bootstrap-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--bootstrap-->
        <!--Css-->
        <link rel="stylesheet" href="css/login.css">
        <!--Css-->
        <!--JSV-->
        <script src="https://kit.fontawesome.com/3aa40a242b.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!--JSV-->
        <!--style form-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">
        <!--style form-->
        <title>Đăng nhập</title>
        <style>
            body {
                background-image: url(https://images.unsplash.com/photo-1464618663641-bbdd760ae84a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
                background-position: center;
                background-size: cover;
            }
        </style>
    </head>
    <body>

        <!--nav bar-->
        <div class="top-login">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a style="margin-left: 50px" class="nav-link" href="home">Trang chủ <span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <!--nav bar-->
        <!--form đăng nhập-->
        <div>
            <div class="login">
                <div class="content-login" style="margin-top: 5%;text-align: center; color: rgb(77, 77, 77);">
                    <h3>Đăng nhập</h3>
                </div>
                <div class="login-form border border-primary" style="margin: 2% 30%;
                    padding: 2% 2%;
                    box-shadow: 0 5px 20px rgba(105, 105, 105, 0.845);
                    background-color: rgba(255, 255, 255, 0.8);">
                    <form action="loginController" method="post">
                        <label for="exampleInputEmail1">Tên tài khoản</label>
                        <div class="input-box">
                            <input  type="text" class="username" id="exampleInputAcount1" aria-describedby="account" placeholder="..." name="account">
                        </div>

                        <label for="exampleInputPassword1">Mật khẩu</label>
                        <div class="input-box">
                            <input class="password" placeholder="..." type="password" name="pass" id="myInput">
                            <span class="eye" onclick="myFunction()">
                                <i class="fa-solid fa-eye" id="show"></i>
                                <i class="fa-sharp fa-solid fa-eye-slash" id="hide"></i>
                            </span>
                        </div>
                        <p class="text-danger" style=" font-size: 1.2em">${mess}</p>
                        <div class="form-group" style="text-align: right; margin-top: 5%;">
                            <small id="accountHelp" class="form-text text-muted"><a style="font-size: 1.5em" href="take_email.jsp">Quên mật khẩu ?</a></small> 
                        </div>
                        <div class="" style=" text-align: center;">
                            <input style="font-size: 1.2em; padding-left: 20px; padding-right: 20px" type="submit" class="btn btn-primary " value="Login">
                        </div>
                        <div class="form-group" style="text-align: center; margin-top: 5%;">
                            <h6 style="font-size: 1.5em;">Đăng ký tài khoản</h6>
                            <a style="font-size: 1.5em" href="register.jsp">NGƯỜI DÙNG MỚI</a>
                        </div>
                        <!--social-->
                        <div class="" style="text-align: center ; margin-top: 2%;">
                            <small id="accountHelp" class="form-text text-muted" style="padding-bottom: 2%; font-size: 1em;">Hoặc đăng nhập bằng</small> 
                            <div class="social-login">

                                <fb:login-button size="xlarge" scope="public_profile,email" onlogin="checkLoginState();" ></fb:login-button>

                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/MoocProject/LoginGoogleHandler&response_type=code&client_id=1048107053599-ep3rpeid2clmq59qlqtrr8nhh29520dg.apps.googleusercontent.com&approval_prompt=force"><i class="fa-brands fa-google" style="font-size: 250%; padding-left: 15px"></i></a>
                            </div>
                        </div>
                        <!--social-->
                    </form>
                </div>
            </div>
        </div>

        <script>
            // This is called with the results from from FB.getLoginStatus().
            function statusChangeCallback(response) {
                console.log('statusChangeCallback');
                console.log(response);
                console.log(response.authResponse.accessToken);
                alert(response.authResponse.accessToken);
                if (response.status === 'connected') {
                    window.location.href = 'register_loginFB.jsp?access_token=' + response.authResponse.accessToken;
                } else {
                    // The person is not logged into your app or we are unable to tell.
                    document.getElementById('status').innerHTML = 'Please log ' +
                            'into this app.';
                }
            }
            // This function is called when someone finishes with the Login
            // Button. See the onlogin handler attached to it in the sample
            // code below.
            function checkLoginState() {
                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });
            }
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '783989646013292',
                    cookie: true, // enable cookies to allow the server to access 
                    // the session
                    xfbml: true, // parse social plugins on this page
                    version: 'v2.8' // use graph api version 2.8
                });
                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });
            };
            // Load the SDK asynchronously
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "https://connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        <script>
            function myFunction() {
                var x = document.getElementById("myInput");
                var y = document.getElementById("show");
                var z = document.getElementById("hide");

                if (x.type === 'password') {
                    x.type = "text";
                    y.style.display = "none";
                    z.style.display = "block";
                } else {
                    x.type = "password";
                    y.style.display = "block";
                    z.style.display = "none";
                }
            }


        </script>
        <!--form đăng nhập-->
    </body>
</html>