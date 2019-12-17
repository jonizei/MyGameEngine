package com.github.jonizei.mygameengine.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all keys that will be listened and recorded
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class InputSettings {

    /**
     * List of keys that will be listened and recorded
     */
    private List<InputKey> inputKeyList;

    /**
     * List of mouse buttons that will be listened and recorded
     */
    private List<MouseKey> mouseKeyList;

    public InputSettings() {
        inputKeyList = new ArrayList<>();
        mouseKeyList = new ArrayList<>();
    }

    /**
     * Returns list of InputKeys
     *
     * @return List of InputKeys
     */
    public List<InputKey> getInputKeyList() {
        return this.inputKeyList;
    }

    /**
     * Returns list of MouseKeys
     *
     * @return List of MouseKeys
     */
    public List<MouseKey> getMouseKeyList() {
        return this.mouseKeyList;
    }

    /**
     * Creates new InputKey instance with given values and adds it to the list of InputKeys
     *
     * @param keyName Name of the key
     * @param keyCode Code of the key
     */
    public void addKey(String keyName, KeyCode keyCode) {
        inputKeyList.add(new InputKey(keyName, keyCode));
    }

    /**
     * Creates new MouseKey instance with given values and adds it to the list of MouseKeys
     *
     * @param keyName Name of the key
     * @param mouseButton MouseButton instance
     */
    public void addMouseKey(String keyName, MouseButton mouseButton) {
        mouseKeyList.add(new MouseKey(keyName, mouseButton));
    }

}
