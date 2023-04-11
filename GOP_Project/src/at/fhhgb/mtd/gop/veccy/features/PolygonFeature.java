package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

public class PolygonFeature implements NamedFeature {

    private static Polygon poly;
    boolean isSelected = false;
    CanvasModel model;

    public PolygonFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Polygon";
    }

    @Override
    public void onSelect() {
        System.out.println("Polygon Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Polygon Deselected");
        poly = null;
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if(isSelected) {
            if(poly == null) {
                poly = new Polygon(i, i1);
            } else {
                poly.addVector(i, i1);
            }
            poly.setFillColor(model.getCurrentFillColor());
            poly.setStrokeColor(model.getCurrentStrokeColor());

            model.addShape(poly);
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {

    }
}