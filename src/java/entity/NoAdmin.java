/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class NoAdmin {
    private int id;
    private String name;
    private String Phone;
    private String address;
    private String Avatar;
    private String path;
    private String userid;

    public NoAdmin(int id, String name, String Phone, String address, String Avatar, String path, String userid) {
        this.id = id;
        this.name = name;
        this.Phone = Phone;
        this.address = address;
        this.Avatar = Avatar;
        this.path = path;
        this.userid = userid;
    }

    public NoAdmin() {
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "NoAdmin{" + "id=" + id + ", name=" + name + ", Phone=" + Phone + ", address=" + address + ", Avatar=" + Avatar + ", path=" + path + ", userid=" + userid + '}';
    }
 
    
}
