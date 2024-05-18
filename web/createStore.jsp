<%-- 
    Document   : createStore
    Created on : Apr 15, 2024, 4:34:50 AM
    Author     : Os
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký người bán hàng</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
        font-family: Arial, sans-serif;
    }

    .background {
        background-image: url('image.jpg'); /* ÄÆ°á»ng dáº«n Ä‘áº¿n áº£nh ná»n */
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        max-width: 400px;
        background-color: rgba(255, 255, 255, 0.8);
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: red;
        border-bottom: 2px solid red;
        padding-bottom: 10px;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: bold;
    }

    input[type="text"],
    input[type="email"],
    input[type="tel"] {
        width: 100%;
        padding: 10px;
        border-radius: 4px;
        border: 1px solid #ccc;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #0056b3;
    }

    </style>
</head>
<body>
    <div class="background">
        <div class="container">
            <h2>Đăng ký người bán hàng</h2>
            <form action="newStore" method="post">
                
                 <div class="form-group">
                    <label for="phone">Tài khoản</label>
                    <input type="text" id="phone" name="username" value="${username}" disabled >
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${email}" disabled>
                </div>
                <div class="form-group">
                    <label for="shopName">Tên shop:</label>
                    <input type="text" id="shopName" name="storeName" required>
                </div>
                <div class="form-group">
                    <label for="address">Địa chỉ:</label>
                    <input type="text" id="address" name="address" required>
                </div>
               
                <div class="form-group">
                    <button type="submit">Đăng ký</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>

