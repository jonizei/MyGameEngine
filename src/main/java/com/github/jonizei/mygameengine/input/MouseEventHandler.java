package com.github.jonizei.mygameengine.input;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {

        if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setPressed(true));
        }
        else if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
            Input.getInputSettings().getMouseKeyList().stream().filter(mouseKey -> mouseKey.getMouseButton() == event.getButton()).forEach(mouseKey -> mouseKey.setReleased(true));
        }

    }
}
