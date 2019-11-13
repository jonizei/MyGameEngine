package com.github.jonizei.mygameengine;

import java.util.List;
import java.util.stream.Collectors;

public class BoxCollider extends Collider {

    private Scale scale;

    private Position topLeft;
    private Position bottomLeft;
    private Position topRight;
    private Position bottomRight;

    public BoxCollider(double width, double height) {
        this.scale = new Scale(width, height);
        topLeft = new Position();
        bottomLeft = new Position();
        topRight = new Position();
        bottomRight = new Position();
    }

    @Override
    public void start() {
        calculateCorners();
    }

    @Override
    public void update() {
        calculateCorners();
        List<GameObject> gameObjects = GameEngine.getScene().getGameObjectsByComponent(Collider.class);
        int collisions = gameObjects.stream()
                .map(gameObject -> (Collider) gameObject.getComponent(Collider.class))
                .filter(collider -> collider.isCollision(this))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size()));

        doesCollide = collisions > 0;
    }

    private void calculateCorners() {
        topLeft.setX(transform.getPosition().getOriginX() - scale.getWidth() / 2);
        topLeft.setY(transform.getPosition().getOriginY() - scale.getHeight() / 2);

        bottomLeft.setX(transform.getPosition().getOriginX() - scale.getWidth() / 2);
        bottomLeft.setY(transform.getPosition().getOriginY() + scale.getHeight() / 2);

        topRight.setX(transform.getPosition().getOriginX() + scale.getWidth() / 2);
        topRight.setY(transform.getPosition().getOriginY() - scale.getHeight() / 2);

        bottomRight.setX(transform.getPosition().getOriginX() + scale.getWidth() / 2);
        bottomRight.setY(transform.getPosition().getOriginY() + scale.getHeight() / 2);
    }

    @Override
    public boolean overlaps(Position position) {

        if(position.getX() > topLeft.getX() && position.getX() < topRight.getX()) {
            if(position.getY() > topLeft.getY() && position.getY() < bottomLeft.getY()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isCollision(Collider collider) {

        if(collider.overlaps(topLeft) || collider.overlaps(bottomLeft) || collider.overlaps(topRight) || collider.overlaps(bottomRight)) {
            return true;
        }

        return false;
    }

}
