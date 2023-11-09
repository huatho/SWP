/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.qldoanhthu;
import entity.topsellP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

//    public List<topsellP> getAllTopselling(String sellersid) {
//        List<topsellP> list = new ArrayList<>();
//        String query = "SELECT TOP 5 p.ProductName, p.Price,ca.Amount AS qty,ISNULL((ca.Amount * p.Price),0) AS priceP\n" +
//"                       FROM Orders AS o LEFT JOIN Cart AS ca ON o.CartID = ca.CartID JOIN Product AS p ON ca.ProductID = p.ProductID JOIN Store AS s ON ca.StoreID = s.StoreID LEFT JOIN Sellers AS sell ON s.SellerID = sell.SellerID\n" +
//"                			WHERE o.PaymentStatus = 3 AND sell.SellerID = '"+sellersid+"'\n" +
//"                			GROUP BY p.ProductName,p.Price,ca.Amount\n" +
//"                            ORDER BY qty DESC";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new topsellP(rs.getString(1), rs.getDouble(2),rs.getInt(3), rs.getDouble(4)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
//    public List<topsellP> statisticalProductByDate(String dfrom, String dto) {
//        List<topsellP> list = new ArrayList<>();
//        String query = "SELECT p.ProductName,ca.Amount AS qty, ISNULL(SUM(ca.Amount * pd.Price),0) AS total\n"
//                + "FROM Cart AS ca JOIN Ship AS sh ON ca.CartID=sh.CartID JOIN Product AS p ON ca.ProductID = p.ProductID JOIN ProductDetail AS pd ON p.ProductID = pd.ProductDetailID\n"
//                + "WHERE ca.Date_Create >= CONVERT(date, '"+dfrom+"') AND ca.Date_Create <= CONVERT(date, '"+dto+"')\n"
//                + "		AND sh.StatusOrder LIKE N'đã giao' \n"
//                + "GROUP BY p.ProductName,ca.Amount";
//        try {
//            con = new DBConnect().getConnection();
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new topsellP(rs.getString(1), rs.getInt(2), rs.getDouble(3)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    
    public List<qldoanhthu> statisticalProductByDate(String dfrom, String dto, String sellersid) {
        List<qldoanhthu> list = new ArrayList<>();
        String query = "SELECT p.ProductName, p.Price,CONVERT(varchar ,o.DeliveryDate, 103) AS dayPay, ISNULL((ca.Amount * p.Price),0) AS priceP\n"
                + "				FROM Orders AS o LEFT JOIN Cart AS ca ON o.CartID = ca.CartID JOIN Product AS p ON ca.ProductID = p.ProductID JOIN Store AS s ON ca.StoreID = s.StoreID LEFT JOIN Sellers AS sell ON s.SellerID = sell.SellerID\n"
                + "                 WHERE o.DeliveryDate >= CONVERT(date, '"+dfrom+"') AND o.DeliveryDate <= CONVERT(date, '"+dto+"')  \n"
                + "				 AND  o.PaymentStatus = 3  AND sell.SellerID = '"+sellersid+"'\n"
                + "				 GROUP BY  p.ProductName, p.Price, o.DeliveryDate, ca.Amount"
                + "                              ORDER BY dayPay ASC ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new qldoanhthu(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
       DAO dao = new DAO();
       
     
//        List<qldoanhthu> list = dao.statisticalProductByDate("20221001","20221030", "1");
//        for (qldoanhthu ql : list) {
//            System.out.println(ql);
//        }
    }
}