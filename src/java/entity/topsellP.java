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
    private String ProductName;
    private double priceProduct;
    private int Amount;
    private double Price;

    public topsellP() {
    }

    public topsellP(String ProductName, double priceProduct, int Amount, double Price) {
        this.ProductName = ProductName;
        this.priceProduct = priceProduct;
        this.Amount = Amount;
        this.Price = Price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "topsellP{" + "ProductName=" + ProductName + ", priceProduct=" + priceProduct + ", Amount=" + Amount + ", Price=" + Price + '}';
    }
}
