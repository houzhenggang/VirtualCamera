package util;

import model.Point3D;

public class MathUtil {

    public static double getDistance(Point3D A, Point3D B) {
        double dx = A.x - B.x;
        double dy = A.y - B.y;
        double dz = A.z - B.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static boolean isEqual(double x1, double x2, double x3, double x4) {
        return (x1 == x2) && (x2 == x3) && (x3 == x4);
    }
}
