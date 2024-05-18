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
    private int amount;
    private int storeID;

    public CartDetail(int cartDetailID, int cartID, int productID, int amount, int storeID) {
        this.cartDetailID = cartDetailID;
        this.cartID = cartID;
        this.productID = productID;
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


    public int getAmount() {
        return amount;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}
