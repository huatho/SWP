
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
        <link rel="stylesheet" href="assets/css/admin-manager-shop.css">
        <!--Css-->
        <!--JSV-->
        <script src="https://kit.fontawesome.com/3aa40a242b.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <!--JSV-->
        <!--style form-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@200&display=swap" rel="stylesheet"
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/font-awesome-line-awesome/css/all.min.css">
        <link rel="stylesheet" href="http://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">  
        <link href="assets/css/cuatu.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
        <!--style form-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                background-image: url(https://images.unsplash.com/photo-1554104707-a76b270e4bbb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
                background-repeat: no-repeat;
                background-position: center;
                background-size: cover;
            }
            .chart_column{
                margin-bottom: 50px;;
            }
            .infoTop{
                display: flex;
                justify-content: center;
                text-align: center;
                flex-direction: column;
                overflow: hidden;
            }
            #myTable_length{
                display: none;
            }
            #myTable_filter{
                display: flex;
                justify-content: flex-end;

            }
            @media (max-width: 1840px){
                .sidebar.open{
                    left: 0;
                }
                .list123.open{
                    margin-left: 40%;
                }
                header.open{
                    left: 22%;
                }
            }
        </style>
        <title>Doanh thu của trang web</title>
    </head>
    <body>
        <!--        <script src="js/stats.js" type="text/javascript"></script>
                <script> window.onload = function () {
                        cateChart("myCateStatsChart")
                    }
                </script>-->
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
                            <a class="nav-link" href="home">Trang chủ <span class="sr-only">(current)</span></a>
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
                </div>
            </nav>
        </div>
        <!-- thanh danh mục sản phẩm-->
      

       
        <!--thanh chuyen trang-->
            <div class="sidebar">
        <div class="sidebar-brand">
            <h2><i class="fa-solid fa-universal-access"></i></span><span>SELLER</span> <i class="bi bi-x-lg" id="close_menu"></i> </h2>
        </div>
                
                
        
        <div class="sidebar-menu">
            <ul style=" list-style: none">
                <li>
                    <a href="TopSellingControl"><i class="fa-solid fa-chart-simple"></i>
                        <span>TopSelling</span></a>
                </li>
                <li>
                    <a href="homeServlet"><i class="fa-solid fa-cart-shopping"></i>
                        <span>Orders</span></a>
                </li>
                <li>
                    <a href="qldanhthu"><i class="fa-solid fa-money-bill-trend-up"></i>
                        <span>Revenue management</span></a>
                </li>
            </ul>   
        </div>
    </div>
        <!--thanh chuyen trang-->



        <!--body-->
        <!--search item-->
        <div class="row search-product-adver list123" style="text-align: center; ">
            <div class="col-11 " style="text-align: center;" >
                <p class="content-admin-qly" > Quản lý bán hàng </p>
            </div>
        </div>


        <!--4 thong tin-->
        
        <!-- end row -->



        <!--search item-->
        <!--table-->
        <div class="ad-home-main">
            <div class="row">
                <!--table về sản phẩm, link quảng cáo-->
                <div class="col-11 table-infor-product-ad rounded">
                    <div class="row">
                        <div class="col">
                            <p style="color: rgb(69, 69, 69); font-weight: bolder;">Danh sách sản phẩm doanh nghiệp bán được</p>
                        </div>
                        <div class="col"></div>
                        <div class="col">
                        </div>
                    </div>
                    <div class="dropdown-divider"></div> 
                    <div class="table-responsive row infoTop">

                        <div class="chart_column" id="columnchart_material" style="width: 1000px; height: 500px; margin-left:15%;"></div>
                    
                    
                    <!--hien thi bieu do-->     
                        <form action="TopSellingControl" class="form_search">
                            <input value="${sessionScope.seller.id}" name="sid" hidden="">
                           
                            <input type="submit" value="hiển thị">
                        </form>
                     <!--hien thi bieu do-->
                        
                            <table class="table table-bordered thead-dark" id="myTable" style="margin-left:40px;">
                          
                  
                            <thead class="bg-secondary text-white">
                                <tr>
                                    <th scope="col">id</th>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Giá sản phẩm</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Tổng tiền</th>
                                </tr>
                            </thead>
                            <tbody class="bg-white">
                                <c:set var="index" value="0" />
                                <c:forEach items="${listTopSell}" var="ts">
                                    <tr>
                                        <th scope="row">${ts.id}</th>
                                        <td>${ts.name}</td>
                                        <td><fmt:formatNumber value = "${ts.price}" type = "currency"/></td>
                                        <td>${ts.amount}</td> 
                                        <td><fmt:formatNumber value = "${ts.total}" type = "currency"/></td> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!--Paging-->
                    <div class="dropdown-divider"></div>  


                    <!--Paging-->
                </div>
                <!--table về sản phẩm, link quảng cáo-->

                <!--table về hoa hồng, tổng link đã nhận được-->

                <!--table về hoa hồng đã nhận được-->
            </div>
            <!--end of row-->
        </div>
        <!--table-->
        <!--body-->

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript" src="assets/js/apexcharts.min.js"></script>
        <script type="text/javascript" src="assets/js/demo.dashboard-crm.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawChart);
<!--bieu do-->
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Product', 'Price'],
            <c:forEach items="${listTopSell}" var="ts">
                    ["${ts.name}", ${ts.total}],
            </c:forEach>
                ]);
                var options = {
                    chart: {
                        title: ''
                    }   
                };

                var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
    </script>
        <!--bieu do-->
        
    <script type="text/javascript">
        $(document).ready(function () {
            $('#myTable').DataTable();
        });
</script>
<script>
    const menuBtn = document.querySelector("#menu_icon");
    const navMenu = document.querySelector(".sidebar");
    const table = document.querySelector(".list123");
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
