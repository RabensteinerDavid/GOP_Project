package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements DrawableShape {
    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;

    protected boolean mirror = false;

    public Shape(double x, double y) {
        position = new Vector3(new double[]{x, y, 1});
    }

    // Returniert die x Koordinate von 'position'
    public int getX() {
        return (int) position.getValues()[0];
    }

    // Returniert die y Koordinate von 'position'
    public int getY() {
        return (int) position.getValues()[1];
    }

    // Setzt die 'fillColor' Instanzvariable
    public void setFillColor(Color c) {
        fillColor = c;
    }

    // Setzt die 'strokeColor' Instanzvariable
    public void setStrokeColor(Color c) {
        strokeColor = c;
    }

    // Setzt die 'transform' Instanzvariable
    public void setTransform(Matrix3 transform) {
        this.transform = transform;
    }

    public void setTransform(Matrix3 transform,boolean mirror) {
        this.transform = transform;
        this.mirror = mirror;
    }

    public Vector3[] calculateTranslation(Vector3[] coordinates, int width, int height) {

        int deltaX = getX() + width / 2;
        int deltaY = getY() + height / 2;

        Matrix3 translToCenter = TransformFactory.createTranslation(-deltaX, -deltaY);
        Matrix3 translBack = TransformFactory.createTranslation(deltaX, deltaY);

        if (this.mirror) {
            translToCenter = TransformFactory.createTranslation(-getX(), -getY());
            translBack = TransformFactory.createTranslation(getX(), getY());
        }

        Vector3[] translateVectors = new Vector3[coordinates.length];

        if (this.transform != null) {
            for (int i = 0; i < coordinates.length; i++) {
                translateVectors[i] = translBack
                        .mult(this.transform)
                        .mult(translToCenter)
                        .mult(coordinates[i]);
            }
            return translateVectors;
        }

        return coordinates;
    }

    // Setzt die fillColor und strokeColor am ‚graphicsContext‘
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
    }
}
