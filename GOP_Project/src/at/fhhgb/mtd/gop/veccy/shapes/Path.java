package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import java.util.LinkedList;

/**
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


public class Path extends Shape {
    LinkedList<Vector3> polygonVectors = new LinkedList<>();

    private int width;
    private int height;

    public Path(double x, double y) {
        super(x, y);
        polygonVectors.add(position);
    }

    public String getName() {
        return "Path";
    }

    public double[][] getCoordinates() {
        Vector3[] vecs = new Vector3[polygonVectors.size()];
        for (int i = 0; i < polygonVectors.size(); i++) {
            vecs[i] = polygonVectors.get(i);
        }

        double xMax = vecs[0].getValues()[0], xMin = vecs[0].getValues()[0], yMax = vecs[0].getValues()[1], yMin = vecs[0].getValues()[1];

        for (int i = 0; i < polygonVectors.size(); i++) {
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

    public void addPath(double x, double y) {
        Vector3 vec = new Vector3(x, y);
        polygonVectors.add(vec);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}

