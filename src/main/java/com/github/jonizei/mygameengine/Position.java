package com.github.jonizei.mygameengine;

public class Position {

    private final double THRESHOLD = 0.07;

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

    public String toString() {
        return "Position{X = " + x + " Y = " + y + "}";
    }

    public boolean equals(Position position) {

        if(position.getX() > (x - THRESHOLD) && position.getX() < (x + THRESHOLD)) {
            if(position.getY() > (y - THRESHOLD) && position.getY() < (y + THRESHOLD)) {
                return true;
            }
        }

        return false;
    }

    public Position clone() {
        return new Position(getX(), getY());
    }

    public static Position translate(Position from, Position to, double speed) {

        Position newPosition = from.clone();

        if(!from.equals(to)) {
            double newX = MetricConverter.toPixels(to.getX()) - MetricConverter.toPixels(from.getX());
            double newY = MetricConverter.toPixels(to.getY()) - MetricConverter.toPixels(from.getY());
            double dist = Math.sqrt(newX*newX + newY*newY);

            double velX = (newX/dist)*speed;
            double velY = (newY/dist)*speed;

            velX = MetricConverter.toMetrics(velX);
            velY = MetricConverter.toMetrics(velY);

            newPosition = new Position(from.getX() + velX, from.getY() + velY);
        }

        return newPosition;
    }

}
