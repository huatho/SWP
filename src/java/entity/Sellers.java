package entity;

public class Sellers {

    private int sellerID;
    private String sellerName;
    private String phone;
    private String sellerAdd;
    private String avatar;
    private String path;
    private int id;
    private String acc;
    private String pass;
    private String email;
    private int roles;
    private String linkImage;
    private String storeName;
    private String descriptions;

    public Sellers() {
    }

    public Sellers(int sellerID, String sellerName, String phone, String sellerAdd, String avatar, String path, int id, String acc, String pass, String email, int roles, String linkImage, String storeName, String descriptions) {
        this.sellerID = sellerID;
        this.sellerName = sellerName;
        this.phone = phone;
        this.sellerAdd = sellerAdd;
        this.avatar = avatar;
        this.path = path;
        this.id = id;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
        this.linkImage = linkImage;
        this.storeName = storeName;
        this.descriptions = descriptions;
    }

    public Sellers(int sellerID, String sellerName, String phone, String sellerAdd, String avatar, String path, int id, String acc, String pass, String email, int roles) {
        this.sellerID = sellerID;
        this.sellerName = sellerName;
        this.phone = phone;
        this.sellerAdd = sellerAdd;
        this.avatar = avatar;
        this.path = path;
        this.id = id;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
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

    public String getSellerAdd() {
        return sellerAdd;
    }

    public void setSellerAdd(String sellerAdd) {
        this.sellerAdd = sellerAdd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Sellers{" + "sellerID=" + sellerID + ", sellerName=" + sellerName + ", phone=" + phone + ", sellerAdd=" + sellerAdd + ", avatar=" + avatar + ", id=" + id + ", acc=" + acc + ", pass=" + pass + ", email=" + email + ", roles=" + roles + '}';
    }

}
