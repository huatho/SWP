/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LINH
 */
public class Product {
    private int productID;//1
    private String productName;//2
    private String descriptions;//3
    private String imageLink;//5
    private int price;//6
    private int categoryID;//7
    private String categoryName;//8
//    ---------------------------------------

    public Product() {
    }

    public Product(int productID, String productName, String descriptions, String imageLink, int price, int categoryID, String categoryName) {
        this.productID = productID;
        this.productName = productName;
        this.descriptions = descriptions;
        this.imageLink = imageLink;
        this.price = price;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
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


    
   
    
//    -----------------------------------
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