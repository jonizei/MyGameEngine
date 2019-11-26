package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gameobject.*;
import com.github.jonizei.mygameengine.graphics.Graphics;
import com.github.jonizei.mygameengine.graphics.Renderable;
import javafx.scene.paint.Color;

public class MyComponent extends Component {

    private long startTime;
    private boolean calculated = false;
    private boolean started = false;

    @Override
    public void start() {

    }

    @Override
    public void update() {

        Position movement = Position.translate(transform.getPosition(), new Position(6, 4), 1);
        transform.setPosition(movement);

        /*
                if(!started) {
            startTime = System.currentTimeMillis();
            started = true;
        }

        Scale newSize = Scale.scaleTo(transform.getScale(), new Scale(2, 2), 1000);
        //transform.setScale(newSize);

        if(transform.getScale().equals(new Scale(2, 2)) && !calculated) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println(elapsedTime);
            calculated = true;
        }


        Rotation rotation = Rotation.rotateTo(transform.getRotation(), new Rotation(-45), 1);
        transform.setRotation(rotation);
         */

    }

}
