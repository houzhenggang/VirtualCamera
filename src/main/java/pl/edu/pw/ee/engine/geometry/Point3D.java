package pl.edu.pw.ee.engine.geometry;

/**

 */
public class Point3D {

    public double x;
    public double y;
    public double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(Point3D p) {
        x = p.x;
        y = p.y;
        z = p.z;
    }

    public Vector toVector() {
        return new Vector(x, y, z);
    }

    public Point2D onPlane() {
        return new Point2D((int) x, (int) y);
    }

}
