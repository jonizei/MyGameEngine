package com.github.jonizei.mygameengine.input;

import javafx.scene.input.MouseButton;

public class MouseKey extends InputKey {

    private boolean isDragged = false;

    public MouseKey(String keyName, MouseButton mouseButton) {
        super(keyName, mouseButton);
    }

    public void setDragged(boolean value) {
        this.isDragged = value;
    }

    public boolean isDragged() {
        return this.isDragged;
    }

    @Override
    public void setReleased(boolean value) {
        super.setReleased(value);
        isDragged = !value;
    }
}
