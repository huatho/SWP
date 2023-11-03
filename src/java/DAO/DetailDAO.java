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
    public List<Color> getListColor(int productID) {
        List<Color> listColor = new ArrayList<>();
        String query = "SELECT pimage.Color, pimage.linkImageColor\n"
                + " FROM Products as p\n"
                + " left join Product_Image as pimage ON p.productID = pimage.productID\n"
                + " where p.ProductID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Color c = new Color(rs.getString(1),
                                    rs.getString(2));
                listColor.add(c);
            }
        } catch (Exception e) {
        }
        return listColor;
    }

    public List<Size> getListSize(int productID) {
        List<Size> listSize = new ArrayList<>();
        String query = "Select DISTINCT pd.size\n"
                + "From Product_Detail As pd\n"
                + "where pd.productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Size z = new Size(rs.getString(1));
                listSize.add(z);
            }
        } catch (Exception e) {
        }
        return listSize;
    }

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
public Cart showCart1(String cus, int stt, String size, String color, int cid) {
        String query = "select ct.* from Product p, Cart ct, ProductDetail pd, Customers c\n" +
                        "where p.ProductID = pd.ProductID\n" +
                        "and ct.ProductID = p.ProductID \n" +
                        "and ct.Size = pd.Size\n" +
                        "and ct.Color = pd.Color\n" +
                        "and c.CustomerID = ct.CustomerID\n" +
                        "and ct.[Status] < ?\n" +
                        "and ct.ProductID = ?\n" +
                        "and ct.Size = ?\n" +
                        "and ct.Color = ?\n" +
                        "and ct.CustomerID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, stt);
            ps.setString(2, cus);
            ps.setString(3, size);
            ps.setString(4, color);
            ps.setInt(5, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Cart(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {

        }
        return null;

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
        String query = "  select c.cartID, c.userID, cd.productID, cd.size, cd.color, cd.amount, c.status, p.productName, p.imageLink, p.price, p.price * cd.amount as total, cd.cartDetaiID, cd.storeID\n" +
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
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getInt(12),
                        rs.getInt(13)
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
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4)
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
 public List<Size> showSizeProducts(int stt, int ct) {
        List<Size> list = new ArrayList<>();
        String query = "select DISTINCT pd.Size from Product p, Cart ct, ProductDetail pd, Customers c\n"
                + "where p.ProductID = pd.ProductID\n"
                + "and ct.ProductID = p.ProductID \n"
                + "and c.CustomerID = ct.CustomerID\n"
                + "and ct.[Status] < ?\n"
                + "and ct.CartID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, stt);
            ps.setInt(2, ct);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Size(
                        rs.getString(1)));
            }
        } catch (Exception e) {

        }
        return list;

    }
 public Carts showCart1s(int stt, int ct) {
        String query = "select ct.*, p.ProductName, p.ImageLink, p.Price, p.Price * ct.Amount as total\n"
                + "from Product p, Cart ct, ProductDetail pd, Customers c\n"
                + "where p.ProductID = pd.ProductID\n"
                + "and ct.ProductID = p.ProductID \n"
                + "and ct.Size = pd.Size\n"
                + "and ct.Color = pd.Color\n"
                + "and c.CustomerID = ct.CustomerID\n"
                + "and ct.[Status] < ?\n"
                + "and ct.CartID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, stt);
            ps.setInt(2, ct);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Carts(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDouble(11),
                        rs.getDouble(12));
            }
        } catch (Exception e) {

        }
        return null;

    }
 public List<Colors> getListColors(int stt, int ct) {
        List<Colors> listColor = new ArrayList<>();
        String query = "select DISTINCT pd.Color from Product p, Cart ct, ProductDetail pd, Customers c\n"
                + "where p.ProductID = pd.ProductID\n"
                + "and ct.ProductID = p.ProductID \n"
                + "and c.CustomerID = ct.CustomerID\n"
                + "and ct.[Status] < ?\n"
                + "and ct.CartID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, stt);
            ps.setInt(2, ct);
            rs = ps.executeQuery();
            while (rs.next()) {
                listColor.add(new Colors(
                        rs.getString(1)));
            }
        } catch (Exception e) {
        }
        return listColor;
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
        String query = "Insert into Orders values (?, GETDATE(), NULL, ?, ?, NULL, ?, ?, ?, ?)";
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
            ps.setInt(2, oid);
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
