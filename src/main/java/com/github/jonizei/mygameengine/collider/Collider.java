package com.github.jonizei.mygameengine.collider;

import com.github.jonizei.mygameengine.Component;
import com.github.jonizei.mygameengine.GameEngine;
import com.github.jonizei.mygameengine.GameObject;
import com.github.jonizei.mygameengine.Position;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is a base of every collider.
 * This class contains all necessary methods for every collider.
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public abstract class Collider extends Component {

    /**
     * Boolean value which tells if the collider collides or not
     */
    private boolean doesCollide = false;

    /**
     * List of colliders which collides with this collider
     */
    private List<Collider> colliders;

    public abstract boolean overlaps(Position position);
    public abstract boolean isCollision(Collider collider);

    /**
     * Returns a boolean value which tells if the collides collides or not
     *
     * @return
     */
    public boolean collides() {
        return doesCollide;
    }

    /**
     * Checks if the collider collides with other colliders
     */
    public void checkCollisions() {
        List<GameObject> gameObjects = GameEngine.getScene().getGameObjectsByComponent(Collider.class);
        colliders = gameObjects.stream()
                .map(gameObject -> (Collider) gameObject.getComponent(Collider.class))
                .filter(collider -> collider.isCollision(this))
                .collect(Collectors.toList());

        doesCollide = colliders.size() > 0;
    }

    /**
     * Returns list of colliders which collides with this collider
     *
     * @return List of colliders
     */
    public List<Collider> getColliders() {
        return colliders;
    }

}
