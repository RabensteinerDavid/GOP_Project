package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.veccy.features.*;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author David Rabensteiner, s2210238050 (Gruppe 1)
 */

public class Veccy extends Application {
    public static Stack<Shape> stack = new Stack<>();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        RectangleFeature recF = new RectangleFeature(model);
        model.addFeature(recF);
        CircleFeature cirF = new CircleFeature(model);
        model.addFeature(cirF);
        LineFeature liF = new LineFeature(model);
        model.addFeature(liF);
        PointFeature ptF = new PointFeature(model);
        model.addFeature(ptF);
        PolygonFeature polyF = new PolygonFeature(model);
        model.addFeature(polyF);
        TextFeature textF = new TextFeature(model);
        model.addFeature(textF);
        PathFeature pathF = new PathFeature(model);
        model.addFeature(pathF);

        TranslateFeature translF = new TranslateFeature(model,stack);
        model.addFeature(translF);
        RotateFeature rotateF = new RotateFeature(model,stack);
        model.addFeature(rotateF);
        TransformFeature transF = new TransformFeature(model,stack);
        model.addFeature(transF);

        for (int i = 0; i < model.getDrawableShapes().size(); i++) {
            stack.push((Shape) model.getDrawableShapes().get(i));
            Shape shape = stack.get(i);
            shape.setSelected(false);
        }

        model.setCurrentlySelectedShapeHandler((clickEvent) -> {
                    if (!(clickEvent.equals(-1))) {
                        Shape shape = stack.get(clickEvent);
                        for (int i = 0; i < stack.size(); i++) {
                            stack.get(i).setSelected(false);
                        }
                        shape.setSelected(true);
                    }
                }
        );

        model.setShapeCreationHandler((clickEvent) -> {
                    stack.push((Shape) clickEvent);
                }
        );

        model.setShapeDeletionHandler((clickEvent) -> {
                    System.out.println("Delete");

                    model.removeShape(stack.get(clickEvent));
                    stack.removeElementAt(clickEvent);
                }
        );
    }
}