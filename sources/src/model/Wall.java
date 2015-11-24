package model;

import util.MathUtil;

import java.awt.*;

public class Wall implements Comparable<Wall> {

    public enum Type {
        HORIZONTAL, VERTICAL, SIDE
    }

    public Vector3D vectorA;
    public Vector3D vectorB;
    public Vector3D vectorC;
    public Vector3D vectorD;

    public Point3D pointA;
    public Point3D pointB;
    public Point3D pointC;
    public Point3D pointD;

    public boolean isSplited = false;
    public double figureHeight;

    public Type wallType;

    public Color color;

    public Wall(Point3D pointA, Point3D pointB, Point3D pointC, Point3D pointD, Color color) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.wallType = determinateWallType();
        this.vectorA = new Vector3D(pointA, pointB);
        this.vectorB = new Vector3D(pointB, pointC);
        this.vectorC = new Vector3D(pointC, pointD);
        this.vectorD = new Vector3D(pointD, pointA);
        this.color = color;
    }

    public Wall(Point3D pointA, Point3D pointB, Point3D pointC, Point3D pointD, Color color, double figureHeight) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.wallType = determinateWallType();
        this.vectorA = new Vector3D(pointA, pointB);
        this.vectorB = new Vector3D(pointB, pointC);
        this.vectorC = new Vector3D(pointC, pointD);
        this.vectorD = new Vector3D(pointD, pointA);
        this.color = color;
        this.figureHeight = figureHeight;
    }

    private double getWallDistance() {
        double tmpMinDistance = Math.min(Math.abs(pointA.z), Math.abs(pointB.z));
        double tmpMinDistance2 = Math.min(Math.abs(pointC.z), Math.abs(pointD.z));
        return Math.min(tmpMinDistance, tmpMinDistance2);
    }

    private double getWallDistance2() {
        double tmpMinDistance = Math.min(Math.abs(pointA.x), Math.abs(pointB.x));
        double tmpMinDistance2 = Math.min(Math.abs(pointC.x), Math.abs(pointD.x));
        return Math.min(tmpMinDistance, tmpMinDistance2);
    }

    private double getWallDistance3() {
        double tmpMinDistance = Math.min(Math.abs(pointA.y), Math.abs(pointB.y));
        double tmpMinDistance2 = Math.min(Math.abs(pointC.y), Math.abs(pointD.y));
        return Math.min(tmpMinDistance, tmpMinDistance2);
    }

    private Type determinateWallType() {
        if (MathUtil.isEqual(pointA.x, pointB.x, pointC.x, pointD.x)) {
            return Type.SIDE;
        } else if (MathUtil.isEqual(pointA.y, pointB.y, pointC.y, pointD.y)) {
            return Type.HORIZONTAL;
        } else {
            return Type.VERTICAL;
        }
    }


    @Override
    public int compareTo(Wall o) {

        if (this.getWallDistance() < o.getWallDistance()) {
            return 1;
        } else if (this.getWallDistance() > o.getWallDistance()) {
            return -1;
        }

        if (this.getWallDistance2() < o.getWallDistance2()) {
            return 1;
        } else if (this.getWallDistance2() > o.getWallDistance2()) {
            return -1;
        }

        if (this.getWallDistance3() < o.getWallDistance3()) {
            return 1;
        } else if (this.getWallDistance3() > o.getWallDistance3()) {
            return -1;
        }

        return 0;
    }
}
