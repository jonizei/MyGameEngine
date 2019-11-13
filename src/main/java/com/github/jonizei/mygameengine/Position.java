package com.github.jonizei.mygameengine;

public class Position {

    private final double THRESHOLD = 0.07;

    private double x;
    private double y;
    private double xOffset;
    private double yOffset;

    public Position() {
        setX(0);
        setY(0);
        setXOffset(0);
        setYOffset(0);
    }

    public Position(double x, double y) {
        setX(x);
        setY(y);
        setXOffset(0);
        setYOffset(0);
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

    public double getOriginX() {
        return this.x + xOffset;
    }

    public double getOriginY() {
        return this.y + yOffset;
    }

    public void setXOffset(double offset) {
        if(offset >= 0) {
            this.xOffset = offset;
        }
    }

    public void setYOffset(double offset) {
        if(offset >= 0) {
            this.yOffset = offset;
        }
    }

    public double getXOffset() {
        return this.xOffset;
    }

    public double getYOffset() {
        return this.yOffset;
    }

    public String toString() {
        return "Position{X = " + getX() + " Y = " + getY() + "}";
    }

    public boolean equals(Position position) {

        if(position.getOriginX() > (getOriginX() - THRESHOLD) && position.getOriginX() < (getOriginX() + THRESHOLD)) {
            if(position.getOriginY() > (getOriginY() - THRESHOLD) && position.getOriginY() < (getOriginY() + THRESHOLD)) {
                return true;
            }
        }

        return false;
    }

    public Position clone() {
        Position clonePosition = new Position(getX(), getY());
        clonePosition.setXOffset(getXOffset());
        clonePosition.setYOffset(getYOffset());
        return clonePosition;
    }

    public static Position translate(Position from, Position to, double speed) {

        Position newPosition = from.clone();

        if(!from.equals(to)) {
            double newX = MetricConverter.toPixels(to.getOriginX()) - MetricConverter.toPixels(from.getOriginX());
            double newY = MetricConverter.toPixels(to.getOriginY()) - MetricConverter.toPixels(from.getOriginY());
            double dist = Math.sqrt(newX*newX + newY*newY);

            double velX = (newX/dist)*speed;
            double velY = (newY/dist)*speed;

            velX = MetricConverter.toMetrics(velX);
            velY = MetricConverter.toMetrics(velY);

            newPosition = new Position(from.getX() + velX, from.getY() + velY);
            newPosition.setXOffset(from.getXOffset());
            newPosition.setYOffset(from.getYOffset());
        }

        return newPosition;
    }

}
