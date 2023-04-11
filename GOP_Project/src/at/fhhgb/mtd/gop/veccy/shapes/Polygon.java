package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import java.util.LinkedList;

public class Polygon extends Shape {
    LinkedList<Vector3> polygonVector = new LinkedList<>();

    public Polygon(double x, double y) {
        super(x, y);
        polygonVector.add(position);
    }

    public double area(Polygon poly) {
        int numPoints = polygonVector.size();
        double area = 0.0;

        // Schleife, um die Fläche für jedes Dreieck im Polygon zu berechnen
        for (int i = 0; i < numPoints; i++) {
            int j = (i + 1) % numPoints;
            area +=  polygonVector.get(i).getValues()[0] * polygonVector.get(j).getValues()[1];
            area -= polygonVector.get(j).getValues()[0] * polygonVector.get(i).getValues()[1];
        }

        area /= 2.0;

        return Math.abs(area);
    }

    public void addVector(double x,double y) {
        Vector3 vec = new Vector3(x, y);
        polygonVector.add(vec);
    }

    public Rectangle boundingBox() {

        double minX = Double.POSITIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;

        for (Vector3 v : polygonVector) {
            double x = v.getValues()[0];
            double y = v.getValues()[1];
            if (x < minX) {
                minX = x;
            }
            if (x > maxX) {
                maxX = x;
            }
            if (y < minY) {
                minY = y;
            }
            if (y > maxY) {
                maxY = y;
            }
        }
        return new Rectangle((int) Math.floor(minX), (int) Math.floor(minY),
                (int) Math.ceil(maxX - minX), (int) Math.ceil(maxY - minY));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);

        double[] x = new double[polygonVector.size()];
        double[] y = new double[polygonVector.size()];

        for (int i = 0; i < polygonVector.size();i++) {
            x[i] = polygonVector.get(i).getValues()[0];
            y[i] = polygonVector.get(i).getValues()[1];
        }

        graphicsContext.fillPolygon(x, y, x.length);
        graphicsContext.strokePolygon(x, y, x.length);
    }
}
