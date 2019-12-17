package com.github.jonizei.mygameengine.resource;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreBoard implements Saveable<ScoreBoard> {

    private static int idCounter = 1;

    private int id;
    private String name;
    private List<Score> scores;

    public ScoreBoard(String name) {
        setId(idCounter++);
        setName(name);
        scores = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addScore(String name, int value) {
        scores.add(new Score(name, value));
        sortScores();
    }

    public void removeScore(int id) {
        Score tmp = scores.stream().filter(score -> score.getId() == id).collect(Collectors.toList()).get(0);
        removeScore(tmp);
    }

    public void removeScore(Score score) {
        scores.remove(score);
        sortScores();
    }

    private void sortScores() {
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o1.getValue() - o2.getValue();
            }
        });
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);

        JSONArray array = new JSONArray();
        scores.stream().forEach(score -> array.put(score.toJson()));

        json.put("scores", array);
        return json;
    }

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
