package com.github.jonizei.mygameengine;

public class MetricConverter {

    private static final int MODIFIER = 25;

    public static double toPixels(double value) {
        return value * MODIFIER;
    }

    public static double toMetrics(double value) {
        return value / MODIFIER;
    }

}
