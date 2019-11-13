package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

public class MyTestComponent extends Component implements Renderable {

    @Override
    public void start() {
        System.out.println("Started");
    }

    @Override
    public void update() {
        transform.setPosition(Position.translate(transform.getPosition(), new Position(13, 5), 1));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getWidth(), transform.getScale().getHeight(), Color.RED);
    }

}
