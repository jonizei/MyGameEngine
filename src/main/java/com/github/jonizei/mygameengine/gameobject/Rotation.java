package com.github.jonizei.mygameengine.gameobject;

/**
 * This class holds angle of the gameObject
 *
 * @author Joni Koskinen
 * @version 2019-11-27
 */
public class Rotation {

    /**
     * Threshold that widens the angle
     * When comparing to another Rotation object the angle doesn't need to be exact the same to be equal
     */
    public final double THRESHOLD = 0.05;

    /**
     * Angle in degrees
     */
    private double angleDegrees;

    /**
     * Angle in radians
     */
    private double angleRadians;

    /**
     * Constructor of Rotation
     *
     * Initializes the angle
     *
     * @param angle Value of angle
     */
    public Rotation(double angle) {
        setAngle(angle);
    }

    /**
     * Sets angle degree value and converts it to radians also
     *
     * @param angle angle value
     */
    public void setAngle(double angle) {
        this.angleDegrees = angle;
        this.angleRadians = degreesToRadians(angle);
    }

    /**
     * Returns angle value as degrees
     *
     * @return angle value as degrees
     */
    public double getAngle() {
        return this.angleDegrees;
    }

    /**
     * Sets angle radian value and converts it to degrees also
     *
     * @param radians angle value as radians
     */
    public void setAngleRadians(double radians) {
        this.angleRadians = radians;
        this.angleDegrees = radiansToDegrees(radians);
    }

    /**
     * Returns angle value as radians
     *
     * @return angle value as radians
     */
    public double getAngleRadians() {
        return this.angleRadians;
    }

    /**
     * Converts given degrees to radians
     *
     * @param degrees angle in degrees
     * @return angle in radians
     */
    public double degreesToRadians(double degrees) {
        return degrees * Math.PI/180;
    }

    /**
     * Converts given radians to degrees
     *
     * @param radians angle in radians
     * @return angle in degrees
     */
    public double radiansToDegrees(double radians) {
        return radians * 180/Math.PI;
    }

    /**
     * Compares Rotation-objects together and checks if they match
     *
     * @param rotation Rotation-object to be compared with
     * @return boolean value which tells if they match
     */
    public boolean equals(Rotation rotation) {

        if(getAngle() < (rotation.getAngle() + THRESHOLD) && getAngle() > (rotation.getAngle() - THRESHOLD)) {
            return true;
        }

        return false;
    }

    /**
     * Creates new Rotation instance using values from this instance
     *
     * @return new Rotation instance
     */
    public Rotation clone() {
        return new Rotation(getAngle());
    }

    /**
     * Calculates rotation using start point and end point and speed
     *
     * @param from Start value of rotation
     * @param to End value of rotation
     * @param speed Speed of rotation
     * @return Rotation value which is the next angle of the object
     */
    public static Rotation rotateTo(Rotation from, Rotation to, double speed) {

        Rotation newRotation = from.clone();

        if(!from.equals(to)) {

            speed = to.getAngle() < 0 ? speed * -1 : speed;

            newRotation = new Rotation(from.getAngle() + speed);

            if(Math.abs(newRotation.getAngle()) > Math.abs(to.getAngle())) {
                newRotation = to;
            }

        }
        else {
            newRotation = to;
        }

        return newRotation;
    }

}
