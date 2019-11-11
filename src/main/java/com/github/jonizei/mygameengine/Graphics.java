package com.github.jonizei.mygameengine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Graphics {

    private GraphicsContext context;

    public Graphics(GraphicsContext context) {
        this.context = context;
    }

    public void drawRect(double x, double y, double width, double height, Color color) {
        context.setFill(color);
        context.setStroke(color);
        context.setLineWidth(2);
        context.strokeRect(MetricConverter.toPixels(x), MetricConverter.toPixels(y), MetricConverter.toPixels(width), MetricConverter.toPixels(height));
        context.fillRect(MetricConverter.toPixels(x), MetricConverter.toPixels(y), MetricConverter.toPixels(width), MetricConverter.toPixels(height));
    }

}
