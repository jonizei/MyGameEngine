package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.Component;
import com.github.jonizei.mygameengine.gameobject.Position;
import com.github.jonizei.mygameengine.input.Input;

public class MyComponent extends Component {

    boolean fileCreated = false;

    @Override
    public void start() {

    }

    @Override
    public void update() {

        if(!fileCreated) {
            GameEngine.getResources().createSaveFile(GameEngine.getSceneList());
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
