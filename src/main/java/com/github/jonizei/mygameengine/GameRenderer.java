package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.graphics.Graphics;
import com.github.jonizei.mygameengine.input.InputEventHandler;
import com.github.jonizei.mygameengine.input.MouseEventHandler;
import com.github.jonizei.mygameengine.utils.MetricConverter;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

/**
 * This class handles the rendering of the GameObjects
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class GameRenderer extends Application {

    /**
     * Instance of the GameRenderer object
     */
    private static GameRenderer instance;

    /**
     * Canvas of the where all the GameObjects will be drawn
     */
    private Canvas canvas;

    /**
     * Stage which holds the canvas
     */
    private Stage stage;

    /**
     * Graphics object which contains methods for that are used to draw to the canvas
     */
    private Graphics graphics;

    /**
     * Boolean value which tells if GameRenderer is running or not
     */
    private boolean isRunning = false;

    /**
     * Constructor of GameRenderer
     *
     * Initializes the instance of GameRenderer and sets GameRenderer running
     */
    public GameRenderer() {
        instance = this;
        isRunning = true;
    }

    /**
     * Returns instance of GameRenderer
     * If instance is null it waits until the instance is created
     *
     * @return Instance of GameRenderer
     */
    public synchronized static GameRenderer getInstance() {

        if(instance == null) {
            new Thread(() -> Application.launch(GameRenderer.class)).start();
        }

        while(instance == null) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return instance;
    }

    /**
     * Method required by JavaFX Application class
     *
     * Initializes the stage object
     *
     * @param stage Stage object
     */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    /**
     * Overrides a stop method from Application class
     *
     * Sets inRunning value to false
     */
    @Override
    public void stop() {
        isRunning = false;
    }

    /**
     * Tells if GameRenderer is running or not
     *
     * @return boolean value which tells if GameRenderer is running or not
     */
    public boolean isRunning() {
        return this.isRunning;
    }

    /**
     * Creates the window and canvas and renders them
     * Also sets event handlers for key input and mouse input
     */
    public void initStage() {

        Group root = new Group();

        Scene scene = new Scene(root, MetricConverter.toPixels(GameEngine.getScene().getWidth()), MetricConverter.toPixels(GameEngine.getScene().getHeight()));

        setInputEventHandlers(scene);
        setMouseEventHandlers(scene);

        canvas = new Canvas(MetricConverter.toPixels(GameEngine.getScene().getWidth()), MetricConverter.toPixels(GameEngine.getScene().getHeight()));
        graphics = new Graphics(canvas.getGraphicsContext2D());

        root.getChildren().add(canvas);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Returns Graphics object
     *
     * @return Graphics object
     */
    public Graphics getGraphics() {
        return this.graphics;
    }

    /**
     * Sets event handlers for key press, key typed and key released
     *
     * @param scene Scene for event handlers
     */
    private void setInputEventHandlers(Scene scene) {

        InputEventHandler inputEventHandler = new InputEventHandler();
        scene.setOnKeyPressed(inputEventHandler);
        scene.setOnKeyTyped(inputEventHandler);
        scene.setOnKeyReleased(inputEventHandler);

    }

    /**
     * Sets event handlers for mouse press, mouse released, mouse clicked,
     * mouse dragged and mouse moved
     *
     * @param scene Scene for event handlers
     */
    private void setMouseEventHandlers(Scene scene) {

        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        scene.setOnMousePressed(mouseEventHandler);
        scene.setOnMouseReleased(mouseEventHandler);
        scene.setOnMouseClicked(mouseEventHandler);
        scene.setOnMouseDragged(mouseEventHandler);
        scene.setOnMouseMoved(mouseEventHandler);

    }

}