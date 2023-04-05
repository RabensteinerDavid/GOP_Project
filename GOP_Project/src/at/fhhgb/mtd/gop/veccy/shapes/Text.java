package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Text extends Shape {

    private String text;

    public Text(double x, double y, String text) {
        super(x, y);
        this.text = text;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillText(text, getX(), getY());
        graphicsContext.strokeText(text, getX(), getY());
    }
}
