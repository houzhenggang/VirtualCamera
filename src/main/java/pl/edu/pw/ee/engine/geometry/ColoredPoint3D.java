package pl.edu.pw.ee.engine.geometry;

import java.awt.*;

public class ColoredPoint3D extends Point3D {
    public Color color;
    public double i;

    public ColoredPoint3D(double x, double y, double z, Color color) {
        super(x, y, z);
        this.color = color;
    }

    public ColoredPoint3D(double x, double y, double z, Color color, double i) {
        super(x, y, z);
        this.color = color;
        this.i = i;
    }
}
