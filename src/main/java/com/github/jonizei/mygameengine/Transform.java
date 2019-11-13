package com.github.jonizei.mygameengine;

public class Transform {

    private Position position;
    private Scale scale;

    public Transform() {
        setScale(new Scale(0, 0));
        setPosition(new Position(0, 0));
    }

    public Transform(Position position, Scale scale) {
        setScale(scale);
        setPosition(position);
        setPositionOffsets();
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

    private void setPositionOffsets() {
        if(scale.getWidth() > 0) {
            this.position.setXOffset(scale.getWidth()/2);
        }
        if(scale.getHeight() > 0) {
            this.position.setYOffset(scale.getHeight()/2);
        }
    }

}
