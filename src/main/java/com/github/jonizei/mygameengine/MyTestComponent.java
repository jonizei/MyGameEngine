package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

public class MyTestComponent extends Component implements Renderable {

    private BoxCollider collider;

    @Override
    public void start() {
        System.out.println("Started");
        collider = (BoxCollider) getComponent(BoxCollider.class);
    }

    @Override
    public void update() {

        Position movement = Position.translate(transform.getPosition(), new Position(10, 10), 1);

        if(!collider.collides()) {
            transform.setPosition(movement);
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getWidth(), transform.getScale().getHeight(), Color.RED);
        graphics.drawRect(transform.getPosition().getOriginX(), transform.getPosition().getOriginY(), 0.1, 0.1, Color.BLACK);
    }

}
