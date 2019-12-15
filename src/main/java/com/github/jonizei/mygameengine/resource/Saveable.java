package com.github.jonizei.mygameengine.resource;

import org.json.JSONObject;

public interface Saveable {
    JSONObject saveInfo();
    void loadInfo(JSONObject json);
}
