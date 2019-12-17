package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.gameobject.Transform;
import com.github.jonizei.mygameengine.resource.Saveable;
import javafx.scene.paint.Color;
import org.json.JSONObject;

/**
 * This class represents a shape
 *
 * @author Joni Koskinen
 * @version 2019-12-02
 */
public class Shape implements Renderable, Saveable<Shape> {

    /**
     * Constant shape that is rectangle
     */
    public static final Shape RECTANGLE = new Shape("rectangle");

    /**
     * Constant shape that is oval
     */
    public static final Shape OVAL = new Shape("oval");

    /**
     * Name of the shape
     */
    private String name;

    /**
     * Color of the shape
     */
    private Color color;

    /**
     * Transform of the shape
     */
    private Transform transform;

    /**
     * Default constructor of Shape
     */
    public Shape() {

    }

    /**
     * Constructor of Shape
     *
     * Initializes the name of the shape
     *
     * @param name Name of the shape
     */
    public Shape(String name) {
        setName(name);
    }

    /**
     * Sets name of the shape
     *
     * @param name name of the shape
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns name of the shape
     *
     * @return name of the shape
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set color of the shape
     *
     * @param color Color of the shape
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Returns Color of the shape
     *
     * @return Color of the shape
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Set transform of the shape
     *
     * @param transform Transform of the shape
     */
    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    /**
     * Returns transform of the shape
     *
     * @return Transform of the shape
     */
    public Transform getTransform() {
        return this.transform;
    }

    /**
     * Overrides render method from Component class.
     * Renders shape by using name of the shape
     *
     * @param graphics Graphics-object
     */
    @Override
    public void render(Graphics graphics) {

        switch (name.toLowerCase()) {
            case "rectangle":
                graphics.drawRect(transform, color);
                break;

            case "oval":
                graphics.drawOval(transform, color);
                break;
        }

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);

        JSONObject colorJson = new JSONObject();
        colorJson.put("red", color.getRed());
        colorJson.put("green", color.getGreen());
        colorJson.put("blue", color.getBlue());
        colorJson.put("opacity", color.getOpacity());

        json.put("color", colorJson);
        return json;
    }

    @Override
    public Shape toObject(JSONObject json) {
        setName(json.getString("name"));
        JSONObject colorJson = json.getJSONObject("color");
        double red = colorJson.getDouble("red");
        double green = colorJson.getDouble("green");
        double blue = colorJson.getDouble("blue");
        double opacity = colorJson.getDouble("opacity");

        color = new Color(red,green,blue,1);

        return this;
    }
}
