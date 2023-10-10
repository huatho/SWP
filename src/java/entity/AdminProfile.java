
package entity;


public class AdminProfile {
    private int adminId;
    private String adminName;
    private String adminAddress;
    private String adminPhone;
    private String avatar;
    private String path;
    private int id;
    private String acc;
    private String pass;
    private String email;
    private int roles;

    public AdminProfile() {
    }

    public AdminProfile(int adminId, String adminName, String adminAddress, String adminPhone, String avatar) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminAddress = adminAddress;
        this.adminPhone = adminPhone;
        this.avatar = avatar;
    }

    public AdminProfile(int adminId, String adminName, String adminAddress, String adminPhone, String avatar, String path, int id, String acc, String pass, String email, int roles) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminAddress = adminAddress;
        this.adminPhone = adminPhone;
        this.avatar = avatar;
        this.path = path;
        this.id = id;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
    }
        
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }
    

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
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
    
    

    @Override
    public String toString() {
        return "AdminProfile{" + "adminId=" + adminId + ", adminName=" + adminName + ", adminAddress=" + adminAddress + ", adminPhone=" + adminPhone + ", avatar=" + avatar + ", path=" + path + '}';
    }


}
