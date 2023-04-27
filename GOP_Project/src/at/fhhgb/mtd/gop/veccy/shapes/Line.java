package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class Line extends Shape {
    private int x2;
    private int y2;

    int width = 0;
    int height = 0;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public String getName(){
        return "Line";
    }

    public void setX2Y2(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Rectangle boundingBox() {

        int xMin = Math.min(super.getX(), x2);
        int xMax = Math.max(super.getX(), x2);

        int yMin = Math.min(super.getY(), y2);
        int yMax = Math.max(super.getY(), y2);

        width = Math.abs(yMax - yMin);
        height = Math.abs(xMax - xMin);

        return new Rectangle(xMin, yMin, Math.abs(xMax - xMin), Math.abs(yMax - yMin));
    }

    @Override
    public double[][] getCoordinates() {

        Vector3[] vecs = new Vector3[2];
        vecs[0]= new Vector3(new double[]{position.getValues()[0],position.getValues()[1], 1});
        vecs[1]= new Vector3(new double[]{x2,y2,1});

        Vector3[] newVecs = calculateTranslation(vecs,width,height,getName()); // transforms if transform is set
        double[][] cords= new double[3][newVecs.length];

        for (int i = 0; i < newVecs.length; i++) {
            cords[0][i]= newVecs[i].getValues()[0];
            cords[1][i]= newVecs[i].getValues()[1];
        }

        return cords;
    }


    @Override
    public Vector3[] calculateTranslation(Vector3[] coordinates, int width, int height, String name) {

        int xMin = Math.min(this.x2,this.getX());
        int xMax = Math.max(this.x2,this.getX());

        int yMin = Math.min(this.y2,this.getY());
        int yMax = Math.max(this.y2,this.getY());
        width = xMax-xMin;
        height = yMax-yMin;


        Matrix3 translToCenter = TransformFactory.createTranslation(
                (this.width / 2)-this.width - this.getX(), (this.height / 2)-this.height - this.getY());

        Matrix3 translBack = TransformFactory.createTranslation(
                (this.width/2) + this.getX(), (this.height /2) + this.getY());



        Vector3[] newVecs = new Vector3[coordinates.length];


        if (this.transform != null) {
            for (int i = 0; i < coordinates.length; i++) {
                newVecs[i] = translBack.mult(this.transform.mult(translToCenter.mult(coordinates[i])));            }
            return newVecs;
        }

        return coordinates;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}
