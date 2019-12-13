package com.github.jonizei.mygameengine.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class InputKey {

    private String keyName;
    private KeyCode keyCode;
    private MouseButton mouseButton;

    private boolean isPressed = false;
    private boolean isReleased = true;
    private boolean isClicked = false;

    public InputKey(String keyName, KeyCode keyCode) {
        setKeyName(keyName);
        setKeyCode(keyCode);
    }

    public InputKey(String keyName, MouseButton mouseButton) {
        setKeyName(keyName);
        setMouseButton(mouseButton);
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public void setKeyCode(KeyCode keyCode) {
        this.keyCode = keyCode;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public KeyCode getKeyCode() {
        return this.keyCode;
    }

    public void setMouseButton(MouseButton mouseButton) {
        this.mouseButton = mouseButton;
    }

    public MouseButton getMouseButton() {
        return this.mouseButton;
    }

    public void setPressed(boolean value) {
        this.isPressed = value;
        this.isReleased = !value;
    }

    public boolean isPressed() {
        return this.isPressed;
    }

    public void setReleased(boolean value) {
        this.isReleased = value;
        this.isPressed = !value;
    }

    public boolean isReleased() {
        return this.isReleased;
    }

    public void setClicked(boolean value) {
        this.isClicked = value;
    }

    public boolean isClicked() {
        return this.isClicked;
    }
}
