/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MSII
 */
public class Colors {
    private String Color;

    public Colors() {
    }

    public Colors(String Color) {
        this.Color = Color;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String toString() {
        return "Colors{" + "Color=" + Color + '}';
    }
    
}
