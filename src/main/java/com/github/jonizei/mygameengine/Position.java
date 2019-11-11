package com.github.jonizei.mygameengine;

public class Position implements Component {

    private double x;
    private double y;

    public Position() {
        setX(0);
        setY(0);
    }

    public Position(double x, double y) {
        setX(x);
        setY(y);
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

}
