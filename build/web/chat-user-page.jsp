<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <title>Danh sách tin nhắn</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
              integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />

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

            input[type=text] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            /* Center the image and position the close button */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }


            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 80%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <c:set var="listProductStore" value="${sessionScope.LIST_PRODUCT_STORE}"/>
        <div class="row justify-content-between" style="height: 50px; background: white; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); padding: 20px;">
            <div class="col-md-1">
                <a href="view-store"><i class="fa fa-angle-left" style="color: black; font-size: 22px"></i></a>
            </div>
            <div class="col-md-4"></div>
            <div class="col-md-2"><h3>${requestScope.STORE_NAME}</h3></div>
            <div class="col-md-4"></div>
            <div class="col-md-1">
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
        <c:set var="listSellerChat" value="${requestScope.LIST_SELLER_CHAT}"/>
        <c:set var="listMessage" value="${requestScope.LIST_MESSAGE}"/>
        <div class="wrapper ">
            <div class="main-panel">
                <div class="content">
                    <div class="row p-3">
                        <div class="col-md-8">
                            <div class="col">
                                <c:if test="${listMessage.size() > 0}">
                                    <div class="row align-items-center item-user-chat" style="border-bottom: 1px solid grey; margin-bottom: 20px;">
                                        <div class="col-md-2 m-3" style="border-radius: 50%; width: 50px; height: 50px; border: 1px solid silver;">
                                            <c:if test="${listMessage.get(0).sellerDTO.avatar == null}">
                                                <img src="img/default-avatar.png" alt="" style="max-width: 100%; height: auto;"/>
                                            </c:if>
                                            <c:if test="${listMessage.get(0).sellerDTO.avatar != null}">
                                                <img src="${listMessage.get(0).sellerDTO.avatar}" alt="" style="max-width: 100%; height: auto;"/>
                                            </c:if>
                                        </div>
                                        <h4 class="col-md-10">${listMessage.get(0).sellerDTO.sellerName}</h4>
                                    </div>

                                    <c:forEach var="message" items="${listMessage}">
                                        <c:if test="${message.isCustomerSend}">
                                            <div class="row justify-content-between">
                                                <div class="col-md-6"></div>
                                                <div class="col-md-6" style="display: flex; justify-content: flex-end; margin-bottom: 20px">
                                                    <span style="border-radius: 100px; background: blue; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); padding: 10px 15px 10px 15px; color: white;">${message.messageChat}</span>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${!message.isCustomerSend}">
                                            <div class="row justify-content-between">
                                                <div class="col-md-6" style="display: flex; justify-content: flex-start; margin-bottom: 20px">
                                                    <span style="border-radius: 100px; background: #fefefe; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); padding: 10px 15px 10px 15px; color: black;">${message.messageChat}</span>
                                                </div>
                                                <div class="col-md-6"></div>
                                            </div>
                                        </c:if>


                                    </c:forEach>
                                    <form action="create-chat" method="POST">
                                        <input type="hidden" name="txtCustomerID" value="${listMessage.get(0).customerDTO.customerID}"/>
                                        <input type="hidden" name="txtSellerID" value="${listMessage.get(0).sellerDTO.sellerID}"/>
                                        <input type="hidden" name="isCustomer" value="true"/>

                                        <div class="row align-items-center mt-3">
                                            <div class="col-md-10"><input type="text" name="txtMessage" value="" placeholder="" style="width: 100%; border-radius: 100px; border: 1px solid silver; padding: 10px 15px 10px 15px; color: black;" required/>
                                            </div>
                                            <div class="col-md-2"><button type="submit" class="btn btn-success">Gửi</button></div>
                                        </div>
                                    </form>
                                </c:if>
                                    <c:if test="${listMessage.size() == 0}">
                                        <form action="create-chat" method="POST">
                                            <input type="hidden" name="txtCustomerID" value="${sessionScope.custom.customerID}"/>
                                        <input type="hidden" name="txtSellerID" value="${requestScope.SELLER_ID}"/>
                                        <input type="hidden" name="isCustomer" value="true"/>

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
                                <c:forEach var="sellerChat" items="${listSellerChat}">
                                    <div onclick="location.href = 'get-chat-user?sellerID=${sellerChat.sellerID}'"  class="row align-items-center" style="border-bottom: 1px solid grey;">
                                        <div class="col-md-2 m-3" style="border-radius: 50%; width: 50px; height: 50px; border: 1px solid silver;">
                                            <c:if test="${sellerChat.avatar == null}"><img src="img/default-avatar.png" alt="" style="max-width: 100%; height: auto;"/></c:if>      
                                            <c:if test="${sellerChat.avatar != null}"><img src="${sellerChat.avatar}" alt="" style="max-width: 100%; height: auto;"/></c:if>
                                            </div>
                                            <h4 class="col-md-10">${sellerChat.sellerName}</h4>
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
