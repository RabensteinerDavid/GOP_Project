package at.fhhgb.mtd.gop.veccy.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testAreaCer() {
        Circle cer = new Circle(0,0,42);

        assertEquals(5541,cer.area());
        assertNotEquals(123,cer.area());
    }

    @Test
    void testBoundingCer() {
        Circle cer = new Circle(0,0,2);

        assertEquals(16,cer.boundingBox().area());
    }

    @Test
    void testOverlapCer() {
        Circle cir = new Circle(0,0,42);
        Circle cir1 = new Circle(0,0,42);

        assertTrue(cir.boundingBox().isOverlapping(cir1.boundingBox()));
        assertTrue(cir1.boundingBox().isOverlapping(cir.boundingBox()));

        cir = new Circle(20,0,12);
        cir1 = new Circle(0,0,5);

        assertFalse(cir1.boundingBox().isOverlapping(cir.boundingBox()));
    }
}