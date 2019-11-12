package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameScene {

    private static int idCounter = 1;

    private int id;
    private String name;
    private double width;
    private double height;
    private List<GameObject> gameObjects;

    public GameScene(String name, double width, double height) {
        this.id = idCounter++;
        setName(name);
        setWidth(width);
        setHeight(height);
        gameObjects = new ArrayList<>();
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

    public void setWidth(double width) {
        if(width > 0) {
            this.width = width;
        }
    }

    public void setHeight(double height) {
        if(height > 0) {
            this.height = height;
        }
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    public GameObject getGameObjectByName(String name) {
        return (GameObject) gameObjects.stream().filter(gameObject -> gameObject.getName().equals(name)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    public <T extends Component> List<GameObject> getGameObjectsByComponent(Class<T> c) {
        return (List) gameObjects.stream().filter(gameObject -> gameObject.contains(c)).collect(Collectors.toList());
    }

}