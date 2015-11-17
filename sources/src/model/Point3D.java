package model;

public class Point3D {

    public double x, y, z, w;

    public Point3D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1.0;
    }

    public void raiseY(double step){
        y += step;
    }
}
