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

    private String texturePath = "textures/";
    private String savePath = "saves/";
    private String scorePath = "scores/";

    private List<ScoreBoard> scoreBoards;

    public Resources() {
        createDirectories();
        scoreBoards = new ArrayList<>();
    }

    private void createDirectories() {

        File resourceDir = new File(GameEngine.getFilePath());
        File textureDir = new File(GameEngine.getFilePath() + texturePath);
        File saveDir = new File(GameEngine.getFilePath() + savePath);
        File scoreDir = new File(GameEngine.getFilePath() + scorePath);

        if(!resourceDir.exists()) {
            resourceDir.mkdir();
        }
        if(!textureDir.exists()) {
            textureDir.mkdir();
        }
        if(!saveDir.exists()) {
            saveDir.mkdir();
        }
        if(!scoreDir.exists()) {
            scoreDir.mkdir();
        }

    }

    public void createSaveFile(List<GameScene> sceneList, String filename) {

        List<Saveable> saveableList = sceneList.stream().filter(gameScene -> gameScene instanceof Saveable).map(gameScene -> (Saveable) gameScene).collect(Collectors.toList());

        JSONObject rootJson = new JSONObject();
        JSONArray array = new JSONArray();
        saveableList.stream().forEach(saveable -> array.put(saveable.toJson()));
        rootJson.put("scenes", array);

        writeToJsonFile(GameEngine.getFilePath() + savePath + filename + ".json", rootJson);

    }

    public List<GameScene> loadSaveFile(String filename) {

        JSONObject json = new JSONObject(readFileContents(GameEngine.getFilePath() + savePath + filename + ".json"));
        JSONArray array = json.getJSONArray("scenes");
        List<GameScene> sceneList = IntStream.range(0, array.length()).mapToObj(array::getJSONObject).map(new GameScene()::toObject).collect(Collectors.toList());

        return sceneList;
    }

    public void createScoreFile(ScoreBoard scoreBoard, String filename) {
        writeToJsonFile(GameEngine.getFilePath() + scorePath + filename + ".json", scoreBoard.toJson());
    }

    public ScoreBoard loadScoreFile(String filename) {

        JSONObject json = new JSONObject(readFileContents(GameEngine.getFilePath() + scorePath + filename + ".json"));
        ScoreBoard scoreBoard = new ScoreBoard("").toObject(json);

        return scoreBoard;
    }

    public ScoreBoard createScoreBoard(String name) {
        ScoreBoard scoreBoard = new ScoreBoard(name);
        scoreBoards.add(scoreBoard);
        return scoreBoard;
    }

    public ScoreBoard getScoreBoard(String name) {
        return scoreBoards.stream().filter(scoreBoard -> scoreBoard.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    private String readFileContents(String filePath) {

        String content = "";

        try(FileReader reader = new FileReader(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                content += line;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return content;
    }

    private void writeToJsonFile(String filePath, JSONObject root) {

        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(root.toString(4));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
