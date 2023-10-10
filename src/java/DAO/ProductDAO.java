/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.CardProduct;
import entity.Cart;
import entity.Product;
import entity.store1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LINH
 */
public class ProductDAO {

    Connection conn = null; //ket noi toi sql_server
    PreparedStatement ps = null; //nem cau lenh sql tu netbean sang sql server
    ResultSet rs = null; //nhan ket qua tra ve
    
    public Product getNewProduct() {
        String query = "SELECT top 1 * FROM Products\n" +
"ORDER BY productID DESC";
        Product p = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public List<CardProduct> getTopProduct() {
        List<CardProduct> listTop = new ArrayList<>();
        String query = "SELECT TOP 6 p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, s.storeID, s.storeName\n" +
"FROM Store_Detail as sd INNER JOIN Products as p ON sd.productID = p.productID\n" +
"INNER JOIN Stores as s ON sd.storeID = s.storeID\n" +
"INNER JOIN Category as c ON p.categoryID = c.categoryID ORDER BY productID DESC";
              
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CardProduct p = new CardProduct(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)
                       );
                listTop.add(p);
            }
        } catch (Exception e) {
        }
        return listTop;
    }


    public int getTotalProduct() {
        String query = "SELECT COUNT(*) FROM Products";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<CardProduct> pagingProduct(int index) {
        List<CardProduct> listProductInPage = new ArrayList<>();
        String query = "SELECT p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, s.storeID, s.storeName, sd.amount\n" +
"FROM Store_Detail as sd INNER JOIN Products as p ON sd.productID = p.productID\n" +
"INNER JOIN Stores as s ON sd.storeID = s.storeID\n" +
"INNER JOIN Category as c ON p.categoryID = c.categoryID\n" +
"ORDER BY productID\n" +
"OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                CardProduct p = new CardProduct(
                        rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getString(10),
                            rs.getInt(11)
                );
                listProductInPage.add(p);
            }
        } catch (Exception e) {
        }
        return listProductInPage;
    }


    public int getTotalProductByCategory(int categoryID) {
        if (categoryID == 0) {
            return getTotalProduct();
        } else {
            String query = "SELECT COUNT(*) FROM Products WHERE CategoryID = ?";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, categoryID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (Exception e) {
            }
        }
        return 0;
    }
    
//    public int getTotalProductByCategory(int categoryID) {
//        if (categoryID == 0) {
//            return getTotalProduct();
//        } else {
//            String query = "SELECT COUNT(*) FROM Products WHERE CategoryID = ?";
//            try {
//                conn = new DBContext().getConnection();
//                ps = conn.prepareStatement(query);
//                ps.setInt(1, categoryID);
//                rs = ps.executeQuery();
//                while (rs.next()) {
//                    return rs.getInt(1);
//                }
//            } catch (Exception e) {
//            }
//        }
//        return 0;
//    }

   
                  

    public int getTotalProductBySex(String sex) {
        String query = "SELECT COUNT(*) FROM Products where sex = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sex);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> pagingProductBySex(String sex, int index) {
        List<Product> listProductInPage = new ArrayList<>();
        String query = "select p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, sum(pd.CountProduct) as totalProduct\n"
                + "from Products as p\n"
                + "left outer join Product_Detail as pd on (p.productID = pd.productID)\n"
                + "left outer join Category as c on (p.categoryID = c.categoryID)\n"
                + "WHERE sex like ?\n"
                + "group by p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName\n"
                + "ORDER BY productID\n"
                + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + sex + "%");
            ps.setInt(2, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9)
                       );
                listProductInPage.add(p);
            }
        } catch (Exception e) {
        }
        return listProductInPage;
    }


    public int getTotalProductBySearch(String txtSearch) {
        String query = "SELECT COUNT(*) FROM Products left join Store on Product.StoreID = Store.StoreID\n"
                + "where Product.ProductName like ? or Store.StoreName like ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> pagingProductBySearch(String txtSearch, int index) {
        List<Product> listProductInPage = new ArrayList<>();
        String query = "select p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, sum(pd.CountProduct) as totalProduct\n"
                + "from Products as p\n"
                + "left outer join Product_Detail as pd on (p.productID = pd.productID)\n"
                + "left outer join Category as c on (p.categoryID = c.categoryID)\n"
                + "where p.productName like ? or s.StoreName like ?\n"
                + "group by p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName\n"
                + "ORDER BY productID\n"
                + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setInt(3, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9)
                       );
                listProductInPage.add(p);
            }
        } catch (Exception e) {
        }
        return listProductInPage;
    }

    public Product getProductByID(int productID) {
        String query = "select p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, sum(pd.countProduct) as totalProduct\n"
                + "from Products as p\n"
                + "left outer join Product_Detail as pd on (p.productID = pd.productID)\n"
                + "left outer join Category as c on (p.categoryID = c.categoryID)\n"
                + "Where p.productID = ?\n"
                + "group by p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return  new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9)
                       );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<CardProduct> getProductSame(int productID) {
        List<CardProduct> listTop = new ArrayList<>();
        String query = "SELECT TOP 4 p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, s.storeID, s.storeName\n" +
"FROM Store_Detail as sd INNER JOIN Products as p ON sd.productID = p.productID\n" +
"INNER JOIN Stores as s ON sd.storeID = s.storeID\n" +
"INNER JOIN Category as c ON p.categoryID = c.categoryID\n" +
"WHERE p.categoryID = (Select categoryID from Products where productID = ?)";
             
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                CardProduct p = new CardProduct(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getString(10));
                    listTop.add(p);
            }
        } catch (Exception e) {
        }
        return listTop;
    }
    public store1 showStore (String productID) {
         String query = "select s.* from Store s, Product p\n" +
                        "where p.StoreID = s.StoreID\n" +
                        "and p.ProductID = ?";
         try {
             conn = new DBContext().getConnection();
             ps = conn.prepareStatement(query);
             ps.setString(1, productID);
             rs = ps.executeQuery();
             while (rs.next()){
                 return new store1 (rs.getString(1),
                         rs.getString(2),
                         rs.getString(3),
                         rs.getString(4),
                         rs.getString(5)
                 );
             }
         }catch (Exception e) {
             
         }
         return null;
     }
    public void updateProductdetail(String ct) {
         String query = "Update ProductDetail set CountProduct = CountProduct - Cart.Amount \n" +
                        "from Cart\n" +
                        "where Cart.Color = ProductDetail.Color\n" +
                        "and Cart.Size = ProductDetail.Size\n" +
                        "and Cart.ProductID = ProductDetail.ProductID\n" +
                        "and Cart.CartID = ?";
         try{
             conn = new DBContext().getConnection();
             ps = conn.prepareStatement(query);
             ps.setString(1, ct);
             ps.executeUpdate();
         }catch(Exception e) {
             
         }
     }
    public void updateProductAfOrder(String ct) {
         String query = "Update ProductDetail set CountProduct = CountProduct + Cart.Amount \n" +
                        "from Cart, Orders\n" +
                        "where Cart.Color = ProductDetail.Color\n" +
                        "and Cart.Size = ProductDetail.Size\n" +
                        "and Cart.ProductID = ProductDetail.ProductID\n" +
                        "and Cart.CartID = Orders.CartID\n" +
                        "and Orders.OrderID = ?";
         try{
             conn = new DBContext().getConnection();
             ps = conn.prepareStatement(query);
             ps.setString(1, ct);
             ps.executeUpdate();
         }catch(Exception e) {
             
         }
    }
    
    public Product createProduct(Product product) {
        Product p = null;
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO Products VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescriptions());
            ps.setString(3, product.getSex());
            ps.setString(4, product.getImageLink());
            ps.setInt(5, product.getPrice());
            ps.setInt(6, product.getCategoryID());
            result = ps.executeUpdate() > 0;
            if (result) {
                p = this.getNewProduct();
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return p;
    } 
    
    public List<CardProduct> pagingByCategory(int index, int categoryID) {
        List<CardProduct> listProductInPage = new ArrayList<>();
        if (categoryID == 0) {
            listProductInPage = pagingProduct(index);
        } else {
            String query = "SELECT p.productID, p.productName, p.descriptions, p.sex, p.imageLink, p.price, p.categoryID, c.categoryName, s.storeID, s.storeName, sd.amount\n" +
"FROM Store_Detail as sd INNER JOIN Products as p ON sd.productID = p.productID\n" +
"INNER JOIN Stores as s ON sd.storeID = s.storeID\n" +
"INNER JOIN Category as c ON p.categoryID = c.categoryID\n" +
"WHERE p.categoryID = ?\n" +
"ORDER BY productID\n" +
"OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, categoryID);
                ps.setInt(2, (index - 1) * 8);
                rs = ps.executeQuery();
                while (rs.next()) {
                    CardProduct p = new CardProduct(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getString(10),
                            rs.getInt(11)
                    );
                    listProductInPage.add(p);
                }
            } catch (Exception e) {
            }
        }
        return listProductInPage;
    }
    
    public boolean deleteProduct(int productID) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("DELETE FROM Products WHERE productID = ?");
            ps.setInt(1, productID);

            result = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.getMessage();       
        }
         return result;
    }
    
    public boolean updateProduct(Product product) {
        boolean result = false;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("UPDATE Products SET productName = ?, descriptions = ?, sex = ?, imageLink = ?, price = ?, categoryID = ? WHERE productID = ?");
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescriptions());
            ps.setString(3, product.getSex());
            ps.setString(4, product.getImageLink());
            ps.setInt(5, product.getPrice());
            ps.setInt(6, product.getCategoryID());
            ps.setInt(7, product.getProductID());

            result = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.getMessage();
        } 
        return result;
    }
    
    public List<String> getListNameProduct (int orderID) {
         String query = "SELECT p.productName\n" +
"FROM Orders as o INNER JOIN Orders_Detail as od ON o.orderID = od.orderID\n" +
"INNER JOIN Products as p ON od.productID = p.productID\n" +
"WHERE o.orderID = ?";
         List<String> l = new ArrayList<>();
         try {
             conn = new DBContext().getConnection();
             ps = conn.prepareStatement(query);
             ps.setInt(1, orderID);
             rs = ps.executeQuery();
             while (rs.next()){
                 String s = rs.getString(1);
                 l.add(s);
                 
             }
         }catch (Exception e) {
             
         }
         return l;
     }
}
