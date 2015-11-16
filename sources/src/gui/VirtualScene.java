package gui;

import model.Point3D;
import model.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class VirtualScene {

    public static List<Vector3D> createScene(){

        ArrayList<Vector3D> scene = new ArrayList<Vector3D>();

        Point3D A1 = new Point3D(-100, -60, 200);
        Point3D B1 = new Point3D(-20, -60, 200);
        Point3D C1 = new Point3D(-100, 40, 200);
        Point3D D1 = new Point3D(-20, 40, 200);
        Point3D E1 = new Point3D(-100, -60, 160);
        Point3D F1 = new Point3D(-20, -60, 160);
        Point3D G1 = new Point3D(-100, 40, 160);
        Point3D H1 = new Point3D(-20, 40, 160);

        scene.add(new Vector3D(A1, B1));
        scene.add(new Vector3D(B1, D1));
        scene.add(new Vector3D(D1, C1));
        scene.add(new Vector3D(C1, A1));
        scene.add(new Vector3D(A1, E1));
        scene.add(new Vector3D(B1, F1));
        scene.add(new Vector3D(D1, H1));
        scene.add(new Vector3D(C1, G1));
        scene.add(new Vector3D(E1, F1));
        scene.add(new Vector3D(F1, H1));
        scene.add(new Vector3D(H1, G1));
        scene.add(new Vector3D(G1, E1));

        Point3D A2 = new Point3D(-100, -60, 120);
        Point3D B2 = new Point3D(-20, -60, 120);
        Point3D C2 = new Point3D(-100, 40, 120);
        Point3D D2 = new Point3D(-20, 40, 120);
        Point3D E2 = new Point3D(-100, -60, 80);
        Point3D F2 = new Point3D(-20, -60, 80);
        Point3D G2 = new Point3D(-100, 40, 80);
        Point3D H2 = new Point3D(-20, 40, 80);

        scene.add(new Vector3D(A2, B2));
        scene.add(new Vector3D(B2, D2));
        scene.add(new Vector3D(D2, C2));
        scene.add(new Vector3D(C2, A2));
        scene.add(new Vector3D(A2, E2));
        scene.add(new Vector3D(B2, F2));
        scene.add(new Vector3D(D2, H2));
        scene.add(new Vector3D(C2, G2));
        scene.add(new Vector3D(E2, F2));
        scene.add(new Vector3D(F2, H2));
        scene.add(new Vector3D(H2, G2));
        scene.add(new Vector3D(G2, E2));

        Point3D A3 = new Point3D(20, -60, 200);
        Point3D B3 = new Point3D(100, -60, 200);
        Point3D C3 = new Point3D(20, 40, 200);
        Point3D D3 = new Point3D(100, 40, 200);
        Point3D E3 = new Point3D(20, -60, 160);
        Point3D F3 = new Point3D(100, -60, 160);
        Point3D G3 = new Point3D(20, 40, 160);
        Point3D H3 = new Point3D(100, 40, 160);

        scene.add(new Vector3D(A3, B3));
        scene.add(new Vector3D(B3, D3));
        scene.add(new Vector3D(D3, C3));
        scene.add(new Vector3D(C3, A3));
        scene.add(new Vector3D(A3, E3));
        scene.add(new Vector3D(B3, F3));
        scene.add(new Vector3D(D3, H3));
        scene.add(new Vector3D(C3, G3));
        scene.add(new Vector3D(E3, F3));
        scene.add(new Vector3D(F3, H3));
        scene.add(new Vector3D(H3, G3));
        scene.add(new Vector3D(G3, E3));

        Point3D A4 = new Point3D(20, -60, 120);
        Point3D B4 = new Point3D(100, -60, 120);
        Point3D C4 = new Point3D(20, 40, 120);
        Point3D D4 = new Point3D(100, 40, 120);
        Point3D E4 = new Point3D(20, -60, 80);
        Point3D F4 = new Point3D(100, -60, 80);
        Point3D G4 = new Point3D(20, 40, 80);
        Point3D H4 = new Point3D(100, 40, 80);

        scene.add(new Vector3D(A4, B4));
        scene.add(new Vector3D(B4, D4));
        scene.add(new Vector3D(D4, C4));
        scene.add(new Vector3D(C4, A4));
        scene.add(new Vector3D(A4, E4));
        scene.add(new Vector3D(B4, F4));
        scene.add(new Vector3D(D4, H4));
        scene.add(new Vector3D(C4, G4));
        scene.add(new Vector3D(E4, F4));
        scene.add(new Vector3D(F4, H4));
        scene.add(new Vector3D(H4, G4));
        scene.add(new Vector3D(G4, E4));

        return scene;
    }
}
