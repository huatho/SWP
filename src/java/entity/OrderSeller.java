/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Os
 */
public class OrderSeller {
    private int orderDetailID;
    private int orderID;
    private int userID;
    private String productName;
    private int amount;
    private String foundDate;
    private int total;
    private String status;
    private String image;

    public OrderSeller(int orderID, int userID, String productName, int amount, String foundDate, int total, String status) {
        this.orderID = orderID;
        this.userID = userID;
        this.productName = productName;
        this.amount = amount;
        this.foundDate = foundDate;
        this.total = total;
        this.status = status;
    }

    public OrderSeller(int orderID, int userID, String productName, int amount, String foundDate, int total, String status, int orderDetailID) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.userID = userID;
        this.productName = productName;
        this.amount = amount;
        this.foundDate = foundDate;
        this.total = total;
        this.status = status;
    }
    
    public OrderSeller(int orderID, int userID, String productName, int amount, String foundDate, int total, String status, int orderDetailID, String image) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.userID = userID;
        this.productName = productName;
        this.amount = amount;
        this.foundDate = foundDate;
        this.total = total;
        this.status = status;
        this.image = image;
    }

    
    
    

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public String getImage() {
        return image;
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public int getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }
    
    
}
