package com.github.jonizei.mygameengine;

import javafx.application.Platform;
import java.util.List;
import java.util.stream.Collectors;

public class GameRunner implements Runnable {

    private GameScene scene;
    private GameRenderer renderer;

    public GameRunner(GameRenderer renderer, GameScene scene) {
        this.renderer = renderer;
        this.scene = scene;
    }

    @Override
    public void run() {

        start();

        while(renderer.isRunning()) {
            update();
            Platform.runLater(this::render);

            try {
                Thread.sleep(16,6);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void start() {
        scene.getGameObjects().forEach(gameObject -> gameObject.getComponents().forEach(component -> component.start()));
    }

    public void update() {
        scene.getGameObjects().forEach(gameObject -> gameObject.getComponents().forEach(component -> component.update()));
    }

    public void render() {
        scene.getGameObjects().stream().forEach(gameObject -> {
            List<GraphicComponent> graphicComponents = (List) gameObject.getComponents().stream().filter(component -> component instanceof GraphicComponent).collect(Collectors.toList());
            graphicComponents.forEach(item -> item.render(renderer.getGraphics()));
        });
    }

}
