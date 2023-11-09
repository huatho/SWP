/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Cart;
import entity.CartDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Os
 */
public class CartDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
  
    public Cart getCartByUserId(int id){       
        String query = "SELECT * FROM Carts WHERE userID = ?";
        Cart c = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }

        }catch(Exception e){
            
        }
        return c;
    }
    
        public Cart createCart(int userID, String status){       
        String query = "INSERT INTO Carts(userID, status) VALUES(?,?)";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, status);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return getCartByUserId(userID);
    }
    
    public void addToCart(int cID, int pID, String size, String color, int quantity, int storeID){       
        String query = "INSERT INTO Cart_Detail(cartID, productID, size, color, amount, storeID) VALUES(?,?,?,?,?,?)";
        Cart c = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cID);
            ps.setInt(2, pID);
            ps.setString(3, size);
            ps.setString(4, color);
            ps.setInt(5, quantity);
            ps.setInt(6, storeID);
            ps.executeUpdate();
            

        }catch(Exception e){
            
        }
    }
    
    public CartDetail getDetail(int cid, int pid, int storeID){       
        String query = "  SELECT * FROM Cart_Detail WHERE cartID = ? AND productID = ? AND storeID = ?";
        CartDetail c = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            ps.setInt(2, pid);
            
            ps.setInt(3, storeID);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new CartDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
            }

        }catch(Exception e){
            
        }
        return c;
    }
    
    public void updateCart(int cdetailID, int quantity){       
        String query = "UPDATE Cart_Detail SET amount = ? WHERE cartDetaiID = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, cdetailID);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    public CartDetail getCartDetail(int id){       
        String query = "SELECT * FROM Cart_Detail WHERE cartDetaiID = ?";
        CartDetail c = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                c = new CartDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
            }

        }catch(Exception e){
            
        }
        return c;
    }
    
    public int getStoreID(int id){       
        String query = "SELECT storeID FROM Cart_Detail WHERE cartDetaiID = ?";
        int storeID = 0;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                storeID = rs.getInt(1);
            }

        }catch(Exception e){
            
        }
        return storeID;
    }
    
}
