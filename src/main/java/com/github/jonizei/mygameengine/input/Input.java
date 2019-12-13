package com.github.jonizei.mygameengine.input;

import java.util.stream.Collectors;

public class Input {

    private static InputSettings settings;

    public static void setInputSettings(InputSettings inputSettings) {
        settings = inputSettings;
    }

    public static InputSettings getInputSettings() {
        return settings;
    }

    public static InputKey getKey(String key) {
        return settings.getInputKeyList().stream().filter(inputKey -> inputKey.getKeyName().equals(key)).collect(Collectors.toList()).get(0);
    }

    public static InputKey getMouseKey(String key) {
        return settings.getMouseKeyList().stream().filter(mouseKey -> mouseKey.getKeyName().equals(key)).collect(Collectors.toList()).get(0);
    }

}
