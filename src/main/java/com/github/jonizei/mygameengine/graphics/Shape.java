package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.gameobject.Rotation;
import com.github.jonizei.mygameengine.gameobject.Transform;
import javafx.scene.paint.Color;

public class Shape implements Renderable {

    public static Shape RECTANGLE = new Shape("rectangle");
    public static Shape OVAL = new Shape("oval");

    private String name;
    private Color color;
    private Transform transform;

    public Shape(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public Transform getTransform() {
        return this.transform;
    }

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
