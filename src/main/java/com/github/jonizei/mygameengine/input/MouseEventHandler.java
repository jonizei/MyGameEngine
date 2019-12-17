package com.github.jonizei.mygameengine.input;

import com.github.jonizei.mygameengine.gameobject.Position;
import com.github.jonizei.mygameengine.utils.MetricConverter;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to listen all mouse events
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class MouseEventHandler implements EventHandler<MouseEvent> {

    /**
     * Last clicked mouse button
     */
    private MouseKey mouseKey;

    /**
     * Boolean value which tells if clicked mouse button is released
     */
    private boolean isKeyReleased = true;

    /**
     * Time in milliseconds after the clicked mouse button will be released
     */
    private long clickSleepTime = 20;

    /**
     * Overrided method from EventHandler
     * Checks if MouseEvent has been executed
     *
     * @param event MouseEvent object
     */
    @Override
    public void handle(MouseEvent event) {

        if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            mousePressed(event);
        }
        else if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
            mouseReleased(event);
        }
        else if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            mouseClicked(event);
        }
        else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            mouseDragged(event);
        }
        else if(event.getEventType() == MouseEvent.MOUSE_MOVED) {
            mouseMoved(event);
        }

    }

    /**
     * If mouse button has been pressed it checks if InputSettings has the key in its MouseKey list
     * If the key exists it sets isPressed to true in MouseKey
     *
     * @param event MouseEvent object
     */
    private void mousePressed(MouseEvent event) {
        Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setPressed(true));
    }

    /**
     * If mouse button has been released it checks if InputSettings has the key in its MouseKey list
     * If the key exists it sets isReleased to true in MouseKey
     *
     * @param event MouseEvent object
     */
    private void mouseReleased(MouseEvent event) {
        Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setReleased(true));
    }

    /**
     * If mouse button has been clicked it checks if InputSettings has the key in its MouseKey list
     * If the key exists it checks if last clicked mouse button has been released
     * If the key is released it sets isClicked to true in MouseKey and starts new Thread
     * which will sleep few milliseconds and after that it sets isClicked to false in MouseKey
     * and sets isKeyReleased to true;
     *
     * @param event MouseEvent object
     */
    private void mouseClicked(MouseEvent event) {
        if(isKeyReleased) {
            mouseKey = Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).collect(Collectors.toList()).get(0);
            mouseKey.setClicked(true);
            new Thread(this::releaseClicked).start();
        }
    }

    /**
     * If mouse button has been dragged it checks if InputSettings has the key in its MouseKey list
     * If the key exists it sets isDragged to true in MouseKey
     *
     * @param event MouseEvent object
     */
    private void mouseDragged(MouseEvent event) {
        Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setDragged(true));
    }

    /**
     * If mouse has been moved it calls Input.setMousePosition()
     * and set new Position value
     *
     * @param event MouseEvent
     */
    private void mouseMoved(MouseEvent event) {
        Input.setMousePosition(new Position(
                MetricConverter.toMetrics(event.getX())
                , MetricConverter.toMetrics(event.getY()))
        );
    }

    /**
     * Sleeps few milliseconds and then sets isClicked to false in MouseKey
     * and sets isKeyReleased to true
     */
    private void releaseClicked() {

        isKeyReleased = false;

        try {
            Thread.sleep(clickSleepTime);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        mouseKey.setClicked(false);

        isKeyReleased = true;
    }

}
