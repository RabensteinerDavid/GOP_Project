package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class LineFeature implements NamedFeature {

    private static Line li;
    boolean isSelected = false;
    int i = 0;
    int i1 = 0;
    CanvasModel model;

    public LineFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public void onSelect() {
        System.out.println("Line Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Line Deselected");
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if (isSelected) {
            li = null;
        }
    }

    //1 mouse click
    @Override
    public void onMouseDrag(int i, int i1) {
        if (li == null) {
            if (isSelected) {

                this.i = i;
                this.i1 = i1;

                li = new Line(i, i1, i, i1);

                li.setStrokeColor(model.getCurrentStrokeColor());

                model.addShape(li);
            }
        } else {
            li.setX2Y2(i, i1);
            //model.addShape(li);
        }
    }
}