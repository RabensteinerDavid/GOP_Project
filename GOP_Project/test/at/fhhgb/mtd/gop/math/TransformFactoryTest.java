package at.fhhgb.mtd.gop.math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


class TransformFactoryTest {

    @Test
    void testTranslate(){
        Vector3 vec = new Vector3(new double[] {5.0, 5.0, 1.0});

        Vector3 vecE = new Vector3(new double[] {7.0, 8.0, 1.0});

        Matrix3 translation = TransformFactory.createTranslation(2, 3);
        Vector3 transformedVec = translation.mult(vec);

        double[] transformedVecValue = transformedVec.getValues();
        double[] vecEValue = vecE.getValues();

        for(int i = 0; i < vecEValue.length;i++){
            assertEquals(vecEValue[i], transformedVecValue[i]);
        }
        // transformedVec sollte nun die Werte {7.0, 8.0, 1.0} beinhalten!
    }

    @Test
    void testRotate(){
        Vector3 vec = new Vector3(new double[] {1.0, 0.0, 1.0});
        Vector3 vecE = new Vector3(new double[] {0.0, 1.0, 1.0});

        Matrix3 translation = TransformFactory.createRotation(Math.PI/2);
        Vector3 transformedVec = translation.mult(vec);

        double[] transformedVecValue = transformedVec.getValues();
        double[] vecEValue = vecE.getValues();

        assertEquals(vecEValue[0], transformedVecValue[0], 0.1);
        assertEquals(vecEValue[1], transformedVecValue[1],0.1);
        assertEquals(vecEValue[2], transformedVecValue[2],0.1);
        // transformedVec sollte nun die Werte {7.0, 8.0, 1.0} beinhalten!
    }

    @Test
    void testHorizontalMirroring(){
        Vector3 vec = new Vector3(new double[] {1.0, 1.0, 1.0});
        Vector3 vecE = new Vector3(new double[] {1.0, -1.0, 1.0});

        Matrix3 translation = TransformFactory.createHorizontalMirroring();
        Vector3 transformedVec = translation.mult(vec);

        double[] transformedVecValue = transformedVec.getValues();
        double[] vecEValue = vecE.getValues();

        assertEquals(vecEValue[0], transformedVecValue[0]);
        assertEquals(vecEValue[1], transformedVecValue[1]);
        assertEquals(vecEValue[2], transformedVecValue[2]);
    }

    @Test
    void testVerticalMirroring(){
        Vector3 vec = new Vector3(new double[] {1.0, 1.0, 1.0});
        Vector3 vecE = new Vector3(new double[] {-1.0, 1.0, 1.0});

        Matrix3 translation = TransformFactory.createVerticalMirroring();
        Vector3 transformedVec = translation.mult(vec);

        double[] transformedVecValue = transformedVec.getValues();
        double[] vecEValue = vecE.getValues();

        assertEquals(vecEValue[0], transformedVecValue[0], 0.1);
        assertEquals(vecEValue[1], transformedVecValue[1],0.1);
        assertEquals(vecEValue[2], transformedVecValue[2],0.1);
    }

    @Test
    void testScaling(){
        Vector3 vec = new Vector3(new double[] {1.0, 1.0, 1.0});
        Vector3 vecE = new Vector3(new double[] {10.0, 10.0, 1.0});

        Matrix3 translation = TransformFactory.createScaling(10,10);
        Vector3 transformedVec = translation.mult(vec);

        double[] transformedVecValue = transformedVec.getValues();
        double[] vecEValue = vecE.getValues();

        assertEquals(vecEValue[0], transformedVecValue[0]);
        assertEquals(vecEValue[1], transformedVecValue[1]);
        assertEquals(vecEValue[2], transformedVecValue[2]);
    }
}