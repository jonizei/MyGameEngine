package com.github.jonizei.mygameengine.gameobject;

/**
 * This class holds position and scale
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class Transform {

    /**
     * Position object
     */
    private Position position;

    /**
     * Scale object
     */
    private Scale scale;

    /**
     * Constructor of Transform
     *
     * Initializes position and scale
     */
    public Transform() {
        setScale(new Scale(0, 0));
        setPosition(new Position(0, 0));
    }

    /**
     * Constructor of Transform
     *
     * Initializes position and scale
     *
     * @param position Position object
     * @param scale Scale object
     */
    public Transform(Position position, Scale scale) {
        setScale(scale);
        setPosition(position);
        setPositionOffsets();
    }

    /**
     * Sets value for position
     *
     * @param position Value of position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Sets value for scale
     *
     * @param scale Value of scale
     */
    public void setScale(Scale scale) {
        this.scale = scale;
    }

    /**
     * Returns position value
     *
     * @return Position value
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Returns scale value
     *
     * @return Scale value
     */
    public Scale getScale() {
        return this.scale;
    }

    /**
     * Initializes offset for position using width and height from scale object
     */
    private void setPositionOffsets() {
        if(scale.getWidth() > 0) {
            this.position.setXOffset(scale.getWidth()/2);
        }
        if(scale.getHeight() > 0) {
            this.position.setYOffset(scale.getHeight()/2);
        }
    }

}
