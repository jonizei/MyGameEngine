package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public GameScene create() {
        GameScene scene = new GameScene("My Scene", 24, 16);
        GameObject gameObject = new GameObject("My Object");
        GameObject gameObject2 = new GameObject("TestObject");
        MyTestComponent component = new MyTestComponent();
        gameObject.addComponent(component);
        gameObject2.addComponent(component);
        scene.addGameObject(gameObject);
        scene.addGameObject(gameObject2);
        scene.addGameObject(gameObject2);
        scene.addGameObject(gameObject2);
        scene.addGameObject(gameObject2);
        return scene;
    }

}
