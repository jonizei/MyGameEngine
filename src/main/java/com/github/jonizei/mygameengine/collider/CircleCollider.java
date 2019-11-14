package com.github.jonizei.mygameengine.collider;

import com.github.jonizei.mygameengine.Position;

/**
 * This class represents a circle collider which is used to detect if
 * a GameObject collides with a another GameObject
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class CircleCollider extends Collider{

    /**
     * Radius of the collider
     */
    private double radius;

    /**
     * Constructor of CircleCollider
     *
     * Initializes the radius of the collider
     *
     * @param radius radius of the collider
     */
    public CircleCollider(double radius) {
        setRadius(radius);
    }

    /**
     * Overrides a start method from Component class
     */
    @Override
    public void start() {

    }

    /**
     * Overrides an update method from Component class
     *
     * Checks if the collider collides with other colliders
     */
    @Override
    public void update() {
        checkCollisions();
    }

    /**
     * Sets the collider radius
     *
     * @param radius radius of the collider
     */
    public void setRadius(double radius) {
        if(radius > 0) {
            this.radius = radius;
        }
    }

    /**
     * Returns the radius of the collider
     *
     * @return radius of the collider
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Checks if given position is inside the collider
     *
     * @param position Position object
     * @return boolean value which tells if position is inside the collider or not
     */
    @Override
    public boolean overlaps(Position position) {

        double newX = position.getX() - transform.getPosition().getOriginX();
        double newY = position.getY() - transform.getPosition().getOriginY();
        double distance = Math.sqrt(newX * newX + newY * newY);

        if(distance < radius) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the collider collides with given Collider
     *
     * @param collider Collider object
     * @return boolean which tells if its a collision or not
     */
    @Override
    public boolean isCollision(Collider collider) {

        boolean doesOverlap = false;

        Position[] array = new Position[8];

        double slice = 2 * Math.PI / array.length;
        for(int i = 0; i < array.length && !doesOverlap; i++) {
            double angle = slice * i;
            double newX = transform.getPosition().getOriginX() + radius * Math.cos(angle);
            double newY = transform.getPosition().getOriginY() + radius * Math.sin(angle);
            doesOverlap = collider.overlaps(new Position(newX, newY));
        }

        return doesOverlap;
    }

}
