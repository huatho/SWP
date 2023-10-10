<%-- 
    Document   : infoCus
    Created on : Nov 22, 2022, 11:15:53 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
        <!--  All snippets are MIT license http://bootdey.com/license -->
        <title>Thông tin khách hàng</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="${pageContext.request.contextPath}/assets/css/admin.css" rel="stylesheet"/>
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
        <style>
            .content-shop {
                display: flex;
            }

            .des {
                max-width: 600px;
                margin-left: 24px;
            }

            .des p {
                word-wrap: break-word;
            }

            body {
                background-image: url(https://images.unsplash.com/photo-1464618663641-bbdd760ae84a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
                background-position: center;
                background-size: cover;
            }
            .bg-secondary-soft {
                background-color: rgba(225, 225, 225, 0.75) !important;
            }
        </style>
        <!--header-->
        <div class="admin-header">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li style="margin-left: 300px" class="nav-item active">
                            <a class="nav-link" href="listU" style=" font-size: 1.2em; color: white;">Quay lại<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>    
        <!--header-->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Page title -->
                    <div class="my-5">
                        <h3 style="color: black;">Profile ${cus.customerName}</h3>
                        <hr style="color: black;">
                    </div>
                    <!-- Form START -->
                    <form style="color: black;" class="file-upload" action="${pageContext.request.contextPath}/infoSell" method="post">
                        <div class="row mb-5 gx-5">
                            <!-- Contact detail -->
                            <div class="col-xxl-8 mb-5 mb-xxl-0">
                                <div class="bg-secondary-soft px-4 py-5 rounded">
                                    <div class="row g-3">
                                        <h4 class="mb-4 mt-0">Contact detail</h4>
                                        <div class="col-md-6" style="display: none;">
                                            <label class="form-label">UserID</label>
                                            <input name="" type="text" class="form-control" placeholder="" aria-label="UserID" value="${s.id}">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">CustomerID</label>
                                            <input name="" type="text" class="form-control" placeholder="" aria-label="UserName" value="${s.sellerID}">
                                        </div>
                                        <!-- First Name -->
                                        <div class="col-md-6">
                                            <label class="form-label">Tên tài khoản</label>
                                            <input name="" type="text" class="form-control" placeholder="" aria-label="UserName" value="${s.acc}">
                                        </div>
                                        <!-- Last name -->
                                        <div class="col-md-6">
                                            <label class="form-label">Mật khẩu</label>
                                            <input type="password" class="form-control" placeholder="" aria-label="Last name" value="${s.pass}" readonly="">
                                        </div>
                                        <!-- Phone number -->
                                        <div class="col-md-6">
                                            <label class="form-label">Email</label>
                                            <input type="text" class="form-control" placeholder="" aria-label="Email" value="${s.email}">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Tên</label>
                                            <input type="text" class="form-control" placeholder="" aria-label="Phone number" value="${s.sellerName}">
                                        </div>
                                        <!-- Email -->
                                        <div class="col-md-6">
                                            <label for="inputEmail4" class="form-label">Số điện thoại</label>
                                            <input type="email" class="form-control" id="inputEmail4" value="${s.phone}">
                                        </div>
                                        <!-- Skype -->
                                        <div class="col-md-6">
                                            <label class="form-label">Địa chỉ</label>
                                            <input type="text" class="form-control" placeholder="" aria-label="Phone number" value="${s.sellerAdd}">
                                        </div>
                                    </div> <!-- Row END -->
                                </div>
                            </div>
                            <!-- Upload profile -->
                            <div class="col-xxl-4">
                                <div class="bg-secondary-soft px-4 py-5 rounded">
                                    <div class="row g-3">
                                        <h4 style="display: flex; justify-content: center;" class="mb-4 mt-0">Avatar</h4>
                                        <div class="text-center">
                                            <!-- Image upload -->
                                            <div class="square position-relative display-2 mb-3">
                                                <img style="width: 250px; height: 250px; object-fit: contain;" src="${s.avatar}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- Row END -->
                        <!-- button -->

                    </form> <!-- Form END -->
                    <div style="color: black;" class="row mb-5 gx-5">
                        <div class="col-xxl-8 mb-5 mb-xxl-0">
                            <div class="bg-secondary-soft px-4 py-5 rounded">
                                <div class="row g-3">
                                    <h4 class="mb-4 mt-0">
                                        ${s.storeName}
                                    </h4>
                                    <div class="col-mb-4 content-shop">
                                        <img class="rounded-circle img-fluid"
                                             src="${s.linkImage}"
                                             alt="avtar" style="width: 200px; height: 200px; object-fit: cover;">
                                        <div class="des mb-8">
                                            <h3>Mô tả:</h3>
                                            <p>${s.descriptions}
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">

        </script>
    </body>
</html>