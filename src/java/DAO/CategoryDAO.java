/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBContext;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LINH
 */
public class CategoryDAO {

    Connection conn = null; //ket noi toi sql_server
    PreparedStatement ps = null; //nem cau lenh sql tu netbean sang sql server
    ResultSet rs = null; //nhan ket qua tra ve

    public List<Category> getAllCategory() {
        List<Category> listAllCategory = new ArrayList<>();
        String query = "Select * from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                listAllCategory.add(c);
            }
        } catch (Exception e) {
        }
        return listAllCategory;
    }

//    public List<Category> getAllsex() {
//        List<Category> listAllSex = new ArrayList<>();
//        String query = "SELECT DISTINCT Sex FROM Product";
//        try {
//            conn = new JDBC().getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Category c = new Category(rs.getInt(1), rs.getString(2));
//                listAllSex.add(c);
//            }
//        } catch (Exception e) {
//        }
//        return listAllSex;
//    }
    
    public String getCateNameByID(int id) {
        String query = "select categoryName from Category\n"
                + "where categoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> getAllsex = categoryDAO.getAllCategory();
        for (Category c : getAllsex) {
            System.out.println(c);
        }
    }

}
