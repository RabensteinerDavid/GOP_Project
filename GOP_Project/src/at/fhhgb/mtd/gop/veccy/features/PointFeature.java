package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Point;

public class PointFeature implements NamedFeature {

    boolean isSelected = false;

    CanvasModel model;

    public PointFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public void onSelect() {
        System.out.println("Point Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Point Deselected");
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if (isSelected) {

            Point pt = new Point(i, i1);
            pt.setFillColor(model.getCurrentFillColor());

            model.addShape(pt);
        }
    }

    //1 mouse click
    @Override
    public void onMouseDrag(int i, int i1) {

    }
}