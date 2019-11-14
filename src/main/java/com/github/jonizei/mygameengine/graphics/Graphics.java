package com.github.jonizei.mygameengine.graphics;

import com.github.jonizei.mygameengine.utils.MetricConverter;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
     * @param x X position of the rectangle
     * @param y Y position of the rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     * @param color Color of the rectangle
     */
    public void drawRect(double x, double y, double width, double height, Color color) {
        context.setFill(color);
        context.setStroke(color);
        context.setLineWidth(2);
        context.strokeRect(MetricConverter.toPixels(x), MetricConverter.toPixels(y), MetricConverter.toPixels(width), MetricConverter.toPixels(height));
        context.fillRect(MetricConverter.toPixels(x), MetricConverter.toPixels(y), MetricConverter.toPixels(width), MetricConverter.toPixels(height));
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
