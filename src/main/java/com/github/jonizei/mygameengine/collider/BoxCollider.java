package com.github.jonizei.mygameengine.collider;

import com.github.jonizei.mygameengine.gameobject.Position;
import com.github.jonizei.mygameengine.gameobject.Scale;

/**
 * This class represents a square collider which is used to detect if
 * a GameObject collides with a another GameObject
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class BoxCollider extends Collider {

    /**
     * Width and Height of the collider
     */
    private Scale scale;

    /**
     * Position of top left corner
     */
    private Position topLeft;

    /**
     * Position of bottom left corner
     */
    private Position bottomLeft;

    /**
     * Position of top right corner
     */
    private Position topRight;

    /**
     * Position of bottom right corner
     */
    private Position bottomRight;

    /**
     * Constructor of BoxCollider
     *
     * Initializes the size and all corners of the collider
     *
     * @param width Width of the collider
     * @param height Height of the collider
     */
    public BoxCollider(double width, double height) {
        setScale(new Scale(width, height));
        topLeft = new Position();
        bottomLeft = new Position();
        topRight = new Position();
        bottomRight = new Position();
    }

    /**
     * Sets a width and a height of the collider
     *
     * @param scale Scale object
     */
    public void setScale(Scale scale) {
        this.scale = scale;
    }

    /**
     * Returns a width and a height of the collider as a Scale object
     *
     * @return Scale object
     */
    public Scale getScale() {
        return this.scale;
    }

    /**
     * Overrides a start method from Component class
     */
    @Override
    public void start() {
        calculateCorners();
    }

    /**
     * Overrides an update method from Component class
     *
     * Checks if the collider collides with other colliders
     */
    @Override
    public void update() {
        calculateCorners();
        checkCollisions();
    }

    /**
     * Calculates positions of every corner of the collider
     */
    private void calculateCorners() {
        topLeft.setX(transform.getPosition().getOriginX() - scale.getWidth() / 2);
        topLeft.setY(transform.getPosition().getOriginY() - scale.getHeight() / 2);

        bottomLeft.setX(transform.getPosition().getOriginX() - scale.getWidth() / 2);
        bottomLeft.setY(transform.getPosition().getOriginY() + scale.getHeight() / 2);

        topRight.setX(transform.getPosition().getOriginX() + scale.getWidth() / 2);
        topRight.setY(transform.getPosition().getOriginY() - scale.getHeight() / 2);

        bottomRight.setX(transform.getPosition().getOriginX() + scale.getWidth() / 2);
        bottomRight.setY(transform.getPosition().getOriginY() + scale.getHeight() / 2);
    }

    /**
     * Checks if given position is inside the collider
     *
     * @param position Position object
     * @return boolean value which tells if position is inside the collider or not
     */
    @Override
    public boolean overlaps(Position position) {

        if(position.getX() > topLeft.getX() && position.getX() < topRight.getX()) {
            if(position.getY() > topLeft.getY() && position.getY() < bottomLeft.getY()) {
                return true;
            }
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

        if(!equals(collider)) {
            if(collider.overlaps(topLeft) || collider.overlaps(bottomLeft) || collider.overlaps(topRight) || collider.overlaps(bottomRight)) {
                return true;
            }
        }

        return false;
    }

}
