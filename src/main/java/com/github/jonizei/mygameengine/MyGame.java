package com.github.jonizei.mygameengine;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameEngineAdapter {

    @Override
    public GameScene create() {
        GameScene myScene = new GameScene("MyScene", 600, 400);
        GameObject gameObject = new GameObject();
        gameObject.addComponent(new Component() {
            @Override
            public void start() {
                System.out.println("GameObject initialized");
            }

            @Override
            public void update() {
                System.out.println("Updating gameObject");
            }
        });

        myScene.addGameObject(gameObject);
        return myScene;
    }

}
