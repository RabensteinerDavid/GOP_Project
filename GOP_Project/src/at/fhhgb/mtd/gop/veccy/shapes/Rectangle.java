package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class Rectangle extends Shape {
    private int width;
    private int height;
    private double rotate = 0;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public String getName(){
        return "Rectangle";
    }

    public Rectangle(int x, int y, int width, int height, double rotate) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.rotate = rotate;
    }

    public void setHeiWid(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int area() {
        return this.width * this.height;
    }

    public Rectangle boundingBox() {
        return new Rectangle(super.getX(), super.getY(), width, height);
    }

    public boolean isOverlapping(Rectangle other) {
        //horizontal
        if ((super.getX() <= other.getX() + other.width) && (super.getX() + width >= other.getX())) {
            //horizontal
            if ((super.getY() <= other.getY() + other.height) && (super.getY() + height >= other.getY())) {
                return true;
            }
        }
        return false;
    }

    public double[][] getCoordinates() {
        Vector3[] vec = new Vector3[]{
                new Vector3(new double[]{super.getX(), super.getY(), 1}),
                new Vector3(new double[]{super.getX() + width, super.getY(), 1}),
                new Vector3(new double[]{super.getX() + width, super.getY() + height, 1}),
                new Vector3(new double[]{super.getX(), super.getY() + height, 1})
        };

        Vector3[] trVec = calculateTranslation(vec, width, height, getName());

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

//        graphicsContext.fillRect(super.getX(), super.getY(), width, height); // Füllt ein Rechteck
//        graphicsContext.strokeRect(super.getX(), super.getY(), width, height); // Rand eines Rechtecks

        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}




