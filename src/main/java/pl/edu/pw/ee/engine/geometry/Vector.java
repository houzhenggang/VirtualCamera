package pl.edu.pw.ee.engine.geometry;

/**

 */
public class Vector {

    public double x;
    public double y;
    public double z;

    public Vector() {

    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Point3D start, Point3D end) {
        x = end.x - start.x;
        y = end.y - start.y;
        z = end.z - start.z;
    }

    public Vector(Vector vector) {
        x = vector.x;
        y = vector.y;
        z = vector.z;
    }

    public Vector normalize() {
        double length = Math.sqrt(x * x + y * y + z * z);
        Vector result = new Vector();
        result.x = x / length;
        result.y = y / length;
        result.z = z / length;
        return result;
    }

    public Vector add(Vector addend) {
        Vector result = new Vector();
        result.x = x + addend.x;
        result.y = y + addend.y;
        result.z = z + addend.z;
        return result;
    }

    public Vector subtract(Vector subtrahend) {
        Vector result = new Vector();
        result.x = x - subtrahend.x;
        result.y = y - subtrahend.y;
        result.z = z - subtrahend.z;
        return result;
    }

    public Vector multiply(double multiplier) {
        Vector result = new Vector();
        result.x *= multiplier;
        result.y *= multiplier;
        result.z *= multiplier;
        return result;
    }

    public double scalarMultiplication(Vector b) {
        return x * b.x +
                y * b.y +
                z * b.z;
    }

    public double cosBetween(Vector b) {
        double length = Math.sqrt(Math.pow(x, 2) +
                Math.pow(y, 2) +
                Math.pow(z, 2));
        double bLength = Math.sqrt(Math.pow(b.x, 2) +
                Math.pow(b.y, 2) +
                Math.pow(b.z, 2));
        return scalarMultiplication(b) / (length * bLength);
    }

    public Vector reverse() {
        return new Vector(-x, -y, -z);
    }

    // Odbicie idealne czyli wektor symetryczny V względem N. Wzór to R = 2(N.*L)N - L
    public Vector reflection(Vector N) {
        Vector R = new Vector();
        double sc = scalarMultiplication(N);
        R.x = 2 * sc * N.x - x;
        R.y = 2 * sc * N.y - y;
        R.z = 2 * sc * N.z - z;
        return R;
    }

    public double length() {
        return Math.sqrt(scalarMultiplication(this));
    }

}
