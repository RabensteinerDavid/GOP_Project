package at.fhhgb.mtd.gop.veccy.math;

import at.fhhgb.mtd.gop.math.Vector3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VectorTest {

    @Test
    void testVector() {
        Vector3 vec = new Vector3();
        Vector3 vec1 = new Vector3(new double[]{0.0, 0.0, 1.0});
        Vector3 vec3 = new Vector3(vec);

        double[] vecValue = vec.getValues();
        double[] vecValue1 = vec1.getValues();
        double[] vecValue3 = vec3.getValues();

        assertEquals(vecValue1[0],vecValue[0]);
        assertEquals(vecValue1[1],vecValue[1]);
        assertEquals(vecValue1[2],vecValue[2]);

        assertEquals(vecValue1[0],vecValue3[0]);
        assertEquals(vecValue1[1],vecValue3[1]);
        assertEquals(vecValue1[2],vecValue3[2]);
    }
}