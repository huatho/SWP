<%-- 
    Document   : take_email
    Created on : Dec 2, 2022, 3:30:44 PM
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
    <title>Verify</title>
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
            <li class="nav-item">
              <a class="nav-link" href="login.jsp">Trở lại</a>
            </li>
          </ul>
        </div>
      </nav>
</div> 
<!--nav bar-->

<div class="login">
    <div class="">
        <div class="content-login" style="margin-top: 10%; text-align: center; color: rgb(77, 77, 77);">
          <h3 style="color: rgb(255, 255, 255); text-shadow: 0 2px 5px #393939;">Verify Email</h3>
        </div>
        <div class=" rounded login-form border border-primary" style="background-color: rgba(255, 255, 255, 0.896);">
            <form action="VerifyCode" method="post">
                <div class="form-group">
                  <label for="inputEmail">Nhập mã Code</label>
                  <input type="text" class="form-control" required placeholder="" name="verifyCode">
                  <p class="text-danger" style=" font-size: 1.2em">${mes}</p>
                </div>
                <div style="text-align: center; margin-bottom: 4%;">
                  <a href="home.jsp">Quay về trang chủ</a>
                </div>
                <div style="text-align: center;">
                    <button type="submit" class="btn btn-primary" value="Register">Xác nhận</button>
                </div>
                
            </form>
        </div>
      </div>
</div>
<!--form đăng nhập-->
</body>
</html>