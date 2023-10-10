<%-- 
    Document   : editPassword
    Created on : Dec 2, 2022, 3:25:52 PM
    Author     : PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>F-Market</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="assets/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="assets/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/style.css" type="text/css">
    
     <link rel="stylesheet" href="css/NoAdmin.css">
</head>

<body>
 <!--header-->
    <div class="admin-header">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li style="margin-left: 100px" class="nav-item active">
                        <a class="nav-link" href="home">Trang chủ<span class="sr-only">(current)</span></a>
                    </li>
                    <c:if test="${sessionScope.account.roles == 2}">
                    <li class="nav-item">
                        <a class="nav-link" href="profileSeller?Accid=${sessionScope.account.id}">Quay lại</a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.account.roles == 3}">
                    <li class="nav-item">
                        <a class="nav-link" href="profileCustomer?Accid=${sessionScope.account.id}">Quay lại</a>
                    </li>
                    </c:if>
              </ul>
            </div>
          </nav>
    </div>    
<!--header-->
<div style=" height: 100px;"></div>
<div style=" height: 100px; width: 100%; text-align: center;"><h2 style=" color: #3CC032">Đổi Mật khẩu</h2></div>
    <!-- Body Profile Start -->
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
                <div style=" margin-top: 0" class="col-md-6 info__form">
                    <form action="editPassword" method="post">   
                            
                            <div class="form-group">   
                                <label for="">Username:</label>
                                <input class="col-md-12" type="text" name="username" value="${sessionScope.user.acc}" placeholder="Username" readonly>
                            </div>    
                            <div class="form-group">                            
                                <label for="">Old Password:</label>
                                <input class="col-md-12" type="password" name="oldpass" id="" value="">
                            </div>
                            <p class="text-danger" style=" font-size: 1.2em; height: 6px">${m}</p>
                            <div class="form-group">                            
                                <label for="">New Password:</label>
                                <input class="col-md-12" type="password" name="newpass" id="" value="" >
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-info" value="Save">         
                            </div>
                    </form>            
                </div>                            
        </div>
    </div>

     <div style=" height: 150px; width: 100%"></div>
    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <!-- <div class="footer__about__logo">
                                <a href="./index.html"><img src="img/logo.png" alt=""></a>
                            </div> -->
                        <ul>
                            <li>Address: Đường Ngũ Hành Sơn Đà Nẵng VietNam</li>
                            <li>Phone: +84 9841 2548</li>
                            <li>Email: fmarket@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">

                        <ul>
                            <li><a href="#">Về chúng tôi</a></li>
                            <li><a href="#">Mua sắm an toàn</a></li>
                            <li><a href="#">Thông tin vận chuyển</a></li>
                            <li><a href="#">Chính sách bảo mật</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Chúng tôi là ai?</a></li>
                            <li><a href="#">Dịch vụ của chúng tôi</a></li>
                            <li><a href="#">Dự án</a></li>
                            <li><a href="#">Liên hệ</a></li>
                            <li><a href="#">Lời chứng thực</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Tham gia với chúng tôi</h6>
                        <p>Nhận thông báo mới nhất của chúng tôi qua mail.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Đăng kí</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">

                        <div class="footer__copyright__payment"><img src="assets/img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.js"></script>
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.nice-select.min.js"></script>
    <script src="assets/js/jquery-ui.min.js"></script>
    <script src="assets/js/jquery.slicknav.js"></script>
    <script src="assets/js/mixitup.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>