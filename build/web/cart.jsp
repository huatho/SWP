<%-- 
Document   : cart
Created on : Nov 26, 2022, 4:09:09 PM
Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        </style>
        <jsp:include page="navbar.jsp"></jsp:include>
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
        <jsp:include page="category.jsp"></jsp:include>
            <!-- Breadcrumb Section End -->
            <form action="checkOut">
                <!-- Shoping Cart Section Begin -->
                <section class="shoping-cart spad">

                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="shoping__cart__table">

                                    <table>
                                        <thead>
                                            <tr>
                                                <th style="display : flex; flex-direction : row">
                                                    <input type="checkbox" class="check" id="checkAll">
                                                    <label>
                                                        Chọn tất cả
                                                    </label>
                                                </th>
                                                <th  class="shoping__product" style="text-align: center; ">Sản phẩm</th>
                                                <th>Shop ID</th>
                                                <th>Giá</th>
                                                <th>Số lượng</th>
                                                <th>Tổng</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:set var="total" value="0"/>
                                        <c:forEach items="${sessionScope.listC}" var="c">
                                            <c:set var="total" value="${total + c.total}"/>
                                            <tr>

                                                <td><label>
                                                        <input type="checkbox" name="cbid" value="${c.cartDetailID}" class="check">
                                                    </label>
                                                </td>
                                                <td class="shoping__cart__item">
                                                    <img src="${c.imgLink}" alt="">
                                                    <h5 style="margin-left: 50px">${c.productName}</h5>
                                                </td>
                                                <td class="shoping__cart__quantity">
                                                    ${c.storeID}
                                                </td>
                                                <td class="shoping__cart__price">
                                                    <fmt:formatNumber value = "${c.price}" type = "currency"/>VNĐ
                                                </td>
                                                <td class="shoping__cart__quantity">
                                                   ${c.amount}
                                                </td>
<!--                                                <td>
                                                    <button type="button">
                                                        <a href="updateCart?cid={c.cartID}" style="text-decoration: none; color: black;">
                                                            {c.size} - {c.color}
                                                        </a>
                                                    </button>
                                                </td>-->
                                        <td class="shoping__cart__total">
                                            <fmt:formatNumber value = "${c.total}" type = "currency"/>VNĐ
                                        </td>
                                        
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__btns">
                                <a href="home" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                                
                                <a href="UpdateCart.jsp" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                    Upadate Cart</a>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="shoping__continue">
                                <div class="shoping__discount">
                                    <h5>Discount Codes</h5>
                                    <form action="#">
                                        <input type="text" placeholder="Enter your coupon code">
                                        <button type="submit" class="site-btn">APPLY COUPON</button>

                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <h5>Cart Total</h5>
                                <ul>
                                    <li>Subtotal <span><fmt:formatNumber value = "${total}" type = "currency"/>VNĐ</span></li>
                                    <li>Total <span><fmt:formatNumber value = "${total}" type = "currency"/>VNĐ</span></li></span></li>
                                </ul>
                                <button class="primary-btn">PROCEED TO CHECKOUT</button>
                            </div>
                        </div>

                    </div>
                </div>


            </section>
            <!-- Shoping Cart Section End -->
        </form>
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
            $("#checkAll").click(function () {
                $(".check").prop('checked', $(this).prop('checked'));
            });
            
            


            document.getElementById("getChecked").addEventListener("click", function () {
                // Get the one radio button (within its group) that is checked:
                var checkedRadio = document.querySelector("input[type='radio'][name='rad']:checked");

                // Clear old output and log new results
                console.clear();
                console.log(checkedRadio.value);
            });
            
            
        </script>
    </body>

</html>