package gui;

import model.Point2D;
import model.Point3D;
import model.Vector2D;
import model.Vector3D;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CameraView extends JPanel {

    static int SCEANE_WIDHT = 500;
    static int SCEANE_HEIGHT = 500;

    private double DISTANCE = 0.5;

    private Color backgorundColor = Color.WHITE;
    private Color lineColor = Color.BLACK;
    private List<Vector3D> vectors3D;

    public CameraView() {
        this.setBackground(backgorundColor);
        this.setForeground(backgorundColor);
    }

    public void initScene() {
        vectors3D = VirtualScene.createScene();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(lineColor);

        if (vectors3D != null) {
            for (Vector3D v : vectors3D) {

                Point3D p1 = new Point3D((v.A.x * DISTANCE) / v.A.z,
                        (v.A.y * DISTANCE) / v.A.z, DISTANCE, 1);

                Point3D p2 = new Point3D((v.B.x * DISTANCE) / v.B.z,
                        (v.B.y * DISTANCE) / v.B.z, DISTANCE, 1);


                if (isPointVisible(p1) && isPointVisible(p2)) {
                    Point2D p12d = new Point2D((int) ((p1.x + 1) * SCEANE_WIDHT / 2), (int) ((p1.y + 1) * SCEANE_HEIGHT / 2));
                    Point2D p22d = new Point2D((int) ((p2.x + 1) * SCEANE_WIDHT / 2), (int) ((p2.y + 1) * SCEANE_HEIGHT / 2));
                    Vector2D e = new Vector2D(p12d, p22d);
                    g.drawLine(e.A.x, e.A.y, e.B.x, e.B.y);
                }
            }
        }
    }

    private boolean isPointVisible(Point3D p){
        return (p.x >= -1 && p.x <= 1 && p.y >= -1 && p.y <= 1 && p.z >= -1 && p.z <= 1);
    }

    public void translateX(double step) {
        for (Vector3D v : vectors3D) {
            v.A.x += step;
            v.B.x += step;
        }
        repaint();
    }

    public void translateY(double step) {
        for (Vector3D v : vectors3D) {
            v.A.y += step;
            v.B.y += step;
        }
        repaint();
    }

    public void translateZ(double step) {
        for (Vector3D v : vectors3D) {
            v.A.z += step;
            v.B.z += step;
        }
        repaint();
    }

    public void rotateOX(double fi){
        for (Vector3D v : vectors3D) {
            v.A.y = v.A.y * Math.cos(fi) - v.A.z * Math.sin(fi);
            v.A.z = v.A.y * Math.sin(fi) + v.A.z * Math.cos(fi);

            v.B.y = v.B.y * Math.cos(fi) - v.B.z * Math.sin(fi);
            v.B.z = v.B.y * Math.sin(fi) + v.B.z * Math.cos(fi);
        }
        repaint();
    }

    public void rotateOY(double fi){
        for (Vector3D v : vectors3D) {
            v.A.x = v.A.x * Math.cos(fi) - v.A.z * Math.sin(fi);
            v.A.z = v.A.x * Math.sin(fi) + v.A.z * Math.cos(fi);

            v.B.x = v.B.x * Math.cos(fi) - v.B.z * Math.sin(fi);
            v.B.z = v.B.x * Math.sin(fi) + v.B.z * Math.cos(fi);
        }
        repaint();
    }

    public void rotateOZ(double fi){
        for (Vector3D v : vectors3D) {
            v.A.x = v.A.x * Math.cos(fi) - v.A.y * Math.sin(fi);
            v.A.y = v.A.x * Math.sin(fi) + v.A.y * Math.cos(fi);

            v.B.x = v.B.x * Math.cos(fi) - v.B.y * Math.sin(fi);
            v.B.y = v.B.x * Math.sin(fi) + v.B.y * Math.cos(fi);
        }
        repaint();
    }

    public void zoom(double step){
        DISTANCE += step;
        repaint();
    }
}
