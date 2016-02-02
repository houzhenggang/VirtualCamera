package pl.edu.pw.ee.engine.geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sphere {
    public Point3D center;
    public int radius;
    public List<ColoredPoint3D> visiblePointsOnSphere = new ArrayList<>();

    public Sphere(Point3D center, int radius) {
        this.center = center;
        this.radius = radius;
        Point2D centerOnPlane = center.onPlane();
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                double inequalityValue = Math.pow(i, 2) + Math.pow(j, 2) - Math.pow(radius, 2);
                if (inequalityValue <= 0) {
                    visiblePointsOnSphere.add(convertToPointOnSphere(centerOnPlane.x - i, centerOnPlane.y - j, Color.BLACK));
                    if (i != 0 || j != 0) {
                        visiblePointsOnSphere.add(convertToPointOnSphere(centerOnPlane.x + i, centerOnPlane.y + j, Color.BLACK));
                        visiblePointsOnSphere.add(convertToPointOnSphere(centerOnPlane.x + i, centerOnPlane.y - j, Color.BLACK));
                        visiblePointsOnSphere.add(convertToPointOnSphere(centerOnPlane.x - i, centerOnPlane.y + j, Color.BLACK));
                    }
                }
            }
        }
    }

    private ColoredPoint3D convertToPointOnSphere(int x, int y, Color color) {
        return new ColoredPoint3D(x, y, Math.sqrt(Math.pow(radius, 2) - Math.pow(x - center.x, 2)
                - Math.pow(y - center.y, 2)), color);
    }
}
