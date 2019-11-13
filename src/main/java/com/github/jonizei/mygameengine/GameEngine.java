package com.github.jonizei.mygameengine;

import javafx.application.Platform;

import java.util.List;
import java.util.stream.Collectors;

public class GameEngine {

    private static List<GameScene> sceneList;

    private static GameScene scene;
    private static GameRunner runner;
    private static GameRenderer renderer;
    private static double deltaTime;

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

    public static double getDeltaTime() {
        return deltaTime;
    }

    public static void setDeltaTime(double time) {
        deltaTime = time;
    }

    public static void setSceneList(List<GameScene> scenes) {
        sceneList = scenes;
        setScene(sceneList.get(0));
    }

    public static List<GameScene> getSceneList() {
        return sceneList;
    }

    public static GameScene getSceneByName(String name) {
        return (GameScene) sceneList.stream().filter(s -> s.getName().equals(name)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

}
