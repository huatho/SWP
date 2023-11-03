/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Os
 */
public class Review {
    private int reviewID;
    private int userID;
    private int productID;
    private String content;
    private String userName;

    public Review(int reviewID, int userID, int productID, String content, String userName) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.productID = productID;
        this.content = content;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
    

    public int getReviewID() {
        return reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public int getProductID() {
        return productID;
    }

    public String getContent() {
        return content;
    }
    
    
}
