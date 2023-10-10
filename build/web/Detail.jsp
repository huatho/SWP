<%-- 
    Document   : Detail
    Created on : Dec 2, 2022, 2:44:46 PM
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
        <style>
            .hero__categories ul {
                padding-left: 0px;
                text-align: center;
            }
            .buttons_added {
                opacity:1;
                display:inline-block;
                display:-ms-inline-flexbox;
                display:inline-flex;
                white-space:nowrap;
                vertical-align:top;
            }
            .is-form {
                overflow:hidden;
                position:relative;
                background-color:#f9f9f9;
                height:2.2rem;
                width:1.9rem;
                padding:0;
                text-shadow:1px 1px 1px #fff;
                border:1px solid #ddd;
            }
            .is-form:focus,.input-text:focus {
                outline:none;
            }
            .is-form.minus {
                border-radius:4px 0 0 4px;
            }
            .is-form.plus {
                border-radius:0 4px 4px 0;
            }
            .input-qty {
                background-color:#fff;
                height:2.2rem;
                text-align:center;
                font-size:1rem;
                display:inline-block;
                vertical-align:top;
                margin:0;
                border-top:1px solid #ddd;
                border-bottom:1px solid #ddd;
                border-left:0;
                border-right:0;
                padding:0;
            }
            .input-qty::-webkit-outer-spin-button,.input-qty::-webkit-inner-spin-button {
                -webkit-appearance:none;
                margin:0;
            }
        </style>
    </head>

    <body>
        <!-- Header Section  -->
        <jsp:include page="navbar.jsp"></jsp:include>
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
        <jsp:include page="category.jsp"></jsp:include> 
            <!-- Hero Section End -->

            <!--Breadcrumb Section Begin--> 
            <section class="breadcrumb-section set-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                        </div>
                    </div>
                </div>
            </section>
            <!--Breadcrumb Section End--> 
            <form action="add-cart" method="POST">
                <!-- Product Details Section Begin -->
                <input hidden name="storeID" value="${storeID}"/>
                <section class="product-details spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="product__details__pic">
                                    <div class="product__details__pic__item">
                                        <img class="product__details__pic__item--large"
                                             src="${detail.imageLink}" alt="">
                                </div>
                                <div class="product__details__pic__slider owl-carousel">
                                    <c:forEach items="${listColor}" var="o">
                                        <img src="${o.linkImageColor}" alt="">
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">

                            <div class="product__details__text">
                                <h3>${detail.productName}</h3>
                                <div class="product__details__rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-half-o"></i>
                                    <span>(18 reviews)</span>
                                </div>
                                <div class="product__details__price">${detail.priceWithDot}</div>
                                <!--                            <form action="detail" method="GET" id="inforDetail">-->
<!--                               Size + Color-->
                                <!--                                <div class="product__details-color">
-->                                                                    <input style="display: none" name="productID" value="${detail.productID}"><!--
                                                                    <button onclick="loadCountProduct()" style="background-color: red; color: black;" type="submit" class="btn btn-outline-danger">CHECK SỐ LƯỢNG SẢN PHẨM</button>
                                                                </div>-->
                                <!--</form>-->
                                <div id="count" class="row">
                                    <div class="product__details-status">
                                        <ul>
<!--                                            <li><b>Tình trạng</b> <span>Còn {detail.totalProduct} sản phẩm</span></li>-->
                                            <li><b>Giao hàng</b> <span>Từ 02 - 03 ngày. <samp>Miễn phí giao hàng</samp></span></li>
                                            <li><b>Trọng lượng</b> <span>0.5 kg</span></li>
                                            <li><b>Sản phẩm còn lại</b> <span>${countProduct}</span></li>
                                            <li><b>Chia sẻ</b>
                                                <div class="share">
                                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="product__details__quantity">
<!--                                <form action="addtocart" method="POST">-->
                                    <div class="quantity">
                                        <div class="buttons_added" style="padding-top: 16px;">
                                            <input class="minus is-form" type="button" value="-">
                                            <input name="quantity" aria-label="quantity" class="input-qty" max=${countProduct} min="1" name="" type="number" value="1">
                                            <input class="plus is-form" type="button" value="+">
                                        </div>
                                    </div>
                                    <div class="product__details-btn">
                                        <button class="primary-btn">Thêm vào giỏ hàng</button>
                                        <!--<a href="#" class="primary-btn">Mua ngay</a>-->
                                    </div>
<!--                                </form>-->
                                
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                       aria-selected="true">Mô tả</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab" aria-selected="false">Thông
                                        tin</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab" aria-selected="false">Đánh
                                        giá<span>(1)</span></a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Thônng tin sản phẩm</h6>
                                        <p>${detail.descriptions}
                                        </p>
                                        <p>Hướng Dẫn Chọn Size <br>
                                            - Size M từ 45Kg đến 50Kg <br>
                                            - Size L từ 50Kg đến 60Kg <br>
                                            - Size XL từ 60Kg đến 68Kg <br>
                                            - Size XXL từ 65Kg đến78Kg <br>
                                            - Size 3XL từ75Kg đến83Kg.</p>

                                        <p>
                                            Hướng Dẫn Đặt Hàng <br>
                                            - Nếu mua 1 sản phẩm bạn chọn Màu, Size rồi bấm “MUA HÀNG” <br>
                                            - Nếu bạn muốn mua 2-3 sản phẩm bạn chọn từng sản phẩm rồi
                                            thêm vào Giỏ Hàng, khi đã thêm đầy đủ các sản phẩm cần mua, bạn click
                                            vào Giỏ
                                            Hàng và “THANH TOÁN”
                                        </p>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-2" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Products Infomation</h6>
                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.
                                            Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac
                                            diam
                                            sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue
                                            leo
                                            eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.
                                            Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem.
                                            Praesent
                                            sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum
                                            ac
                                            diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante
                                            ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                            Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet
                                            ligula.
                                            Proin eget tortor risus.</p>
                                        <p>Praesent sapien massa, convallis a pellentesque nec, egestas non nisi.
                                            Lorem
                                            ipsum dolor sit amet, consectetur adipiscing elit. Mauris blandit
                                            aliquet
                                            elit, eget tincidunt nibh pulvinar a. Cras ultricies ligula sed magna
                                            dictum
                                            porta. Cras ultricies ligula sed magna dictum porta. Sed porttitor
                                            lectus
                                            nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.</p>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-3" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Products Infomation</h6>
                                        <p>Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                                            Pellentesque in ipsum id orci porta dapibus. Proin eget tortor risus.
                                            Vivamus suscipit tortor eget felis porttitor volutpat. Vestibulum ac
                                            diam
                                            sit amet quam vehicula elementum sed sit amet dui. Donec rutrum congue
                                            leo
                                            eget malesuada. Vivamus suscipit tortor eget felis porttitor volutpat.
                                            Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem.
                                            Praesent
                                            sapien massa, convallis a pellentesque nec, egestas non nisi. Vestibulum
                                            ac
                                            diam sit amet quam vehicula elementum sed sit amet dui. Vestibulum ante
                                            ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                            Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet
                                            ligula.
                                            Proin eget tortor risus.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </section>
            <!-- Product Details Section End -->
        </form>
        <!-- Related Product Section Begin -->
        <section class="related-product">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title related__product__title">
                            <h2>Sản phẩm liên quan</h2>
                        </div>
                    </div>
                </div>
                <%--<c:forEach items="listProductSameID" var="o">--%>
                <div class="row categories__slider owl-carousel">
                    <c:forEach items="${listProductSameID}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${o.imageLink}">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="detail?productID=${o.productID}">${o.productName}</a></h6>
                                    <h5>${o.priceWithDot}</h5>
<!--                                    {o.totalProduct == 0 ? "<h6>hết hàng</h6>":""}-->
                                </div>
                            </div>
                        </div>  
                    </c:forEach>
                </div>
                <%--</c:forEach>--%>
            </div>
        </section>
        <!-- Related Product Section End -->

        <!-- Footer Section Begin -->
        <jsp:include page="footer.jsp"></jsp:include>
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
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script>
            function loadCountProduct() {
                $("#inforDetail").submit(function (e) {
                    e.preventDefault(); // avoid to execute the actual submit of the form.
                    var form = $(this);
                    $.ajax({
                        type: "GET",
                        url: "/Mooc/loadCount",
                        data: form.serialize(), // serializes the form's elements.
                        success: function (data)
                        {
                            document.getElementById("count").innerHTML = data;
                        }
                    });
                });
            }

            $('input.input-qty').each(function () {
                var $this = $(this),
                        qty = $this.parent().find('.is-form'),
                        min = Number($this.attr('min')),
                        max = Number($this.attr('max'))
                if (min == 0) {
                    var d = 0
                } else
                    d = min
                $(qty).on('click', function () {
                    if ($(this).hasClass('minus')) {
                        if (d > min)
                            d += -1
                    } else if ($(this).hasClass('plus')) {
                        var x = Number($this.val()) + 1
                        if (x <= max)
                            d += 1
                    }
                    $this.attr('value', d).val(d)
                });
            });

        </script>

    </body>

</html>
