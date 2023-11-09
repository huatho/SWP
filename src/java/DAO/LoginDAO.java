
package DAO;

import entity.Account;
import entity.AdminProfile;
import entity.Custom;
import entity.NoAdmin;
import entity.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class LoginDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account checkLogin(String acc, String pass){
        
        String query = "SELECT * FROM ManageUsers WHERE UserName = ? AND Passwords = ?";
        try{
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public Custom checkCustomer(String acc){
        String query = "select C.* from ManageUsers M, Customers C where C.UserID = M.UserID and M.UserName = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Custom a = new Custom(rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public NoAdmin checkSeller(String acc){
        String query = "select SellerID, SellerName, Phone, SellerAddress, Avatar, [path], Sellers.UserID from ManageUsers, Sellers where Sellers.UserID = ManageUsers.UserID and UserName = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            rs = ps.executeQuery();
            
            while(rs.next()){
                NoAdmin a = new NoAdmin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public AdminProfile checkAdmin(String acc){
        String query = "select * from ManageUsers, Admins where Admins.UserID = ManageUsers.UserID and UserName = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AdminProfile a = new AdminProfile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getInt(7) , rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
                return a;
            }
        }catch(Exception e){
        }
        return null;
    }
    
    public Account checkUsername(String user){
        
        String query = "SELECT * FROM ManageUsers WHERE UserName = ?";
        try{
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public Account checkEmail(String email, String user){
        
        String query = "SELECT * FROM ManageUsers WHERE email = ? and UserName = ?";
        try{
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2,user);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public void register(String acc, String pass, String email ,String roles){
        
        String query = "INSERT INTO ManageUsers VALUES (?, ?, ?, ?);";
        
        try {
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, roles);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void changPassword(int pass, String mail) {
        String query = "UPDATE ManageUsers\n"
                + "SET Passwords = ?\n"
                + "WHERE email = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setInt(1, pass);
            ps.setString(2, mail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Account checkPass(String pass, String id){
        
        String query = "SELECT * FROM ManageUsers WHERE Passwords = ? and UserID = ?";
        try{
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2,id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public void changPassById(String pass, String oldpass, int id) {
        String query = "UPDATE ManageUsers\n"
                + "SET Passwords = ?\n"
                + "WHERE Passwords = ?\n"
                + "AND UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, oldpass);
            ps.setInt(3, id);
            ps.executeUpdate();     
        } catch (Exception e) {
        }
    }
    
    public List<Account> getAllAccounts() {
        
        List<Account> list = new ArrayList<>();
        String query = "select * from ManageUsers";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void editAccount(String id, String acc, String pass, String mail, String roles) {
        String query = "UPDATE ManageUsers\n"
                + "SET UserName = ?,\n"
                + "Passwords = ?,\n"
                + "email = ?,\n"
                + "Roles = ?\n"
                + "WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            ps.setString(3, mail);
            ps.setString(4, roles);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Account getAccountByID(String id) {
        String query = "select * from ManageUsers where UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
         
    public void deleteAccount(String id) {
        String query = "delete from ManageUsers where UserID = ?";
                
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }   
   
    public void addAccount(String acc, String pass, String email ,String roles){
        
        String query = "INSERT INTO ManageUsers VALUES (?, ?, ?, ?);";
        
        try {     
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, roles);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
        
    public List<Account> searchAccountByName(String txtSearch) {
        List<Account> list = new ArrayList<>();
        String query = "select * from ManageUsers where UserName like ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+ txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public AdminProfile getProfileByID(String id) {
        String query = "select * from Admins where UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AdminProfile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getInt(7) , rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void editProfileAd(String id, String name, String phone) {
        String query = "UPDATE Admins\n"
                + "SET AdminName = ?,\n"
                + "Phone = ?\n"
                + "WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2, phone);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertCus(String name, String phone, String address ,String userid){
        
        String query = "INSERT INTO Customers VALUES (?, ?, ?, 'images\\\\cus3.png', 'D:\\MoocProject\\MoocProject1\\web\\images', ?)";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, userid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public NoAdmin checkCus(String id){
        
        String query = "SELECT * FROM Customers WHERE UserID = ?";
        try{
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                NoAdmin a = new NoAdmin(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    
    public void editProfileCus(String id, String name, String phone, String address) {
        String query = "UPDATE Customers\n"
                + "SET CustomerName = ?,\n"
                + "Phone = ?,\n"
                + "CustomerAddress = ?\n"
                + "WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertSell(String name, String phone, String address ,String userid){
        
        String query = "INSERT INTO Sellers VALUES (?, ?, ?, 'images\\\\seller1.jpg', 'D:\\MoocProject\\MoocProject1\\web\\images', ?)";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, userid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public NoAdmin checkSell(String id){
        
        String query = "SELECT * FROM Sellers WHERE UserID = ?";
        try{
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                NoAdmin a = new NoAdmin(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return a;
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    
    
    public void editProfileSel(String id, String name, String phone, String address) {
        String query = "UPDATE Sellers\n"
                + "SET SellerName = ?,\n"
                + "Phone = ?,\n"
                + "SellerAddress = ?\n"
                + "WHERE UserID = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     
    public void insertStore(String id, String name, String descrip, String link){
        
        String query = "INSERT INTO Store(SellerID, StoreName, Descriptions, LinkImage) VALUES (?, ?, ?, ?)";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, descrip);
            ps.setString(4, link);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
   
}
