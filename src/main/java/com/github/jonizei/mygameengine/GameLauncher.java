package com.github.jonizei.mygameengine;

import javafx.application.Application;
import javafx.application.Platform;

public class GameLauncher {

    public GameLauncher(GameAdapter adapter) {

        GameEngine.setRenderer(GameRenderer.getInstance());
        GameEngine.setSceneList(adapter.create());
        GameEngine.setRunner(new GameRunner());
        new Thread(GameEngine.getRunner()).start();

    }
}
