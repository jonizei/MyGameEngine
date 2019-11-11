package com.github.jonizei.mygameengine;

import javafx.application.Application;
import javafx.application.Platform;

public class GameLauncher {

    public GameLauncher(GameAdapter adapter) {

        GameScene mainScene = adapter.create();
        GameRenderer renderer = GameRenderer.getInstance();
        renderer.setGameScene(mainScene);
        Platform.runLater(renderer::initStage);
        new Thread(new GameRunner(renderer, mainScene)).start();

    }
}
