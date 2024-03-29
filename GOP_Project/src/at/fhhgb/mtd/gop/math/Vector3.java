package at.fhhgb.mtd.gop.math;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class Vector3 {
    private double[] values;

    // Initialisiert values mit { 0.0, 0.0, 1.0 }
    public Vector3() {
        values = new double[]
                {0.0, 0.0, 1.0};
    }

    public Vector3(double x, double y) {
        this.values = new double[] {x, y, 1};
    }

    // Initialisiert this.values mit dem Parameter values (kopieren Sie die Werte!)
    public Vector3(double[] values) {
        this.values = values;
    }

    // Initialisiert this.values mit den values aus dem Parameter vector
    // (verwenden Sie this()!)
    public Vector3(Vector3 vector) {
        this.values = vector.getValues();
    }

    // Returniert die Instanzvariable values
    public double[] getValues() {
        return values;
    }
}
