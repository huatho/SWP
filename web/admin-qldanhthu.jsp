
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
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
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
        <link href="assets/css/cuatu.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/baothu.css" rel="stylesheet" type="text/css"/>
        <!--style form-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                background-image: url(https://images.unsplash.com/photo-1454117096348-e4abbeba002c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
                background-repeat: no-repeat;
                background-position: center;
                background-size: cover;
            }
            .infoqlbanhang{
                display: flex;
                justify-content: center;
                text-align: center;
            }
            .sum_admin{
                display: flex;
                justify-content: center;
                text-align: center;
            }
        </style>
        <title>Doanh thu của trang web !!!</title>
    </head>
    <body>
        <!--Header-->
        <!-- thanh menu nav bar -->
        <div class="container-1">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <!--item in header-->
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Trang chủ <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <div  class="nav-link" id="menu_icon"><i class="bi bi-list"></i></div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Xin chào
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#"><i style="font-size:100% ; margin-right: 2%;" class="fa">&#xf2be;</i>  Thông tin cá nhân</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout"><i style="font-size:100%; margin-right: 2%;" class="fa">&#xf104;</i>  Đăng xuất</a>
                            </div>
                        </li>
                        <!--item in header-->
                    </ul>
                    <!-- <form class="form-inline my-2 my-lg-0">
                      <input class="form-control mr-sm-2" type="search" placeholder="Áo, máy tính..." aria-label="Search">
                      <button class="btn btn-outline-secondary text-light my-2 my-sm-0" type="submit">Tìm kiếm</button>
                    </form> -->
                </div>
            </nav>
        </div>

        <!-- thanh danh mục sản phẩm-->
        <!--Header-->
        <!--body-->
        <!--search item-->
            <div class="row search-product-adver" style="text-align: center; ">
            <p class="content-admin-qly" ><i class="fa-solid fa-money-check-dollar"></i>Doanh thu của seller</p>
        </div>

        <div class="sidebar">
            <div class="sidebar-brand">
                <h2><i class="fa-solid fa-universal-access"></i></span><span>Seller</span><i class="bi bi-x-lg" id="close_menu"></i></h2>
            </div>

            <div class="sidebar-menu">
                <ul>
                    <li>
                        <a href="qldanhthu" class=""><i class="fa-solid fa-money-bill-trend-up"></i>
                            <span>Revenue management</span></a>
                    </li>
                    <li>
                        <a href="homeServlet"><i class="fa-solid fa-cart-shopping"></i>
                            <span>Orders</span></a>
                    </li>
                    <li>
                        <a href="TopSellingControl"><i class="fa-solid fa-chart-simple"></i>
                            <span>Top Selling</span></a>
                    </li>
                </ul>   
            </div>
        </div>


        <div class="row" style="margin: 0;
             font-family: Nunito,sans-serif;
             font-size: .9rem;
             font-weight: 400;
             line-height: 1.5;
             color: #6c757d;
             background-color: #fafbfe;
             -webkit-text-size-adjust: 100%;
             -webkit-tap-highlight-color: transparent;">
            <div class="col-lg-6 col-xl-3">
                <div class="card">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-6">
                                <h5 class="text-muted fw-normal mt-0 text-truncate" title="Campaign Sent">Campaign Sent</h5>
                                <h3 class="my-2 py-1">9,184</h3>
                                <p class="mb-0 text-muted">
                                    <span class="text-success me-2"><i class="mdi mdi-arrow-up-bold"></i> 3.27%</span>
                                </p>
                            </div>
                            <div class="col-6">
                                <div class="text-end">
                                    <div id="campaign-sent-chart" data-colors="#727cf5"></div>
                                </div>
                            </div>
                        </div> <!-- end row-->
                    </div> <!-- end card-body -->
                </div> <!-- end card -->
            </div> <!-- end col -->

            <div class="col-lg-6 col-xl-3">
                <div class="card">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-6">
                                <h5 class="text-muted fw-normal mt-0 text-truncate" title="New Leads">New Leads</h5>
                                <h3 class="my-2 py-1">3,254</h3>
                                <p class="mb-0 text-muted">
                                    <span class="text-danger me-2"><i class="mdi mdi-arrow-down-bold"></i> 5.38%</span>
                                </p>
                            </div>
                            <div class="col-6">
                                <div class="text-end">
                                    <div id="new-leads-chart" data-colors="#0acf97"></div>
                                </div>
                            </div>
                        </div> <!-- end row-->
                    </div> <!-- end card-body -->
                </div> <!-- end card -->
            </div> <!-- end col -->

            <div class="col-lg-6 col-xl-3">
                <div class="card">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-6">
                                <h5 class="text-muted fw-normal mt-0 text-truncate" title="Deals">Deals</h5>
                                <h3 class="my-2 py-1">861</h3>
                                <p class="mb-0 text-muted">
                                    <span class="text-success me-2"><i class="mdi mdi-arrow-up-bold"></i> 4.87%</span>
                                </p>
                            </div>
                            <div class="col-6">
                                <div class="text-end">
                                    <div id="deals-chart" data-colors="#727cf5"></div>
                                </div>
                            </div>
                        </div> <!-- end row-->
                    </div> <!-- end card-body -->
                </div> <!-- end card -->
            </div> <!-- end col -->

            <div class="col-lg-6 col-xl-3">
                <div class="card">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-6">
                                <h5 class="text-muted fw-normal mt-0 text-truncate" title="Booked Revenue">Booked Revenue</h5>
                                <h3 class="my-2 py-1">$253k</h3>
                                <p class="mb-0 text-muted">
                                    <span class="text-success me-2"><i class="mdi mdi-arrow-up-bold"></i> 11.7%</span>
                                </p>
                            </div>
                            <div class="col-6">
                                <div class="text-end">
                                    <div id="booked-revenue-chart" data-colors="#0acf97"></div>
                                </div>
                            </div>
                        </div> <!-- end row-->
                    </div> <!-- end card-body -->
                </div> <!-- end card -->
            </div> <!-- end col -->
        </div>

        <!--table-->
        <div class="ad-home-main">
            <div class="row">
                <!--table về sản phẩm, link quảng cáo-->
                <div class="col-11 table-infor-product-ad rounded">
                    <div class="col-12 sum_admin">
                        <form action="qldanhthu" class="form_search">
                            <input value="${sessionScope.seller.id}" name="sid" hidden>
                            Từ ngày <input type="date" name="fromd">
                            Đến ngày <input type="date" name="tod">
                            <input type="submit" value="Search">
                        </form>
                    </div>
                    <div class="row">
                        <div class="col">
                            <p style="color: rgb(69, 69, 69); font-weight: bolder;">Danh sách sản phẩm bán được của từng Seller</p>
                        </div>
                        <div class="col"></div>
                        <div class="col">
                        </div>
                    </div>
                    <div class="dropdown-divider"></div> 
                    <div class="table-responsive infoqlbanhang row">
                        <div dir="ltr">
                            <div id="sessions-overview" class="apex-charts mt-3" data-colors="#0acf97"></div>
                        </div>
                        <div id="columnchart_material" style="width: 800px; height: 500px; margin-bottom: 50px;"></div>

                        <table class="table table-bordered thead-dark ">
                            <thead class="bg-secondary text-white " >
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Ngày thanh toán</th>
                                    <th scope="col">Tổng tiền</th>
                                </tr>
                            </thead>
                            <tbody class="bg-white">
                                <c:set var="index" value="0" />
                                <c:set var="total" value="0" />
                                <c:forEach items="${statisticalP}" var="st">
                                    <c:set var="index" value="${index + 1}"/>
                                    <c:set var="total" value="${total + st.price}"/>
                                    <tr>
                                        <th scope="row">${index}</th>
                                        <td>${st.productName}</td>
                                        <td>${st.dayofcreate}</td> 
                                        <td><fmt:formatNumber value = "${st.price}" type = "currency"/></td> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!--Paging-->
                    <div class="row">
                        <div class="col-7"></div>
                        <div class="col-4 sum-admin">
                            <p>Tổng tiền sản phẩm bán được :</p>
                            <span style="color: red;"><fmt:formatNumber value = "${total}" type = "currency"/></span>
                        </div>
                    </div>
                <!--table về sản phẩm, link quảng cáo-->
                <!--table về hoa hồng, tổng link đã nhận được-->

                <!--table về hoa hồng đã nhận được-->
            </div>
            <!--end of row-->
        </div>
        <!--table-->
        <a href="TopSelling.jsp"></a>
        <!--body-->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script src="assets/js/apexcharts.min.js" type="text/javascript"></script>
        <script src="assets/js/demo.dashboard-crm.js" type="text/javascript"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Day', 'Total money of day'],
            <c:forEach items="${statisticalP}" var="st">
                    ["Ngày ${st.dayofcreate}", ${st.price}],
            </c:forEach>
                ]);

                var options = {
                    chart: {
                        title: 'Thống kê doanh thu',
                    }
                };

                var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
        </script>
        <script>
            const menuBtn = document.querySelector("#menu_icon");
            const navMenu = document.querySelector(".sidebar");
            const ClosemenuBtn = document.querySelector("#close_menu");

            menuBtn.onclick = () => {
                navMenu.classList.add('open');
            }
            ClosemenuBtn.onclick = () => {
                navMenu.classList.remove('open');
            }
        </script>
    </body>
</html>
