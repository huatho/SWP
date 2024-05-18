/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MSII
 */
public class Carts {
    private  int cartID;
    private int userID;
    private int productID;
    private int amount;
    private int stauts;
    private String productName;
    private String imgLink;
    private double price;
    private double total;
    private int cartDetailID;
    private int storeID;

    public Carts() {
    }

    public Carts(int cartID, int userID, int productID, int amount, int stauts, String productName, String imgLink, double price, double total, int cartDetailID, int storeID) {
        this.cartID = cartID;
        this.userID = userID;
        this.productID = productID;
        this.amount = amount;
        this.stauts = stauts;
        this.productName = productName;
        this.imgLink = imgLink;
        this.price = price;
        this.total = total;
        this.cartDetailID = cartDetailID;
        this.storeID = storeID;
    }

    
    

    public int getStoreID() {
        return storeID;
    }
    
    
    
    
    public Carts(int stauts, int cartID) {
        this.cartID = cartID;
        this.stauts = stauts;
    }
    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int customerID) {
        this.userID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartDetailID() {
        return cartDetailID;
    }

    public void setCartDetailID(int cartDetailID) {
        this.cartDetailID = cartDetailID;
    }
    
    
    public String getPriceWithDot() {
        String priceDot = "" + price;
        int i = priceDot.length() - 3;
        while (i > 0) {
            priceDot = priceDot.substring(0, i) + "." + priceDot.substring(i, priceDot.length());
            i -= 3;
        }
        return priceDot;
    }


    
}
