package entity;

public class Store {

    private int storeID;
    private String name;
    private String address;
    private int userID;
    private String userName;

    public Store() {
    }

    public Store(int storeID, String name, String address, int userID) {
        this.storeID = storeID;
        this.name = name;
        this.address = address;
        this.userID = userID;
    }

    public Store(int storeID, String name, String address, int userID, String userName) {
        this.storeID = storeID;
        this.name = name;
        this.address = address;
        this.userID = userID;
        this.userName = userName;
    }
    
    

    public int getStoreID() {
        return storeID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
    
    
    

    
}
