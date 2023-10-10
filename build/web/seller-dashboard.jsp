
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
                        <li>
                            <a href="edit">
                                <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                                <p>Quản lý cửa hàng</p>
                            </a>
                        </li>
                        <li class="active">
                            <a href="view-product">
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                <p>Quản lý sản phẩm</p>
                            </a>
                        </li>
                        <li>
                            <a href="get-chat">
                                <i class="fa fa-comment" aria-hidden="true"></i>
                                <p>Tin nhắn</p>
                            </a>
                        </li>
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
                    <form action="view-product" method="POST">
                        <div class="row m-2 justify-content-around align-items-center">
                            <div><input type="text" name="txtProductNameSearch" value="${param.txtProductNameSearch}" placeholder="Product name" style="border-radius: 10px; border: 1px solid silver; padding: 8px;"/>
                            </div>
                            <div>
                                <input type="number" name="txtPriceFrom" placeholder="Price from" value="${param.txtPriceFrom}" style="border-radius: 10px; border: 1px solid silver; padding: 8px;"/>
                            </div>
                            <div><input  type="number" name="txtPriceTo" placeholder="Price to"value="${param.txtPriceTo}" style="border-radius: 10px; border: 1px solid silver; padding: 8px;"/>
                            </div>
                            <div><select class="form-control search-slt" id="exampleFormControlSelect1" name="txtCategorySearch">
                                    <option value="">All</option>
                                    <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
                                        <option value="${category.categoryName}" <c:if test="${param.txtCategorySearch == category.categoryName}">selected</c:if>>${category.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div><button type="submit" class="btn btn-danger">Tìm kiếm</button>
                            </div>
                        </div>
                    </form>
                    <c:set var="listProduct" value="${sessionScope.LIST_PRODUCT}"/>

                    <div style="background: #fff; padding-left: 10px; border-radius: 10px; height: 100%; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3);">
                        <c:if test="${sessionScope.mystore != null}">
                            <div class="col"><a href="create-update-product.jsp"><button class="btn btn-success">Thêm sản phẩm</button></a></div>
                        </c:if>
                        <c:if test="${sessionScope.mystore == null}">
                            <div class="col"><a href="newStore.jsp"><button class="btn btn-success">Tạo shop</button></a></div>
                        </c:if>
                        <c:if test="${listProduct != null}">
                            <div class="row">
                                <div class="col-12">
                                    <table class="table table-image">
                                        <thead>
                                            <tr>
                                                <th class="col-1" scope="col">STT</th>
                                                <th class="col-2" scope="col">Hình ảnh</th>
                                                <th class="col-3" scope="col">Tên sản phẩm</th>
                                                <th class="col-1" scope="col">Số lượng còn lại</th>
                                                <th class="col-1" scope="col">Giá</th>
                                                <th class="col-2" scope="col">Loại sản phẩm</th>
                                                <th class="col-2" scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="product" items="${listProduct}" varStatus="counter">
                                            <a href="seller-dashboard.jsp"></a>
                                            <tr>
                                                <th scope="row">${counter.count}</th>
                                                <td class="w-25">
                                                    <img src="${product.imageLink}"
                                                         class="img-fluid img-thumbnail" alt="">
                                                </td>
                                                <td><span style="font-weight: bold;">${product.productName}</span></br>${product.descriptions}</td>
                                                <td>${product.totalProduct}</td>
                                                <td>${product.price}</td>
                                                <td>${product.categoryName}</td>
                                                <th>
                                                    <form action="redirect-update-product" method="post">
                                                        <input type="hidden" name="txtProductID" value="${product.productID}"/>
                                                        <input type="hidden" name="txtProductName" value="${product.productName}"/>
                                                        <input type="hidden" name="txtDescription" value="${product.descriptions}"/>
                                                        <input type="hidden" name="txtImageLink" value="${product.imageLink}"/>
                                                        <input type="hidden" name="txtAmount" value="${product.totalProduct}"/>
                                                        <input type="hidden" name="txtPrice" value="${product.price}"/>
                                                        <input type="hidden" name="txtCategoryID" value="${product.categoryID}"/>
<!--                                                        <input type="hidden" name="txtCategoryName" value="{product.categoryName}"/>-->
                                                        <button type="submit" class="btn btn-success"><i class="fa fa-pencil"></i></button> 
                                                    </form>
                                                    <form action="delete-product" method="post">
                                                        <input type="hidden" name="txtProductID" value="${product.productID}"/>
                                                        <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i></button>
                                                    </form

                                                </th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${listProduct == null}">
                            <h1>Product Not Found</h1>
                        </c:if>
                    </div>
                </div>



            </div>
        </div>
    </body>
</html>