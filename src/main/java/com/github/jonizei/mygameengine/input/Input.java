package com.github.jonizei.mygameengine.input;

import com.github.jonizei.mygameengine.gameobject.Position;

import java.util.stream.Collectors;

public class Input {

    private static InputSettings settings;
    private static Position mousePosition = new Position(0, 0);

    public static void setInputSettings(InputSettings inputSettings) {
        settings = inputSettings;
    }

    public static InputSettings getInputSettings() {
        return settings;
    }

    public static InputKey getKey(String key) {
        return settings.getInputKeyList().stream().filter(inputKey -> inputKey.getKeyName().equals(key)).collect(Collectors.toList()).get(0);
    }

    public static MouseKey getMouseKey(String key) {
        return settings.getMouseKeyList().stream().filter(mouseKey -> mouseKey.getKeyName().equals(key)).collect(Collectors.toList()).get(0);
    }

    public static void setMousePosition(Position position) {
        mousePosition = position;
    }

    public static Position getMousePosition() {
        return mousePosition;
    }

}
