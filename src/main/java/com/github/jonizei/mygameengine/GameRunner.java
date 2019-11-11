package com.github.jonizei.mygameengine;

public class GameRunner implements Runnable {

    private boolean isRunning = false;
    private GameScene scene;
    private GameRenderer renderer;

    public GameRunner(GameRenderer renderer, GameScene scene) {
        this.renderer = renderer;
        this.scene = scene;
        isRunning = true;
    }

    @Override
    public void run() {

        start();

        while(isRunning) {
            update();
        }

    }

    public void start() {
        scene.getGameObjects().forEach(gameObject -> gameObject.getComponents().forEach(component -> component.start()));
    }

    public void update() {
        scene.getGameObjects().forEach(gameObject -> gameObject.getComponents().forEach(component -> component.update()));
    }

}
