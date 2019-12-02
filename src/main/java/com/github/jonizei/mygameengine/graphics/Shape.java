package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.gameobject.Transform;
import javafx.scene.paint.Color;

/**
 * This class represents a shape
 *
 * @author Joni Koskinen
 * @version 2019-12-02
 */
public class Shape implements Renderable {

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
}
