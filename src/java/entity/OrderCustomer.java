/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author Os
 */
public class OrderCustomer {
    private int orderID;
    private int storeID;
    private String listProductName;
    private int amount;
    private String phone;
    private String address;
    private int total;
    private String status;
    private int orderDetailID;
    private String image;

    public OrderCustomer(int orderID, int storeID, String listProductName, int amount, String phone, String address, int total, String status) {
        this.orderID = orderID;
        this.storeID = storeID;
        this.listProductName = listProductName;
        this.amount = amount;
        this.phone = phone;
        this.address = address;
        this.total = total;
        this.status = status;
    }

    public OrderCustomer(int orderID, int storeID, String listProductName, int amount, String phone, String address, int total, String status, int orderDetailID) {
        this.orderID = orderID;
        this.storeID = storeID;
        this.listProductName = listProductName;
        this.amount = amount;
        this.phone = phone;
        this.address = address;
        this.total = total;
        this.status = status;
        this.orderDetailID = orderDetailID;
    }
    
    public OrderCustomer(int orderID, int storeID, String listProductName, int amount, String phone, String address, int total, String status, int orderDetailID, String image) {
        this.orderID = orderID;
        this.storeID = storeID;
        this.listProductName = listProductName;
        this.amount = amount;
        this.phone = phone;
        this.address = address;
        this.total = total;
        this.status = status;
        this.orderDetailID = orderDetailID;
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

    public int getStoreID() {
        return storeID;
    }

    public String getListProductName() {
        return listProductName;
    }

    public int getAmount() {
        return amount;
    }

    

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setListProductName(String listProductName) {
        this.listProductName = listProductName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
