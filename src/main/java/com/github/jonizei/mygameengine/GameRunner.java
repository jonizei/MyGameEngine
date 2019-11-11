package com.github.jonizei.mygameengine;

import javafx.application.Platform;
import java.util.List;
import java.util.stream.Collectors;

public class GameRunner implements Runnable {

    // 60 FRAMES PER SECOND
    private static final long FRAME_SPEED_MILLIS = 16;
    private static final int FRAME_SPEED_NANOS = 6;

    public GameRunner() {

    }

    @Override
    public void run() {

        start();

        while(GameEngine.getRenderer().isRunning()) {
            update();
            Platform.runLater(this::render);

            try {
                Thread.sleep(FRAME_SPEED_MILLIS,FRAME_SPEED_NANOS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void start() {
        GameEngine.getScene().getGameObjects().forEach(gameObject -> gameObject.getComponents().forEach(Component::start));
    }

    public void update() {
        GameEngine.getScene().getGameObjects().forEach(gameObject -> gameObject.getComponents().forEach(Component::update));
    }

    public void render() {
        GameEngine.getScene().getGameObjects().stream().forEach(gameObject -> {
            List<GraphicComponent> graphicComponents = (List) gameObject.getComponents().stream().filter(component -> component instanceof GraphicComponent).collect(Collectors.toList());
            graphicComponents.forEach(item -> item.render(GameEngine.getRenderer().getGraphics()));
        });
    }

}
