package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements DrawableShape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color strokeColor = Color.RED;

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle boundingBox() {
        if ((x1 < x2) && (y1 > y2)) {
            return new Rectangle(x1, y2, x2 - x1, y2 - y1);
        } else if ((x1 > x2) && (y1 < y2)) {
            return new Rectangle(x2, y1, x2 - x1, y2 - y1);
        } else if ((x1 < x2) && (y1 < y2)) {
            return new Rectangle(x1, y1, x2 - x1, y2 - y1);
        } else if ((x1 > x2) && (y1 > y2)) {
            return new Rectangle(x2, y2, x2 - x1, y2 - y1);
        } else {
            return new Rectangle(x1, y1, x2 - x1, y2 - y1);
        }
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(strokeColor); // Setzt die Randfarbe
        graphicsContext.strokeLine(x1,x2, y1,y2); // Füllt ein Rechteck
    }
}
