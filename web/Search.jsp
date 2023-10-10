<%-- 
    Document   : Search
    Created on : Dec 2, 2022, 2:43:18 PM
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
        <style>
            .pagination {
                display: inline-block;
                margin-left: 40%;
            }

            .pagination a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
                border-radius: 5px;
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
                border-radius: 5px;
            }
        </style>
    </head>

    <body>
        <!-- Page Preloder -->
        <jsp:include page="navbar.jsp"></jsp:include>
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
        <jsp:include page="category.jsp"></jsp:include>
            <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12" style="margin-top: 30px; margin-bottom: 30px;">
                            <div class="hero__item" style="">
                                <div class="hero__item-img">
                                    <img src="assets/img/banner/banner.jpg" alt="">
                                </div>
                                <div class="hero__item-text">

                                    <h2> <br /></h2>
                                    <p></p>
                                    <a href="#" class="primary-btn">SHOP NOW</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Hero Section End -->

            <!-- Categories Section Begin -->
            <section class="categories">
                <div class="container">
                    <div class="section-title">
                        <h2>Sản Phẩm nổi bật</h2>
                    </div>
                    <div class="row">
                        <div class="categories__slider owl-carousel">
                        <c:forEach items="${listTop}" var="o">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="${o.imageLink}">
                                    <h5><a href="detail?productID=${o.productID}">${o.productName}</a></h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="featured__controls">                           
                            <ul>
                                <li data-filter="*"><a href="home">All</a></li>
                                    <c:forEach items="${listAllCategory}" var="o">
                                    <li class="${tagCategory == o.categoryID?"active":""}"><a href="home?categoryID=${o.categoryID}">${o.categoryName}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <c:forEach items="${listProductInPage}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix coat man women">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.imageLink}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?productID=${o.productID}">${o.productName}</a></h6>
                                    <h5>${o.priceWithDot}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>                   
                </div>

            </div>

        </section>

        <div class="pagination">
            <c:forEach begin="1" end="${endPage}" var="o">
                <!--<a class="${tag == o?"active":""}" href="home?categoryID=${tagCategory}&index=${o}">${o}</a>-->
                <!--<a class="${tag == o?"active":""}" href="home?${txtSearch == null?"categoryID=${tagCategory}":"txt=${txtSearch}"}&index=${o}">${o}</a>-->
                <a class="${tag == o?"active":""}" href="search?txt=${txtSearch}&index=${o}">${o}</a>
            </c:forEach>
        </div>
        <!--phân trang-->

        <!-- Featured Section End -->

        <!-- Blog Section Begin -->
        <section class="from-blog spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title from-blog__title">
                            <h2>From The Blog</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic">
                                <img src="assets/img/blog/phối đồ name.jpg" alt="">
                            </div>
                            <div class="blog__item__text">
                                <ul>
                                    <li><i class="fa fa-calendar-o"></i> May 4,2022</li>
                                    <li><i class="fa fa-comment-o"></i> 5</li>
                                </ul>
                                <h5><a href="#">Các tips phối đồ cho nam </a></h5>
                                <p>Ăn mặc đẹp là một lợi thế khiến các quý ông không chỉ trở nên hấp dẫn hơn mà còn giúp ích
                                    rất nhiều trong công việc. Nếu như các bạn vẫn chưa tìm được cho </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic">
                                <img src="assets/img/blog/shopping.jpg" alt="">
                            </div>
                            <div class="blog__item__text">
                                <ul>
                                    <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                    <li><i class="fa fa-comment-o"></i> 5</li>
                                </ul>
                                <h5><a href="#">Phương pháp shopping online hiệu quả</a></h5>
                                <p>Thời đại 4.0 đánh dấu bước phát triển cực mạnh của thương mại điện tử. Phương pháp bán
                                    hàng online ngày càng trở nên phổ biến hơn với tất cả mọi người... </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic ">
                                <img src="assets/img/blog/lenvents.jpg" alt="">
                            </div>
                            <div class="blog__item__text">
                                <ul>
                                    <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                    <li><i class="fa fa-comment-o"></i> 5</li>
                                </ul>
                                <h5><a href="#">Hợp tác với thương hiệu Levents</a></h5>
                                <p>Levents và F-market đã hoàn tất đàm phán về sự hợp tác của hai bên. Tất cả sản phẩm của
                                    levent sẽ được lên kệ sớm nhất...</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Section End -->

        <!-- Footer Section Begin -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
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
