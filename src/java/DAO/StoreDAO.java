/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Product;
import entity.Store;
import entity.StoreDetail;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Os
 */
public class StoreDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void create(String name, String address, int userID){
        String query = "INSERT INTO Stores(storeName, storeAddress, userID) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, userID);
    
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Store getByUserID(int userID){
        String query = "SELECT * FROM Stores WHERE userID = ?";
        Store s = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return s;
    }
    
    public List<Store> getAllStore(){
        String query = "SELECT * FROM Stores";
        List<Store> l = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
           
            rs = ps.executeQuery();
            while (rs.next()) {
                int storeID = rs.getInt(1);
                String storeName = rs.getString(2);
                String storeAddress = rs.getString(3);
                int userID = rs.getInt(4);
                UserDAO dao = new UserDAO();
                User u = dao.getUserById(userID);
                l.add(new Store(storeID, storeName, storeAddress, userID, u.getAcc()));
            }
        } catch (Exception e) {
        }
        return l;
    }
    
    public void addProductToStore(int storeID, int productID, int amount){
        String query = "INSERT INTO Store_Detail(storeID, productID, amount) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, storeID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);

    
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Product> getAllProduct(int storeID){
        String query = "SELECT p.*, Store_Detail.amount FROM Store_Detail \n" +
"  INNER JOIN Products as p ON Store_Detail.productID = p.productID \n" +
"  WHERE storeID = ?";
        List<Product> l = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
           ps.setInt(1, storeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryDAO cateDAO = new CategoryDAO();
                int cateID = rs.getInt(7);
                l.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), cateID, cateDAO.getCateNameByID(cateID), rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return l;
    }
    
    public void deleteProduct(int storeID, int productID){
        String query = "DELETE Store_Detail WHERE storeID = ? AND productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, storeID);
            ps.setInt(2, productID);

    
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateAmount(int storeID, int productID, int amount){
        String query = "UPDATE Store_Detail SET amount = ? WHERE storeID = ? AND productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, storeID);
            ps.setInt(3, productID);

    
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public StoreDetail getStoreDetail(int id){
        String query = "SELECT * FROM Store_Detail WHERE storeDetaiID = ?";
        StoreDetail s = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new StoreDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return s;
    }
}
