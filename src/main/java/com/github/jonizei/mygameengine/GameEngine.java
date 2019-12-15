package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gamescene.GameScene;
import com.github.jonizei.mygameengine.resource.Resources;
import javafx.application.Platform;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains all required objects that are needed to run the game.
 * This class eases a communication between the objects
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class GameEngine {

    /**
     * List of all GameScenes of the game
     */
    private static List<GameScene> sceneList;

    /**
     * Currently active GameScene
     */
    private static GameScene scene;

    /**
     * GameRunner object which handles component execution
     */
    private static GameRunner runner;

    /**
     * GameRenderer objects which handles gameObject rendering
     */
    private static GameRenderer renderer;

    /**
     * Elapsed time between each frame
     */
    private static float deltaTime;

    /**
     * Path to the resources directory
     */
    private static String filePath;

    private static Resources resources;

    /**
     * Sets the active GameScene
     *
     * @param s GameScene object
     */
    public static void setScene(GameScene s) {
        scene = s;
        Platform.runLater(renderer::initStage);
    }

    /**
     * Sets the GameRunner
     *
     * @param r GameRunner object
     */
    public static void setRunner(GameRunner r) {
        runner = r;
    }

    /**
     * Sets the GameRenderer
     *
     * @param r GameRenderer object
     */
    public static void setRenderer(GameRenderer r) {
        renderer = r;
    }

    /**
     * Sets path to the resources directory
     *
     * @param f path to resources directory
     */
    public static void setFilePath(String f) {
        filePath = f;
    }

    /**
     * Returns path to resources directory
     *
     * @return path to resources directory
     */
    public static String getFilePath() {
        return filePath;
    }

    public static void setResources(Resources r) {
        resources = r;
    }

    public static Resources getResources() {
        return resources;
    }

    /**
     * Returns the currently active GameScene
     *
     * @return currently active GameScene
     */
    public static GameScene getScene() {
        return scene;
    }

    /**
     * Returns GameRunner object
     *
     * @return GameRunner object
     */
    public static GameRunner getRunner() {
        return runner;
    }

    /**
     * Returns GameRenderer object
     *
     * @return GameRenderer object
     */
    public static GameRenderer getRenderer() {
        return renderer;
    }

    /**
     * Return elapsed time from last frame
     *
     * @return elapsed time
     */
    public static float getDeltaTime() {
        return deltaTime;
    }

    /**
     * Sets elapsed time from last frame
     *
     * @param time elapsed time in seconds
     */
    public static void setDeltaTime(float time) {
        deltaTime = time;
    }

    /**
     * Sets list of all GameScenes
     *
     * @param scenes List of GameScenes
     */
    public static void setSceneList(List<GameScene> scenes) {
        sceneList = scenes;
        setScene(sceneList.get(0));
    }

    /**
     * Returns list of all GameScenes
     *
     * @return List of GameScenes
     */
    public static List<GameScene> getSceneList() {
        return sceneList;
    }

    /**
     * Returns GameScene with given name
     *
     * @param name Name of the GameScene
     * @return GameScene object
     */
    public static GameScene getSceneByName(String name) {
        return (GameScene) sceneList.stream().filter(s -> s.getName().equals(name)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

}
