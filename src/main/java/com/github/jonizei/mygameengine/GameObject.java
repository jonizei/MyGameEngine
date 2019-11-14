package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents object in a game scene
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class GameObject {

    /**
     * Holds the id value of next GameObject
     */
    private static int idCounter = 1;

    /**
     * Id of the GameObject
     */
    private int id;

    /**
     * Name of the GameObject
     */
    private String name;

    /**
     * List of Components of the GameObject
     */
    private List<Component> components;

    /**
     * Transform object which contains position and scale of the GameObject
     */
    private Transform transform;

    /**
     * Constructor of the GameObject
     *
     * Initializes the id, name, components and transform
     *
     * @param name Name of the GameObject
     */
    public GameObject(String name) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        transform = new Transform();
    }

    /**
     * Constructor of the GameObject
     *
     * Initializes the id, name, components, transform and position
     *
     * @param name Name of the GameObject
     * @param x X position of the GameObject
     * @param y Y position of the GameObject
     */
    public GameObject(String name, double x, double y) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        transform = new Transform(new Position(x, y), new Scale());
    }

    /**
     * Constructor of the GameObject
     *
     * Initializes the id, name, components, transform, position and scale
     *
     * @param name Name of the GameObject
     * @param x X position of the GameObject
     * @param y Y position of the GameObject
     * @param width Width of the GameObject
     * @param height Height of the GameObject
     */
    public GameObject(String name, double x, double y, double width, double height) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        transform = new Transform(new Position(x, y), new Scale(width, height));
    }

    /**
     * Returns the id of the GameObject
     *
     * @return Id of the GameObject
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the name of the GameObject
     *
     * @param name Name of the GameObject
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the GameObject
     *
     * @return Name of the GameObject
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the transform of the GameObject
     *
     * @return Transform of the GameObject
     */
    public Transform getTransform() {
        return transform;
    }

    /**
     * Returns list of components of the GameObject
     *
     * @return List of components of the GameObject
     */
    public List<Component> getComponents() {
        return this.components;
    }

    /**
     * Adds component to the GameObject
     *
     * @param component Component object
     */
    public void addComponent(Component component) {
        component.setGameObject(this);
        this.components.add(component);
    }

    /**
     * Returns component which is an instance of given class
     *
     * @param c class which instance needs to be found
     * @param <T> type of the class
     * @return Component which is an instance of given class
     */
    public <T extends Component> Component getComponent(Class<T> c) {
        return components.stream()
                .filter(component -> c.isInstance(component))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    /**
     * Tells if GameObject contains component which is an instance of given class
     *
     * @param c class which instance needs to be found
     * @param <T> type of the class
     * @return boolean value which tells if contains component or not
     */
    public <T extends Component> boolean contains(Class<T> c) {

        if(getComponent(c) != null) {
            return true;
        }

        return false;
    }


}
