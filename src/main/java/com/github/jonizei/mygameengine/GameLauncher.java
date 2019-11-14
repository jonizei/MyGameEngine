package com.github.jonizei.mygameengine;

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
     * and then starts the GameRenderer in a new thread
     *
     * @param adapter Class which implements GameAdapter interface
     */
    public GameLauncher(GameAdapter adapter) {

        GameEngine.setRenderer(GameRenderer.getInstance());
        GameEngine.setSceneList(adapter.create());
        GameEngine.setRunner(new GameRunner());
        new Thread(GameEngine.getRunner()).start();

    }
}
