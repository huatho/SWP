<%-- 
    Document   : register
    Created on : Dec 2, 2022, 3:00:15 PM
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
        <title>Đăng ký thành viên của cộng đồng affliate</title>
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
        <div class="top-login" action="register"> 
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="home">Trang chủ <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="loginController">Trở lại</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
        <!--nav bar-->
        <!--form đăng nhập-->
        <div class="login">
            <div class="">
                <div class="content-login" style="margin-top: 5%; text-align: center; color: rgb(77, 77, 77);">
                    <h3>Đăng ký</h3>
                </div>
                <div class="login-form border border-primary">
                    <form action="register" method="post">

                        <div class="form-group">
                            <label for="exampleInputEmail1">Tên tài khoản</label>
                            <input name="user"  type="account" class="form-control" id="exampleInputAcount1" aria-describedby="account" placeholder="...">
                        </div>
                        <p class="text-danger" style=" font-size: 1.2em">${messe}</p>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Mật khẩu</label>
                            <input name="pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="***" required>
                            <small id="passwordHelpInline" class="text-muted">
                                Tối thiểu 6 ký tự.
                            </small>
                        </div>
                        <p class="text-danger" style=" font-size: 1.2em">${passWarning}</p>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Nhập lại mật khẩu</label>
                            <input name="repass" type="password" class="form-control" id="exampleInputPassword1" placeholder="***" required>                   
                        </div>
                        <p class="text-danger" style=" font-size: 1.2em">${messages}</p>
                        <div class="form-group">
                            <label for="inputEmail4">Email</label>
                            <input name="email" type="email" class="form-control" id="inputEmail4" placeholder="Email" required>
                        </div>
                      
                        <div class="custom-control custom-checkbox my-1 mr-sm-2">
                            <input type="checkbox" class="custom-control-input" id="customControlInline">
                            <label class="custom-control-label" for="customControlInline">Tôi đã đọc kỹ và chấp nhận <a href="#">điều khoản dịch vụ</a>.</label>
                        </div>
                        <div class="" style="text-align: center; margin-top: 5%;">
                            <button type="submit" class="btn btn-primary ">Đăng ký</button>
                        </div>
                        <!--social-->
                        <div class="" style="text-align: center ; margin-top: 2%;">

                            <small id="accountHelp" class="form-text text-muted" style="padding-bottom: 2%; font-size: 1.2rem">Hoặc đăng ký bằng</small> 
                            <div class="social-login">
                                <a href="#"><i class="fa-brands fa-facebook"></i></a>
                                <a href="#"><i class="fa-brands fa-google"></i></a>
                            </div>
                        </div>
                        <!--social-->
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>