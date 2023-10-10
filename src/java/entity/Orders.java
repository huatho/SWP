/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author trung
 */
public class Orders {
    private int orderID;
    private int cartID;
    private Date foundedDate;
    private Date deliveryDate;
    private String address;
    private String paymentWay;
    private String paymentStatus;

    public Orders() {
    }

    public Orders(int orderID, int cartID, Date foundedDate, Date deliveryDate, String address, String paymentWay, String paymentStatus) {
        this.orderID = orderID;
        this.cartID = cartID;
        this.foundedDate = foundedDate;
        this.deliveryDate = deliveryDate;
        this.address = address;
        this.paymentWay = paymentWay;
        this.paymentStatus = paymentStatus;
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

    public Date getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Date foundedDate) {
        this.foundedDate = foundedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", cartID=" + cartID + ", foundedDate=" + foundedDate + ", deliveryDate=" + deliveryDate + ", address=" + address + ", paymentWay=" + paymentWay + ", paymentStatus=" + paymentStatus + '}';
    }

    
}
