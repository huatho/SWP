package dtos;

import java.io.Serializable;

public class SellerDTO implements Serializable {
    
    private int sellerID;
    private String sellerName;
    private String phone;
    private String sellerAddress;
    private String avatar;
    private int managerUser;

    public SellerDTO() {
    }

    public SellerDTO(int sellerID, String sellerName, String phone, String sellerAddress, String avatar, int managerUser) {
        this.sellerID = sellerID;
        this.sellerName = sellerName;
        this.phone = phone;
        this.sellerAddress = sellerAddress;
        this.avatar = avatar;
        this.managerUser = managerUser;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
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
