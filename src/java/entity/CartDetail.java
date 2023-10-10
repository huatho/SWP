/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Os
 */
public class CartDetail {
    private int cartDetailID;
    private int cartID;
    private int productID;
    private String size;
    private String color;
    private int amount;
    private int storeID;

    public CartDetail(int cartID, int productID, String size, String color, int amount) {
        this.cartID = cartID;
        this.productID = productID;
        this.size = size;
        this.color = color;
        this.amount = amount;
    }
    
    public CartDetail(int cartID, int productID, String size, String color) {
        this.cartID = cartID;
        this.productID = productID;
        this.size = size;
        this.color = color;
    }

    public CartDetail(int cartDetailID, int cartID, int productID, String size, String color, int amount) {
        this.cartDetailID = cartDetailID;
        this.cartID = cartID;
        this.productID = productID;
        this.size = size;
        this.color = color;
        this.amount = amount;
    }

    public CartDetail(int cartDetailID, int cartID, int productID, String size, String color, int amount, int storeID) {
        this.cartDetailID = cartDetailID;
        this.cartID = cartID;
        this.productID = productID;
        this.size = size;
        this.color = color;
        this.amount = amount;
        this.storeID = storeID;
    }
    
    
    
    

    public int getCartDetailID() {
        return cartDetailID;
    }

    public void setCartDetailID(int cartDetailID) {
        this.cartDetailID = cartDetailID;
    }
    
    public int getCartID() {
        return cartID;
    }

    public int getProductID() {
        return productID;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}
