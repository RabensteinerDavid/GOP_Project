package at.fhhgb.mtd.gop.veccy.shapes;

public class Circle {

    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int area() {
        return (int) (Math.PI * radius * radius);
    }

    public Rectangle boundingBox() {
        return new Rectangle(x, y, radius*2,radius*2);
    }
}
