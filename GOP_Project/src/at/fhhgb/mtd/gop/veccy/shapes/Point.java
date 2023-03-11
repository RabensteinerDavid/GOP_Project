package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point implements DrawableShape {

    private int x;
    private int y;

    private Color fillColor = Color.RED;

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor); // Setzt die Füllfarbe
        graphicsContext.fillRect(x, y, 1, 1); // Füllt ein Rechteck
    }
}
