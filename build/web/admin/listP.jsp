<%@page import="java.text.DecimalFormat"%>
<%@page import="entity.Product"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="entity.Count"%>
<%@page import="entity.AdminProfile"%>
<%@page import="DAO.AdminDAO"%>
<%@page import="entity.Account"%>
<%@page import="entity.AdminProfile"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            Quản lý Sản Phẩm 
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
              name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/paper-dashboard.css?v=2.0.1" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="${pageContext.request.contextPath}/assets/css/admin.css" rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"/>
        <link href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css"/>
        <style>
            body {
                margin-top: 0;
                height: 100%;
            }
            .card-stats .card-body .numbers p {
                margin-bottom: 0;
                font-size: 16px;
            }

            .sidebar[data-color="white"]:after {
                background: black;
            }
            .sidebar .nav p {
                color: white;
            }
            .logo a {
                font-size: 18px;
                color:white;
                margin-left: 20px;
            }
            .sidebar .sidebar-wrapper {
                overflow: hidden;
            }
            .main-panel {
                background-color: #41434429;
            }
            .table-responsive {
                overflow: hidden;
            }
            .row {
                margin: 0;
            }
            .table > thead > tr > th,
            .table > tbody > tr > td {
                text-align: center;
            }
            .table > tbody > tr > td a {
                font-size: 20px;
            }
        </style>
    </head>

    <body>
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <div class="logo">

                    <a href="editAdmin?Accid=${sessionScope.account.id}">
                        Xin chào ${sessionScope.account.acc}
                        <!-- <div class="logo-image-big">
                <img src="../assets/img/logo-big.png">
              </div> -->
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/load">
                                <i class="fa fa-home"></i>
                                <p>Bảng điều khiển</p>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/listU">
                                <i class="fa fa-user"></i>
                                <p>Quản lý Người dùng</p>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/listP.jsp">
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                <p>Quản lý sản phẩm</p>
                            </a>
                        </li>
                        <li>
                            <a href="editAdmin?Accid=${sessionScope.account.id}">
                                <i class="fa fa-info" aria-hidden="true"></i>
                                <p>Thông tin cá nhân</p>
                            </a>
                        </li>
                        <li>
                            <a href="logout">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                                <p>Đăng xuất</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="">Quàn lý sản phẩm</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                                aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            <form>
                                <div class="input-group no-border">
                                    <input type="text" value="" class="form-control" placeholder="Search...">
                                    <div class="input-group-append">
                                        <div class="input-group-text">
                                            <i class="fa fa-search" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <ul class="navbar-nav">

                                <li class="nav-item btn-rotate dropdown">
                                    <a class="nav-link dropdown-toggle" href="http://example.com"
                                       id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                                       aria-expanded="false">
                                        <i class="fa fa-cog" aria-hidden="true"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Tài khoản</span>
                                        </p>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                        <a class="dropdown-item" href="editAdmin?Accid=${sessionScope.account.id}">Thông tin cá nhân</a>
                                        <a class="dropdown-item" href="#">Đăng xuất</a>

                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- End Navbar -->
                <div class="content">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center">
                                                <i class="fa fa-user" style="color: #6bd098"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Nguời dùng</p>
                                                <p class="card-title"><%
                                                    AdminDAO ad = new AdminDAO();
                                                    Count c = new Count();
                                                    c = ad.countUser();
                                                    %>
                                                    <%= c.getCount()%>
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <i class="fa fa-refresh"></i>
                                    Xem danh sách
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center">
                                                <i class="fa fa-money" style="color: #ef8157" aria-hidden="true"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Doanh thu</p>
                                                <%
                                                    long total = ad.totalPrice();
                                                    Locale localeVN = new Locale("vi", "VN");
                                                    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                                                    String str1 = currencyVN.format(total);
                                                %>
                                                <p class="card-title"><%= str1%>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-calendar-o"></i>
                                        Xem doanh thu
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center icon-warning">
                                                <i class="fa fa-university" style="color: #ef8157   " aria-hidden="true"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Cửa hàng</p>
                                                <p class="card-title"><%

                                                    c = ad.countStore();
                                                    %>
                                                    <%= c.getCount()%>
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-clock-o"></i>
                                        Xem danh sách
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center icon-warning">
                                                <i class="fa fa-product-hunt" style="color: #6bd098" aria-hidden="true"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Sản phẩm</p>
                                                <p class="card-title"><%

                                                    c = ad.countProduct();
                                                    %>
                                                    <%= c.getCount()%>
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-refresh"></i>
                                        Xem sản phẩm
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button style="margin-left: 16px;" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">
                        Thêm Loại Sản Phẩm
                    </button>
                    <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Thêm loại sản phẩm</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="addCategory" method="POST">
                                    <div class="modal-body">
                                        <% int num = ad.lastCategoryId();
                                                int num1 = num + 1;%>
                                        <label>ID:</label>
                                        <input type="text" name="categoryID" class="form-control" placeholder="ID" aria-label="ID" value="<%= num1%>" readonly="">
                                        <label>Tên loại Sản Phẩm:</label>
                                        <input type="text" name="categoryName" class="form-control" placeholder="Tên loại Sản Phẩm">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Thêm</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>               
                    <div class="row">                        
                        <div class="col-md-12">
                            <div class="card ">
                                <div class="">
                                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Ảnh</th>
                                                <th>Dành cho</th>
                                                <th>Giá</th>
                                                <th>Loại</th>
                                                <th>Tên Shop</th>
                                                <th>Tình trạng</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${listP}" var= "p">
                                                <tr>
                                                    <td>${p.productName}</td>
                                                    <td><img src="${p.imageLink}" style="width: 200px; height: 200px; object-fit: contain;"/></td>
                                                    <td>${p.sex}</td>
                                                    <td>${p.getPriceWithDot()}đ</td>
                                                    <td>${p.categoryName}</td>
                                                    <td>${p.storeName}</td>
                                                    <c:choose>
                                                        <c:when test="${p.totalProduct > 0}">
                                                            <td style="color: green; font-weight: 600;">Còn hàng</td>
                                                        </c:when>    
                                                        <c:otherwise>
                                                            <td style="color: red; font-weight: 600;">Hết Hàng</td> 
                                                        </c:otherwise>
                                                    </c:choose>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="${pageContext.request.contextPath}/assets/js/core/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/core/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Google Maps Plugin    -->
        <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
        <!-- Chart JS -->
        <script src="${pageContext.request.contextPath}/assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="${pageContext.request.contextPath}/assets/js/paper-dashboard.min.js?v=2.0.1" type="text/javascript"></script>
        <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
        <script src="${pageContext.request.contextPath}/assets/js/admin.js"></script>
        <script>
            $(document).ready(function () {
                // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
                demo.initChartsPages();
            });
        </script>
        <script>
            function showMess(id) {
                var option = confirm('Bạn muốn XÓA tài khoản');
                if (option === true) {
                    window.location.href = 'deleteAccount?Accid=' + id;
                }
            }
        </script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>     
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>

    </body>
</html>