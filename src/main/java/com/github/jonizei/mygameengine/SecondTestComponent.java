package com.github.jonizei.mygameengine;

import javafx.scene.paint.Color;

public class SecondTestComponent extends Component implements Renderable {

    private BoxCollider collider;

    @Override
    public void start() {
        collider = (BoxCollider) getComponent(BoxCollider.class);
    }

    @Override
    public void update() {

        if(collider.collides()) {
            System.out.println("Second collides");
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getWidth(), transform.getScale().getHeight(), Color.BLUE);
    }

}
