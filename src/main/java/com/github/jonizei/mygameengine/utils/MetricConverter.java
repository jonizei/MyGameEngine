package com.github.jonizei.mygameengine.utils;

/**
 * This class converts pixels to metrics and vice versa
 * These metres has nothing to do with real meters
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public class MetricConverter {

    /**
     * Multiplier which tells how much 1 meter is in pixels
     */
    private static final int MULTIPLIER = 32;

    /**
     * Converts meters to pixels
     *
     * @param value Value in meters
     * @return Value in pixels
     */
    public static double toPixels(double value) {
        return value * MULTIPLIER;
    }

    /**
     * Converts pixels to meters
     *
     * @param value Value in pixels
     * @return Value in meters
     */
    public static double toMetrics(double value) {
        return value / MULTIPLIER;
    }

}
