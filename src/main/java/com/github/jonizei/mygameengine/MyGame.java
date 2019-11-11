package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public GameScene create() {
        GameScene myScene = new GameScene("MyScene", 24, 16);
        GameScene myScene2 = new GameScene("MyScene", 12, 8);
        GameObject gameObject = new GameObject();
        gameObject.addComponent(new GraphicComponent() {

            private long startTime;
            private boolean hasSet = false;

            @Override
            public void start() {
                System.out.println("GameObject initialized");
                startTime = System.currentTimeMillis();
            }

            @Override
            public void update() {
                System.out.println("Updating gameObject");

                if((System.currentTimeMillis() - startTime) > 3000 && !hasSet) {
                    GameEngine.setScene(myScene2);
                    hasSet = true;
                }

            }

            @Override
            public void render(Graphics graphics) {
                graphics.drawRect(0.5,  0.5, 1, 1, Color.RED);
            }
        });

        GameObject gameObject2 = new GameObject();
        gameObject2.addComponent(new Component() {
            @Override
            public void start() {
                System.out.println("Another scene");
            }

            @Override
            public void update() {
                System.out.println("Updating too");
            }
        });

        myScene2.addGameObject(gameObject2);
        myScene.addGameObject(gameObject);
        return myScene;
    }

}
