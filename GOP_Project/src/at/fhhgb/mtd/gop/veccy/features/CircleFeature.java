package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;

public class CircleFeature implements NamedFeature {

    private static Circle cir;
    boolean isSelected = false;
    int i = 0;
    int i1 = 0;
    CanvasModel model;

    public CircleFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public void onSelect() {
        System.out.println("Circle Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Circle Deselected");
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if (isSelected) {
            cir = null;
        }
    }

    //1 mouse click
    @Override
    public void onMouseDrag(int i, int i1) {
        if (cir == null) {
            if (isSelected) {

                this.i = i;
                this.i1 = i1;

                cir = new Circle(i, i1, 0);

                cir.setFillColor(model.getCurrentFillColor());
                cir.setStrokeColor(model.getCurrentStrokeColor());

                model.addShape(cir);
            }
        } else {
            int distance = (int) (Math.sqrt((i - this.i) * (i - this.i) + (i1 - this.i1) * (i1 - this.i1)) / 2.4); // /2.4 for better usability
            cir.setRadius(distance);
        }
    }
}