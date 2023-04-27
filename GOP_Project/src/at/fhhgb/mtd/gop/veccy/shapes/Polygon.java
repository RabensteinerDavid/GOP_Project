package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import java.util.LinkedList;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


public class Polygon extends Shape {
    LinkedList<Vector3> polygonVector = new LinkedList<>();
    Vector3[] vecs;
    private int width;
    private int height;


    public Polygon(double x, double y) {
        super(x, y);
        polygonVector.add(position);
    }

    public String getName(){
        return "Polygon";
    }

    public void setHeiWid(int width, int height) {
        this.height = height;
        this.width = width;
    }


    public double[][] getCoordinates() {
        Vector3[] vecs = new Vector3[polygonVector.size()];
        for (int i = 0; i < polygonVector.size(); i++) {
            vecs[i] = polygonVector.get(i);
        }

        double xMax =vecs[0].getValues()[0], xMin=vecs[0].getValues()[0] ,yMax=vecs[0].getValues()[1] ,yMin= vecs[0].getValues()[1];

        for (int i = 0; i < polygonVector.size(); i++) {
            //System.out.println("cords[0][i]"+cords[0][i]);
            xMin = Math.min(xMin, vecs[i].getValues()[0]);
            xMax = Math.max(xMax, vecs[i].getValues()[0]);

            //System.out.println("cords[1][i]"+cords[1][i]);
            yMin = Math.min(yMin, vecs[i].getValues()[1]);
            yMax = Math.max(yMax, vecs[i].getValues()[1]);
        }

        width = (int) Math.ceil(xMax - xMin);
        height = (int) Math.ceil(yMax - yMin);

        System.out.println(width + " " + height);

        Vector3[] newVecs = calculateTranslation(vecs, width, height, getName()); // transforms if transform is set

        double[][] cords = new double[3][newVecs.length];

        for (int i = 0; i < newVecs.length; i++) {
            cords[0][i] = newVecs[i].getValues()[0];
            cords[1][i] = newVecs[i].getValues()[1];
            cords[2][i] = newVecs[i].getValues()[2];
        }

        return cords;
    }

    public double area(Polygon poly) {
        int numPoints = polygonVector.size();
        double area = 0.0;

        // Schleife, um die Fläche für jedes Dreieck im Polygon zu berechnen
        for (int i = 0; i < numPoints; i++) {
            int j = (i + 1) % numPoints;
            area += polygonVector.get(i).getValues()[0] * polygonVector.get(j).getValues()[1];
            area -= polygonVector.get(j).getValues()[0] * polygonVector.get(i).getValues()[1];
        }

        area /= 2.0;

        return Math.abs(area);
    }

    public void addVector(double x, double y) {
        Vector3 vec = new Vector3(x, y);
        polygonVector.add(vec);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
