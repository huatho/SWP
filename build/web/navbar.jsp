<%-- 
    Document   : navbar
    Created on : Dec 2, 2022, 2:11:07 PM
    Author     : PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i> fmarket@gmail.com</li>
                                    <li>Free Shipping for all Order of $99</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>

                                <c:if test="${sessionScope.user != null}">  

                                    <div class="header__top__right__account">
                                        <div>Hello ${sessionScope.user.name}</div>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="showOrder?sod=${sessionScope.user.id}">Đơn hàng</a></li>
                                            <!--<li><a href="#">Lịch sử</a></li>-->
                                            <c:if test="${sessionScope.user.roles == 3}">    
                                                <li><a href="profileCustomer?Accid=${sessionScope.user.id}">Cá Nhân</a></li>
                                                </c:if>
                                        </ul>
                                    </div>

                                    <div class="header__top__right__auth">
                                        <a href="logout"><i class="fa fa-outdent"></i> Logout</a>
                                    </div>
                                </c:if>

                                <c:if test="${sessionScope.user == null}">
                                    <div class="header__top__right__auth">
                                        <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">

                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="home">Home</a></li>
                                <!--<li><a href="./shop-grid.html">Shop</a></li>-->
                                <!--                            <li><a href="#">Pages</a>
                                                                <ul class="header__menu__dropdown">
                                                                    <li><a href="./shop-details.html">Shop Details</a></li>
                                                                    <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                                                                    <li><a href="./checkout.html">Check Out</a></li>
                                                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                                                </ul>
                                                            </li>-->
                                <li><a href="view-store">Store</a></li>
                                <c:if test="${sessionScope.user.roles == 2}">  
                                    <li><a href="view-product">My Store</a></li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
<!--                                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>-->
                                <li><a href="showCart?cid=${sessionScope.user.id}"><i class="fa fa-shopping-bag"></i></a></li>
                            </ul>
<!--                            <div class="header__cart__price"></span></div>-->
                        </div>
                    </div>,
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
    </body>
</html>
