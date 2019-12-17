package com.github.jonizei.mygameengine.resource;

import org.json.JSONObject;

public interface Saveable<T> {
    JSONObject toJson();
    T toObject(JSONObject json);
}
