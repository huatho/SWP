<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            Thông tin sản phẩm
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
              name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
              integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
        <!-- CSS Files -->
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
        <c:set var="product" value="${PRODUCT}"/>
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <div class="logo">
                    <a href="" class="simple-text logo-mini">
                        <div class="logo-image-small">
                            <img src="img/logo-small.png">
                        </div>
                        <!-- <p>CT</p> -->
                    </a>
                    <a href="" class="simple-text logo-normal">
                        @huytn
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li>
                            <a href="#">
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
<!--                        <li>
                            <a href="GetChatServlet">
                                <i class="fa fa-comment" aria-hidden="true"></i>
                                <p>Doanh thu</p>
                            </a>
                        </li>-->
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
                            <c:if test="${product == null}">
                                <a class="navbar-brand" href="">Thêm sản phầm</a>
                            </c:if>
                            <c:if test="${product != null}">
                                <a class="navbar-brand" href="">Sửa thông tin sản phầm</a>
                            </c:if>
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
                <!-- End Navbar -->

                <div class="content">
                    <c:if test="${product == null}">
                        <form action="create-product" method="POST" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="card card-user">
                                        <div class="card-header" style="text-align: center;">
                                            <h5 class="card-title">Hình ảnh sản phẩm</h5>
                                        </div>
                                        <div class="card-body">
                                            <div class="col-md-6" style="padding: auto; margin: auto;">
                                                <img src="img/default-image.png"
                                                     class="img-fluid img-thumbnail" alt="" id="blah">
                                                <input type="file" name="txtImageLink" accept="image/*" onchange="readURL(this);">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="card card-user">
                                        <div class="card-header">
                                            <h5 class="card-title">Thông tin sản phẩm</h5>
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Tên sản phẩm</label>
                                                        <input name="txtProductName" type="text" class="form-control" placeholder="Product Name" required="true"
                                                               >
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Description</label>
                                                        <textarea name="txtDescription" rows="4" class="form-control" placeholder="Description"
                                                                  ></textarea>
                                                    </div>
                                                </div>
                                                <div class="row col-md-12">
                                                    
                                                    <div class="col-md-6">
                                                        <label for="exampleFormControlSelect1">Loại sản phẩm</label>
                                                        <select class="form-control search-slt" id="exampleFormControlSelect1" name="txtCategory">
                                                            <c:forEach var="category" items="${LIST_CATEGORY}">
                                                                <option value="${category.categoryID}">${category.categoryName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div style="height: 20px;"></div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Giá</label>
                                                        <input name="txtPrice" type="number" class="form-control" placeholder="Price" required="true">
                                                    </div>

                                                </div>
                                            </div>


                                            <div class="row">
                                                <div class="update ml-auto mr-auto">
                                                    <button type="submit" class="btn btn-primary btn-round">Thêm sản phẩm</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </c:if>
                    <c:if test="${product != null}">
                        <form action="update-product" method="POST" enctype="multipart/form-data">
                            <div class="row">
                                <input type="hidden" name="txtProductID" value="${product.productID}"/>  
<!--                                <input type="hidden" name="txtStoreID" value="{product.storeID}"/>-->

                                <div class="col-md-6">
                                    <div class="card card-user">
                                        <div class="card-header" style="text-align: center;">
                                            <h5 class="card-title">Hình ảnh sản phẩm</h5>
                                        </div>
                                        <div class="card-body">
                                            <div class="col-md-6" style="padding: auto; margin: auto;">
                                                <img src="${product.imageLink}"
                                                     class="img-fluid img-thumbnail" alt="" id="blah">
                                                <input type="hidden" name="txtImageLinkHide" value="${product.imageLink}">
                                                <input type="file" name="txtImageLink" accept="image/*" onchange="readURL(this);">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="card card-user">
                                        <div class="card-header">
                                            <h5 class="card-title">Thông tin sản phẩm</h5>
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Tên sản phẩm</label>
                                                        <input name="txtProductName" type="text" class="form-control" placeholder="Product Name"
                                                               value="${product.productName}" required="true">
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Description</label>
                                                        <textarea name="txtDescription" rows="4" class="form-control" placeholder="Description"
                                                                  >${product.descriptions}</textarea>
                                                    </div>
                                                </div>
                                                <div class="row col-md-12">
                                                    
                                                    <div class="col-md-6">
                                                        <label for="exampleInputEmail1">Loại sản phẩm</label>
                                                        <select class="form-control search-slt" id="exampleFormControlSelect1" name="txtCategory">
                                                            <c:forEach var="category" items="${LIST_CATEGORY}">
                                                                <option value="${category.categoryID}" <c:if test="${product.categoryID == category.categoryID}">selected</c:if>>${category.categoryName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div style="height: 20px;"></div>
                                                <div class="col-md-12">
                                                    <div>
                                                        <label for="exampleInputEmail1">Giá</label>
                                                        <input name="txtPrice" type="number" class="form-control" placeholder="Price" value="${product.price}" required="true">
                                                    </div>

                                                </div>
                                            </div>


                                            <div class="row">
                                                <div class="update ml-auto mr-auto">
                                                    <button type="submit" class="btn btn-primary btn-round">Cập nhật thông
                                                        tin</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </c:if>
                </div>

            </div>
        </div>
    </body>
    <script
        class="jsbin"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"
    ></script>
    <script
        class="jsbin"
        src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"
    ></script>
    <script>
                                                    function readURL(input) {
                                                        console.log("aaaaaaaaa");
                                                        if (input.files && input.files[0]) {
                                                            var reader = new FileReader();

                                                            reader.onload = function (e) {
                                                                $('#blah').attr('src', e.target.result);
                                                            };

                                                            reader.readAsDataURL(input.files[0]);
                                                        }
                                                    }
    </script>
</html>