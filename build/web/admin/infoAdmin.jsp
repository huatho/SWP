<%-- 
    Document   : infoAdmin
    Created on : Nov 20, 2022, 10:39:35 AM
    Author     : DELL
--%>

<%@page import="entity.AdminProfile"%>
<%@page import="DAO.AdminDAO"%>
<%@page import="entity.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Admin</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
              name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/paper-dashboard.css?v=2.0.1" rel="stylesheet"/>
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="${pageContext.request.contextPath}/assets/css/admin.css" rel="stylesheet" />
        <style>
            .card-stats .card-body .numbers p {
                margin-bottom: 0;
                font-size: 16px;
            }
            .card-user .author {
                margin-top: 0px;
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
                height: 100%;
            }
            .card-user .author {
                display: flex;
                flex-direction: column;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <div class="logo">

                    <a href="editAdmin?Accid=${sessionScope.account.id}">
                        Xin chào @${sessionScope.account.acc}
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
                            <a href="${pageContext.request.contextPath}/listProduct">
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
                            <a class="navbar-brand" href="">Bảng điều khiển</a>
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
                <div class="content">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card card-user">
                                <div class="card-body">
                                    <form action="adminUploadImg" method="post" enctype="multipart/form-data">
                                        <div class="author">
                                            <img class="avatar border-gray" src="${ad.avatar}" alt="" id="image">
                                            <!--<label class="btn btn-primary" for="imageFile">Select file</label>-->
                                            <input type="file" name="file" id="imageFile" onchange="chooseFile(this)"
                                                   accept="image/gif, image/jpeg, image/png"/>
                                            <input name="id" value="${ad.adminId}" hidden/>
                                            <a href="#">
                                                <h5 class="title">${ad.acc}</h5>
                                            </a>

                                            <p class="description text-center">
                                                Email: ${ad.email}
                                            </p>
                                            <button type="submit">Update ảnh</button>
                                        </div>
                                    </form>

                                </div>
                                <div class="card-footer text-center">
                                    <hr>

                                    <button class="btn btn-social btn-info btn-just-icon btn-round btn-facebook">
                                        <i class="fa fa-facebook"> </i>
                                    </button>
                                    <button class="btn btn-social btn-info btn-just-icon btn-round btn-twitter">
                                        <i class="fa fa-twitter"></i>
                                    </button>
                                    <button class="btn btn-social btn-info bbtn-just-icon btn-round btn-github">
                                        <i class="fa fa-github"></i>
                                    </button>
                                    <button class="btn btn-social btn-info btn-just-icon btn-round btn-youtube">
                                        <i class="fa fa-youtube"></i>
                                    </button>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-8">
                            <div class="card card-user">
                                <div class="card-header">
                                    <h5 class="card-title text-center">Chỉnh sửa thông tin cá nhân</h5>
                                </div>
                                <div class="card-body">
                                    <form action="editAdmin" method="post">
                                        <div class="row">
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <label>Tên</label>
                                                    <input name="adminName" type="text" class="form-control" placeholder="Company"
                                                           value="${ad.adminName}">
                                                    <input name="adid" value="${ad.adminId}" hidden>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <label>Địa chỉ</label>
                                                    <input name= "adminAddress" type="text" class="form-control" placeholder="Home Address"
                                                           value="${ad.adminAddress}">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <label>Số điện thoại</label>
                                                    <input name="adminPhone" type="text" class="form-control" placeholder="Home Address"
                                                           value="${ad.adminPhone}">
                                                </div>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="update ml-auto mr-auto">
                                                <button type="submit" class="btn btn-primary btn-round">Cập nhật thông
                                                    tin</button>
                                            </div>
                                        </div>
                                    </form>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

        <script>
                                                function chooseFile(fileInput) {
                                                    if (fileInput.files && fileInput.files[0]) {
                                                        var reader = new FileReader();
                                                        reader.onload = function (e) {
                                                            $('#image').attr('src', e.target.result);
                                                        }
                                                        reader.readAsDataURL(fileInput.files[0]);
                                                    }
                                                }
        </script>
    </body>
</html>
