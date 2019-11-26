package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.GameEngine;
import com.github.jonizei.mygameengine.gameobject.Component;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Texture extends Component implements Renderable {

    private String name;
    private Shape shape;
    private Image image;
    private String filename;

    public Texture(String name, Shape shape, Color color) {
        setName(name);
        setShape(shape);
        this.shape.setColor(color);
    }

    public Texture(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setImage(String filename) {

        try {
            this.image = new Image(new FileInputStream(GameEngine.getFilePath() + "/" + filename));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public Image getImage() {
        return this.image;
    }

    @Override
    public void start() {
        if(shape != null) {
            this.shape.setTransform(transform);
        }
        else if(!filename.equals("")) {
            setImage(filename);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

        if(shape != null) {
            shape.render(graphics);
        }
        else if(image != null) {
            graphics.drawImage(transform, image);
        }

    }

}
