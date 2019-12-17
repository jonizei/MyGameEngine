package com.github.jonizei.mygameengine.input;

import com.github.jonizei.mygameengine.gameobject.Position;

import java.util.stream.Collectors;

/**
 * This class is used to get input information.
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class Input {

    /**
     * Instance of InputSettings class
     */
    private static InputSettings settings;

    /**
     * Holds mouse pointer position
     */
    private static Position mousePosition = new Position(0, 0);

    /**
     * Set value for InputSettings
     *
     * @param inputSettings Value of InputSettings
     */
    public static void setInputSettings(InputSettings inputSettings) {
        settings = inputSettings;
    }

    /**
     * Returns InputSettings instance
     *
     * @return Instance of InputSettings
     */
    public static InputSettings getInputSettings() {
        return settings;
    }

    /**
     * Return instance of InputKey with given key name
     *
     * @param key Name of the key
     * @return Instance of InputKey with given key name
     */
    public static InputKey getKey(String key) {
        return settings.getInputKeyList().stream().filter(inputKey -> inputKey.getKeyName().equals(key)).collect(Collectors.toList()).get(0);
    }

    /**
     * Returns instance of MouseKey with given key name
     *
     * @param key Name of the key
     * @return Instance of MouseKey with given key name
     */
    public static MouseKey getMouseKey(String key) {
        return settings.getMouseKeyList().stream().filter(mouseKey -> mouseKey.getKeyName().equals(key)).collect(Collectors.toList()).get(0);
    }

    /**
     * Set value for mouse position
     *
     * @param position Value of mouse position
     */
    public static void setMousePosition(Position position) {
        mousePosition = position;
    }

    /**
     * Returns mouse position
     *
     * @return Position object which holds mouse position
     */
    public static Position getMousePosition() {
        return mousePosition;
    }

}
