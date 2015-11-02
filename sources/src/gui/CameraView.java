package gui;

import model.Point2D;
import model.Point3D;
import model.Vector2D;
import model.Vector3D;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CameraView extends JPanel {

    static int FOCAL = 25;
    static int SCEANE_WIDHT = 500;
    static int SCEANE_HEIGHT = 500;

    private Color backgorundColor = Color.WHITE;
    private Color lineColor = Color.BLACK;
    private ArrayList<Vector3D> vectors3D;

    public Point2D projectPoint(Point3D point) {
        double k = FOCAL / point.y;
        int x = (int) (k * point.x + (SCEANE_WIDHT / 2));
        int y = (int) ((SCEANE_HEIGHT / 2) - k * point.z);
        return new Point2D(x, y);
    }

    public CameraView() {
        this.setBackground(backgorundColor);
        this.setForeground(backgorundColor);
    }

    public void initScene() {
        vectors3D = VirtualScene.createScene();
        this.repaint();
    }

    public boolean visiblePoint(Point3D point) {
        return point.y >= FOCAL;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(lineColor);

        if (vectors3D != null) {
            for (Vector3D v : vectors3D) {

                Point3D p1 = new Point3D((v.A.x * 0.5) / v.A.z,
                        (v.A.y * 0.5) / v.A.z, 0.5, 1);

                Point3D p2 = new Point3D((v.B.x * 0.5) / v.B.z,
                        (v.B.y * 0.5) / v.B.z, 0.5, 1);


                if (isPointOnView(p1) && isPointOnView(p2)) {
                    Point2D p12d = new Point2D((int) ((p1.x + 1) * SCEANE_WIDHT / 2), (int) ((p1.y + 1) * SCEANE_HEIGHT / 2));
                    Point2D p22d = new Point2D((int) ((p2.x + 1) * SCEANE_WIDHT / 2), (int) ((p2.y + 1) * SCEANE_HEIGHT / 2));
                    Vector2D e = new Vector2D(p12d, p22d);
                    g.drawLine(e.A.x, e.A.y, e.B.x, e.B.y);

//                    newEdges.add(new Edge2D(p12d, p22d));
                }
//                if (visiblePoint(v.A) && visiblePoint(v.B)) {
//                    Point2D a = projectPoint(v.A);
//                    Point2D b = projectPoint(v.B);
//                    Vector2D e = new Vector2D(a, b);
//                    g.drawLine(e.A.x, e.A.y, e.B.x, e.B.y);
//                }
            }

        }
    }

    private boolean isPointOnView(Point3D p){
        if(p.x >= -1 && p.x <= 1 && p.y >= -1 && p.y <= 1)
            return true;

        return false;
    }

    public void refreshScene(ArrayList<Vector3D> vectors3D) {
        this.vectors3D = vectors3D;
        this.repaint();
    }
}
