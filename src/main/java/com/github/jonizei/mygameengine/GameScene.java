package com.github.jonizei.mygameengine;

public class GameScene {

    private int width;
    private int height;

    public GameScene(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int width) {
        if(width > 0) {
            this.width = width;
        }
    }

    public void setHeight(int height) {
        if(height > 0) {
            this.height = height;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}