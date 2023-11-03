package entity;

public class Customer {

    private int id;
    private String name;
    private String phone;
    private String address;
    private String acc;
    private String pass;
    private String email;
    private int roles;
    private int lock;

    public Customer(int id, String name, String phone, String address, String acc, String pass, String email, int roles, int lock) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
        this.lock = lock;
    }

    public int getLock() {
        return lock;
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAcc() {
        return acc;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public int getRoles() {
        return roles;
    }
    
    



    
}
