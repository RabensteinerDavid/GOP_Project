package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Text;
import at.fhhgb.mtd.gop.veccy.view.BlockingTextInputDialog;

public class TextFeature implements NamedFeature {

    private String text;
    boolean isSelected = false;
    CanvasModel model;

    public TextFeature(CanvasModel model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return "Text";
    }

    @Override
    public void onSelect() {
        System.out.println("Text Selected");
        isSelected = true;
        this.text = BlockingTextInputDialog.requestTextInput();
    }

    @Override
    public void onDeselect() {
        System.out.println("Text Deselected");
        isSelected = false;
    }

    //let go mouseclick
    @Override
    public void onMouseClick(int i, int i1) {
        if(isSelected && text != null) {
            Text textS = new Text(i,i1, text);

            textS.setFillColor(model.getCurrentFillColor());
            textS.setStrokeColor(model.getCurrentStrokeColor());

            model.addShape(textS);
        }
    }

    @Override
    public void onMouseDrag(int i, int i1) {
    }
}