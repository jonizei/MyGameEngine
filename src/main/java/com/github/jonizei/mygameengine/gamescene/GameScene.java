package com.github.jonizei.mygameengine.gamescene;

import com.github.jonizei.mygameengine.gameobject.Component;
import com.github.jonizei.mygameengine.gameobject.GameObject;
import com.github.jonizei.mygameengine.resource.Saveable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents a scene of the game.
 * This class holds all the GameObjects
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class GameScene implements Saveable {

    /**
     * Holds the id value of next GameScene
     */
    private static int idCounter = 1;

    /**
     * Id of the GameScene
     */
    private int id;

    /**
     * Name of the GameScene
     */
    private String name;

    /**
     * Width of the GameScene
     */
    private double width;

    /**
     * Height of the GameScene
     */
    private double height;

    /**
     * List of GameObjects in the GameScene
     */
    private List<GameObject> gameObjects;

    /**
     * Constructor of GameScene
     *
     * @param name Name of the GameScene
     * @param width Width of the GameScene
     * @param height Height of the GameScene
     */
    public GameScene(String name, double width, double height) {
        this.id = idCounter++;
        setName(name);
        setWidth(width);
        setHeight(height);
        gameObjects = new ArrayList<>();
    }

    /**
     * Returns id of the GameScene
     *
     * @return Id of the GameScene
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets name of the GameScene
     *
     * @param name Name of the GameScene
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns name of the GameScene
     *
     * @return Name of the GameScene
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the width of the GameScene
     *
     * @param width Width of the GameScene
     */
    public void setWidth(double width) {
        if(width > 0) {
            this.width = width;
        }
    }

    /**
     * Sets height of the GameScene
     *
     * @param height Height of the GameScene
     */
    public void setHeight(double height) {
        if(height > 0) {
            this.height = height;
        }
    }

    /**
     * Returns width of the GameScene
     *
     * @return Width of the GameScene
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns height of the GameScene
     *
     * @return Height of the GameScene
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Adds GameObject to the List of GameObjects
     *
     * @param gameObject GameObject object
     */
    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    /**
     * Returns list of GameObjects
     *
     * @return List of GameObjects
     */
    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    /**
     * Return GameObject with given id
     *
     * @param id Id of the GameObject
     * @return GameObject with given id
     */
    public GameObject getGameObjectById(int id) {
        return (GameObject) gameObjects.stream().filter(gameObject -> gameObject.getId() == id).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    /**
     * Returns GameObject with given name
     *
     * @param name Name of the GameObject
     * @return GameObject with given name
     */
    public GameObject getGameObjectByName(String name) {
        return (GameObject) gameObjects.stream().filter(gameObject -> gameObject.getName().equals(name)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    /**
     * Returns list of GameObjects which contains given component instance
     *
     * @param c class instance that needs to be found
     * @param <T> type of class
     * @return List of GameObjects which contains given component
     */
    public <T extends Component> List<GameObject> getGameObjectsByComponent(Class<T> c) {
        return (List) gameObjects.stream().filter(gameObject -> gameObject.contains(c)).collect(Collectors.toList());
    }

    @Override
    public JSONObject saveInfo() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("width", width);
        json.put("height", height);

        JSONArray array = new JSONArray();
        gameObjects.stream().forEach(gameObject -> array.put(gameObject.saveInfo()));
        json.put("gameobjects", array);

        return json;
    }

    @Override
    public void loadInfo(JSONObject json) {
        setName(json.getString("name"));
        setWidth(json.getDouble("width"));
        setHeight(json.getDouble("height"));

        JSONArray array = json.getJSONArray("gameobjects");
        gameObjects = IntStream.range(0, array.length()).mapToObj(array::getJSONObject).map(jsonObject -> {
            GameObject gameObject = new GameObject("", 0, 0);
            gameObject.loadInfo(jsonObject);
            return gameObject;
        }).collect(Collectors.toList());

    }

}