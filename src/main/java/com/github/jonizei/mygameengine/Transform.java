package com.github.jonizei.mygameengine;

public class Transform {

    private Position position;
    private Scale scale;

    public Transform() {
        setPosition(new Position(0, 0));
        setScale(new Scale(0, 0));
    }

    public Transform(Position position, Scale scale) {
        setPosition(position);
        setScale(scale);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Position getPosition() {
        return this.position;
    }

    public Scale getScale() {
        return this.scale;
    }

}
