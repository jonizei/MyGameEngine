package com.github.jonizei.mygameengine;

import javafx.application.Platform;

public class GameEngine {

    private static GameScene scene;
    private static GameRunner runner;
    private static GameRenderer renderer;

    public static void setScene(GameScene s) {
        scene = s;
        Platform.runLater(renderer::initStage);
    }

    public static void setRunner(GameRunner r) {
        runner = r;
    }

    public static void setRenderer(GameRenderer r) {
        renderer = r;
    }

    public static GameScene getScene() {
        return scene;
    }

    public static GameRunner getRunner() {
        return runner;
    }

    public static GameRenderer getRenderer() {
        return renderer;
    }

}
