package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


public abstract class Shape implements DrawableShape {
    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;
    protected boolean mirror = false;
    private boolean isSelected = false;
    private int width, height;

    public Shape(double x, double y) {
        position = new Vector3(new double[]{x, y, 1});
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Returniert die x Koordinate von 'position'
    public int getX() {
        return (int) position.getValues()[0];
    }

    // Setzen die jeweiligen x/y Werte auf 'position'
    public void setX(int x) {
        position = new Vector3(new double[]{x, position.getValues()[1], 1});
    }

    // Returniert die y Koordinate von 'position'
    public int getY() {
        return (int) position.getValues()[1];
    }

    public void setY(int y) {
        position = new Vector3(new double[]{position.getValues()[0], y, 1});
    }

    // Setzt die 'fillColor' Instanzvariable
    public void setFillColor(Color c) {
        fillColor = c;
    }

    // Setzt die 'strokeColor' Instanzvariable
    public void setStrokeColor(Color c) {
        strokeColor = c;
    }

    public Matrix3 getTransform() {
        return transform;
    }

    // Setzt die 'transform' Instanzvariable
    public void setTransform(Matrix3 transform) {
        this.transform = transform;
    }

    public void setTransform(Matrix3 transform, boolean mirror) {
        this.transform = transform;
        this.mirror = mirror;
    }

    // Getter/Setter für isSelected
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract double[][] getCoordinates();

    // Berechnet die Bounding Box via der Koordinaten von getCoordinates().
    // Betrachten Sie die Extremwerte um die korrekten Dimensionen zu
    // berechnen!
    public Rectangle getBoundingBox() {
        double[][] cords = getCoordinates();

        double xMin = cords[0][0], xMax = cords[0][0], yMin = cords[1][0], yMax = cords[1][0];

        for (int i = 0; i < cords[0].length; i++) {
            xMin = Math.min(xMin, cords[0][i]);
            xMax = Math.max(xMax, cords[0][i]);

            yMin = Math.min(yMin, cords[1][i]);
            yMax = Math.max(yMax, cords[1][i]);
        }

        System.out.println("----------------------------");
        System.out.println("xMin " + (xMin));
        System.out.println("xMax " + (xMax));
        System.out.println("yMin " + (yMin));
        System.out.println("yMax " + (yMax));
        return new Rectangle((int) xMin, (int) yMin, (int) Math.abs(xMin - xMax), (int) Math.abs(yMin - yMax));
    }

    public Vector3[] calculateTranslation(Vector3[] coordinates, int width, int height, String name) {

        int deltaX = getX() + (width / 2);
        int deltaY = getY() + (height / 2);

        Matrix3 translToCenter = TransformFactory.createTranslation(-deltaX, -deltaY);
        Matrix3 translBack = TransformFactory.createTranslation(deltaX, deltaY);

        if (this.mirror) {
            translToCenter = TransformFactory.createTranslation(-getX(), -getY());
            translBack = TransformFactory.createTranslation(getX(), getY());
        }

        if (name.equals("Circle") || name.equals("Rectangle") || name.equals("Polygon") || name.equals("Path")) {
            translToCenter = TransformFactory.createTranslation(
                    (this.width / 2) - this.width - this.getX(), (this.height / 2) - this.height - this.getY());

            translBack = TransformFactory.createTranslation(
                    (this.width / 2) + this.getX(), (this.height / 2) + this.getY());
        }

        Vector3[] translateVectors = new Vector3[coordinates.length];

        if (this.transform != null) {

            if (name.equals("Point")) {
                this.setX((int) (this.getX() + transform.getValues()[0][2]));
                this.setY((int) (this.getY() + transform.getValues()[1][2]));
            }
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

    @Override
    public void draw(GraphicsContext graphicsContext) {
        // Zeichne eine Bounding Box, sofern das Shape selektiert ist
        if (isSelected()) {
            Rectangle bb = getBoundingBox();
            graphicsContext.setStroke(Color.GREEN);
            graphicsContext.strokeRect(bb.getX(), bb.getY(),
                    bb.getWidth(), bb.getHeight());
        }
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);
    }
}