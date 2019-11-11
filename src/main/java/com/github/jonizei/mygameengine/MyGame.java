package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public GameScene create() {
        GameScene myScene = new GameScene("MyScene", 24, 16);
        GameObject gameObject = new GameObject();
        gameObject.addComponent(new GraphicComponent() {
            @Override
            public void start() {
                System.out.println("GameObject initialized");
            }

            @Override
            public void update() {
                System.out.println("Updating gameObject");
            }

            @Override
            public void render(Graphics graphics) {
                graphics.drawRect(0.5,  0.5, 1, 1, Color.RED);
            }
        });

        myScene.addGameObject(gameObject);
        return myScene;
    }

}
