package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.Component;
import com.github.jonizei.mygameengine.graphics.Renderable;
import javafx.application.Platform;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class handles the execution of all the components
 */
public class GameRunner implements Runnable {

    /**
     * The time that thread sleeps every loop in milliseconds
     */
    private static final long FRAME_SPEED_MILLIS = 16;


    /**
     * The time that thread sleeps every loop in nanoseconds
     */
    private static final int FRAME_SPEED_NANOS = 6;

    /**
     * Holds the time when last loop was executed
     */
    private long lastTime;

    /**
     * Method required by Runnable interface
     *
     * Handles the execution of all components
     *
     */
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

    /**
     * Calls start method from every component if its enabled
     */
    public void start() {
        GameEngine.getScene().getGameObjects().forEach(gameObject -> gameObject.getComponents().stream().filter(component -> component != null).filter(Component::isEnabled).forEach(Component::start));
    }

    /**
     * Calls update method from every component if its enabled
     */
    public void update() {
        GameEngine.getScene().getGameObjects().forEach(gameObject -> gameObject.getComponents().stream().filter(component -> component != null).filter(Component::isEnabled).forEach(Component::update));
    }

    /**
     * Clears the window and then calls render method from every component that implements Renderable interface
     */
    public void render() {

        GameEngine.getRenderer().getGraphics().clearRect(0, 0, GameEngine.getScene().getWidth(), GameEngine.getScene().getHeight());

        GameEngine.getScene().getGameObjects().stream().forEach(gameObject -> {
            List<Renderable> components = (List) gameObject.getComponents().stream().filter(component -> component != null).filter(component -> component instanceof Renderable).collect(Collectors.toList());
            components.forEach(item -> item.render(GameEngine.getRenderer().getGraphics()));
        });
    }

    /**
     * Counts elapsed time between each loop and returns it as seconds
     *
     * @return Elapsed time as seconds
     */
    private float countDeltaTime() {
        long deltaTimeMillis = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        return (deltaTimeMillis / 1000F) % 60;
    }

}
