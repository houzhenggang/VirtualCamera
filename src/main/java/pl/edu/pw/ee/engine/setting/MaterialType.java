package pl.edu.pw.ee.engine.setting;

/**

 */
public enum MaterialType {

    METAL(0.4, 0.6, 75),
    MAT(0.9, 0.01, 25),
    PLASTIC(0.9, 0.2, 50),
    WOOD(0, 1, 200);

    private double kd;
    private double ks;
    private double n;

    MaterialType(double kd, double ks, double n) {
        this.kd = kd;
        this.ks = ks;
        this.n = n;
    }

    public double getKd() {
        return kd;
    }

    public double getKs() {
        return ks;
    }

    public double getN() {
        return n;
    }
}
