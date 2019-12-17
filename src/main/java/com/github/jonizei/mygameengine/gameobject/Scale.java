package com.github.jonizei.mygameengine.gameobject;

import com.github.jonizei.mygameengine.GameEngine;
import com.github.jonizei.mygameengine.resource.Saveable;
import com.github.jonizei.mygameengine.utils.MetricConverter;
import org.json.JSONObject;

/**
 * This class holds width and height values
 *
 * @author Joni Koskinen
 * @version 2019-11-26
 */
public class Scale implements Saveable<Scale> {

    /**
     * Threshold which widens the width and height
     * When comparing to another scale-object they don't need to be exact the same to be equal
     */
    private final double THRESHOLD = 0.07;

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

    /**
     * Returns Scale as a String
     *
     * @return Scale as a String
     */
    public String toString() {
        return "Scale{Width = " + getWidth() + ", Height = " + getHeight() + "}";
    }

    /**
     * Compares Scale-objects together and checks if they match
     *
     * @param scale Scale-object to be compared with
     * @return boolean value which tells if the match
     */
    public boolean equals(Scale scale) {

        if(getWidth() > (scale.getWidth() - THRESHOLD) && getWidth() < (scale.getWidth() + THRESHOLD)) {
            if(getHeight() > (scale.getHeight() - THRESHOLD) && getHeight() < (scale.getHeight() + THRESHOLD)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Creates new Scale instance using values from this instance
     *
     * @return new Scale instance
     */
    public Scale clone() {
        return new Scale(getWidth(), getHeight());
    }

    /**
     * Calculates new Scale using start size and end size and duration
     *
     * @param begin Scale-object where to start
     * @param end Scale-object where to stop
     * @param duration Duration how long the scaling should take
     * @return Scale which is the next size of the object
     */
    public static Scale scaleTo(Scale begin, Scale end, long duration) {

        Scale newScale = begin.clone();

        if(!begin.equals(end)) {

            double durationInSeconds = duration / 1000;

            double wDist = MetricConverter.toPixels(end.getWidth()) - MetricConverter.toPixels(begin.getWidth());
            double hDist = MetricConverter.toPixels(end.getHeight()) - MetricConverter.toPixels(begin.getHeight());

            double newWidth = wDist / (durationInSeconds * 59);
            double newHeight = hDist / (durationInSeconds * 59);

            newWidth = MetricConverter.toMetrics(newWidth);
            newHeight = MetricConverter.toMetrics(newHeight);

            newScale = new Scale(begin.getWidth() + newWidth, begin.getHeight() + newHeight);

            if(newScale.getWidth() > end.getWidth() && newScale.getHeight() > end.getHeight()) {
                newScale = end;
            }

        }
        else {
            newScale = end;
        }

        return newScale;
    }

    /**
     * Overrided method from Saveable interface.
     * Creates json object using necessary information from this class
     *
     * @return JsonObject with necessary information
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("width", width);
        json.put("height", height);
        return json;
    }

    /**
     * Overrided method from Saveable interface.
     * Tries to initialize this object using given json object
     *
     * @param json JsonObject holding object information
     * @return Instance of this class
     */
    @Override
    public Scale toObject(JSONObject json) {
        setWidth(json.getDouble("width"));
        setHeight(json.getDouble("height"));

        return this;
    }

}
