package com.github.jonizei.mygameengine;

/**
 * This class represents feature of a GameObject
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public abstract class Component {

    /**
     * Parent GameObject of the component
     */
    protected GameObject gameObject;

    /**
     * Transform of the parent GameObject
     */
    protected Transform transform;

    /**
     * Boolean value which tells if component can be executed or not
     */
    private boolean isEnabled = true;

    public abstract void start();
    public abstract void update();

    /**
     * Sets parent GameObject of the component
     * Sets also Transform of the parent GameObject
     *
     * @param gameObject Parent GameObject
     */
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        this.transform = gameObject.getTransform();
    }

    /**
     * Returns the parent GameObject
     *
     * @return Parent GameObject
     */
    public GameObject getGameObject() {
        return this.gameObject;
    }

    /**
     * Returns component which is an instance of given class
     *
     * @param c class which instance needs to be found
     * @param <T> type of the class
     * @return Component which is instance of given class
     */
    public <T extends Component> Component getComponent(Class<T> c) {
        return gameObject.getComponent(c);
    }

    /**
     * Tells if component can be executed or not
     *
     * @return boolean value which tells if component can be executed or not
     */
    public boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Enables or disables the component
     *
     * @param value boolean value which determines if component is enabled or disabled
     */
    public void setEnabled(boolean value) {
        this.isEnabled = value;
    }


}
