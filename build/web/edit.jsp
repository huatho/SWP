
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <title>
            Bảng điều khiển
        </title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/paper-dashboard.css?v=2.0.1" rel="stylesheet" />
        <style>
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
                z-index: 1;
            }

            .dropdown-content a {
                text-decoration: none;
                color: black;
            }

            .dropdown-content:hover {
                cursor: pointer;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
        </style>

    </head>

    <body class="">
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <div class="logo">
                    <a href="" class="simple-text logo-mini">
                        <div class="logo-image-small">
                            <img src="img/logo-small.png" alt="">
                        </div>
                    </a>
                    <a href="home" class="simple-text logo-normal">
                        Home
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active">
                            <a href="edit">
                                <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                                <p>Quản lý cửa hàng</p>
                            </a>
                        </li>
                        <li >
                            <a href="view-product">
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                <p>Quản lý sản phẩm</p>
                            </a>
                        </li>
<!--                        <li>
                            <a href="get-chat">
                                <i class="fa fa-comment" aria-hidden="true"></i>
                                <p>Tin nhắn</p>
                            </a>
                        </li>-->
                    </ul>
                </div>
            </div>
            <div class="main-panel">
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
                            <a class="navbar-brand" href="">Quản Lý Sản Phẩm</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                                aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            <div class="dropdown">
                                <div class="row">
                                    <div class="col-md-5"><i class="fa fa-gear"></i></div>
                                    <div class="col-md-5"><i class="fa fa-caret-down"></i></div>
                                </div>
                                <div class="dropdown-content">
                                    <a href="logout">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
                <div class="content">
                    <h3 style="color: blue;" >${msg}</h3>
                    <c:set var="listOrderSeller" value="${list}"/>

                    <div style="background: #fff; padding-left: 10px; border-radius: 10px; height: 100%; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3);">
                       
                        <c:if test="${listOrderSeller != null}">
                            <div class="row">
                                <div class="col-12">
                                    <table class="table table-image">
                                        <thead>
                                            <tr>
                                                <th class="col-1" scope="col">Mã đơn hàng</th>
                                                <th class="col-1" scope="col">Mã khách hàng</th>
                                                <th class="col-2" scope="col">Tên sản phẩm</th>
                                                <th class="col-1" scope="col">Số lượng</th>
                                                <th class="col-2" scope="col">Ngày tạo đơn</th>
                                                <th class="col-2" scope="col">Tổng tiền</th>
                                                <th class="col-3" scope="col">Trạng thái</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ol" items="${listOrderSeller}" varStatus="counter">
                                                <a href="seller-dashboard.jsp"></a>
                                                <tr>
                                                    <th scope="row">${ol.orderID}</th>
                                                    <td class="w-25">
                                                        ${ol.userID}
                                                    </td>
                                                    <td>
                                                        <span style="font-weight: bold;">
                                                            ${ol.productName}</span>
                                                        <img src="${ol.image}" class="img-fluid img-thumbnail"/>
                                                        
                                                    </td>
                                                    <td style="text-align: center">${ol.amount}</td>
                                                    <td>${ol.foundDate}</td>
                                                    <td>${ol.total}</td>
                                                    <th>
                                                        <c:if test="${ol.status == 1}">
                                                            <form action="edit" method="post">
                                                                <input hidden name="od" value="${ol.orderDetailID}"/>
                                                                <input hidden name="amount" value="${ol.amount}" />
                                                                <select name="status">
                                                                    <option value="1">Đợi phê duyệt</option>
                                                                    <option value="2">Xác nhận</option>
                                                                    <option value="0">Hủy đơn</option>
                                                                </select>
                                                                <button type="submit" class="btn btn-success">Save</button> 
                                                            </form>
                                                        </c:if>
                                                        <c:if test="${ol.status == 2}">
                                                            <span style="color: yellow; font-weight: 700;">Đã xác nhận</span>
                                                        </c:if>
                                                        <c:if test="${ol.status == 3}">
                                                            <span style="color: green; font-weight: 700;">Đã giao hàng</span>
                                                        </c:if>
                                                        <c:if test="${ol.status == 0}">
                                                            <span style="color: red; font-weight: 700;">Đã hủy</span>
                                                        </c:if>
                                                        
                                                    </th>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${listOrderSeller == null}">
                            <h1>Bạn chưa có đơn hàng nào!!!</h1>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>