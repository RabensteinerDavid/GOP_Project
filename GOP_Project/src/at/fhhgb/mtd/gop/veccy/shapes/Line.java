package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1,y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setX2Y2(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle boundingBox() {

        int xMin = Math.min(super.getX(), x2);
        int xMax = Math.max(super.getX(), x2);

        int yMin = Math.min(super.getY(), y2);
        int yMax = Math.max(super.getY(), y2);

        return new Rectangle(xMin, yMin, Math.abs(xMax - xMin), Math.abs(yMax - yMin));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.strokeLine(super.getX(), super.getY(), x2, y2); // Füllt ein Rechteck
    }
}
