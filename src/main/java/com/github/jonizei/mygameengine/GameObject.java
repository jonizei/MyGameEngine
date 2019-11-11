package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private static int idCounter = 1;

    private int id;
    private List<Component> components;

    public GameObject() {
        this.id = idCounter++;
        components = new ArrayList<>();
        addComponent(new Position());
    }

    public GameObject(double x, double y) {
        this.id = idCounter++;
        components = new ArrayList<>();
        addComponent(new Position(x, y));
    }

    public int getId() {
        return this.id;
    }

    public List<Component> getComponents() {
        return this.components;
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public boolean contains(Component component) {
        return components.contains(component);
    }

}
