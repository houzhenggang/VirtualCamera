package gui;

import model.Point3D;
import model.Wall;

import java.awt.*;
import java.util.ArrayList;

public class VirtualScene {

    public static ArrayList<Wall> createScene(){

        ArrayList<Wall> scene = new ArrayList<Wall>();

        Point3D A1 = new Point3D(-100, -120, 200);
        Point3D B1 = new Point3D(-20, -120, 200);
        Point3D C1 = new Point3D(-100, 40, 200);
        Point3D D1 = new Point3D(-20, 40, 200);
        Point3D E1 = new Point3D(-100, -120, 160);
        Point3D F1 = new Point3D(-20, -120, 160);
        Point3D G1 = new Point3D(-100, 40, 160);
        Point3D H1 = new Point3D(-20, 40, 160);

        scene.add(new Wall(A1, B1, D1, C1, Color.BLACK));
        scene.add(new Wall(E1, F1, H1, G1, Color.BLACK));
        scene.add(new Wall(B1, F1, H1, D1, Color.BLACK));
        scene.add(new Wall(A1, E1, G1, C1, Color.BLACK));
        scene.add(new Wall(A1, B1, F1, E1, Color.BLACK));
        scene.add(new Wall(C1, D1, H1, G1, Color.BLACK));

        Point3D A2 = new Point3D(-100, -60, 120);
        Point3D B2 = new Point3D(-20, -60, 120);
        Point3D C2 = new Point3D(-100, 40, 120);
        Point3D D2 = new Point3D(-20, 40, 120);
        Point3D E2 = new Point3D(-100, -60, 80);
        Point3D F2 = new Point3D(-20, -60, 80);
        Point3D G2 = new Point3D(-100, 40, 80);
        Point3D H2 = new Point3D(-20, 40, 80);

        scene.add(new Wall(A2, B2, D2, C2, Color.CYAN));
        scene.add(new Wall(E2, F2, H2, G2, Color.CYAN));
        scene.add(new Wall(B2, F2, H2, D2, Color.CYAN));
        scene.add(new Wall(A2, E2, G2, C2, Color.CYAN));
        scene.add(new Wall(A2, B2, F2, E2, Color.CYAN));
        scene.add(new Wall(C2, D2, H2, G2, Color.CYAN));

        Point3D A3 = new Point3D(20, -20, 200);
        Point3D B3 = new Point3D(100, -20, 200);
        Point3D C3 = new Point3D(20, 40, 200);
        Point3D D3 = new Point3D(100, 40, 200);
        Point3D E3 = new Point3D(20, -20, 160);
        Point3D F3 = new Point3D(100, -20, 160);
        Point3D G3 = new Point3D(20, 40, 160);
        Point3D H3 = new Point3D(100, 40, 160);

        scene.add(new Wall(A3, B3, D3, C3, Color.BLUE));
        scene.add(new Wall(E3, F3, H3, G3, Color.BLUE));
        scene.add(new Wall(B3, F3, H3, D3, Color.BLUE));
        scene.add(new Wall(A3, E3, G3, C3, Color.BLUE));
        scene.add(new Wall(A3, B3, F3, E3, Color.BLUE));
        scene.add(new Wall(C3, D3, H3, G3, Color.BLUE));

        Point3D A4 = new Point3D(20, -60, 120);
        Point3D B4 = new Point3D(100, -60, 120);
        Point3D C4 = new Point3D(20, 40, 120);
        Point3D D4 = new Point3D(100, 40, 120);
        Point3D E4 = new Point3D(20, -60, 80);
        Point3D F4 = new Point3D(100, -60, 80);
        Point3D G4 = new Point3D(20, 40, 80);
        Point3D H4 = new Point3D(100, 40, 80);

        scene.add(new Wall(A4, B4, D4, C4, Color.GREEN));
        scene.add(new Wall(E4, F4, H4, G4, Color.GREEN));
        scene.add(new Wall(B4, F4, H4, D4, Color.GREEN));
        scene.add(new Wall(A4, E4, G4, C4, Color.GREEN));
        scene.add(new Wall(A4, B4, F4, E4, Color.GREEN));
        scene.add(new Wall(C4, D4, H4, G4, Color.GREEN));

//        Point3D p1A = new Point3D(-35.0, -10.0, 125.0);
//        Point3D p1B = new Point3D(-25.0, -10.0, 125.0);
//        Point3D p1C = new Point3D(-25.0, -10.0, 133.0);
//        Point3D p1D = new Point3D(-35.0, -10.0, 133.0);
//        Point3D p1E = new Point3D(-35.0, 25.0, 125.0);
//        Point3D p1F = new Point3D(-30.0, 25.0, 125.0);
//        Point3D p1G = new Point3D(-30.0, 25.0, 133.0);
//        Point3D p1H = new Point3D(-35.0, 25.0, 133.0);
//
//        Point3D p1A2 = new Point3D(-15.0, -10.0, 125.0);
//        Point3D p1B2 = new Point3D(-10.0, -10.0, 125.0);
//        Point3D p1C2 = new Point3D(-10.0, -10.0, 133.0);
//        Point3D p1D2 = new Point3D(-15.0, -10.0, 133.0);
//        Point3D p1E2 = new Point3D(-15.0, 25.0, 125.0);
//        Point3D p1F2 = new Point3D(-10.0, 25.0, 125.0);
//        Point3D p1G2 = new Point3D(-10.0, 25.0, 133.0);
//        Point3D p1H2 = new Point3D(-15.0, 25.0, 133.0);
//
//        Point3D p1A3 = new Point3D(-15.0, -10.0, 100.0);
//        Point3D p1B3 = new Point3D(-10.0, -10.0, 100.0);
//        Point3D p1C3 = new Point3D(-10.0, -10.0, 80.0);
//        Point3D p1D3 = new Point3D(-15.0, -10.0, 80.0);
//        Point3D p1E3 = new Point3D(-15.0, 25.0, 100.0);
//        Point3D p1F3 = new Point3D(-10.0, 25.0, 100.0);
//        Point3D p1G3 = new Point3D(-10.0, 25.0, 80.0);
//        Point3D p1H3 = new Point3D(-15.0, 25.0, 80.0);
//
//        Point3D p1A4 = new Point3D(-35.0, -10.0, 100.0);
//        Point3D p1B4 = new Point3D(-30.0, -10.0, 100.0);
//        Point3D p1C4 = new Point3D(-30.0, -10.0, 80.0);
//        Point3D p1D4 = new Point3D(-35.0, -10.0, 80.0);
//        Point3D p1E4 = new Point3D(-35.0, 25.0, 100.0);
//        Point3D p1F4 = new Point3D(-30.0, 25.0, 100.0);
//        Point3D p1G4 = new Point3D(-30.0, 25.0, 80.0);
//        Point3D p1H4 = new Point3D(-35.0, 25.0, 80.0);
//
//        Point3D p1A5 = new Point3D(-35.0, -40.0, 140.0);
//        Point3D p1B5 = new Point3D(-30.0, -40.0, 140.0);
//        Point3D p1C5 = new Point3D(-30.0, -40.0, 160.0);
//        Point3D p1D5 = new Point3D(-35.0, -40.0, 160.0);
//        Point3D p1E5 = new Point3D(-35.0, 25.0, 140.0);
//        Point3D p1F5 = new Point3D(-30.0, 25.0, 140.0);
//        Point3D p1G5 = new Point3D(-30.0, 25.0, 160.0);
//        Point3D p1H5 = new Point3D(-35.0, 25.0, 160.0);
//
//        scene.add(new Vector3D(p1A, p1B));
//        scene.add(new Vector3D(p1B, p1C));
//        scene.add(new Vector3D(p1C, p1D));
//        scene.add(new Vector3D(p1D, p1A));
//        scene.add(new Vector3D(p1E, p1F));
//        scene.add(new Vector3D(p1F, p1G));
//        scene.add(new Vector3D(p1G, p1H));
//        scene.add(new Vector3D(p1H, p1E));
//        scene.add(new Vector3D(p1A, p1E));
//        scene.add(new Vector3D(p1D, p1H));
//        scene.add(new Vector3D(p1B, p1F));
//        scene.add(new Vector3D(p1C, p1G));
//
//        scene.add(new Vector3D(p1A2, p1B2));
//        scene.add(new Vector3D(p1B2, p1C2));
//        scene.add(new Vector3D(p1C2, p1D2));
//        scene.add(new Vector3D(p1D2, p1A2));
//        scene.add(new Vector3D(p1E2, p1F2));
//        scene.add(new Vector3D(p1F2, p1G2));
//        scene.add(new Vector3D(p1G2, p1H2));
//        scene.add(new Vector3D(p1H2, p1E2));
//        scene.add(new Vector3D(p1A2, p1E2));
//        scene.add(new Vector3D(p1D2, p1H2));
//        scene.add(new Vector3D(p1B2, p1F2));
//        scene.add(new Vector3D(p1C2, p1G2));
//
//        scene.add(new Vector3D(p1A3, p1B3));
//        scene.add(new Vector3D(p1B3, p1C3));
//        scene.add(new Vector3D(p1C3, p1D3));
//        scene.add(new Vector3D(p1D3, p1A3));
//        scene.add(new Vector3D(p1E3, p1F3));
//        scene.add(new Vector3D(p1F3, p1G3));
//        scene.add(new Vector3D(p1G3, p1H3));
//        scene.add(new Vector3D(p1H3, p1E3));
//        scene.add(new Vector3D(p1A3, p1E3));
//        scene.add(new Vector3D(p1D3, p1H3));
//        scene.add(new Vector3D(p1B3, p1F3));
//        scene.add(new Vector3D(p1C3, p1G3));
//
//        scene.add(new Vector3D(p1A4, p1B4));
//        scene.add(new Vector3D(p1B4, p1C4));
//        scene.add(new Vector3D(p1C4, p1D4));
//        scene.add(new Vector3D(p1D4, p1A4));
//        scene.add(new Vector3D(p1E4, p1F4));
//        scene.add(new Vector3D(p1F4, p1G4));
//        scene.add(new Vector3D(p1G4, p1H4));
//        scene.add(new Vector3D(p1H4, p1E4));
//        scene.add(new Vector3D(p1A4, p1E4));
//        scene.add(new Vector3D(p1D4, p1H4));
//        scene.add(new Vector3D(p1B4, p1F4));
//        scene.add(new Vector3D(p1C4, p1G4));
//
//        scene.add(new Vector3D(p1A5, p1B5));
//        scene.add(new Vector3D(p1B5, p1C5));
//        scene.add(new Vector3D(p1C5, p1D5));
//        scene.add(new Vector3D(p1D5, p1A5));
//        scene.add(new Vector3D(p1E5, p1F5));
//        scene.add(new Vector3D(p1F5, p1G5));
//        scene.add(new Vector3D(p1G5, p1H5));
//        scene.add(new Vector3D(p1H5, p1E5));
//        scene.add(new Vector3D(p1A5, p1E5));
//        scene.add(new Vector3D(p1D5, p1H5));
//        scene.add(new Vector3D(p1B5, p1F5));
//        scene.add(new Vector3D(p1C5, p1G5));

        return scene;
    }
}
