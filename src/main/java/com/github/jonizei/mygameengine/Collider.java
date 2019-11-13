package com.github.jonizei.mygameengine;

import java.util.List;

public abstract class Collider extends Component {

    protected boolean doesCollide = false;

    public abstract boolean overlaps(Position position);
    public abstract boolean isCollision(Collider collider);

    public boolean collides() {
        return doesCollide;
    }

}
