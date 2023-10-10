/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MSII
 */
public class Order {
    private int orderID;
    private int cartID;
    private String image;
    private String productName;
    private String foundedDate;
    private String deliveryDate;
    private String adress;
    private String paymentWay;
    private double price;
    private String paymentStatus;
    private String status;
    private List<String> listProductName;
    private int total;

    public Order() {
    }

    public Order(int orderID, int cartID, String image, String productName, String foundedDate, String deliveryDate, String adress, String paymentWay, double price ,String paymentStatus) {
        this.orderID = orderID;
        this.cartID = cartID;
        this.image = image;
        this.productName = productName;
        this.foundedDate = foundedDate;
        this.deliveryDate = deliveryDate;
        this.adress = adress;
        this.paymentWay = paymentWay;
        this.price = price;
        this.paymentStatus = paymentStatus;
    }

    public Order(int orderID, String image, String productName, String foundedDate, String deliveryDate, String adress, String paymentWay, double price, String status) {
        this.orderID = orderID;
        this.image = image;
        this.productName = productName;
        this.foundedDate = foundedDate;
        this.deliveryDate = deliveryDate;
        this.adress = adress;
        this.paymentWay = paymentWay;
        this.price = price;
        this.status = status;
    }

    public Order(int orderID, String foundedDate, String deliveryDate, String adress, String paymentWay, String status, int total, List<String> listProductName) {
        this.orderID = orderID;
        this.foundedDate = foundedDate;
        this.deliveryDate = deliveryDate;
        this.adress = adress;
        this.paymentWay = paymentWay;
        this.status = status;
        this.total = total;
        this.listProductName = listProductName;
    }

   

    
    
    
    public int getTotal() {
        return total;
    }

    public List<String> getListProductName() {
        return listProductName;
    }

    public void setListProductName(List<String> listProductName) {
        this.listProductName = listProductName;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
    

    public void setStatus(String status) {
        this.status = status;
    }



    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(String foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }
    
    

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", cartID=" + cartID + ", image=" + image + ", productName=" + productName + ", foundedDate=" + foundedDate + ", deliveryDate=" + deliveryDate + ", adress=" + adress + ", paymentWay=" + paymentWay + ", price=" + price + ", paymentStatus=" + paymentStatus + '}';
    }
    
}