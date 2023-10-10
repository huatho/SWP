<%-- 
    Document   : checkout
    Created on : Nov 26, 2022, 4:15:47 PM
    Author     : ADMIN
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
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="assets/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="assets/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="assets/css/style.css" type="text/css">
    </head>

    <body>

        <!-- Page Preloder -->
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
            <section class="hero hero-normal">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="hero__categories">
                                <div class="hero__categories__all">
                                    <i class="fa fa-bars"></i>
                                    <span>Danh mục</span>
                                </div>
                                <ul>
                                    <li><a href="#">Nam</a></li>
                                    <li><a href="#">Nữ</a></li>
                                    <li><a href="#">Quần</a></li>
                                    <li><a href="#">Áo</a></li>
                                    <li><a href="#">Váy</a></li>
                                    <li><a href="#">Áo khoác</a></li>
                                    <li><a href="#">Giày dép</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="hero__search">
                                <div class="hero__search__form">
                                    <form action="#">
                                        <div class="hero__search__categories">
                                            Danh mục
                                            <span class="arrow_carrot-down"></span>
                                        </div>
                                        <input type="text" placeholder="What do yo u need?">
                                        <button type="submit" class="site-btn">Tìm kiếm</button>
                                    </form>
                                </div>
                                <div class="hero__search__phone">
                                    <div class="hero__search__phone__icon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <div class="hero__search__phone__text">
                                        <h5>+84 9841 2548</h5>
                                        <span>support 24/7 time</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Hero Section End -->

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Checkout</h2>
                                <div class="breadcrumb__option">
                                    <a href="./index.html">Home</a>

                                    <span>Checkout</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <form action="order" >
            <!-- Checkout Section Begin -->
            <section class="checkout spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                            </h6>
                        </div>
                    </div>
                    <div class="checkout__form">
                        <h4>Chi tiết hóa đơn</h4>
                            <div class="row">
                                <div class="col-lg-8 col-md-6">
                                    <div class="checkout__input">
                                        <p>Tên người nhận<span>*</span></p>
                                        <input type="text" name="name" required>
                                    </div>

                                    <div class="checkout__input">
                                        <p>Địa chỉ<span>*</span></p>
                                        <input type="text" placeholder="Ví dụ: Đà Nẵng..." name="address" class="checkout__input__add" required>

                                    </div>
                                    <div class="checkout__input">
                                        <p>Số điện thoại<span>*</span></p>
                                        <input type="text" name="phone" required>
                                    </div>
<!--                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="text" value="{sessionScope.user.email.email}">
                                    </div>-->

<!--                                    <div class="checkout__input__checkbox">
                                        <label for="diff-acc">
                                            Ship to a different address?
                                            <input type="checkbox" id="diff-acc">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>-->
                                    <div class="checkout__input">
                                        <p>Order notes<span>*</span></p>
                                        <input type="text"
                                               placeholder="Notes about your order, e.g. special notes for delivery.">
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-6">
                                    <div class="checkout__order">
                                        <h4>Đơn hàng của bạn</h4>
                                        
                                        <div class="checkout__order__products">Sản phẩm</div>
                                    <c:set var="total" value="0"/>
                                        <c:forEach items="${listCheckout}" var="c">
                                            <c:set var="total" value="${total + c.total}"/>
                                        <ul>
                                            <li>${c.productName}x${c.amount} <span>${c.total}</span></li>
                                            <input name="orid" value="${c.cartID}" hidden>
<!--                                            <input name="total" value="{c.total}" hidden>-->
                                        </ul>
                                        </c:forEach>    
                                        <div class="checkout__order__subtotal">Phí ship <span>0đ</span></div>
                                        <div class="checkout__order__total">Tổng <span>${total}</span></div>
                                        <div class="checkout__input__checkbox">
                                             
                                        </div>
                                        <input type="hidden" name="total" value="${total}"/>

                                        <div class="checkout__input__checkbox" >
                                            <label for="payment">
                                                Thanh toán khi nhận hàng
                                                <input type="checkbox" id="payment" name="pay" value="Ship Cod" checked>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <button type="submit" class="site-btn">Đặt hàng</button>
                                    </div>
                                </div>   
                            </div>
                    </div>
                </div>
            </section>
            <!-- Checkout Section End -->
</form>
            <!-- Footer Section Begin -->
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

