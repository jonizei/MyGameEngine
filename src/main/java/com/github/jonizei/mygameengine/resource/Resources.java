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

/**
 * This class holds all information where all resource files are located.
 * This class also handles all data storing.
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class Resources {

    /**
     * Path to texture directory
     */
    private String texturePath = "textures/";

    /**
     * Path to save directory
     */
    private String savePath = "saves/";

    /**
     * Path to score directory
     */
    private String scorePath = "scores/";

    /**
     * List of ScoreBoard objects
     */
    private List<ScoreBoard> scoreBoards;

    /**
     * Default Constructor of Resources
     * Initializes required directories and scoreBoard list
     */
    public Resources() {
        createDirectories();
        scoreBoards = new ArrayList<>();
    }

    /**
     * Checks if all required directories exist.
     * If directory doesn't exist it creates that directory
     */
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

    /**
     * Creates json file from all given GameScenes and filename
     * The json file represent a save file
     *
     * @param sceneList List of GameScenes that will be saved to the file
     * @param filename Name of the file
     */
    public void createSaveFile(List<GameScene> sceneList, String filename) {

        List<Saveable> saveableList = sceneList.stream().filter(gameScene -> gameScene instanceof Saveable).map(gameScene -> (Saveable) gameScene).collect(Collectors.toList());

        JSONObject rootJson = new JSONObject();
        JSONArray array = new JSONArray();
        saveableList.stream().forEach(saveable -> array.put(saveable.toJson()));
        rootJson.put("scenes", array);

        writeToJsonFile(GameEngine.getFilePath() + savePath + filename + ".json", rootJson);

    }

    /**
     * Reads content of the json file with given filename.
     * Creates list of GameScenes using file content
     *
     * @param filename Name of the file
     * @return List of GameScenes
     */
    public List<GameScene> loadSaveFile(String filename) {

        JSONObject json = new JSONObject(readFileContents(GameEngine.getFilePath() + savePath + filename + ".json"));
        JSONArray array = json.getJSONArray("scenes");
        List<GameScene> sceneList = IntStream.range(0, array.length()).mapToObj(array::getJSONObject).map(new GameScene()::toObject).collect(Collectors.toList());

        return sceneList;
    }

    /**
     * Creates json file from given ScoreBoard and filename.
     *
     * @param scoreBoard ScoreBoard to be saved
     * @param filename Name of the file
     */
    public void createScoreFile(ScoreBoard scoreBoard, String filename) {
        writeToJsonFile(GameEngine.getFilePath() + scorePath + filename + ".json", scoreBoard.toJson());
    }

    /**
     * Reads content of the json file with given filename.
     * Creates ScoreBoard object using the file content
     *
     * @param filename Name of the file
     * @return ScoreBoard object
     */
    public ScoreBoard loadScoreFile(String filename) {

        JSONObject json = new JSONObject(readFileContents(GameEngine.getFilePath() + scorePath + filename + ".json"));
        ScoreBoard scoreBoard = new ScoreBoard("").toObject(json);

        return scoreBoard;
    }

    /**
     * Creates instance of ScoreBoard using given parameters.
     * Also it adds the new ScoreBoard to List of ScoreBoards
     *
     * @param name Name of the ScoreBoard
     * @return Instance of ScoreBoard
     */
    public ScoreBoard createScoreBoard(String name) {
        ScoreBoard scoreBoard = new ScoreBoard(name);
        scoreBoards.add(scoreBoard);
        return scoreBoard;
    }

    /**
     * Returns ScoreBoard with given name
     *
     * @param name Name of the ScoreBoard
     * @return ScoreBoard with given name if found
     */
    public ScoreBoard getScoreBoard(String name) {
        return scoreBoards.stream().filter(scoreBoard -> scoreBoard.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    /**
     * Reads content of given filename
     *
     * @param filePath Path to the file
     * @return Content of the file
     */
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

    /**
     * Creates json file to given path using given JsonObject
     *
     * @param filePath Path to the file
     * @param root JsonObject holding writable information
     */
    private void writeToJsonFile(String filePath, JSONObject root) {

        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(root.toString(4));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
