package com.github.jonizei.mygameengine.gameobject;

public class Rotation {

    public final double THRESHOLD = 0.05;

    private double angleDegrees;
    private double angleRadians;

    public Rotation(double angle) {
        setAngle(angle);
    }

    public void setAngle(double angle) {
        this.angleDegrees = angle;
        this.angleRadians = degreesToRadians(angle);
    }

    public double getAngle() {
        return this.angleDegrees;
    }

    public void setAngleRadians(double radians) {
        this.angleRadians = radians;
        this.angleDegrees = radiansToDegrees(radians);
    }

    public double getAngleRadians() {
        return this.angleRadians;
    }

    public double degreesToRadians(double degrees) {
        return degrees * Math.PI/180;
    }

    public double radiansToDegrees(double radians) {
        return radians * 180/Math.PI;
    }

    public boolean equals(Rotation rotation) {

        if(getAngle() < (rotation.getAngle() + THRESHOLD) && getAngle() > (rotation.getAngle() - THRESHOLD)) {
            return true;
        }

        return false;
    }

    public Rotation clone() {
        return new Rotation(getAngle());
    }

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
