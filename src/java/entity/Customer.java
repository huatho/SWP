package entity;

public class Customer {

    private int customerID;
    private String customerName;
    private String phone;
    private String customerAdd;
    private String avatar;
    private String path;
    private int id;
    private String acc;
    private String pass;
    private String email;
    private int roles;

    public Customer() {
    }

    public Customer(int customerID, String customerName, String phone, String customerAdd, String avatar, String path, int id, String acc, String pass, String email, int roles) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.customerAdd = customerAdd;
        this.avatar = avatar;
        this.path = path;
        this.id = id;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
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

    public String getCustomerAdd() {
        return customerAdd;
    }

    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerName=" + customerName + ", phone=" + phone + ", customerAdd=" + customerAdd + ", avatar=" + avatar + ", path=" + path + ", id=" + id + ", acc=" + acc + ", pass=" + pass + ", email=" + email + ", roles=" + roles + '}';
    }

}
