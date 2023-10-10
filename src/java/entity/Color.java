/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LINH
 */
public class Color {
    private String color;
    private String linkImageColor;
    
    
    public Color() {
    }

    public Color(String color, String linkImageColor) {
        this.color = color;
        this.linkImageColor = linkImageColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinkImageColor() {
        return linkImageColor;
    }

    public void setLinkImageColor(String linkImageColor) {
        this.linkImageColor = linkImageColor;
    }

    @Override
    public String toString() {
        return "Color{" + "color=" + color + ", linkImageColor=" + linkImageColor + '}';
    }
    
}
