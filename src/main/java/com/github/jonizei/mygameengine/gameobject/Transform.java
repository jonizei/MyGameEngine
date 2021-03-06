package com.github.jonizei.mygameengine.gameobject;

import com.github.jonizei.mygameengine.resource.Saveable;
import org.json.JSONObject;

/**
 * This class holds position and scale
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class Transform implements Saveable<Transform> {

    /**
     * Position object
     */
    private Position position;

    /**
     * Scale object
     */
    private Scale scale;

    /**
     * Rotation object
     */
    private Rotation rotation;

    /**
     * Radius of the object
     */
    private double radius;

    /**
     * Constructor of Transform
     *
     * Initializes position and scale
     */
    public Transform() {
        setScale(new Scale(0, 0));
        setPosition(new Position(0, 0));
        setRotation(new Rotation(0));
        setRadius(0);
    }

    /**
     * Constructor of Transform
     *
     * Initializes position and scale
     *
     * @param position Position object
     * @param scale Scale object
     */
    public Transform(Position position, Scale scale, Rotation rotation) {
        setScale(scale);
        setPosition(position);
        setRotation(rotation);
        setRadius(0);
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
     * Sets value for rotation
     *
     * @param rotation Value of rotation
     */
    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    /**
     * Sets value for radius
     *
     * @param radius Value of radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
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
     * Returns rotation value
     *
     * @return Rotation value
     */
    public Rotation getRotation() {
        return this.rotation;
    }

    /**
     * Returns radius value
     *
     * @return radius value
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Initializes offset for position using width and height from scale object
     * if radius is bigger than zero then it will be used instead of scale object
     */
    private void setPositionOffsets() {

        if(scale.getWidth() > 0) {
            this.position.setXOffset(scale.getWidth()/2);
        }
        if(scale.getHeight() > 0) {
            this.position.setYOffset(scale.getHeight()/2);
        }

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
        json.put("position", position.toJson());
        json.put("scale", scale.toJson());
        json.put("rotation", rotation.toJson());
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
    public Transform toObject(JSONObject json) {
        Position p = new Position();
        p.toObject(json.getJSONObject("position"));

        Scale s = new Scale();
        s.toObject(json.getJSONObject("scale"));

        Rotation r = new Rotation(0);
        r.toObject(json.getJSONObject("rotation"));

        setPosition(p);
        setScale(s);
        setRotation(r);

        return this;
    }

}
