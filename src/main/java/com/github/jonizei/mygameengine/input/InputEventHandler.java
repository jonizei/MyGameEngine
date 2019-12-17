package com.github.jonizei.mygameengine.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to listen key inputs and inform if some event has been executed
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class InputEventHandler implements EventHandler<KeyEvent> {

    /**
     * Overrided method from EventHandler class.
     * Checks if some event has been executed
     *
     * @param event KeyEvent object
     */
    @Override
    public void handle(KeyEvent event) {

        if(event.getEventType() == KeyEvent.KEY_PRESSED) {
            keyPressed(event);
        }
        else if(event.getEventType() == KeyEvent.KEY_RELEASED) {
            keyReleased(event);
        }

    }

    /**
     * If some key has been pressed it check if InputSettings has the key in its InputKey list.
     * If the key exist it set isPressed value to true to that InputKey instance
     *
     * @param event KeyEvent object
     */
    private void keyPressed(KeyEvent event) {
        Input.getInputSettings().getInputKeyList().stream().filter(inputKey -> inputKey.getKeyCode() == event.getCode()).forEach(inputKey -> inputKey.setPressed(true));
    }

    /**
     * If some key has been released it check if InputSettings has the key in its InputKey list.
     * If the key exist it set isReleased value to true to that InputKey instance
     *
     * @param event KeyEvent object
     */
    private void keyReleased(KeyEvent event) {
        Input.getInputSettings().getInputKeyList().stream().filter(inputKey -> inputKey.getKeyCode() == event.getCode()).forEach(inputKey -> inputKey.setReleased(true));
    }

}
