package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public String getName(){
        return "Circle";
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int area() {
        return (int) (Math.PI * radius * radius);
    }

    public Rectangle boundingBox() {
        return new Rectangle(super.getX(), super.getY(), radius * 2, radius * 2);
    }

    public double[][] getCoordinates() {

        int numberPoints = 255;

        Vector3[] ptV1 = new Vector3[numberPoints];

        double angleIncrement = 2 * Math.PI / numberPoints;

        for (int i = 0; i < numberPoints; i++) {

            double angle = i * angleIncrement;
            double x = super.getX() + radius * Math.cos(angle);
            double y = super.getY() + radius  * Math.sin(angle);

            ptV1[i] = new Vector3(new double[]{x, y, 1});
        }

        Vector3[] trVec = calculateTranslation(ptV1, radius*2, radius*2, getName());

        double[][] coordinates = new double[3][trVec.length];

        for (int j = 0; j < trVec.length; j++) {
            coordinates[0][j] = trVec[j].getValues()[0];
            coordinates[1][j] = trVec[j].getValues()[1];
            coordinates[2][j] = trVec[j].getValues()[2];
        }
        return coordinates;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
