package com.github.jonizei.mygameengine.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * This class represents a key that will be listened
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class InputKey {

    /**
     * Name of the key
     */
    private String keyName;

    /**
     * Code of the key
     */
    private KeyCode keyCode;

    /**
     * Boolean value which tells if key has been pressed
     */
    private boolean isPressed = false;

    /**
     * Boolean value which tells if key has been released
     */
    private boolean isReleased = true;

    /**
     * Boolean value which tells if key has been clicked
     */
    private boolean isClicked = false;

    /**
     * Constructor of InputKey
     * Initializes keyName and keyCode
     *
     * @param keyName Name of the key
     * @param keyCode Code of the key
     */
    public InputKey(String keyName, KeyCode keyCode) {
        setKeyName(keyName);
        setKeyCode(keyCode);
    }

    /**
     * Constructor of InputKey
     * Initializes keyName
     *
     * @param keyName Name of the key
     */
    public InputKey(String keyName) {
     setKeyName(keyName);
     }

     /**
     * Sets value for keyName
     *
     * @param keyName Name of the key
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * Sets value for keyCode
     *
     * @param keyCode Code of the key
     */
    public void setKeyCode(KeyCode keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * Returns the name of the key
     *
     * @return Name of the key
     */
    public String getKeyName() {
        return this.keyName;
    }

    /**
     * Returns the code of the key
     *
     * @return Code of the key
     */
    public KeyCode getKeyCode() {
        return this.keyCode;
    }

    /**
     * Sets given value to the isPressed boolean and set the opposite value to isReleased boolean
     *
     * @param value Value of isPressed boolean
     */
    public void setPressed(boolean value) {
        this.isPressed = value;
        this.isReleased = !value;
    }

    /**
     * Return value which tells if key is pressed
     *
     * @return Boolean value which tells if key has been pressed
     */
    public boolean isPressed() {
        return this.isPressed;
    }

    /**
     * Sets given value to the isReleased boolean and set the opposite value to isPressed boolean
     *
     * @param value Value of isReleased boolean
     */
    public void setReleased(boolean value) {
        this.isReleased = value;
        this.isPressed = !value;
    }

    /**
     * Returns value which tells if key is released
     *
     * @return Boolean value which tells if key has been released
     */
    public boolean isReleased() {
        return this.isReleased;
    }

    /**
     * Sets given value to the isClicked boolean
     *
     * @param value Value of isClicked boolean
     */
    public void setClicked(boolean value) {
        this.isClicked = value;
    }

    /**
     * Returns value which tells if key is clicked
     *
     * @return Boolean value which tells if key has been clicked
     */
    public boolean isClicked() {
        return this.isClicked;
    }
}
