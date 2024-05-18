/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import entity.Cart;
import entity.Carts;
import entity.Color;
import entity.Colors;
import entity.Customers;
import entity.Order;
import entity.OrderCustomer;
import entity.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LINH
 */
public class DetailDAO {

    Connection conn = null; //ket noi toi sql_server
    PreparedStatement ps = null; //nem cau lenh sql tu netbean sang sql server
    ResultSet rs = null; //nhan ket qua tra ve

//    public Detail getProductByID(int productID) {
//        String query = "";
//        try {
//            conn = new JDBC().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, productID);
//            rs = ps.executeQuery();
//            /*private String productID;
//    private String color;
//    private String linkImageColor;
//    private String size;
//    private int count;*/
//            while (rs.next()) {
//                return new Detail(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getInt(5));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }
   

    

    public int getCountProduct(int storeID, int productID) {
        String query = "  SELECT amount \n" +
"  FROM Store_Detail\n" +
"  WHERE productID = ? AND storeID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, storeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

 public void insertCart(int cusID, String sID, String pID, String size, String color, int quantity) {
        String query = "Insert into Cart values (?,?,?,?,?,?,1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cusID);
            ps.setString(2, sID);
            ps.setString(3, pID);
            ps.setString(4, size);
            ps.setString(5, color);
            ps.setInt(6, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
 public void updateCart(int quantity, int pro) {
        String query = "update Cart set Amount = ? where CartID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, pro);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
 public List<Carts> showCart(int cus, int stt) {
        List<Carts> list = new ArrayList<>();
        String query = "  select c.cartID, c.userID, cd.productID, cd.amount, c.status, p.productName, p.imageLink, p.price, p.price * cd.amount as total, cd.cartDetaiID, cd.storeID\n" +
"  from Cart_Detail as cd INNER JOIN Carts as c ON (cd.cartID = c.cartID) \n" +
"  INNER JOIN Products as p ON (cd.productID = p.productID)\n" +
"  WHERE userID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cus);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Carts(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),

                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getInt(10),
                        rs.getInt(11)
                ));
            }
        } catch (Exception e) {

        }
        return list;

    }
 
    public void deleteCart(int CartID) {
        String query = "  delete Cart_Detail where cartDetaiID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, CartID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
    public void checkout(int orderID, int productID, int amount, int storeID) {
        String query = "INSERT INTO Orders_Detail VALUES(?, ?, '1', ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.setInt(4, storeID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
 public Carts showCheckOut(int id) {
        Carts c = null;
        String query = "SELECT  cd.cartID, cd.amount, p.productName,  (cd.amount*p.price) as total\n" +
"FROM Cart_Detail as cd INNER JOIN Products as p ON cd.productID = p.productID\n" +
"WHERE cd.cartDetaiID = ?";
              
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Carts(
                        rs.getInt(1),
                        0, 0,
                        rs.getInt(2),
                        0,
                        rs.getString(3),
                        "" ,0,
                        rs.getDouble(4),
                        0 ,0
                );
            }
        } catch (Exception e) {

        }
        return c;

    }
 public  Customers getCustomer(int id) {
       String query = "select * from Customers where CustomerID = ?";
       try {
           conn = new DBContext().getConnection();
           ps =  conn.prepareStatement(query);
           ps.setInt(1,id);
           rs=ps.executeQuery();
           while(rs.next()) {
               return new Customers(rs.getInt(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getString(5),
                       rs.getInt(6)
                       );
           }
       } catch (Exception e) {
       }
        return null;
   }
 
 
 
 public void updateCarts(String Color, String Size, int Amount, int CartID) {
        String query = "update Cart set Color = ?, Size = ?, Amount = ? where CartID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Color);
            ps.setString(2, Size);
            ps.setInt(3, Amount);
            ps.setInt(4, CartID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
 public void insertOrder(int userID, String address, String payWay, String phone, String receiver, int total) {
        String query = "Insert into Orders(userID, foundedDate, deliveryDate, address, paymentWay, paymentStatus, phone, receiver, total, status) values (?, GETDATE(), NULL, ?, ?, NULL, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, address);
            ps.setString(3, payWay);
            ps.setString(4, phone);
            ps.setString(5, receiver);
            ps.setInt(6, total);
            ps.setString(7, "1");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
 
    public List<OrderCustomer> ShowOrder(int userID) {
           List<OrderCustomer> list = new ArrayList<>();
           String query = "SELECT o.orderID, storeID, productName, quantity, phone, address, quantity*price, od.orderStatus, od.orderDetailID, p.imageLink\n" +
"FROM Orders as o INNER JOIN Orders_Detail as od ON o.orderID = od.orderID\n" +
"INNER JOIN Products as p ON od.productID = p.productID\n" +
"WHERE userID = ? ORDER BY o.orderID DESC";
           try {
               conn = new DBContext().getConnection();
               ps = conn.prepareStatement(query);
               ps.setInt(1, userID);
               rs = ps.executeQuery();
               while (rs.next()) {
                   OrderCustomer o = new OrderCustomer(rs.getInt(1), 
                   rs.getInt(2),
                   rs.getString(3),
                   rs.getInt(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getInt(7),
                   rs.getString(8),
                   rs.getInt(9),
                   rs.getString(10));
                   list.add(o);
               }
           } catch (Exception e) {

           }
           return list;

    }
    
    public List<OrderCustomer> getListConfirm(int userID) {
           List<OrderCustomer> list = new ArrayList<>();
           String query = "SELECT o.orderID, storeID, productName, quantity, phone, address, quantity*price, od.orderStatus, od.orderDetailID, p.imageLink\n" +
"FROM Orders as o INNER JOIN Orders_Detail as od ON o.orderID = od.orderID\n" +
"INNER JOIN Products as p ON od.productID = p.productID\n" +
"WHERE userID = ? AND orderStatus = '2'";
           try {
               conn = new DBContext().getConnection();
               ps = conn.prepareStatement(query);
               ps.setInt(1, userID);
               rs = ps.executeQuery();
               while (rs.next()) {
                   OrderCustomer o = new OrderCustomer(rs.getInt(1), 
                   rs.getInt(2),
                   rs.getString(3),
                   rs.getInt(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getInt(7),
                   rs.getString(8),
                   rs.getInt(9),
                   rs.getString(10));
                   list.add(o);
               }
           } catch (Exception e) {

           }
           return list;

    }
    
    public void cancelOrder(int oid) {
        String query = "DELETE Orders_Detail WHERE orderDetailID = ?";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
 
    public int getIdNewestOrder() {
        String query = "SELECT TOP 1 orderID \n" +
"FROM Orders\n" +
"ORDER BY orderID DESC";
        int id = 0;
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return id;
    }
    
}
