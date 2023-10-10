/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Os
 */
public class StoreDetail {
    private int id;
    private int storeID;
    private int productID;
    private int amount;

    public StoreDetail(int id, int storeID, int productID) {
        this.id = id;
        this.storeID = storeID;
        this.productID = productID;
    }

    public StoreDetail(int id, int storeID, int productID, int amount) {
        this.id = id;
        this.storeID = storeID;
        this.productID = productID;
        this.amount = amount;
    }
    
    

    public int getId() {
        return id;
    }

    public int getStoreID() {
        return storeID;
    }

    public int getProductID() {
        return productID;
    }

    public int getAmount() {
        return amount;
    }
    
    
    
    
}
