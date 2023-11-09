/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Os
 */
public class ReviewDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Review> getReviewByProductID(int pid){
        String query = "  SELECT r.*, fullName FROM Review as r INNER JOIN Users as u ON r.userID = u.userID WHERE productID = ?";
        List<Review> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void addReview(int pid, int userID, String content){
        String query = "INSERT INTO Review VALUES(?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
           
            ps.setInt(1, userID);
            ps.setInt(2, pid);
            ps.setString(3, content);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    
}
