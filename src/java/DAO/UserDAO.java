/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Email;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Os
 */
public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void addUser(User user){
        String query = "INSERT INTO Users(userName, pass, fullName, email, phone, userAddress, roleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getAcc());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail().getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setInt(7, user.getRoles());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public User login(String acc, String pass){
        
        String query = "SELECT * FROM Users WHERE userName = ? AND pass = ?";
        User u = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), new Email(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        }catch(Exception e){
            
        }
        return u;
    }
    
    public User getUserById(int id){       
        String query = "SELECT * FROM Users WHERE userID = ?";
        User u = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), new Email(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        }catch(Exception e){
            
        }
        return u;
    }
    
    public User updateUser(int id, String name, String phone, String address){
        
        String query = "UPDATE Users SET fullName = ?, phone = ?, userAddress = ? WHERE userID = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setInt(4, id);
            ps.executeUpdate();

        }catch(Exception e){
            
        }
        return getUserById(id);
    }
    
    public User checkPass(String pass, int id){       
        String query = "SELECT * FROM Users WHERE userID = ? AND pass = ?";
        User u = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), new Email(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        }catch(Exception e){
            
        }
        return u;
    }
    
    public void changePassById(String pass, int id){
        
        String query = "UPDATE Users SET pass = ? WHERE userID = ?";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setInt(2, id);
            ps.executeUpdate();

        }catch(Exception e){
            
        }
    }
    
    public User checkEmailAndUserName(String email, String userName){       
        String query = "SELECT * FROM Users WHERE userName = ? AND email = ?";
        User u = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), new Email(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        }catch(Exception e){
            
        }
        return u;
    }
    
    public User checkUserName(String userName){       
        String query = "SELECT * FROM Users WHERE userName = ?";
        User u = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), new Email(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        }catch(Exception e){
            
        }
        return u;
    }
    
    public User checkEmail(String email){       
        String query = "SELECT * FROM Users WHERE email = ?";
        User u = null;
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), new Email(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        }catch(Exception e){
            
        }
        return u;
    }
    
    
}
