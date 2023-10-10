<%-- 
    Document   : changePass
    Created on : Dec 2, 2022, 3:50:17 PM
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
        <link rel="stylesheet" href="css/style.css">
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
        <title>Đặt lại mật khẩu</title>
        <style>
            body {
                background-image: url(https://images.unsplash.com/photo-1464618663641-bbdd760ae84a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
                background-repeat: no-repeat;
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
                            <a class="nav-link" href="home">Trang chủ <span class="sr-only">(current)</span></a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div> 
        <!--nav bar-->


        <div class="login">
            <div>
                <div class="content-login" style="margin-top: 10%; text-align: center; color: rgb(77, 77, 77);">
                    <h3 style="color: rgb(255, 255, 255); text-shadow: 0 2px 5px #393939;">Change PassWord</h3>
                </div>
                <div class=" rounded login-form border border-primary" style="background-color: rgba(255, 255, 255, 0.896);">
                    <form action="changePass" method="post">
                        
                        <label style="font-size: 1.2rem">Email</label>
                        <div class="input-box">
                            <input type="text" id="exampleInputAcount1"  placeholder="..." name="email" value="${sessionScope.authcode.email}" readonly>
                        </div>

                        <label for="exampleInputPassword1">Mật khẩu mới</label>
                        <div class="input-box">
                            <input class="password" placeholder="..." type="password" name="newpass" id="myInput" value="">
                            <span class="eye" onclick="myFunction()">
                                <i class="fa-solid fa-eye" id="show"></i>
                                <i class="fa-sharp fa-solid fa-eye-slash" id="hide"></i>
                            </span>
                        </div>
                        <div class="" style="text-align: center; margin-top: 5%;">
                            <button type="submit" class="btn btn-primary ">Thay đổi</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
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
    </body>
</html>