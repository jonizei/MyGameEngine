package com.github.jonizei.mygameengine.gameobject;

import com.github.jonizei.mygameengine.utils.MetricConverter;

/**
 * This class reperesents position in the screen
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class Position {

    /**
     * Threshold of the position which widens the position
     * If comparing to positions together they doesn't need to be exact the same to be equal
     */
    private final double THRESHOLD = 0.008;

    /**
     * X value of the position
     */
    private double x;

    /**
     * Y value of the position
     */
    private double y;

    /**
     * Horizontal length to center of the position
     */
    private double xOffset;

    /**
     * Vertical length to center of the position
     */
    private double yOffset;

    /**
     * Constructor of Position
     *
     * Initializes x, y, xOffset and yOffset
     *
     */
    public Position() {
        setX(0);
        setY(0);
        setXOffset(0);
        setYOffset(0);
    }

    /**
     * Constructor of Position
     *
     * Initializes x, y, xOffset and yOffset
     *
     * @param x X value of position
     * @param y Y value of position
     */
    public Position(double x, double y) {
        setX(x);
        setY(y);
        setXOffset(0);
        setYOffset(0);
    }

    /**
     * Sets X value of the position
     *
     * @param x X value of position
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets Y value of the position
     *
     * @param y Y value of the position
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns X value of the position
     *
     * @return X value of the position
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns Y value of the position
     *
     * @return Y value of the position
     */
    public double getY() {
        return this.y;
    }

    /**
     * Returns X value of the center of the position
     *
     * @return X value of the center of the position
     */
    public double getOriginX() {
        return this.x + xOffset;
    }

    /**
     * Returns Y value of the center of the position
     *
     * @return Y value of the center of the position
     */
    public double getOriginY() {
        return this.y + yOffset;
    }

    /**
     * Sets horizontal length to the center of the position
     *
     * @param offset Horizontal length to the center of the position
     */
    public void setXOffset(double offset) {
        if(offset >= 0) {
            this.xOffset = offset;
        }
    }

    /**
     * Sets vertical length to the center of the position
     *
     * @param offset Vertical length to the center of the position
     */
    public void setYOffset(double offset) {
        if(offset >= 0) {
            this.yOffset = offset;
        }
    }

    /**
     * Returns horizontal length to the center of the position
     *
     * @return Horizontal length to the center of the position
     */
    public double getXOffset() {
        return this.xOffset;
    }

    /**
     * Returns vertical length to the center of the position
     *
     * @return Vertical length to the center of the position
     */
    public double getYOffset() {
        return this.yOffset;
    }

    /**
     * Returns position as a String
     *
     * @return Position as a String
     */
    public String toString() {
        return "Position{X = " + getX() + ", Y = " + getY() + "}";
    }

    /**
     * Compares positions together using threshold and checks they match
     *
     * @param position Position to be compared with
     * @return boolean value which tells if they match
     */
    public boolean equals(Position position) {

        if(position.getOriginX() > (getOriginX() - THRESHOLD) && position.getOriginX() < (getOriginX() + THRESHOLD)) {
            if(position.getOriginY() > (getOriginY() - THRESHOLD) && position.getOriginY() < (getOriginY() + THRESHOLD)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Creates clone of the position
     *
     * @return Clone of the position
     */
    public Position clone() {
        Position clonePosition = new Position(getX(), getY());
        clonePosition.setXOffset(getXOffset());
        clonePosition.setYOffset(getYOffset());
        return clonePosition;
    }

    /**
     * Calculates next position between place A and B and returns it
     *
     * @param from Position where to start
     * @param to Position where to stop
     * @param speed Speed of the object
     * @return Position which is the next position where to move
     */
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

            if(newPosition.equals(to)) {
                newPosition = to;
            }

        }
        else {
            newPosition = to;
        }

        return newPosition;
    }

}
