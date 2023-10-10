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
public class qldoanhthu {
    private String ProductName;
    private double priceProduct;
    private String dayofcreate;
    private double Price;

    public qldoanhthu() {
    }

    public qldoanhthu(String ProductName, double priceProduct, String dayofcreate, double Price) {
        this.ProductName = ProductName;
        this.priceProduct = priceProduct;
        this.dayofcreate = dayofcreate;
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

    public String getDayofcreate() {
        return dayofcreate;
    }

    public void setDayofcreate(String dayofcreate) {
        this.dayofcreate = dayofcreate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "qldoanhthu{" + "ProductName=" + ProductName + ", priceProduct=" + priceProduct + ", dayofcreate=" + dayofcreate + ", Price=" + Price + '}';
    }

}
