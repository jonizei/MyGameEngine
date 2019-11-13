package com.github.jonizei.mygameengine;

public abstract class Component {

    protected GameObject gameObject;
    protected Transform transform;

    private boolean isEnabled = true;

    public abstract void start();
    public abstract void update();

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.transform = gameObject.getTransform();
    }

    public GameObject getGameObject() {
        return this.gameObject;
    }

    public <T extends Component> Component getComponent(Class<T> c) {
        return gameObject.getComponent(c);
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean value) {
        this.isEnabled = value;
    }


}
