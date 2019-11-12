package com.github.jonizei.mygameengine;

public class Scale {

    private double width;
    private double height;

    public Scale() {
        setWidth(0);
        setHeight(0);
    }

    public Scale(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        if(width >= 0) {
            this.width = width;
        }
    }

    public void setHeight(double height) {
        if(height >= 0) {
            this.height = height;
        }
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

}
