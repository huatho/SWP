<%-- 
    Document   : home-page
    Created on : Nov 30, 2022, 1:01:35 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <title>Danh sách cửa hàng</title>
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
        <c:set var="listStore" value="${sessionScope.LIST_STORE}"/>
        <div class="row justify-content-between" style="height: 50px; background: white; box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); padding: 20px;">
            <div class="col-md-1">
                <a href="home"><i class="fa fa-angle-left" style="color: black; font-size: 22px"></i></a>
            </div>
            <div class="col-md-4"></div>
            <div class="col-md-2"><h3>Cửa hàng</h3></div>
            <div class="col-md-4"></div>
            <div class="col-md-1">
                <div class="dropdown">
                    <div class="row">
                        <div class="col-md-5"><i class="fa fa-gear"></i></div>
                        <div class="col-md-5"><i class="fa fa-caret-down"></i></div>
                    </div>
                    <div class="dropdown-content">
                        <c:if test="${sessionScope.account != null}">
                            <a href="get-chat-user">Tin nhắn</a></br>
                            <a href="logout">Logout</a>
                        </c:if>
                        <c:if test="${sessionScope.account == null}">
                            <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="wrapper ">
            <div class="main-panel">
                <div class="content">
                    <div class="row" style="padding: 20px">
                        <c:if test="${listStore == null}">
                            <h4>Don't have store!</h4>
                        </c:if>
                        <c:if test="${listStore != null}">
                            <c:forEach items="${listStore}" var="store">
                                <div class="col-md-4" style="margin-top: 20px; margin-bottom: 20px;">
                                    <div class="card card-user" style="box-shadow: 0px 2px 4px rgba(58, 87, 232, 0.3); border-radius: 10px;">
                                        <div class="card-header" style="text-align: center;">
                                            <h5 class="card-title">${store.name}</h5>
                                            <div onclick="document.getElementById('id01').style.display = 'block'; document.getElementById('storeIDReport').value =${store.storeID}" style="background: red; border-radius: 50%; display: flex; align-items: center; vertical-align: middle; width: 20px; height: 20px; position: absolute; top: 5px; right: 5px;"><i class="fa fa-info" style="margin: auto; color: white; font-size: 10px"></i></div>
                                        </div>
                                        <div class="card-body" onclick="location.href = 'redirect-store?store=${store.storeID}&storeName=${store.name}'">
                                            <div style="padding: auto; margin: auto;">
                                                <img src="images/default-image.jpg" class="img-fluid img-thumbnail" alt="aefe" id="blah" />
                                               
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <span> <strong>${store.userName}</strong> - ${store.address}</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
        <div id="id01" class="modal">
            <form class="modal-content" action="create-report" method="post">
                <input type="hidden" value="" name="storeIDReport" id="storeIDReport"/>
                <div class="imgcontainer">
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                    <strong>Báo cáo cửa hàng</strong>
                </div>

                <div class="container">
                    <input type="text" placeholder="Nội dung báo cáo" name="txtContent" value="" required/>
                    <button type="submit">Báo cáo</button>
                </div>
            </form>
        </div>
        <c:if test="${requestScope.RESULT}">
            <script>
                alert('Báo cáo cửa hàng thành công');
            </script>
        </c:if>
        <script>
            var modal = document.getElementById('id01');

            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
    </body>
</html>
