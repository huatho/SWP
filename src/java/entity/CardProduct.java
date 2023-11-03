/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Os
 */
public class CardProduct {
    private int productID;
    private String productName;
    private String descriptions;
    private String sex;
    private String imageLink;
    private int price;
    private int categoryID;
    private String categoryName;
    private int storeID;
    private String storeName;
    private int totalProduct;
    private int accept;

    public CardProduct(int productID, String productName, String descriptions, String sex, String imageLink, int price, int categoryID, String categoryName, int storeID, String storeName, int totalProduct) {
        this.productID = productID;
        this.productName = productName;
        this.descriptions = descriptions;
        this.sex = sex;
        this.imageLink = imageLink;
        this.price = price;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.storeID = storeID;
        this.storeName = storeName;
        this.totalProduct = totalProduct;
    }

    public CardProduct(int productID, String productName, String descriptions, String sex, String imageLink, int price, int categoryID, String categoryName, int storeID, String storeName) {
        this.productID = productID;
        this.productName = productName;
        this.descriptions = descriptions;
        this.sex = sex;
        this.imageLink = imageLink;
        this.price = price;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.storeID = storeID;
        this.storeName = storeName;
    }

    public CardProduct(int productID, String productName, String imageLink, int price, String categoryName, String storeName, int totalProduct, int accept) {
        this.productID = productID;
        this.productName = productName;
        this.imageLink = imageLink;
        this.price = price;
        this.categoryName = categoryName;
        this.storeName = storeName;
        this.totalProduct = totalProduct;
        this.accept = accept;
    }

    public int getAccept() {
        return accept;
    } 

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getSex() {
        return sex;
    }

    public String getImageLink() {
        return imageLink;
    }

    public int getPrice() {
        return price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getTotalProduct() {
        return totalProduct;
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
