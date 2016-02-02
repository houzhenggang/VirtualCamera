package pl.edu.pw.ee.engine;

import pl.edu.pw.ee.engine.geometry.Point3D;
import pl.edu.pw.ee.engine.geometry.Sphere;
import pl.edu.pw.ee.engine.setting.MaterialType;
import pl.edu.pw.ee.engine.setting.Settings;

/**

 */
public class Engine implements CameraModifier {

    private ChangeNotifier changeNotifier = new ChangeNotifier();
    private Point3D sourcePoint;
    private Point3D observatoryPoint;
    private Point3D centerPointOfSphere;
    private Sphere sphere;
    private MaterialType materialType;
    private ScreenBuffer screenBuffer;

    public Engine() {
        screenBuffer = new ScreenBuffer(Settings.DIMENSION);
        centerPointOfSphere = new Point3D(Settings.SPHERE_CENTER_POINT);
        observatoryPoint = new Point3D(Settings.OBSERVATION_POINT);
        sphere = new Sphere(centerPointOfSphere, Settings.SPHERE_RADIUS);
        resetToDefault();
        projection();
    }

    public ChangeNotifier getChangeNotifier() {
        return changeNotifier;
    }

    public void projection() {
        changeNotifier.notifyThatChangeOccurs(
                new Phong(observatoryPoint, sourcePoint, materialType, sphere).computeScreen(screenBuffer));
    }

    @Override
    public void resetToDefault() {
        sourcePoint = new Point3D(Settings.SOURCE_POINT);
        materialType = Settings.SPHERE_DEFAULT_MATERIAL;
    }

    @Override
    public void makeMetalSphere() {
        materialType = MaterialType.METAL;
    }

    @Override
    public void makeMatSphere() {
        materialType = MaterialType.MAT;
    }

    @Override
    public void makeWoodSphere() {
        materialType = MaterialType.WOOD;
    }

    @Override
    public void makePlasticSphere() {
        materialType = MaterialType.PLASTIC;
    }

    private void translateX(double step) {
        sourcePoint.x += step;
        logSourcePosition();
    }

    private void translateY(double step) {
        sourcePoint.y += step;
        logSourcePosition();
    }

    private void translateZ(double step) {
        sourcePoint.z += step;
        logSourcePosition();
    }

    private void logSourcePosition() {
        System.out.println(String.format("Source point: x=%f, y=%f, z=%f", sourcePoint.x, sourcePoint.y, sourcePoint.z));

    }

}
