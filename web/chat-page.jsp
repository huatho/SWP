
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <title>
            Chat
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

            .item-user-chat:hover {
                cursor: pointer;
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
                        <li>
                            <a href="view-product">
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                <p>Quản lý sản phẩm</p>
                            </a>
                        </li>
                        <li class="active">
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
                            <a class="navbar-brand" href="">Danh sách tin nhắn</a>
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
                <c:set var="listCustomerChat" value="${requestScope.LIST_CUSTOMER_CHAT}"/>
                <c:set var="listMessage" value="${requestScope.LIST_MESSAGE}"/>

                <div class="content">
                    <div class="row p-3">
                        <div class="col-md-8">
                            <div class="col">
                                <c:if test="${listMessage.size() > 0}">
                                    <div class="row align-items-center item-user-chat" style="border-bottom: 1px solid grey; margin-bottom: 20px;">
                                    <div class="m-3" style="border-radius: 50%; width: 50px; height: 50px; border: 1px solid silver;">
                                        <c:if test="${listMessage.get(0).customerDTO.avatar == null}">
                                            <img src="img/default-avatar.png" alt=""/>
                                        </c:if>
                                        <c:if test="${listMessage.get(0).customerDTO.avatar != null}">
                                            <img src="${listMessage.get(0).customerDTO.avatar}" alt=""/>
                                        </c:if>
                                    </div>
                                    <h4>${listMessage.get(0).customerDTO.customerName}</h4>
                                </div>
                                </c:if>
                                <c:forEach var="message" items="${listMessage}">
                                    <c:if test="${!message.isCustomerSend}">
                                        <div class="row justify-content-between">
                                            <div class="col-md-6"></div>
                                            <div class="col-md-6" style="display: flex; justify-content: flex-end; margin-bottom: 20px">
                                                <span style="border-radius: 100px; background: blue; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); padding: 10px 15px 10px 15px; color: white;">${message.messageChat}</span>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${message.isCustomerSend}">
                                        <div class="row justify-content-between">
                                            <div class="col-md-6" style="display: flex; justify-content: flex-start; margin-bottom: 20px">
                                                <span style="border-radius: 100px; background: #fefefe; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); padding: 10px 15px 10px 15px; color: black;">${message.messageChat}</span>
                                            </div>
                                            <div class="col-md-6"></div>
                                        </div>
                                    </c:if>


                                </c:forEach>
                                <c:if test="${listMessage.size() > 0}">
                                    <form action="create-chat" method="POST">
                                    <input type="hidden" name="txtCustomerID" value="${listMessage.get(0).customerDTO.customerID}"/>
                                    <input type="hidden" name="txtSellerID" value="${listMessage.get(0).sellerDTO.sellerID}"/>
                                    <input type="hidden" name="isCustomer" value="false"/>

                                    <div class="row align-items-center mt-3">
                                        <div class="col-md-10"><input type="text" name="txtMessage" value="" placeholder="" style="width: 100%; border-radius: 100px; border: 1px solid silver; padding: 10px 15px 10px 15px; color: black;" required/>
                                        </div>
                                        <div class="col-md-2"><button type="submit" class="btn btn-success">Gửi</button></div>
                                    </div>
                                </form>
                                </c:if>
                            </div>
                        </div>
                        <div class="col-md-4" style="background: white; border-radius: 10px; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3);">
                            <div class="col">
                                <p style="padding-top: 20px; font-weight: bold;">Danh sách người nhắn tin</p>
                                <c:forEach var="customerChat" items="${listCustomerChat}">
                                    <div onclick="location.href = 'get-chat?customerID=${customerChat.customerID}'" class="row align-items-center item-user-chat" style="border-bottom: 1px solid grey;">
                                        <div class="m-3" style="border-radius: 50%; width: 50px; height: 50px; border: 1px solid silver;">
                                            <c:if test="${customerChat.avatar == null}"><img src="img/default-avatar.png" alt=""/></c:if>      
                                            <c:if test="${customerChat.avatar != null}"><img src="${customerChat.avatar}" alt=""/></c:if>
                                            </div>
                                            <h4>${customerChat.customerName}</h4>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>



            </div>
        </div>
    </body>
</html>