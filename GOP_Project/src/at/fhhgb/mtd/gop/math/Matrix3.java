package at.fhhgb.mtd.gop.math;

public class Matrix3 {
    private double[][] values;

    // Initialisiert values als Einheitsmatrix
    // 1.0 0.0 0.0
    // 0.0 1.0 0.0
    // 0.0 0.0 1.0
    public Matrix3() {
        values = new double[][]{
                {1.0, 0.0, 0.0},
                {0.0, 1.0, 0.0},
                {0.0, 0.0, 1.0}
        };
    }

    // Initialisiert this.values mit dem Parameter values (kopieren Sie die Werte!)
    public Matrix3(double[][] values) {
        this.values = values;
    }

    // Initialisiert this.values mit den values aus dem Parameter matrix
    // (Tipp: Verwenden Sie this()!)
    public Matrix3(Matrix3 matrix) {
        this.values = matrix.getValues();
    }

    // Implementieren Sie eine Matrixmultiplikation und geben Sie eine neue Matrix3
    // Instanz mit dem Ergebnis zurück
    public Matrix3 mult(Matrix3 matrix) {

        //laenge des mitgegebenen arrays
        int m = matrix.values.length;

        //laenge des ersten Eintrags
        int n = values[0].length;

        //laenge des arrays
        int p = values.length;

        //new Matrix
        double[][] c = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < p; k++) {
                    sum += values[i][k] * matrix.values[k][j];
                }
                c[i][j] = sum;
            }
        }

        Matrix3 vec = new Matrix3(c);
        return vec;
    }

    // Implementieren Sie eine Multiplikation Matrix3 * Vector3 und geben Sie eine
    // neue Vector3 Instanz mit dem Ergebnis zurück
    public Vector3 mult(Vector3 vector) {

        //laenge des mitgegebenen arrays
        int m = values.length;

        //laenge des ersten Eintrags
        int n = values[0].length;

        //new matrix
        double[] c = new double[m];
        double[] vec = vector.getValues();

        for (int i = 0; i < m; i++) {
            double sum = 0.0;
            for (int j = 0; j < n; j++) {

                sum += values[i][j] * vec[j];
            }
            c[i] = sum;
        }

        Vector3 vecR = new Vector3(c);
        return vecR;
    }

    // Returniert die Instanzvariable values
    public double[][] getValues() {
        return values;
    }
}