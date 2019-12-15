package com.github.jonizei.mygameengine.resource;

import com.github.jonizei.mygameengine.GameEngine;
import com.github.jonizei.mygameengine.gamescene.GameScene;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Resources {

    public Resources() {
        createDirectories();
    }

    public void createDirectories() {

        File resourceDir = new File(GameEngine.getFilePath());
        File textureDir = new File(GameEngine.getFilePath() + "textures/");
        File saveDir = new File(GameEngine.getFilePath() + "saves/");

        if(!resourceDir.exists()) {
            resourceDir.mkdir();
        }
        if(!textureDir.exists()) {
            textureDir.mkdir();
        }
        if(!saveDir.exists()) {
            saveDir.mkdir();
        }

    }

    public void createSaveFile(List<GameScene> sceneList) {

        List<Saveable> saveableList = sceneList.stream().filter(gameScene -> gameScene instanceof Saveable).map(gameScene -> (Saveable) gameScene).collect(Collectors.toList());

        JSONObject rootJson = new JSONObject();
        JSONArray array = new JSONArray();
        saveableList.stream().forEach(saveable -> array.put(saveable.saveInfo()));
        rootJson.put("scenes", array);

        try(FileWriter writer = new FileWriter(GameEngine.getFilePath() + "saves/save1.txt")) {
            writer.write(rootJson.toString(4));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
