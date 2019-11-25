package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.utils.MetricConverter;
import com.github.jonizei.mygameengine.gameobject.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 * This class handles drawing to the canvas
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class Graphics {

    /**
     * GraphicsContext of the canvas
     */
    private GraphicsContext context;

    /**
     * Constructor of Graphics
     *
     * Initializes the GraphicsContext
     *
     * @param context GraphicsContext of the canvas
     */
    public Graphics(GraphicsContext context) {
        this.context = context;
    }

    /**
     * Draws rectangle with given width, height and color to given position
     *
     * @param transform Transform of the gameObject
     * @param color Color of the rectangle
     */
    public void drawRect(Transform transform, Color color) {
        Rectangle rectangle = new Rectangle(
                MetricConverter.toPixels(transform.getPosition().getX()),
                MetricConverter.toPixels(transform.getPosition().getY()),
                MetricConverter.toPixels(transform.getScale().getWidth()),
                MetricConverter.toPixels(transform.getScale().getHeight()));

        context.save();
        context.setFill(color);
        context.setStroke(color);
        context.setLineWidth(2);

        context.transform(new Affine(new Rotate(transform.getRotation().getAngle(), MetricConverter.toPixels(transform.getPosition().getOriginX()), MetricConverter.toPixels(transform.getPosition().getOriginY()))));

        context.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        context.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        context.restore();
    }

    /**
     * Draws white rectangle with given width and height to given position
     *
     * @param x X position of the rectangle
     * @param y Y position of the rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public void clearRect(double x, double y, double width, double height) {
        context.setFill(Color.WHITE);
        context.fillRect(MetricConverter.toPixels(x), MetricConverter.toPixels(y), MetricConverter.toPixels(width), MetricConverter.toPixels(height));
    }

}
