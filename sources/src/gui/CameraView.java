package gui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static util.MathUtil.getDistance;

public class CameraView extends JPanel {

    static int SCEANE_WIDHT = 500;
    static int SCEANE_HEIGHT = 500;
    static double WALL_ELEMENT_HEIGHT = 10.0;

    private boolean cameraMode = true;

    private double DISTANCE = 0.5;

    private Color lineColor = Color.RED;
    private ArrayList<Wall> walls;

    public CameraView() {
        Color backgorundColor = Color.WHITE;
        this.setBackground(backgorundColor);
        this.setForeground(backgorundColor);
    }

    public void initScene() {
        walls = VirtualScene.createScene();
        if (!cameraMode) {
            walls = splitWalls();
        }
        this.repaint();
    }

    private ArrayList<Wall> splitWalls() {
        ArrayList<Wall> wallsNet = new ArrayList<Wall>();
        for (Wall wall : walls) {
            double wallHeight = getDistance(wall.pointA, wall.pointD);
            int amountOfElements = (int) wallHeight / (int) WALL_ELEMENT_HEIGHT;
            splitWall(wall, amountOfElements, wallsNet);
        }
        return wallsNet;
    }

    private void splitWall(Wall wall, int amountOfElements, ArrayList<Wall> wallsNet) {
        if (wall.wallType == Wall.Type.VERTICAL || wall.wallType == Wall.Type.SIDE) {
            splitVerticalOrSideWall(wall, amountOfElements, wallsNet);
        }
    }

    private void splitVerticalOrSideWall(Wall wall, int amountOfElements, ArrayList<Wall> wallsNet) {
        for (int i = 0; i < amountOfElements; i++) {
            Point3D newPointC = new Point3D(wall.pointA.x, wall.pointA.y, wall.pointA.z);
            Point3D newPointD = new Point3D(wall.pointB.x, wall.pointB.y, wall.pointB.z);

            newPointC.y += WALL_ELEMENT_HEIGHT;
            newPointD.y += WALL_ELEMENT_HEIGHT;

            Wall w = new Wall(wall.pointA, wall.pointB, newPointD, newPointC, wall.color);
            w.isSplited = true;

            wallsNet.add(w);

            wall.pointA = newPointC;
            wall.pointB = newPointD;
        }
    }

    private void splitHorizontalWall(Wall wall, int amountOfElements, ArrayList<Wall> wallsNet) {
        for (int i = 0; i < amountOfElements; i++) {
            Point3D newPointC = new Point3D(wall.pointA.x, wall.pointA.y, wall.pointA.z);
            Point3D newPointD = new Point3D(wall.pointB.x, wall.pointB.y, wall.pointB.z);


            newPointC.z += WALL_ELEMENT_HEIGHT;
            newPointD.z += WALL_ELEMENT_HEIGHT;

            wallsNet.add(new Wall(wall.pointA, wall.pointB, newPointD, newPointC, wall.color));
            wall.pointA = newPointC;
            wall.pointB = newPointD;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(lineColor);

        if (walls != null) {
            Collections.sort(walls);
            for (Wall wall : walls) {

                Polygon polygon = new Polygon();

                Point3D p1 = new Point3D((wall.pointA.x * DISTANCE) / wall.pointA.z,
                        (wall.pointA.y * DISTANCE) / wall.pointA.z, DISTANCE);

                Point3D p2 = new Point3D((wall.pointB.x * DISTANCE) / wall.pointB.z,
                        (wall.pointB.y * DISTANCE) / wall.pointB.z, DISTANCE);

                Point3D p3 = new Point3D((wall.pointC.x * DISTANCE) / wall.pointC.z,
                        (wall.pointC.y * DISTANCE) / wall.pointC.z, DISTANCE);

                Point3D p4 = new Point3D((wall.pointD.x * DISTANCE) / wall.pointD.z,
                        (wall.pointD.y * DISTANCE) / wall.pointD.z, DISTANCE);

                Point2D p12d = new Point2D((int) ((p1.x + 1) * SCEANE_WIDHT / 2), (int) ((p1.y + 1) * SCEANE_HEIGHT / 2));
                Point2D p22d = new Point2D((int) ((p2.x + 1) * SCEANE_WIDHT / 2), (int) ((p2.y + 1) * SCEANE_HEIGHT / 2));
                Point2D p32d = new Point2D((int) ((p3.x + 1) * SCEANE_WIDHT / 2), (int) ((p3.y + 1) * SCEANE_HEIGHT / 2));
                Point2D p42d = new Point2D((int) ((p4.x + 1) * SCEANE_WIDHT / 2), (int) ((p4.y + 1) * SCEANE_HEIGHT / 2));

                polygon.addPoint(p12d.x, p12d.y);
                polygon.addPoint(p22d.x, p22d.y);
                polygon.addPoint(p32d.x, p32d.y);
                polygon.addPoint(p42d.x, p42d.y);

                if (cameraMode) {
                    g.drawLine(p12d.x, p12d.y, p22d.x, p22d.y);
                    g.drawLine(p22d.x, p22d.y, p32d.x, p32d.y);
                    g.drawLine(p32d.x, p32d.y, p42d.x, p42d.y);
                    g.drawLine(p42d.x, p42d.y, p12d.x, p12d.y);
                } else {
                    g.setColor(wall.color);
                    g.drawPolygon(polygon);
                    g.setColor(wall.color);
                    g.fillPolygon(polygon);
                }
            }
        }
    }

    public void translateX(double step) {
        for (Wall wall : walls) {
            wall.pointA.x += step;
            wall.pointB.x += step;
            wall.pointC.x += step;
            wall.pointD.x += step;
        }
        repaint();
    }

    public void translateY(double step) {
        for (Wall wall : walls) {
            wall.pointA.y += step;
            wall.pointB.y += step;
            wall.pointC.y += step;
            wall.pointD.y += step;
        }
        repaint();
    }

    public void translateZ(double step) {
        for (Wall wall : walls) {
            wall.pointA.z += step;
            wall.pointB.z += step;
            wall.pointC.z += step;
            wall.pointD.z += step;
        }
        repaint();
    }

    public void rotateOX(double fi) {
        for (Wall wall : walls) {
            wall.pointA.y = wall.pointA.y * Math.cos(fi) - wall.pointA.z * Math.sin(fi);
            wall.pointA.z = wall.pointA.y * Math.sin(fi) + wall.pointA.z * Math.cos(fi);

            wall.pointB.y = wall.pointB.y * Math.cos(fi) - wall.pointB.z * Math.sin(fi);
            wall.pointB.z = wall.pointB.y * Math.sin(fi) + wall.pointB.z * Math.cos(fi);

            wall.pointC.y = wall.pointC.y * Math.cos(fi) - wall.pointC.z * Math.sin(fi);
            wall.pointC.z = wall.pointC.y * Math.sin(fi) + wall.pointC.z * Math.cos(fi);

            wall.pointD.y = wall.pointD.y * Math.cos(fi) - wall.pointD.z * Math.sin(fi);
            wall.pointD.z = wall.pointD.y * Math.sin(fi) + wall.pointD.z * Math.cos(fi);
        }
        repaint();
    }

    public void rotateOY(double fi) {
        for (Wall wall : walls) {
            wall.pointA.x = wall.pointA.x * Math.cos(fi) - wall.pointA.z * Math.sin(fi);
            wall.pointA.z = wall.pointA.x * Math.sin(fi) + wall.pointA.z * Math.cos(fi);

            wall.pointB.x = wall.pointB.x * Math.cos(fi) - wall.pointB.z * Math.sin(fi);
            wall.pointB.z = wall.pointB.x * Math.sin(fi) + wall.pointB.z * Math.cos(fi);

            wall.pointC.x = wall.pointC.x * Math.cos(fi) - wall.pointC.z * Math.sin(fi);
            wall.pointC.z = wall.pointC.x * Math.sin(fi) + wall.pointC.z * Math.cos(fi);

            wall.pointD.x = wall.pointD.x * Math.cos(fi) - wall.pointD.z * Math.sin(fi);
            wall.pointD.z = wall.pointD.x * Math.sin(fi) + wall.pointD.z * Math.cos(fi);
        }
        repaint();
    }

    public void rotateOZ(double fi) {
        for (Wall wall : walls) {
            wall.pointA.x = wall.pointA.x * Math.cos(fi) - wall.pointA.y * Math.sin(fi);
            wall.pointA.y = wall.pointA.x * Math.sin(fi) + wall.pointA.y * Math.cos(fi);

            wall.pointB.x = wall.pointB.x * Math.cos(fi) - wall.pointB.y * Math.sin(fi);
            wall.pointB.y = wall.pointB.x * Math.sin(fi) + wall.pointB.y * Math.cos(fi);

            wall.pointC.x = wall.pointC.x * Math.cos(fi) - wall.pointC.y * Math.sin(fi);
            wall.pointC.y = wall.pointC.x * Math.sin(fi) + wall.pointC.y * Math.cos(fi);

            wall.pointD.x = wall.pointD.x * Math.cos(fi) - wall.pointD.y * Math.sin(fi);
            wall.pointD.y = wall.pointD.x * Math.sin(fi) + wall.pointD.y * Math.cos(fi);
        }
        repaint();
    }

    public void zoom(double step) {
        DISTANCE += step;
        repaint();
    }

    public void changeMode() {
        cameraMode = !cameraMode;
        initScene();
    }
}
