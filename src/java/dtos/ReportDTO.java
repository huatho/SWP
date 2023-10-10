package dtos;

import java.io.Serializable;

public class ReportDTO implements Serializable{

    private int customerID;
    private int productID;
    private int storeID;
    private String content;

    public ReportDTO() {
    }

    public ReportDTO(int customerID, int productID, int storeID, String content) {
        this.customerID = customerID;
        this.productID = productID;
        this.storeID = storeID;
        this.content = content;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    

}
