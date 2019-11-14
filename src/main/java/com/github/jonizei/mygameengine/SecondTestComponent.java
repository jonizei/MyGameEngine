package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.collider.CircleCollider;
import com.github.jonizei.mygameengine.gameobject.Component;
import com.github.jonizei.mygameengine.graphics.Renderable;
import com.github.jonizei.mygameengine.graphics.Graphics;
import javafx.scene.paint.Color;

public class SecondTestComponent extends Component implements Renderable {

    private CircleCollider collider;

    @Override
    public void start() {
        collider = (CircleCollider) getComponent(CircleCollider.class);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getWidth(), transform.getScale().getHeight(), Color.BLUE);
    }

}
