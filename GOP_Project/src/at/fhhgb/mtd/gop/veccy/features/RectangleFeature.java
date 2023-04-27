package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class RectangleFeature implements NamedFeature {

    private static Rectangle rec;
    boolean isSelected = false;
    int i = 0;
    int i1 = 0;
    CanvasModel model;

    public RectangleFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void onSelect() {
        System.out.println("Rectangle Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Rectangle Deselected");
        isSelected = false;
    }


    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if (isSelected) {
            rec = null;
        }
    }

    //1 mouse click
    @Override
    public void onMouseDrag(int i, int i1) {
        if (rec == null) {
            if (isSelected) {
                this.i = i;
                this.i1 = i1;

                rec = new Rectangle(i, i1, 0, 0);

                rec.setStrokeColor(model.getCurrentStrokeColor());
                rec.setFillColor(model.getCurrentFillColor());

                model.addShape(rec);
            }
        } else {
            int xMin = Math.min(this.i, i);
            int xMax = Math.max(this.i, i);
            int yMin = Math.min(this.i1, i1);
            int yMax = Math.max(this.i1, i1);

            rec.setHeiWid(xMax - xMin, yMax - yMin);
            //model.addShape(rec);
        }
    }
}