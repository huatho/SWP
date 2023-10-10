<%-- 
    Document   : order
    Created on : 03-12-2022, 14:10:55
    Author     : MSII
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Shop Details</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="assets/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="assets/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/style.css" type="text/css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    </head>

    <body>
        <style>
            label {
                margin-bottom: 0;
            }

            /* Hide the checkboxes */
            input[type='radio'] {
                display: none;
            }

            /* Default styling for labels to make them look like buttons */
            input[type='radio']+label {
                display: inline-block;
                box-shadow: 1px 1px grey;
                background-color: #e0e0e0;
                padding: 0 40px;
                border-radius: 3px;
                font-family: Arial, Helvetica, sans-serif;
                cursor: pointer;
                margin-left: 16px;
                margin-top: 16px;
                margin-bottom: 16px;
            }

            /* Styling for labels when corresponding radio button is checked */
            input[type='radio']:checked+label {
                box-shadow: -1px -1px grey;
                background-color: #7fad39;
            }

            .modal-body p {
                margin: 0;
            }
            .shoping__cart__table table tbody tr td.shoping__cart__item {
                width: 190px;
                text-align: left;
            }
        </style>

        <jsp:include page="navbar.jsp"></jsp:include>
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
        <jsp:include page="category.jsp"></jsp:include>
            <!-- Breadcrumb Section End -->

            <!-- Shoping Cart Section Begin -->
            <section class="shoping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__table">

                                <table>
                                    <thead>
                                        <tr>
                                            <th class="shoping__product">Mã đơn hàng</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Ngày tạo</th>
                                            <th>Ngày giao</th>
                                            <th>Địa chỉ</th>
                                            <th>Tổng tiền</th>
                                            <th>Phương thức</th>
                                            <th>Trạng thái</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listShowOrder}" var="s">
                                        <tr>

                                            <td class="shoping__cart__item">
                                                ${s.orderID}
                                            </td>
                                            <td>
                                                <c:forEach items="${s.listProductName}" var="n">
                                                    <p>${n}</p>
                                                </c:forEach>
                                            </td>
                                            <td class="shoping__cart__Creat">
                                                ${s.foundedDate}
                                            </td>
                                            <c:if test="${s.status != 2}">
                                                <c:if test="${s.deliveryDate == null}">
                                                    <td class="shoping__cart__end">
                                                        3-4 days
                                                    </td>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${s.status != 2}">
                                                <c:if test="${s.deliveryDate != null}">
                                                    <td class="shoping__cart__end">
                                                        ${s.deliveryDate}
                                                    </td>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${s.status == 2}">
                                                <td class="shoping__cart__end">
                                                    Đã hủy
                                                </td>
                                            </c:if>
                                            <td class="shoping__cart__address">
                                                ${s.adress}   
                                            </td>

                                            <td class="shoping__cart__price">
                                                ${s.total}
                                            </td>

                                            <td class="shoping__cart__payway">
                                                ${s.paymentWay}
                                            </td>
                                            <c:if test="${s.status == 1}">
                                                <td class="shoping__cart__status">
                                                    Đợi phê duyệt
                                                </td>
                                                <td class="shoping__cart__status">
                                                    <a href="cancelOrder?id=${s.orderID}">
                                                        <span class="btn btn-sm btn-danger">
                                                            Cancel
                                                        </span>
                                                    </a>
                                                </td>
                                            </c:if>
                                            <c:if test="${s.status == 2}">
                                                <td class="shoping__cart__status">
                                                    Đã hủy
                                                </td>
                                            </c:if>
                                            <c:if test="${s.status == 3}">
                                                <td class="shoping__cart__status">
                                                    Đang giao hàng
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>


            </div>
        </section>
        <!-- Shoping Cart Section End -->

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
