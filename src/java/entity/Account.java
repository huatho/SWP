/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author PC
 */
public class Account {
    private int id;
    private String acc;
    private String pass;
    private String email;
    private int roles;
     

    
     public Account() {
    }

    public Account(int id,String acc, String pass, String email, int roles) {
        this.id = id;
        this.acc = acc;
        this.pass = pass;
        this.email = email;
        this.roles = roles;
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

   

    

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", acc=" + acc + ", pass=" + pass + ", email=" + email + ", roles=" + roles + '}';
    }

   


}
