package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private List<Component> components;

    public GameObject() {
        components = new ArrayList<>();
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
