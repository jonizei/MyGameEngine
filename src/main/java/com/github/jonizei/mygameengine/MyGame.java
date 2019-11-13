package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public List<GameScene> create() {
        GameScene scene = new GameScene("My Scene", 24, 16);
        GameObject gameObject = new GameObject("My Object", 1, 1, 1, 1);
        MyTestComponent component = new MyTestComponent();
        gameObject.addComponent(component);
        scene.addGameObject(gameObject);

        List<GameScene> list = new ArrayList<>();
        list.add(scene);
        return list;
    }

}
