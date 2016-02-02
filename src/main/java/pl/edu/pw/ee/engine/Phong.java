package pl.edu.pw.ee.engine;

import pl.edu.pw.ee.engine.geometry.ColoredPoint3D;
import pl.edu.pw.ee.engine.geometry.Point3D;
import pl.edu.pw.ee.engine.geometry.Vector;
import pl.edu.pw.ee.engine.geometry.Sphere;
import pl.edu.pw.ee.engine.setting.MaterialType;

import java.awt.*;

import static pl.edu.pw.ee.engine.setting.Settings.*;

/**

 */
public class Phong {

    private Point3D observatoryPoint;
    private Point3D source;
    private MaterialType materialType;
    private Sphere sphere;

    public Phong(Point3D observatoryPoint, Point3D source, MaterialType materialType, Sphere sphere) {
        this.observatoryPoint = observatoryPoint;
        this.source = source;
        this.materialType = materialType;
        this.sphere = sphere;
    }

    public ScreenBuffer computeScreen(ScreenBuffer screenBuffer) {
        sphere.visiblePointsOnSphere.forEach(coloredPoint3D -> coloredPoint3D.i = getI(coloredPoint3D));
        double maxI = sphere.visiblePointsOnSphere.stream()
                .max((o1, o2) -> Double.compare(o1.i, o2.i))
                .get().i;
        sphere.visiblePointsOnSphere.forEach(coloredPoint3D -> computeColorAndSet(coloredPoint3D, maxI));
        screenBuffer.drawPoints(sphere.visiblePointsOnSphere);
        return screenBuffer;
    }

    private double getI(ColoredPoint3D pointOnSphere) {
        Vector N = new Vector(sphere.center, pointOnSphere).normalize();
        Vector V = new Vector(pointOnSphere, observatoryPoint).normalize();
        Vector L = new Vector(pointOnSphere, source);
        double distanceBetweenPointAndSource = L.length();
        L = L.normalize();
        Vector R = L.reflection(N);
        return computeI(distanceBetweenPointAndSource, N, V, L, R);
    }

    private void computeColorAndSet(ColoredPoint3D point, double max) {
        float value = (float) (point.i / max);
        point.color = new Color(value, value, value);
    }

    private double computeI(double distanceBetweenPointAndSource, Vector N, Vector V, Vector L, Vector R) {
        double fatt = computeFatt(distanceBetweenPointAndSource);
        return IA * KA
                + fatt * IP * materialType.getKd() * Math.max(0, N.scalarMultiplication(L))
                + fatt * IP * materialType.getKs() * Math.pow(Math.max(0, R.cosBetween(V)), materialType.getN());
    }

    private double computeFatt(double distanceBetweenPointAndSource) {
        return 1.0 / (C + distanceBetweenPointAndSource);
    }

}
