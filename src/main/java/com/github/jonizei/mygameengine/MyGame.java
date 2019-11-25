package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.GameObject;
import com.github.jonizei.mygameengine.gamescene.GameScene;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public List<GameScene> create() {
        List<GameScene> sceneList = new ArrayList<>();

        GameScene gameScene = new GameScene("MyScene",24, 16);
        GameObject gameObject = new GameObject("MyObject", 1, 1, 1, 1);
        gameObject.addComponent(new MyComponent());
        gameScene.addGameObject(gameObject);

        sceneList.add(gameScene);
        return sceneList;
    }

}
