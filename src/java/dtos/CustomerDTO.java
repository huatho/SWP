package dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    
    private int customerID;
    private String customerName;
    private String phone;
    private String customerAddress;
    private String avatar;
    private int managerUser;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerID, String customerName, String phone, String customerAddress, String avatar, int managerUser) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.customerAddress = customerAddress;
        this.avatar = avatar;
        this.managerUser = managerUser;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(int managerUser) {
        this.managerUser = managerUser;
    }
    
    

}
