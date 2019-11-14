package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.collider.CircleCollider;
import com.github.jonizei.mygameengine.gameobject.GameObject;
import com.github.jonizei.mygameengine.gamescene.GameScene;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public List<GameScene> create() {
        GameScene scene = new GameScene("My Scene", 24, 16);
        GameObject gameObject = new GameObject("My Object", 1, 1, 1, 1);
        MyTestComponent component = new MyTestComponent();
        gameObject.addComponent(component);
        gameObject.addComponent(new CircleCollider(0.5));
        scene.addGameObject(gameObject);

        GameObject gameObject2 = new GameObject("Test Object", 5, 1, 1, 1);
        gameObject2.addComponent(new SecondTestComponent());
        gameObject2.addComponent(new CircleCollider(0.5));
        scene.addGameObject(gameObject2);


        List<GameScene> list = new ArrayList<>();
        list.add(scene);
        return list;
    }

}
