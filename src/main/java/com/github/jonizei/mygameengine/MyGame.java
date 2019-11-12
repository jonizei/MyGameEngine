package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {

    @Override
    public GameScene create() {
        return new GameScene("My Scene", 24, 16);
    }

}
