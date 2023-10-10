<%-- 
    Document   : profileNoAdmin
    Created on : Dec 2, 2022, 3:05:26 PM
    Author     : PC
--%>


<%@page import="DAO.LoginDAO"%>
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
        <style>
            .card button {
                width: 133px;
                height: 30px;
            }
        </style>
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
                        <li class="nav-item">
                            <a class="nav-link" href="home">Quay lại</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>    
        <!--header-->
        <div style=" height: 100px;"></div>
        <div style=" height: 100px; width: 100%; text-align: center;"><h2 style=" color: #3CC032">Thông tin cá nhân</h2></div>
        <!-- Body Profile Start -->
        <div class="container">
            <div class="row">
                <c:if test="${sessionScope.user.roles == 2}"> <!-- Seller   -->
                    <div class="card">
                        <form action="sellerUploadImg" method="post" enctype="multipart/form-data">
                            <input name="noID" value="${no.id}" hidden>
                            <div class="card__img">
                                <c:if test="${no.avatar == null}">
                                    <img src="images/seller1.jpg" id="image"
                                         alt="">
                                </c:if>
                                <img src="${no.avatar}" id="image"
                                     alt="">
                            </div>
                            <div class="card__header" style="">
                                <h2>${sessionScope.user.acc} </h2>

                                <div style="margin-left: 110px;">
                                    <input type="file" name="file" id="imageFile" onchange="chooseFile(this)"
                                           accept="image/gif, image/jpeg, image/png"/>
                                </div>
                                <button type="submit">Update ảnh</button>

                            </div>

                            <div class="card__social">
                                <a href="">
                                    <i class="fa fa-facebook"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-youtube"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-linkedin"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-github"></i>
                                </a>
                            </div>
                            <button style="">
                                <a href="editPassword" style="color: white">Đổi mật khẩu <i class="fa fa-edit"></i></a>
                            </button>
                        </form>
                    </div>

                </c:if>

                <c:if test="${sessionScope.user.roles == 3}"> <!-- Customer   -->
                   <div class="card">
                        <form action="customerUploadImg" method="post" enctype="multipart/form-data">
                            <input name="noID" value="${no.id}" hidden>
                            <div class="card__img">
                                <c:if test="${no.avatar == null}">
                                    <img src="images/cus3.png" id="image"
                                         alt="">
                                </c:if>
                                <img src="${no.avatar}" id="image"
                                     alt="">
                            </div>
                            <div class="card__header" style="">
                                <h2>${sessionScope.user.acc} </h2>

                                <div style="margin-left: 110px;">
                                    <input type="file" name="file" id="imageFile" onchange="chooseFile(this)"
                                           accept="image/gif, image/jpeg, image/png"/>
                                </div>
                                <button type="submit">Update ảnh</button>

                            </div>

                            <div class="card__social">
                                <a href="">
                                    <i class="fa fa-facebook"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-youtube"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-linkedin"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-github"></i>
                                </a>
                            </div>
                            <button style="">
                                <a href="editPassword" style="color: white">Đổi mật khẩu <i class="fa fa-edit"></i></a>
                            </button>
                        </form>
                    </div>
                </c:if>

                <div style=" margin-top: 0" class="col-md-6 info__form">
                    <c:if test="${sessionScope.user.roles == 2}">  <!--Seller   -->
                        <form action="managerSeller" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <label>ID</label>
                                    <input name="noID" type="text" id="NameAccount" class="form-control" value="${sessionScope.user.id}" readonly>
                                </div>
                                
                                <div class="form-group">
                                    <label for="NameAccount">Tên người dùng</label>
                                    <input name="noName" type="text" id="NameAccount" class="form-control" value="${sessionScope.user.name}">
                                </div>
                                <div class="form-group">
                                    <label for="NameAccount">Số điện thoại</label>
                                    <input name="noPhone" type="phone" id="NameAccount" class="form-control" value="${sessionScope.user.phone}" required>
                                </div>
                                <div class="form-group">
                                    <label class="labels">Địa chỉ</label>
                                    <input name="noAdd" type="text" class="form-control" value="${sessionScope.user.address}" required>
                                </div>
                            </fieldset>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-info" value="Lưu thay đổi">
                            </div>
                        </form>
                    </c:if> 

                    <c:if test="${sessionScope.user.roles == 3}">  <!--Customer   -->
                        <form action="managerCus" method="post">
                            <fieldset>
 
                                <div class="form-group">
                                    <label>Email</label>
                                    <input name="noEmail" type="text" id="NameAccount" class="form-control" value="${sessionScope.user.email.getEmail()}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="NameAccount">Tên người dùng</label>
                                    <input name="noName" type="text" id="NameAccount" class="form-control" value="${sessionScope.user.name}" required>
                                </div>
                                <div class="form-group">
                                    <label for="NameAccount">Số điện thoại</label>
                                    <input name="noPhone" type="phone" id="NameAccount" class="form-control" value="${sessionScope.user.phone}" required>
                                </div>
                                <div class="form-group">
                                    <label for="NameAccount">Địa chỉ</label>
                                    <input name="noAdd" type="text" id="NameAccount" class="form-control" value="${sessionScope.user.address}"required>
                                </div>
                            </fieldset>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-info" value="Lưu thay đổi" >
                            </div>
                        </form>
                    </c:if>
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

        <script>
                                                function chooseFile(fileInput) {
                                                    if (fileInput.files && fileInput.files[0]) {
                                                        var reader = new FileReader();
                                                        reader.onload = function (e) {
                                                            $('#image').attr('src', e.target.result);
                                                        }
                                                        reader.readAsDataURL(fileInput.files[0]);
                                                    }
                                                }
        </script>
    </body>

</html>