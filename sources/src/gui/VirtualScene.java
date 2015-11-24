package gui;

import model.Point3D;
import model.Wall;

import java.awt.*;
import java.util.ArrayList;

import static util.MathUtil.getDistance;

public class VirtualScene {

    public static ArrayList<Wall> createScene() {

        ArrayList<Wall> scene = new ArrayList<Wall>();

        Point3D A1 = new Point3D(-100, -120, 200);
        Point3D B1 = new Point3D(-20, -120, 200);
        Point3D C1 = new Point3D(-100, 40, 200);
        Point3D D1 = new Point3D(-20, 40, 200);
        Point3D E1 = new Point3D(-100, -120, 160);
        Point3D F1 = new Point3D(-20, -120, 160);
        Point3D G1 = new Point3D(-100, 40, 160);
        Point3D H1 = new Point3D(-20, 40, 160);

        double figureHeight = getDistance(A1, C1);
        scene.add(new Wall(A1, B1, D1, C1, Color.BLACK, figureHeight));
        scene.add(new Wall(E1, F1, H1, G1, Color.BLACK, figureHeight));
        scene.add(new Wall(B1, F1, H1, D1, Color.BLACK, figureHeight));
        scene.add(new Wall(A1, E1, G1, C1, Color.BLACK, figureHeight));
        scene.add(new Wall(A1, B1, F1, E1, Color.BLACK, figureHeight));
        scene.add(new Wall(C1, D1, H1, G1, Color.BLACK, figureHeight));

        Point3D A2 = new Point3D(-100, -60, 120);
        Point3D B2 = new Point3D(-20, -60, 120);
        Point3D C2 = new Point3D(-100, 40, 120);
        Point3D D2 = new Point3D(-20, 40, 120);
        Point3D E2 = new Point3D(-100, -60, 80);
        Point3D F2 = new Point3D(-20, -60, 80);
        Point3D G2 = new Point3D(-100, 40, 80);
        Point3D H2 = new Point3D(-20, 40, 80);

        figureHeight = getDistance(A2, C2);
        scene.add(new Wall(A2, B2, D2, C2, Color.CYAN, figureHeight));
        scene.add(new Wall(E2, F2, H2, G2, Color.CYAN, figureHeight));
        scene.add(new Wall(B2, F2, H2, D2, Color.CYAN, figureHeight));
        scene.add(new Wall(A2, E2, G2, C2, Color.CYAN, figureHeight));
        scene.add(new Wall(A2, B2, F2, E2, Color.CYAN, figureHeight));
        scene.add(new Wall(C2, D2, H2, G2, Color.CYAN, figureHeight));

        Point3D A3 = new Point3D(20, -20, 200);
        Point3D B3 = new Point3D(100, -20, 200);
        Point3D C3 = new Point3D(20, 240, 200);
        Point3D D3 = new Point3D(100, 240, 200);
        Point3D E3 = new Point3D(20, -20, 160);
        Point3D F3 = new Point3D(100, -20, 160);
        Point3D G3 = new Point3D(20, 240, 160);
        Point3D H3 = new Point3D(100, 240, 160);

        figureHeight = getDistance(A3, C3);
        scene.add(new Wall(A3, B3, D3, C3, Color.BLUE, figureHeight));
        scene.add(new Wall(E3, F3, H3, G3, Color.BLUE, figureHeight));
        scene.add(new Wall(B3, F3, H3, D3, Color.BLUE, figureHeight));
        scene.add(new Wall(A3, E3, G3, C3, Color.BLUE, figureHeight));
        scene.add(new Wall(A3, B3, F3, E3, Color.BLUE, figureHeight));
        scene.add(new Wall(C3, D3, H3, G3, Color.BLUE, figureHeight));

        Point3D A4 = new Point3D(20, -60, 120);
        Point3D B4 = new Point3D(100, -60, 120);
        Point3D C4 = new Point3D(20, 540, 120);
        Point3D D4 = new Point3D(100, 540, 120);
        Point3D E4 = new Point3D(20, -60, 80);
        Point3D F4 = new Point3D(100, -60, 80);
        Point3D G4 = new Point3D(20, 540, 80);
        Point3D H4 = new Point3D(100, 540, 80);

        figureHeight = getDistance(A4, C4);
        scene.add(new Wall(A4, B4, D4, C4, Color.GREEN, figureHeight));
        scene.add(new Wall(E4, F4, H4, G4, Color.GREEN, figureHeight));
        scene.add(new Wall(B4, F4, H4, D4, Color.GREEN, figureHeight));
        scene.add(new Wall(A4, E4, G4, C4, Color.GREEN, figureHeight));
        scene.add(new Wall(A4, B4, F4, E4, Color.GREEN, figureHeight));
        scene.add(new Wall(C4, D4, H4, G4, Color.GREEN, figureHeight));

        return scene;
    }
}
