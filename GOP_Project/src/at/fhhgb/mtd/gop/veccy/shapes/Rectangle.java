package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Rectangle implements DrawableShape {
    private int x;
    private int y;
    private int width;
    private int height;
    private double rotate = 0;

    private Color fillColor = Color.RED;
    private Color strokeColor = Color.BLUE;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height, double rotate) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotate = rotate;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
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

    @Override
    public void draw(GraphicsContext graphicsContext) {

        double rotationCenterX = (x + width) / 2;
        double rotationCenterY = (y + height) / 2;
        graphicsContext.transform(new Affine(new Rotate(rotate, rotationCenterX, rotationCenterY)));

        graphicsContext.setFill(fillColor); // Setzt die Füllfarbe
        graphicsContext.setStroke(strokeColor); // Setzt die Randfarbe
        graphicsContext.fillRect(x, y, width, height); // Füllt ein Rechteck
        graphicsContext.strokeRect(x, y, width, height); // Rand eines Rechtecks

        graphicsContext.transform(new Affine(new Rotate(-rotate, rotationCenterX, rotationCenterY)));
    }
}




