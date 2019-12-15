package com.github.jonizei.mygameengine.resource;

import com.github.jonizei.mygameengine.GameEngine;
import com.github.jonizei.mygameengine.gamescene.GameScene;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<GameScene> loadFromSaveFile() {

        List<GameScene> sceneList = new ArrayList<>();

        try(FileReader reader = new FileReader(GameEngine.getFilePath() + "saves/save1.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);

            String content = "";
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                content += line;
            }

            JSONObject json = new JSONObject(content);
            JSONArray array = json.getJSONArray("scenes");
            sceneList = IntStream.range(0, array.length()).mapToObj(array::getJSONObject).map(jsonObject -> {
                GameScene scene = new GameScene("", 0, 0);
                scene.loadInfo(jsonObject);
                return scene;
            }).collect(Collectors.toList());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sceneList;
    }

}
