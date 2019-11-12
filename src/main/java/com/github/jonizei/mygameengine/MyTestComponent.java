package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

import java.util.List;

public class MyTestComponent extends Component implements Renderable {

    @Override
    public void start() {
        System.out.println("Started");
    }

    @Override
    public void update() {
        //System.out.println("Delta time: " + GameEngine.getDeltaTime());
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(position.getX(), position.getY(), scale.getWidth(), scale.getHeight(), Color.RED);
    }

}
