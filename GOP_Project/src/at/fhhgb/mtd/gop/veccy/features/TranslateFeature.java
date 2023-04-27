package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;
import java.util.Stack;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class TranslateFeature implements NamedFeature {

    public static Stack<Shape> stack = new Stack<>();
    boolean isSelected = false;
    int i = 0;
    int i1 = 0;
    CanvasModel model;

    public TranslateFeature(CanvasModel model, Stack<Shape> stack) {
        this.model = model;
        this.stack = stack;
    }

    @Override
    public String getName() {
        return "Translate";
    }

    @Override
    public void onSelect() {
        System.out.println("Translate Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Translate Deselected");
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int x, int y) {
    }

    //1 mouse click
    @Override
    public void onMouseDrag(int x, int y) {
        if (isSelected) {
            Shape shape = stack.get(model.getCurrentlySelectedShapeIndex());

            shape.setTransform(TransformFactory.createTranslation(x - shape.getX(), y - shape.getY()));
        }
    }
}