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
        gameObject.addComponent(new BoxCollider(1.05, 1.05));
        scene.addGameObject(gameObject);

        GameObject gameObject2 = new GameObject("Test Object", 10, 10, 1, 1);
        gameObject2.addComponent(new SecondTestComponent());
        gameObject2.addComponent(new BoxCollider(1.05, 1.05));
        scene.addGameObject(gameObject2);


        List<GameScene> list = new ArrayList<>();
        list.add(scene);
        return list;
    }

}
