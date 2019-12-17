package com.github.jonizei.mygameengine.resource;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents a scoreboard which holds saved scores
 *
 * @author Joni Koskinen
 * @version 2019-12-17
 */
public class ScoreBoard implements Saveable<ScoreBoard> {

    /**
     * Id value of the next ScoreBoard
     */
    private static int idCounter = 1;

    /**
     * Id of the ScoreBoard
     */
    private int id;

    /**
     * Name of the ScoreBoard
     */
    private String name;

    /**
     * List of Scores
     */
    private List<Score> scores;

    /**
     * Default Constructor of ScoreBoard
     * Initializes id, name and list of scores
     *
     * @param name Name of the ScoreBoard
     */
    public ScoreBoard(String name) {
        setId(idCounter++);
        setName(name);
        scores = new ArrayList<>();
    }

    /**
     * Sets value for the id
     *
     * @param id Value of the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns value of the id
     *
     * @return Value of the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set value for the name
     *
     * @param name Value of the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns value of the name
     *
     * @return Value of the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Creates instance of Score with given values and add it to the list of Scores.
     * Sorts the score list from highest score to the lowest score
     *
     * @param name Name of the Score
     * @param value Value of the Score
     */
    public void addScore(String name, int value) {
        scores.add(new Score(name, value));
        sortScores();
    }

    /**
     * Removes Score object from list of Scores with given id
     *
     * @param id Id of the Score
     */
    public void removeScore(int id) {
        Score tmp = scores.stream().filter(score -> score.getId() == id).collect(Collectors.toList()).get(0);
        removeScore(tmp);
    }

    /**
     * Removes given Score object
     *
     * @param score Score object to be removed
     */
    public void removeScore(Score score) {
        scores.remove(score);
        sortScores();
    }

    /**
     * Sorts list of Scores from highest value to the lowest
     */
    private void sortScores() {
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.getValue() - o1.getValue();
            }
        });
    }

    /**
     * Returns list of Scores
     *
     * @return List of Scores
     */
    public List<Score> getScores() {
        return this.scores;
    }

    /**
     * Overrided method from Saveable interface.
     * Creates json object using necessary information from this class
     *
     * @return JsonObject with necessary information
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);

        JSONArray array = new JSONArray();
        scores.stream().forEach(score -> array.put(score.toJson()));

        json.put("scores", array);
        return json;
    }

    @Override
    public ScoreBoard toObject(JSONObject json) {
        setName(json.getString("name"));

        JSONArray array = json.getJSONArray("scores");
        scores = IntStream.range(0, array.length())
                .mapToObj(array::getJSONObject)
                .map(new Score()::toObject)
                .collect(Collectors.toList());

        return this;
    }

}
