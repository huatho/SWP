/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author trung
 */
public class topsellP {
    private int id;
    private String name;
    private double price;
    private int amount;
    private int total;

    public topsellP() {
    }

    public topsellP(int id, String name, double price, int amount, int total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotal() {
        return total;
    }


}
