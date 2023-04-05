package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class Path extends Shape {
    LinkedList<Vector3> polygonVectors = new LinkedList<>();

    public Path(double x, double y) {
        super(x, y);
        polygonVectors.add(position);
    }

    public void addPath(double x, double y) {
        Vector3 vec = new Vector3(x, y);
        polygonVectors.add(vec);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);

        for (int i = 1; i < polygonVectors.size(); i++) {
            graphicsContext.strokeLine(polygonVectors.get(i - 1).getValues()[0], polygonVectors.get(i - 1).getValues()[1], polygonVectors.get(i).getValues()[0], polygonVectors.get(i).getValues()[1]);
        }
    }
}

