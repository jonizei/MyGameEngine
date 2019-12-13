package com.github.jonizei.mygameengine.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputEventHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {

        if(event.getEventType() == KeyEvent.KEY_PRESSED) {
            Input.getInputSettings().getInputKeyList().stream().filter(inputKey -> inputKey.getKeyCode() == event.getCode()).forEach(inputKey -> inputKey.setPressed(true));
        }
        else if(event.getEventType() == KeyEvent.KEY_RELEASED) {
            Input.getInputSettings().getInputKeyList().stream().filter(inputKey -> inputKey.getKeyCode() == event.getCode()).forEach(inputKey -> inputKey.setReleased(true));
        }

        /* IMPLEMENT TYPING LATER
        if(event.getEventType() == KeyEvent.KEY_TYPED) {
            System.out.println(event.getCode());
            Input.getInputSettings().getInputKeyList().stream().filter(inputKey -> inputKey.getKeyCode() == event.getCode()).forEach(inputKey -> inputKey.setTyped(true));
        }
         */

    }

}
