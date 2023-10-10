package dtos;

import java.io.Serializable;

public class ProductDTO  implements Serializable {
    private int productID;
    private String productName;
    private String descriptions;
    private String sex;
    private String imageLink;
    private int price;
    private CategoryDTO categoryDTO;
    private int storeID;

    public ProductDTO() {
    }

    public ProductDTO(int productID, String productName, String descriptions, String sex, String imageLink, int price, CategoryDTO categoryDTO, int storeID) {
        this.productID = productID;
        this.productName = productName;
        this.descriptions = descriptions;
        this.sex = sex;
        this.imageLink = imageLink;
        this.price = price;
        this.categoryDTO = categoryDTO;
        this.storeID = storeID;
    }

    public ProductDTO(String productName, String descriptions, String sex, String imageLink, int price, CategoryDTO categoryDTO, int storeID) {
        this.productName = productName;
        this.descriptions = descriptions;
        this.sex = sex;
        this.imageLink = imageLink;
        this.price = price;
        this.categoryDTO = categoryDTO;
        this.storeID = storeID;
    }
    
    

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

}
