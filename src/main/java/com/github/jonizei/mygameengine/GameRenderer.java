package com.github.jonizei.mygameengine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public class GameRenderer extends Application {

    private static GameRenderer instance;

    private Canvas canvas;
    private Stage stage;
    private GameScene gameScene;

    public GameRenderer() {
        instance = this;
    }

    public synchronized static GameRenderer getInstance() {

        if(instance == null) {
            new Thread(() -> Application.launch(GameRenderer.class)).start();
        }

        while(instance == null) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return instance;
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    public void initStage() {

        Group root = new Group();
        Scene scene = new Scene(root, gameScene.getWidth(), gameScene.getHeight());

        canvas = new Canvas(gameScene.getWidth(), gameScene.getHeight());

        root.getChildren().add(canvas);

        stage.setScene(scene);
        stage.show();
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

}