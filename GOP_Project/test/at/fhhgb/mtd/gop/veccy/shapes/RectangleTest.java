package at.fhhgb.mtd.gop.veccy.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void testAreaRec() {
        Rectangle rec = new Rectangle(0,0,42,12);

        assertEquals(504,rec.area());
        assertNotEquals(123,rec.area());
    }

    @Test
    void testBoundingBoxRec(){
        Rectangle rec = new Rectangle(0,0,42,12);

        assertEquals(rec.area(),rec.boundingBox().area());
    }

    @Test
    void testOverlapRec() {
        Rectangle rec = new Rectangle(0,0,42,12);
        Rectangle rec2 = new Rectangle(0,0,20,5);

        assertTrue(rec.isOverlapping(rec2));
        assertTrue(rec2.isOverlapping(rec));

        rec = new Rectangle(30,0,42,12);
        rec2 = new Rectangle(0,0,20,5);

        assertFalse(rec.isOverlapping(rec2));
        assertFalse(rec2.isOverlapping(rec));

        rec = new Rectangle(10,10,20,20);
        rec2 = new Rectangle(15,5,5,20);

        assertTrue(rec.isOverlapping(rec2));
        assertTrue(rec2.isOverlapping(rec));

        rec = new Rectangle(10,10,20,20);
        rec2 = new Rectangle(20,22,20,5);

        assertTrue(rec.isOverlapping(rec2));
        assertTrue(rec2.isOverlapping(rec));

        rec = new Rectangle(10,10,20,20);
        rec2 = new Rectangle(15,20,5,20);

        assertTrue(rec.isOverlapping(rec2));
        assertTrue(rec2.isOverlapping(rec));

        rec = new Rectangle(10,10,20,20);
        rec2 = new Rectangle(0,22,20,5);

        assertTrue(rec.isOverlapping(rec2));
        assertTrue(rec2.isOverlapping(rec));

        rec = new Rectangle(20,20,30,30);
        rec2 = new Rectangle(30,30,10,10);

        assertTrue(rec.isOverlapping(rec2));
        assertTrue(rec2.isOverlapping(rec));
    }
}