package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameObject {

    private static int idCounter = 1;

    private int id;
    private String name;
    private List<Component> components;
    private Transform transform;

    public GameObject(String name) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        transform = new Transform();
    }

    public GameObject(String name, double x, double y) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        transform = new Transform(new Position(x, y), new Scale());
    }

    public GameObject(String name, double x, double y, double width, double height) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        transform = new Transform(new Position(x, y), new Scale(width, height));
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Transform getTransform() {
        return transform;
    }

    public List<Component> getComponents() {
        return this.components;
    }

    public void addComponent(Component component) {
        component.setGameObject(this);
        this.components.add(component);
    }

    public <T extends Component> Component getComponent(Class<T> c) {
        return components.stream()
                .filter(component -> c.isInstance(component))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    public <T extends Component> boolean contains(Class<T> c) {

        if(getComponent(c) != null) {
            return true;
        }

        return false;
    }


}
