package com.github.jonizei.mygameengine.resource;

import org.json.JSONObject;

/**
 * This class holds required values for a single score
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class Score implements Saveable<Score> {

    /**
     * Id value of the next Score
     */
    private static int idCounter = 1;

    /**
     * Id of the Score
     */
    private int id;

    /**
     * Name of the Score
     */
    private String name;

    /**
     * Value of the Score
     */
    private int value;

    /**
     * Default Constructor of Score
     * Initializes the id of the Score
     */
    public Score() {
        setId(idCounter++);
    }

    /**
     * Constructor of Score
     * Initializes id, name and value
     *
     * @param name Name of the Score
     * @param value Value of the Score
     */
    public Score(String name, int value) {
        setId(idCounter++);
        setName(name);
        setValue(value);
    }

    /**
     * Sets value for the id
     *
     * @param id Value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns value of the id
     *
     * @return Value of id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set value for name of the Score
     *
     * @param name Value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns value of name
     *
     * @return Value of name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets score value
     *
     * @param value Value of Score
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns score value
     *
     * @return Value of Score
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Overrided method from Saveable interface.
     * Creates json object using necessary information from this class
     *
     * @return JsonObject with necessary information
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("value", value);
        return json;
    }

    /**
     * Overrided method from Saveable interface.
     * Tries to initialize this object using given json object
     *
     * @param json JsonObject holding object information
     * @return Instance of this class
     */
    @Override
    public Score toObject(JSONObject json) {
        setName(json.getString("name"));
        setValue(json.getInt("value"));
        return this;
    }
}
