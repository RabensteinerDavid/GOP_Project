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

public class RotateFeature implements NamedFeature {

    public static Stack<Shape> stack = new Stack<>();
    boolean isSelected = false;
    CanvasModel model;

    public RotateFeature(CanvasModel model, Stack<Shape> stack) {
        this.model = model;
        this.stack = stack;
    }

    @Override
    public String getName() {
        return "Rotate";
    }

    @Override
    public void onSelect() {
        System.out.println("Rotate Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Rotate Deselected");
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {

    }

    //1 mouse click
    @Override
    public void onMouseDrag(int x, int y) {
        if (isSelected){
            Shape shape = stack.get(model.getCurrentlySelectedShapeIndex());

             double angle = Math.atan2(shape.getY()-y, shape.getX()-x);
             shape.setTransform(TransformFactory.createRotation(angle));
        }
    }
}