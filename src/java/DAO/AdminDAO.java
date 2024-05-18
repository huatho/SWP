package DAO;

import entity.Account;
import entity.AdminProfile;
import entity.CardProduct;
import entity.Count;
import entity.Customer;
import entity.Product;
import entity.Sellers;
import entity.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public AdminProfile getProfileByID(int id) {
        String query = "select AdminID, AdminName, AdminAddress, Phone, Avatar, path, ManageUsers.UserID, UserName, Passwords, email, Roles\n"
                + "from Admins, ManageUsers \n"
                + "where ManageUsers.UserID = Admins.UserID and AdminID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AdminProfile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Account> getAllAccounts() {

        List<Account> list = new ArrayList<>();
        String query = "select userID, userName, pass, email, roleID from Users where roleID != 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)) {
                });
            }
        } catch (Exception e) {
        }
        return list;
    }
    
        public List<Customer> getRequest() {
        List<Customer> listC = new ArrayList<>();
        String query = " Select userID, fullName, phone, userAddress, userName, pass, email, roleID, lock\n" +
"from Users\n" +
"WHERE roleID != 0 AND upRole = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listC.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listC;
    }

    public Count countUser() {
        Count c = null;
        try {
            String query = "SELECT COUNT(*) \n"
                    + "FROM Users";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Count(rs.getInt(1)-1);
            }
        } catch (Exception e) {
        }
        
        return c;
    }

    public Count countStore() {
        Count store = new Count();
        try {
            String query = "SELECT COUNT(*) \n"
                    + "FROM Stores";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                store = new Count(rs.getInt(1));
            }
            return store;
        } catch (Exception e) {
        }
        return null;
    }

    public Count countProduct() {
        Count product = new Count();
        try {
            String query = "SELECT COUNT(*) \n"
                    + "FROM Products";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Count(rs.getInt(1));
            }
            return product;
        } catch (Exception e) {
        }
        return null;
    }

    public long totalPrice() {
        long total = 0;
        try {
            String query = "SELECT ISNULL(SUM (od.Price * 5/100),0)\n"
                    + "FROM  Orders AS od \n"
                    + "WHERE od.PaymentStatus = 4";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getLong(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int lastCategoryId() {
        int num = 0;
        try {
            String query = "SELECT TOP 1 CategoryID FROM Category ORDER BY CONVERT(int, CategoryID) DESC";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return num;
    }

    public List<Customer> getCustomer() {
        List<Customer> listC = new ArrayList<>();
        String query = " Select userID, fullName, phone, userAddress, userName, pass, email, roleID, lock\n" +
"from Users\n" +
"WHERE roleID != 0";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listC.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listC;
    }


    public List<Sellers> searchSell(String txtSearch) {
        List<Sellers> listS = new ArrayList<>();
        String query = "Select SellerID, SellerName, Phone, SellerAddress, Avatar, path, Sellers.UserID, ManageUsers.UserName, ManageUsers.Passwords, ManageUsers.email, ManageUsers.Roles\n"
                + "from Sellers, ManageUsers\n"
                + "where ManageUsers.UserID = Sellers.UserID and SellerName like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                listS.add(new Sellers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return listS;
    }

//    public Customer getCById(int id) {
//        String query = "Select CustomerID, CustomerName, Phone, CustomerAddress, Avatar, path,"
//                + "Customers.UserID,  ManageUsers.UserName, ManageUsers.Passwords, ManageUsers.email, ManageUsers.Roles\n"
//                + "from Customers, ManageUsers\n"
//                + "where ManageUsers.UserID = Customers.UserID and CustomerID = ?";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//                        rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public Sellers getSById(int id) {
        String query = "Select Sellers.SellerID, SellerName, Phone, SellerAddress, Avatar, path, Sellers.UserID, ManageUsers.UserName, ManageUsers.Passwords, ManageUsers.email, ManageUsers.Roles, LinkImage, StoreName, Descriptions\n"
                + "From ManageUsers, Sellers, Store\n"
                + "where ManageUsers.UserID = Sellers.UserID and Sellers.SellerID = Store.SellerID and Sellers.SellerID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Sellers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
            }
        } catch (Exception e) {
        }
        return null;
    }

//    public Store getStoreBySid(int id) {
//        String query = "Select SellerID, StoreID, StoreName, Descriptions, LinkImage\n"
//                + "from Store\n"
//                + "where SellerID = ?";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, id);
//            while (rs.next()) {
//                return new Store(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public void addSeller(String sellerName, String phone, String sellerAdd, String avatar, String path) {
        String query = "insert into Sellers values (?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sellerName);
            ps.setString(2, phone);
            ps.setString(3, sellerAdd);
            ps.setString(4, avatar);
            ps.setString(5, path);
        } catch (Exception e) {
        }
    }

    public void updateAcc(int id, String acc, String pass, String email, int roles) {
        String query = "update ManageUsers set UserName = ?, Passwords = ?, email = ?, Roles = ?"
                + "where UserID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setInt(4, roles);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAdmin(int adminId, String adminName, String adminAddress, String adminPhone) {
        String query = "update Admins set AdminName = ?, AdminAddress = ?, Phone = ? where AdminID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, adminName);
            ps.setString(2, adminAddress);
            ps.setString(3, adminPhone);
            ps.setInt(4, adminId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

//    public List<CardProduct> getListProduct() {
//        List<CardProduct> listP = new ArrayList<>();
//        String query = "select p.productID, p.productName, p.imageLink, p.price, c.categoryName, s.storeName, sd.amount as totalProduct, p.accept\n" +
//"                from Products as p\n" +
//"				inner join Store_Detail as sd on sd.productID = p.productID\n" +
//"                inner join Stores as s on (sd.storeID = s.storeID)\n" +
//"                inner join Category as c on (p.CategoryID = c.CategoryID)";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                listP.add(new CardProduct(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getInt(7),
//                        rs.getInt(8)
//                        ));
//            }
//        } catch (Exception e) {
//        }
//        return listP;
//        
//    }

    public void addCategory(String categoryID, String categoryName) {
        String query = "Insert into Category values (?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, categoryID);
            ps.setString(2, categoryName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void acceptSeller(int id) {
        String query = "UPDATE Users SET roleID = 2, upRole = 0 WHERE userID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateLockUser(int id, int lock) {
        String query = "UPDATE Users SET lock = ? WHERE userID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, lock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int getNumberOfOrders() {
        String query = "SELECT COUNT(*) FROM Orders\n" +
"  GROUP BY deliveryDate";
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
    
    public int getNumberOfSuccess() {
        String query = "SELECT COUNT(*) FROM Orders as o\n" +
"  INNER JOIN Orders_Detail as od ON o.orderID = od.orderID\n" +
"  WHERE orderStatus = 3\n" +
"  GROUP BY orderStatus";
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
    
    public int getTotalMoney() {
        String query = "SELECT SUM(total) FROM Orders as o\n" +
"  INNER JOIN Orders_Detail as od ON o.orderID = od.orderID\n" +
"  WHERE orderStatus = 3\n" +
"  GROUP BY orderStatus";
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
    

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        dao.updateAdmin(1, "linhlt", "quangNgai", "01234");
    }
}
