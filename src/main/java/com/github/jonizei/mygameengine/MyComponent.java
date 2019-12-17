package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.Component;
import com.github.jonizei.mygameengine.gameobject.Position;
import com.github.jonizei.mygameengine.input.Input;
import com.github.jonizei.mygameengine.resource.ScoreBoard;
import org.json.JSONObject;

public class MyComponent extends Component {

    boolean fileCreated = false;

    @Override
    public void start() {

    }

    @Override
    public void update() {

        if(!fileCreated) {
            GameEngine.getResources().createSaveFile(GameEngine.getSceneList(), "save1");
            ScoreBoard board = GameEngine.getResources().createScoreBoard("MyScoreboard");
            board.addScore("Tiina", 10);
            board.addScore("Jack", 3);
            board.addScore("Dean", 6);
            GameEngine.getResources().createScoreFile(board, "scoreboard1");
            fileCreated = true;
        }

        Position mousePosition = Input.getMousePosition();
        //System.out.println(mousePosition);

        if(Input.getKey("S").isPressed()) {
            transform.getPosition().setY(transform.getPosition().getY()+0.05);
        }
        else if(Input.getKey("W").isPressed()) {
            transform.getPosition().setY(transform.getPosition().getY()-0.05);
        }

        if(Input.getKey("A").isPressed()) {
            transform.getPosition().setX(transform.getPosition().getX()-0.05);
        }
        else if(Input.getKey("D").isPressed()) {
            transform.getPosition().setX(transform.getPosition().getX()+0.05);
        }

    }

}
