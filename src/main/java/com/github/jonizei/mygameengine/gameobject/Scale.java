package com.github.jonizei.mygameengine.gameobject;

/**
 * This class holds width and height values
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class Scale {

    /**
     * Value of width
     */
    private double width;

    /**
     * Value of height
     */
    private double height;

    /**
     * Constructor of Scale
     *
     * Initializes width and height
     */
    public Scale() {
        setWidth(0);
        setHeight(0);
    }

    /**
     * Constructor of Scale
     *
     * Initializes width and height
     *
     * @param width Value of width
     * @param height Value of height
     */
    public Scale(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Sets value for width
     *
     * @param width Value of width
     */
    public void setWidth(double width) {
        if(width >= 0) {
            this.width = width;
        }
    }

    /**
     * Sets value for height
     *
     * @param height Value of height
     */
    public void setHeight(double height) {
        if(height >= 0) {
            this.height = height;
        }
    }

    /**
     * Returns value of width
     *
     * @return Value of width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns value of height
     *
     * @return Value of height
     */
    public double getHeight() {
        return this.height;
    }

}
