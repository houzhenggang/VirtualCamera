package pl.edu.pw.ee.engine;

public interface CameraModifier {

    void projection();

    void resetToDefault();

    void makeMetalSphere();

    void makeMatSphere();

    void makeWoodSphere();

    void makePlasticSphere();

}
