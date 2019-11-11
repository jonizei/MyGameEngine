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
    private Graphics graphics;
    private boolean isRunning = false;

    public GameRenderer() {
        instance = this;
        isRunning = true;
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

    @Override
    public void stop() {
        isRunning = false;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void initStage() {

        Group root = new Group();
        Scene scene = new Scene(root, MetricConverter.toPixels(gameScene.getWidth()), MetricConverter.toPixels(gameScene.getHeight()));

        canvas = new Canvas(MetricConverter.toPixels(gameScene.getWidth()), MetricConverter.toPixels(gameScene.getHeight()));
        graphics = new Graphics(canvas.getGraphicsContext2D());

        root.getChildren().add(canvas);

        stage.setScene(scene);
        stage.show();
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

}