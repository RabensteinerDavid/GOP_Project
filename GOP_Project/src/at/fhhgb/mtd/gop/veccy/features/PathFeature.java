package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class PathFeature implements NamedFeature {

    private static Path path;
    boolean isSelected = false;
    CanvasModel model;

    public PathFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Path";
    }

    @Override
    public void onSelect() {
        System.out.println("Path Selected");
        isSelected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Path Deselected");
        isSelected = false;
        path = null;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if(isSelected) {
            Path path0= path;
            if(path0 == null) {
                path = new Path(i, i1);

                path.setFillColor(model.getCurrentFillColor());
                path.setStrokeColor(model.getCurrentStrokeColor());

                model.addShape(path);
            } else {
                path0.addPath(i, i1);
            }

        }
    }


    @Override
    public void onMouseDrag(int i, int i1) {

    }
}