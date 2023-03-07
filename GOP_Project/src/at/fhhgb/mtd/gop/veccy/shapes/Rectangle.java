package at.fhhgb.mtd.gop.veccy.shapes;

public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int area() {
        return this.width * this.height;
    }

    public Rectangle boundingBox() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isOverlapping(Rectangle other) {
        //horizontal
        if ((x <= other.x + other.width) && (x + width >= other.x)) {
        //horizontal
            if ((y <= other.y + other.height) && (y + height >= other.y)) {
                return true;
            }
        }
        return false;
    }
}




