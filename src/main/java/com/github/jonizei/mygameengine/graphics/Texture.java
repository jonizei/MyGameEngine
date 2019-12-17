package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.GameEngine;
import com.github.jonizei.mygameengine.gameobject.Component;
import com.github.jonizei.mygameengine.resource.Saveable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class is a component that is renderable
 * This class can hold either a shape or an image
 *
 * @author Joni Koskinen
 * @version 2019-12-02
 */
public class Texture extends Component implements Renderable {

    /**
     * Holds the id value of the next Texture
     */
    private static int idCounter = 1;

    /**
     * Id of the Texture
     */
    private int id;

    /**
     * Name of the Texture
     */
    private String name;

    /**
     * Shape of the texture
     */
    private Shape shape;

    /**
     * Image of the texture
     */
    private Image image;

    /**
     * Filename of the image
     */
    private String filename;

    public Texture() {
        setId(idCounter++);
    }

    /**
     * Constructor of Texture
     *
     * Initializes id, name, shape and color
     *
     * @param name Name of the Texture
     * @param shape Shape of the Texture
     * @param color Color of the Shape
     */
    public Texture(String name, Shape shape, Color color) {
        setId(idCounter++);
        setName(name);
        setShape(shape);
        this.shape.setColor(color);
    }

    /**
     * Constructor of Texture
     *
     * Initializes id, name and filename
     *
     * @param name Name of the Texture
     * @param filename Filename of the image
     */
    public Texture(String name, String filename) {
        setId(idCounter++);
        setName(name);
        setFilename(filename);
    }

    /**
     * Sets id value
     *
     * @param id id value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns id value
     *
     * @return id value
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets name value
     *
     * @param name name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return name value
     *
     * @return name value
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets filename value
     *
     * @param filename filename value
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Returns filename value
     *
     * @return filename value
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Sets Shape-object
     *
     * @param shape Shape-object
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Returns Shape-object
     *
     * @return Shape-object
     */
    public Shape getShape() {
        return this.shape;
    }

    /**
     * Tries to load image from resources directory using the filename
     * Throws FileNotFoundException if file doesn't exist
     *
     * @param filename Name of the file
     */
    public void setImage(String filename) {

        try {
            this.image = new Image(new FileInputStream(GameEngine.getFilePath() + "textures/" + filename));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Return Image of the Texture
     *
     * @return Image of the Texture
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Overrides start method from Component class.
     * Sets transform value for shape if not null
     * Loads image if filename is not empty
     */
    @Override
    public void start() {
        if(shape != null) {
            this.shape.setTransform(transform);
        }
        else if(!filename.equals("")) {
            setImage(filename);
        }
    }

    /**
     * Overrides update method from Component class
     */
    @Override
    public void update() {

    }

    /**
     * Overrides render method from Renderable interface.
     * Renders shape if not null and renders image if not null
     * but only one is rendered
     *
     * @param graphics Graphics-object
     */
    @Override
    public void render(Graphics graphics) {

        if(shape != null) {
            shape.render(graphics);
        }
        else if(image != null) {
            graphics.drawImage(transform, image);
        }

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("className", this.getClass().getName());

        if(shape != null) {
            json.put("shape", shape.toJson());
        }
        else if(!filename.equals("")) {
            json.put("filename", filename);
        }

        return json;
    }

    @Override
    public Texture toObject(JSONObject json) {
        setName(json.getString("name"));

        if(json.has("shape")) {
            shape = new Shape().toObject(json.getJSONObject("shape"));
            setShape(shape);
        }
        else if(json.has("filename")) {
            filename = json.getString("filename");
        }

        return this;
    }

}
