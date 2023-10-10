/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Cart {
    private  int cartID;
    private int userID;
    private int status;

    public Cart() {
    }

    public Cart(int cartID, int userID, int status) {
        this.cartID = cartID;
        this.userID = userID;
        this.status = status;
    }

    public int getCartID() {
        return cartID;
    }

    public int getUserID() {
        return userID;
    }

    public int getStatus() {
        return status;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
