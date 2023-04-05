package at.fhhgb.mtd.gop.math;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.Vector3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatrixTest {

    @Test
    void testMatrix() {
        Matrix3 mat = new Matrix3();
        Matrix3 mat1 = new Matrix3(new double[][]{
                {1.0, 0.0, 0.0},
                {0.0, 1.0, 0.0},
                {0.0, 0.0, 1.0}
        });
        Matrix3 mat3 = new Matrix3(mat1);

        double[][] vecValue = mat.getValues();
        double[][] vecValue1 = mat1.getValues();
        double[][] vecValue3 = mat3.getValues();

        assertEquals(vecValue1[0][0], vecValue[0][0]);
        assertEquals(vecValue1[1][1], vecValue[1][1]);
        assertEquals(vecValue1[2][2], vecValue[2][2]);

        assertEquals(vecValue1[0][0], vecValue3[0][0]);
        assertEquals(vecValue1[1][1], vecValue3[1][1]);
        assertEquals(vecValue1[2][2], vecValue3[2][2]);

        assertTrue(Arrays.deepEquals(mat.getValues(), mat1.getValues()));

    }

    @Test
    void testMatrixMult() {
        Matrix3 mat = new Matrix3();
        Matrix3 mat1 = new Matrix3(new double[][]{
                {14.4, 0.27, 7.0},
                {86.4, 5.3, 6.7},
                {2.0, 6.9, 1.0}
        });

        Matrix3 mat4 = new Matrix3(new double[][]{
                {14.4, 0.27, 7.0},
                {86.4, 5.3, 6.7},
                {2.0, 6.9, 1.0}
        });

        Matrix3 mat5 = new Matrix3(new double[][]{
                {14.4, 0.27, 7.0},
                {86.4, 5.3, 6.7},
                {2.0, 6.9, 1.0}
        });

        Matrix3 mat6 = new Matrix3(new double[][]{

                {244.68800000000002, 53.61900000000001, 109.609},
                {1715.4800000000002, 97.64800000000001, 647.0100000000001},
                {626.96, 44.01, 61.230000000000004}

        });

        assertTrue(Arrays.deepEquals(mat4.getValues(), mat.mult(mat5).getValues()));
        assertTrue(Arrays.deepEquals(mat6.getValues(), mat1.mult(mat5).getValues()));
    }

    @Test
    void testMatrixMultVec(){
        Vector3 vec1 = new Vector3(new double[]{5.8, 4.3, 6.2});
        Vector3 vec2 = new Vector3(new double[]{128.081, 565.4499999999999, 47.470000000000006});

        Matrix3 mat5 = new Matrix3(new double[][]{
                {14.4, 0.27, 7.0},
                {86.4, 5.3, 6.7},
                {2.0, 6.9, 1.0}
        });

        double[] vecErg = vec2.getValues();
        double[] matrixMultErg = mat5.mult(vec1).getValues();

        assertEquals(vecErg[0], matrixMultErg[0]);
        assertEquals(vecErg[1], matrixMultErg[1]);
        assertEquals(vecErg[2], matrixMultErg[2]);
    }

}