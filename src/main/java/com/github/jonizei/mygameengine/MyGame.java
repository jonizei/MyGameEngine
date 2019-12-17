package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.GameObject;
import com.github.jonizei.mygameengine.gamescene.GameScene;
import com.github.jonizei.mygameengine.graphics.Shape;
import com.github.jonizei.mygameengine.graphics.Texture;
import com.github.jonizei.mygameengine.input.InputSettings;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MyGame implements GameAdapter {


    @Override
    public List<GameScene> create() {

        List<GameScene> sceneList = new ArrayList<>();
        sceneList = GameEngine.getResources().loadSaveFile("save1");

        /*
        GameScene scene = new GameScene("MyScene",12, 12);
        GameObject gameObject = new GameObject("MyGameObject", 0, 0, 1, 1);
        gameObject.addComponent(new MyComponent());
        gameObject.addComponent(new Texture("MyTexture", Shape.RECTANGLE, Color.RED));
        scene.addGameObject(gameObject);

        sceneList.add(scene);
        */


        return sceneList;
    }

    @Override
    public InputSettings settings() {

        InputSettings settings = new InputSettings();
        settings.addKey("W", KeyCode.W);
        settings.addKey("S", KeyCode.S);
        settings.addKey("A", KeyCode.A);
        settings.addKey("D", KeyCode.D);
        settings.addMouseKey("Left", MouseButton.PRIMARY);
        settings.addMouseKey("Right", MouseButton.SECONDARY);

        return settings;
    }
}
