package com.github.jonizei.mygameengine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public abstract class GameEngine extends Application {

    private Canvas canvas;
    private Stage stage;
    private GameScene gameScene;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        gameScene = new GameScene(600, 400);
        initStage();
    }

    private void initStage() {

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