package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

class PointTest {

    @Test
    void testPoint() {
        Point pt = new Point(4,4);
        assertEquals(4,pt.getX());
        assertEquals(4,pt.getY());
    }
}