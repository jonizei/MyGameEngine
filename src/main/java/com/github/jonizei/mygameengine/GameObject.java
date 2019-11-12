package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameObject {

    private static int idCounter = 1;

    private int id;
    private String name;
    private List<Component> components;
    private Position position;

    public GameObject(String name) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        position = new Position();
    }

    public GameObject(String name, double x, double y) {
        this.id = idCounter++;
        setName(name);
        components = new ArrayList<>();
        position = new Position(x, y);
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

    public List<Component> getComponents() {
        return this.components;
    }

    public void addComponent(Component component) {
        component.setGameObject(this);
        this.components.add(component);
    }

    public <T extends Component> Component getComponent(Class<T> c) {
        return components.stream().filter(component -> c.isInstance(component)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }


}
