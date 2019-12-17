package com.github.jonizei.mygameengine.resource;

import org.json.JSONObject;

/**
 * This interface ensures that class contains required methods for saving object to json file
 *
 * @param <T> Generic class type which determines the return value of toObject method
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public interface Saveable<T> {
    JSONObject toJson();
    T toObject(JSONObject json);
}
