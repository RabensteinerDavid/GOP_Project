package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */


public class Point extends Shape {

    public Point(int x, int y) {
        super(x, y);
    }
    public String getName(){
        return "Point";
    }

    public double[][] getCoordinates() {
        Vector3[] vec = new Vector3[1];
        vec[0]= new Vector3(new double[]{position.getValues()[0],position.getValues()[1],1});

        Vector3[] trVec = calculateTranslation(vec, 1, 1, getName());

        double[][] cords = new double[3][trVec.length];

        for (int i = 0; i < trVec.length; i++) {
            cords[0][i] = trVec[i].getValues()[0]; // store x-coordinate in the first row
            cords[1][i] = trVec[i].getValues()[1]; // store y-coordinate in the second row
            cords[2][i] = trVec[i].getValues()[2]; // store z-coordinate in the third row
        }

        return cords;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillRect(super.getX(), super.getY(), 1, 1); // Füllt ein Rechteck
    }
}
