package com.github.jonizei.mygameengine.resource;

import org.json.JSONObject;

public class Score implements Saveable<Score> {

    private static int idCounter = 1;

    private int id;
    private String name;
    private int value;

    public Score() {
        setId(idCounter++);
    }

    public Score(String name, int value) {
        setId(idCounter++);
        setName(name);
        setValue(value);
    }

    public void setId(int id) {
        this.id = id;
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

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("value", value);
        return json;
    }

    public Score toObject(JSONObject json) {
        setName(json.getString("name"));
        setValue(json.getInt("value"));
        return this;
    }
}
