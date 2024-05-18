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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
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
                    <div class="container">
<!--    <div class="row">
        <div class="col-lg-12" style="margin-top: 70px; margin-bottom: 40px;">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="2000">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item ">
                        <img src="images/banner1.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/banner3.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            
                        </div>
                    </div>
                    <div class="carousel-item active" >
                        <img src="images/banner2.png" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-target="#carouselExampleCaptions" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-target="#carouselExampleCaptions" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </button>
            </div>
        </div>
    </div>-->
</div>
            <!-- Hero Section End -->

            <!-- Categories Section Begin -->
<!--            <section class="categories">
                <div class="container">
                    <div class="section-title">
                        <h2>Sản Phẩm nổi bật</h2>
                    </div>
                    <div class="row">
                        <div class="categories__slider owl-carousel">
                        <c:forEach items="${listTop}" var="o">
                            <div class="col-lg-3">
                                
                                <div class="categories__item set-bg"">
                                    <img src="${o.imageLink}"/>
                                    <h5><a href="detail?productID=${o.productID}&storeID=${o.storeID}">${o.productName}</a></h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>-->
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="section-title"">
                        <h2>Sản Phẩm Tìm Thấy</h2>
                    </div>
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
                                <div class="featured__item__pic set-bg">
                                    <img src="${o.imageLink}"/>
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?productID=${o.productID}&storeID=${o.storeID}">${o.productName}</a></h6>
                                    <h5>${o.priceWithDot}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>                   
                </div>

            </div>

        </section>
<style>
    /* Featured Section */
    .featured {
        padding: 60px 0;
    }

    /* Featured Controls */
    .featured__controls ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    .featured__controls ul li {
        display: inline-block;
        margin-right: 20px;
    }

    .featured__controls ul li:last-child {
        margin-right: 0;
    }

    .featured__controls ul li a {
        text-decoration: none;
        color: #333;
    }

    .featured__controls ul li.active a {
        font-weight: bold;
    }

    /* Featured Filter */
    .featured__filter .featured__item {
        margin-bottom: 30px;
    }

    .featured__item__pic img {
        width: 100%;
        height: auto;
    }

    .featured__item__pic__hover {
        position: absolute;
        bottom: 20px;
        right: 20px;
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    .featured__item__pic__hover li {
        display: inline-block;
        margin-right: 10px;
    }

    .featured__item__pic__hover li:last-child {
        margin-right: 0;
    }

    .featured__item__text h6 {
        margin-top: 10px;
        font-size: 16px;
    }

    .featured__item__text h5 {
        font-size: 18px;
        font-weight: bold;
        color: #333;
    }

    .featured__item__text h6 {
        font-size: 14px;
        color: #999;
    }
</style>
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
                                <img src="images/blog1.png" alt="">
                            </div>
                            <div class="blog__item__text">
                                <ul>
                                    <li><i class="fa fa-calendar-o"></i> May 4,2024</li>
                                    <li><i class="fa fa-comment-o"></i> 5</li>
                                </ul>
                                <h5><a href="https://toplist.vn/top-list/nhan-hieu-thuc-an-nhanh-noi-tieng-nhat-tai-viet-nam-1623.htm">Hệ thông giao thức ăn nhanh</a></h5>
                                <p>Ăn mặc đẹp là một lợi thế khiến các quý ông không chỉ trở nên hấp dẫn hơn mà còn giúp ích
                                    rất nhiều trong công việc. Nếu như các bạn vẫn chưa tìm được cho </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic">
                                <img src="images/blog2.png" alt="">
                            </div>
                            <div class="blog__item__text">
                                <ul>
                                    <li><i class="fa fa-calendar-o"></i> May 4,2024</li>
                                    <li><i class="fa fa-comment-o"></i> 5</li>
                                </ul>
                                <h5><a href="https://www.bachhoaxanh.com/kinh-nghiem-hay/organic-la-gi-vi-sao-nen-su-dung-thuc-pham-huu-co-1011761">Sử dụng thực phẩm Organic</a></h5>
                                <p>Thời đại 4.0 đánh dấu bước phát triển cực mạnh của thương mại điện tử. Phương pháp bán
                                    hàng online ngày càng trở nên phổ biến hơn với tất cả mọi người... </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic ">
                                <img src="images/blog4.png" alt="">
                            </div>
                            <div class="blog__item__text">
                                <ul>
                                    <li><i class="fa fa-calendar-o"></i> May 4,2024</li>
                                    <li><i class="fa fa-comment-o"></i> 5</li>
                                </ul>
                                <h5><a href="https://fiti.vn/an-uong-healthy">Tại sao phải ăn uống Healthy</a></h5>
                                <p>F-market đã hoàn tất đàm phán về sự hợp tác của hai bên. Tất cả sản phẩm của
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
