package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Circle implements DrawableShape {

    private int x;
    private int y;
    private int radius;
    private int radiusX = 0;
    private int radiusY = 0;

    private int rotate = 0;

    private Color fillColor = Color.RED;
    private Color strokeColor = Color.BLUE;

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

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(int x, int y, int radiusX, int radiusY) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Circle(int x, int y, int radiusX, int radiusY,int rotate) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.rotate = rotate;
    }

    public int area() {
        return (int) (Math.PI * radius * radius);
    }

    public Rectangle boundingBox() {
        return new Rectangle(x-radius, y-radius, radius*2,radius*2);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        double rotationCenterX = (x + radiusX) / 2;
        double rotationCenterY = (y + radiusY) / 2;
        graphicsContext.transform(new Affine(new Rotate(rotate, rotationCenterX, rotationCenterY)));


        graphicsContext.setFill(fillColor); // Setzt die Füllfarbe
        graphicsContext.setStroke(strokeColor); // Setzt die Randfarbe

        if(radiusX!=0){
            graphicsContext.fillOval(x, y, radiusX, radiusY); // Füllt ein Rechteck
            graphicsContext.strokeOval(x, y, radiusX, radiusY); // Rand eines Rechtecks

        }
        else{
            graphicsContext.fillOval(x, y, radius, radius); // Füllt ein Rechteck
            graphicsContext.strokeOval(x, y, radius, radius); // Rand eines Rechtecks
        }
        graphicsContext.transform(new Affine(new Rotate(-rotate, rotationCenterX, rotationCenterY)));
    }
}
