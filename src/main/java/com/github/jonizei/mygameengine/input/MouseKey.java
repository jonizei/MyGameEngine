package com.github.jonizei.mygameengine.input;

import javafx.scene.input.MouseButton;

/**
 * This class inherits from InputKey and has methods which are required for mouse input
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class MouseKey extends InputKey {

    /**
     * MouseButton instance
     */
    private MouseButton mouseButton;

    /**
     * Boolean value which tells if mouse has been dragged
     */
    private boolean isDragged = false;

    /**
     * Constructor of MouseKey
     * Initializes name of the key and MouseButton
     *
     * @param keyName Name of the key
     * @param mouseButton MouseButton instance
     */
    public MouseKey(String keyName, MouseButton mouseButton) {
        super(keyName);
        setMouseButton(mouseButton);
    }

    /**
     * Set value for mouseButton
     *
     * @param mouseButton MouseButton instance
     */
    public void setMouseButton(MouseButton mouseButton) {
        this.mouseButton = mouseButton;
    }

    /**
     * Return value of mouseButton
     *
     * @return Value of mouseButton
     */
    public MouseButton getMouseButton() {
        return this.mouseButton;
    }

    /**
     * Set value for isDragged
     *
     * @param value Value of isDragged
     */
    public void setDragged(boolean value) {
        this.isDragged = value;
    }

    /**
     * Returns value which tells if mouse has been dragged
     *
     * @return Boolean value which tells if mouse has been dragged
     */
    public boolean isDragged() {
        return this.isDragged;
    }

    /**
     * Overrides method from InputKey
     * Calls setReleased from InputKey
     * and sets isDragged to opposite value to isRelease boolean
     *
     * @param value Value of isReleased boolean
     */
    @Override
    public void setReleased(boolean value) {
        super.setReleased(value);
        isDragged = !value;
    }
}
