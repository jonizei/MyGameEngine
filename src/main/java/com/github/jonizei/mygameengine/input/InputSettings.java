package com.github.jonizei.mygameengine.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;
import java.util.List;

public class InputSettings {

    private List<InputKey> inputKeyList;
    private List<InputKey> mouseKeyList;

    public InputSettings() {
        inputKeyList = new ArrayList<>();
        mouseKeyList = new ArrayList<>();
    }

    public List<InputKey> getInputKeyList() {
        return this.inputKeyList;
    }

    public List<InputKey> getMouseKeyList() {
        return this.mouseKeyList;
    }

    public void addKey(String keyName, KeyCode keyCode) {
        inputKeyList.add(new InputKey(keyName, keyCode));
    }

    public void addMouseKey(String keyName, MouseButton mouseButton) {
        mouseKeyList.add(new InputKey(keyName, mouseButton));
    }

}
