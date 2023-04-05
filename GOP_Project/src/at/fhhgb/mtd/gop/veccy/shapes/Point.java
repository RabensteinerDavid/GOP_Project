package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Shape {

    public Point(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillRect(super.getX(), super.getY(), 1, 1); // Füllt ein Rechteck
    }
}
