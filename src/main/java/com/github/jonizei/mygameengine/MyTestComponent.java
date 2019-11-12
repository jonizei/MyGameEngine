package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

public class MyTestComponent extends Component implements Renderable {

    @Override
    public void start() {
        System.out.println("Started");
    }

    @Override
    public void update() {
        System.out.println("Updating");
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(position.getX(), position.getY(), scale.getWidth(), scale.getHeight(), Color.RED);
    }

}
