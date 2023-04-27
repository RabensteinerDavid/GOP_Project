package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class Text extends Shape {

    private String text;

    private double angle;

    public Text(double x, double y, String text) {
        super(x, y);
        this.text = text;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public String getName(){
        return "Text";
    }

    @Override
    public double[][] getCoordinates() {

        Vector3[] vec = new Vector3[]{
                new Vector3(new double[]{getX(), getY(), 1}),
                new Vector3(new double[]{getX() + text.length() * 6, getY() - 12, 1}),
        };

        Vector3[] trVec = calculateTranslation(vec, text.length(),12, getName());

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
        double[][] coordinates = getCoordinates();

        graphicsContext.rotate(angle);

        graphicsContext.fillText(text, coordinates[0][0], coordinates[1][0]);
        graphicsContext.strokeText(text, coordinates[0][0], coordinates[1][0]);
    }
}
