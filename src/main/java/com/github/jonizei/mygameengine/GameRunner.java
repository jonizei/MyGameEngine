package com.github.jonizei.mygameengine;

import javafx.application.Platform;
import java.util.List;
import java.util.stream.Collectors;

public class GameRunner implements Runnable {

    // 60 FRAMES PER SECOND
    private static final long FRAME_SPEED_MILLIS = 16;
    private static final int FRAME_SPEED_NANOS = 6;

    private long lastTime;

    public GameRunner() {

    }

    @Override
    public void run() {

        start();

        while(GameEngine.getRenderer().isRunning()) {
            update();
            Platform.runLater(this::render);

            GameEngine.setDeltaTime(countDeltaTime());

            try {
                Thread.sleep(FRAME_SPEED_MILLIS,FRAME_SPEED_NANOS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void start() {
        GameEngine.getScene().getGameObjects().forEach(gameObject -> gameObject.getComponents().stream().filter(Component::isEnabled).forEach(Component::start));
    }

    public void update() {
        GameEngine.getScene().getGameObjects().forEach(gameObject -> gameObject.getComponents().stream().filter(Component::isEnabled).forEach(Component::update));
    }

    public void render() {

        GameEngine.getRenderer().getGraphics().clearRect(0, 0, GameEngine.getScene().getWidth(), GameEngine.getScene().getHeight());

        GameEngine.getScene().getGameObjects().stream().forEach(gameObject -> {
            List<Renderable> components = (List) gameObject.getComponents().stream().filter(component -> component instanceof Renderable).collect(Collectors.toList());
            components.forEach(item -> item.render(GameEngine.getRenderer().getGraphics()));
        });
    }

    private double countDeltaTime() {
        long deltaTimeMillis = System.currentTimeMillis() - lastTime;
        return deltaTimeMillis / 1000;
    }

}
