package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.input.Input;

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
        GameEngine.setSceneList(adapter.create());
        GameEngine.setRunner(new GameRunner());
        GameEngine.setFilePath(System.getProperty("user.dir") + "/resources/");

        Input.setInputSettings(adapter.settings());

        new Thread(GameEngine.getRunner()).start();

    }
}
