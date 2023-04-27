package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


class LineTest {

    @Test
    void testAreaBoundingLineHor() {
        Line line = new Line(4,4,6,4);
        assertEquals(0,line.boundingBox().area());

        line = new Line(4,4,6,6);
        assertEquals(4,line.boundingBox().area());

        line = new Line(4,4,4,4);
        assertEquals(0,line.boundingBox().area());
    }

    @Test
    void testAreaBoundingLine() {
        Line line = new Line(4,4,6,6);
        assertEquals(4,line.boundingBox().area());

        line = new Line(6,6,4,4);
        assertEquals(4,line.boundingBox().area());
    }

    @Test
    void testAreaBoundingLineOverlapp() {
        Line line = new Line(4,4,6,6);
        Line line1 = new Line(4,4,5,5);
        Line line2 = new Line(7,7,7,7);
        assertTrue(line.boundingBox().isOverlapping(line1.boundingBox()));
        assertFalse(line.boundingBox().isOverlapping(line2.boundingBox()));
    }
}