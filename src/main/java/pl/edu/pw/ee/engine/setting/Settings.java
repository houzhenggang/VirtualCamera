package pl.edu.pw.ee.engine.setting;

import pl.edu.pw.ee.engine.geometry.Point3D;

import java.awt.*;


public class Settings {

    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    public static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    public static final Color BACKGROUND_COLOR = Color.WHITE;

    public static final double IA = 0;
    public static final double IP = 10000000.0;
    public static final double KA = 0.05;
    public static final double C = 2.0;

    public static final Point3D SPHERE_CENTER_POINT =
            new Point3D(DIMENSION.getWidth() / 2, DIMENSION.getHeight() / 2, 0);
    public static final Point3D SOURCE_POINT = new Point3D(SPHERE_CENTER_POINT.x + 400.0, SPHERE_CENTER_POINT.y, SPHERE_CENTER_POINT.z);
    public static final int SPHERE_RADIUS = (int) (DIMENSION.getWidth() / 4);
    public static final Point3D OBSERVATION_POINT =
            new Point3D(SPHERE_CENTER_POINT.x, SPHERE_CENTER_POINT.y, SPHERE_CENTER_POINT.z + SPHERE_RADIUS * 2);
    public static final MaterialType SPHERE_DEFAULT_MATERIAL = MaterialType.METAL;

}
