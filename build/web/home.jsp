<%@page import="entity.Orders"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/font-awesome-line-awesome/css/all.min.css">
<link rel="stylesheet" href="http://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">

</head>
<body>
    <style>
         *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            list-style-type: none;
            text-decoration: none;
            font-family: 'Poppins', sans-serif;
        }
        
        .sidebar{
            width: 333px;
            position: fixed;
            left: 0;
            top: 0;
            height: 100vh;
            background: #008ea1;
            z-index: 100;
            transition: width 300ms;
        }
        
        .main-content{
            transition: margin-left 100ms;
            margin-left: -2%;
            background-color: blue;
        }
        .table .payWay{
            background: blue;
            color: white;
            border-radius: 5px;
            width: 70%;
            font-size: 12px;
            height: 50%;
            font-weight: 500;
            text-align: center;
        }
        .table .payStatus{
            background: red;
            color: white;
            border-radius: 5px;
            width: 70%;
            font-size: 12px;
            height: 50%;
            font-weight: 500;
            text-align: center;
        }
 
        .sidebar-brand{
            height: 90px;
            padding: 1rem 0rem 1rem 2rem;
            color: #fff;
        }
        
        .sidebar-brand span {
            display: inline-block;
            margin-right: 1rem;
        }
        
        .sidebar-brand a {
            color: #fff;
        }
        
        .sidebar-menu {
            margin-top: 1rem;
        }
        
        .sidebar-menu li {
            width: 100%;
            margin-bottom: 2rem;
            padding-left: 5%;
        }
        
        .sidebar-menu a {
            padding-left: -200%;
            display: block;
            color: #fff;
            font-size: -200%;
        }
        
        .sidebar-menu a span:first-child {
            font-size: 1.5rem;
            padding-left: 2rem;
        }
        
        .sidebar-menu a.active {
            background: #fff;
            padding-top: 1rem;
            padding-bottom: 1rem;
            color: #008ea1;
            border-radius: 30px 0px 0px 30px;
        }
        
        .search-wrapper {
            border: 1px solid #008ea1;
            border-radius: 30px;
            height: 50px;
            display: flex;
            align-items: center;
            overflow-x: hidden;
        }
        
        .search-wrapper span {
            display: inline-block;
            padding: 0rem 1rem;
            font-size: 1.5rem;
            color: #008ea1;
        }
        .search-wrapper input {
            height: 100%;
            padding: .5rem;
            border: none;
            outline: none;
        }
        header {
            background-color: #fff;
            display: flex;
            justify-content: space-between;
            padding: 1rem;
            box-shadow: 2px 5px 15px 2px rgb(0 0 0 / 10%);
            position: absolute;
            left: 22%;
            width: calc(100% - 22%);
            top: 0;
            z-indez: 100;
            transition: left 300ms; 
        }
        
        header h2 {
            color: #222;
        }
        header label span {
            font-size: 1.7rem;
            padding-left: 1rem;
        }
        .user-wrapper {
            display: flex;
            align-items: center;
        }
        
        .user-wrapper img {
            border-radius: 50%;
            margin-right: 5rem;
        }
        
        .user-wrapper small {
            display: inline-block;
            color: #ccc;
        }
        
        .user-wrapper h4{
            margin-bottom: 0rem;
        }
        
        main {
            margin-top: 65px;
            padding: 2rem 1.5rem;
            background-color: white;
            min-height: calc(100vh);
        }
        
        .table-order {
            width: 77%;
            right: 0;
            position: absolute;
        }
        
        .list123 {
            margin-left: 20px;
            width: 73%;
            margin-left: 26%;
        }
        .accueil {
            font-size: 2.5rem;
            padding-right: 1rem;
            margin-left: 5px;
            color: #008ea1;
        }
        
        .logo-admin {
            cursor: pointer;
        }
        
        #dropdown{
            position: relative;
            display: inline-block;
        }
        
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            height: 80px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            padding: 5px;
            z-index: 1;
        }
        
        #dropdown:hover .dropdown-content{
            display:block;
            cursor: pointer;
        }
        
        .dropdown-content p{
            padding: .5rem;
        }


    </style>
    
    <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <a href="TopSellingControl"><h2><span class="lab la-accusoft"></span><span>Manager</span></h2></a>
        </div>
        
        <div class="sidebar-menu">
            <ul style=" list-style: none;">
                <li>
                    <a href="TopSellingControl"><span class="las la-igloo"></span>
                    <span>TopSelling</span></a>
                </li>
                <li>
                    <a href="homeServlet" class="active"><span class="las la-shopping-bag"></span>
                    <span>Orders</span></a>
                </li>
                <li>
                    <a href="qldanhthu"><span class="las la-users"></span>
                    <span>Revenue management</span></a>
                </li>
            </ul>   
        </div>
    </div>
    
    <div class="main-content">
        <header>
                <h2>
                    <label for="nav-toggle">
                        <span class="las la-bars" id="menu_icon"></span>
                    </label>
                    <span class="accueil">Orders</span>
                </h2>
        </header>
    
    
    <main>
    <div class="list123">
        <table class="cell-border" id="tb">
          
				<thead>
					<tr>						
						<th>Order ID</th>
						<th>Cart ID</th>
						<th>Founded Date</th>
						<th>Delivery Date</th>
						<th>Address</th>
                                                <th>Payment Way</th>
                                                <th>Payment Status</th>
                                                <th>Actions</th>
					</tr>
				</thead>
                                
                                <tbody>

                                    <c:forEach items="${listCo}" var="o">
                                        <tr>					
                                            <td>${o.orderID}</td>
                                            <td>${o.cartID}</td>
                                            <td>${o.foundedDate}</td>
                                            <td>${o.deliveryDate}</td>
                                            <td>${o.address}</td>
                                            <td> <div class="payWay" style=" background: blue;
            color: white;
            border-radius: 5px;
            width: 70%;
            font-size: 12px;
            height: 50%;
            font-weight: 500;
            text-align: center;">${o.paymentWay}</div></td>
                                            <c:if test="${o.paymentStatus == 1}">
                                                <td> <div class="payStatus" style="background: red;
                                                color: white;
                                                border-radius: 5px;
                                                width: 70%;
                                                font-size: 12px;
                                                height: 50%;
                                                font-weight: 500;
                                                text-align: center;">Chưa xử lý</div>
                                            </td>
                                            </c:if>
                                            <c:if test="${o.paymentStatus == 2}">
                                                <td> <div class="payStatus" style="background: red;
                                                color: white;
                                                border-radius: 5px;
                                                width: 70%;
                                                font-size: 12px;
                                                height: 50%;
                                                font-weight: 500;
                                                text-align: center;">Huỷ đơn</div>
                                            </td>
                                            </c:if>
                                            <c:if test="${o.paymentStatus == 3}">
                                                <td> <div class="payStatus" style="background: red;
                                                color: white;
                                                border-radius: 5px;
                                                width: 70%;
                                                font-size: 12px;
                                                height: 50%;
                                                font-weight: 500;
                                                text-align: center;">Đã giao hàng</div>
                                            </td>
                                            </c:if>
                                            <td>
                                                <a href="loadOrders?sid=${o.orderID}"><i class="material-icons" data-toggle="tooltip" title=Update">edit</i>Edit</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
				</tbody>
         
			</table>
    </div>
    </main>
        </div>
        
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready( function () {
        $('#tb').DataTable();
} );
</script>
</html>