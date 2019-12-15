package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.input.Input;
import com.github.jonizei.mygameengine.resource.Resources;

import java.io.File;

/**
 * This class is a launcher for the game
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class GameLauncher {

    /**
     * Constructor of GameLauncher
     *
     * Initializes the GameRenderer, GameRunner and List of GameScenes to GameEngine class
     * and then starts the GameRenderer in a new thread. Also initializes path to resources directory
     *
     * @param adapter Class which implements GameAdapter interface
     */
    public GameLauncher(GameAdapter adapter) {

        GameEngine.setRenderer(GameRenderer.getInstance());
        GameEngine.setRunner(new GameRunner());
        GameEngine.setFilePath(System.getProperty("user.dir") + "/resources/");
        GameEngine.setResources(new Resources());
        GameEngine.setSceneList(adapter.create());

        Input.setInputSettings(adapter.settings());

        new Thread(GameEngine.getRunner()).start();

    }
}
