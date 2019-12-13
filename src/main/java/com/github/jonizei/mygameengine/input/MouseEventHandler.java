package com.github.jonizei.mygameengine.input;

import com.github.jonizei.mygameengine.gameobject.Position;
import com.github.jonizei.mygameengine.utils.MetricConverter;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.stream.Collectors;

public class MouseEventHandler implements EventHandler<MouseEvent> {

    private List<InputKey> mouseKeys;
    private boolean isKeysReleased = true;
    private long clickSleepTime = 20;

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

    private void mousePressed(MouseEvent event) {
        Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setPressed(true));
    }

    private void mouseReleased(MouseEvent event) {
        Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setReleased(true));
    }

    private void mouseClicked(MouseEvent event) {
        if(isKeysReleased) {
            mouseKeys = Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).collect(Collectors.toList());
            mouseKeys.forEach(mouseKey -> mouseKey.setClicked(true));
            new Thread(this::releaseClicked).start();
        }
    }

    private void mouseDragged(MouseEvent event) {
        Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setDragged(true));
    }

    private void mouseMoved(MouseEvent event) {
        Input.setMousePosition(new Position(
                MetricConverter.toMetrics(event.getX())
                , MetricConverter.toMetrics(event.getY()))
        );
    }

    private void releaseClicked() {

        isKeysReleased = false;

        try {
            Thread.sleep(clickSleepTime);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        mouseKeys.forEach(mouseKey -> mouseKey.setClicked(false));

        isKeysReleased = true;
    }

}
