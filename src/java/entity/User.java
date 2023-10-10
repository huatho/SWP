/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Os
 */
public class User {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String avatar;
    private String path;
    private String acc;
    private String pass;
    private Email email;
    private int roles;
    
    User(){}

    public User(int id, String acc, String pass, String name, Email email,String phone, String address, int roles) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
    }

    public User(String name, String phone, String address, String acc, String pass, Email email, int roles) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
    }
    
    public User(String acc, String pass, Email email, int roles) {
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
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

    public String getAvatar() {
        return avatar;
    }

    public String getPath() {
        return path;
    }

    public String getAcc() {
        return acc;
    }

    public String getPass() {
        return pass;
    }

    public Email getEmail() {
        return email;
    }

    public int getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", avatar=" + avatar + ", path=" + path + ", acc=" + acc + ", pass=" + pass + ", email=" + email + ", roles=" + roles + '}';
    }
    
    
    
}
