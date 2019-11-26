package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.GameObject;
import com.github.jonizei.mygameengine.gamescene.GameScene;
import com.github.jonizei.mygameengine.graphics.Shape;
import com.github.jonizei.mygameengine.graphics.Texture;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public List<GameScene> create() {
        List<GameScene> sceneList = new ArrayList<>();

        GameScene gameScene = new GameScene("MyScene",24, 16);
        GameObject gameObject = new GameObject("MyObject", 10, 10, 1, 1);
        gameObject.addComponent(new MyComponent());
        gameObject.addComponent(new Texture("MyTexture", Shape.OVAL, Color.RED));
        gameScene.addGameObject(gameObject);

        sceneList.add(gameScene);
        return sceneList;
    }

}
