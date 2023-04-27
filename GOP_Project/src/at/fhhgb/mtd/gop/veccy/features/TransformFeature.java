package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.math.Matrix3;
import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.model.TransformConfig;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;
import at.fhhgb.mtd.gop.veccy.view.BlockingTransformInputDialog;
import java.util.Stack;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class TransformFeature implements NamedFeature {

    public static Stack<Shape> stack = new Stack<>();
    boolean isSelected = false;
    int i = 0;
    int i1 = 0;
    CanvasModel model;

    public TransformFeature(CanvasModel model, Stack<Shape> stack) {
        this.model = model;
        this.stack = stack;
    }

    @Override
    public String getName() {
        return "Transform";
    }

    @Override
    public void onSelect() {
        isSelected = true;
        onMouseClick(1,1);
    }

    @Override
    public void onDeselect() {
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int x, int y) {
        boolean mirror = false;

        if (isSelected) {
            try {
                Shape shape = stack.get(model.getCurrentlySelectedShapeIndex());
                TransformConfig config = BlockingTransformInputDialog.requestConfigInput();

                Matrix3 transform = TransformFactory.createScaling(config.getScaleX(),config.getScaleY());
                transform = transform.mult(TransformFactory.createRotation(config.getRotation()));

                if(config.isMirrorX()) {
                    mirror = true;
                    transform = transform.mult(TransformFactory.createHorizontalMirroring());
                }
                if(config.isMirrorY()) {
                    mirror = true;
                    transform = transform.mult(TransformFactory.createVerticalMirroring());
                }
                shape.setTransform(transform,mirror);

            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("No Shape available");
            }

        }
    }

    //1 mouse click
    @Override
    public void onMouseDrag(int x, int y) {

    }

}

