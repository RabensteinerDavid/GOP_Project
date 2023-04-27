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

    public static LinkedList<Shape> shapeList = new LinkedList<>();
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

              /*
            -------------------------------------- REC--------------------------------------
             */

//        Rectangle rectangle1 = new Rectangle(200, 50, 100, 100);
//        rectangle1.setFillColor(Color.BLUE);
//        model.addShape(rectangle1);
//
//        rectangle1 = new Rectangle(200, 50, 100, 100);
//        rectangle1.setFillColor(Color.BLUE);
//        rectangle1.setTransform(TransformFactory.createRotation(Math.PI / 4));
//        model.addShape(rectangle1);
//
//        Rectangle rectangle2 = new Rectangle(200, 200, 100, 100);
//        rectangle2.setFillColor(Color.RED);
//        model.addShape(rectangle2);
//
//        rectangle2 = new Rectangle(200, 200, 100, 100);
//        rectangle2.setFillColor(Color.RED);
//        rectangle2.setTransform(TransformFactory.createTranslation(110, 0));
//        model.addShape(rectangle2);
//
//        Rectangle rectangle3 = new Rectangle(200, 450, 120, 100);
//        rectangle3.setFillColor(Color.GREEN);
//        model.addShape(rectangle3);
//
//        rectangle3 = new Rectangle(200, 450, 120, 100);
//        rectangle3.setFillColor(Color.GREEN);
//        rectangle3.setTransform(TransformFactory.createHorizontalMirroring(), true);
//        model.addShape(rectangle3);
//
//        Rectangle rectangle4 = new Rectangle(200, 600, 120, 100);
//        rectangle4.setFillColor(Color.YELLOWGREEN);
//        model.addShape(rectangle4);
//
//        rectangle4 = new Rectangle(200, 600, 120, 100);
//        rectangle4.setFillColor(Color.YELLOWGREEN);
//        rectangle4.setTransform(TransformFactory.createVerticalMirroring(), true);
//        model.addShape(rectangle4);
//
//        Rectangle rectangle5 = new Rectangle(500, 50, 50, 50);
//        rectangle5.setFillColor(Color.DARKGREEN);
//        model.addShape(rectangle5);
//
//        rectangle5 = new Rectangle(500, 50, 50, 50);
//        rectangle5.setFillColor(Color.DARKGREEN);
//        rectangle5.setTransform(TransformFactory.createScaling(2, 2));
//        model.addShape(rectangle5);
//
//        Rectangle rectangle6 = new Rectangle(500, 50, 50, 50);
//        rectangle6.setFillColor(Color.DARKGREEN);
//        model.addShape(rectangle6);
//
//                 /*
//            -------------------------------------- CIRCLE--------------------------------------
//             */
//
//        Circle circle1 = new Circle(500, 250, 50);
//        circle1.setFillColor(Color.BLUE);
//        model.addShape(circle1);
//
//        circle1 = new Circle(500, 250, 50);
//        circle1.setFillColor(Color.BLUE);
//        circle1.setTransform(TransformFactory.createTranslation(-50, 50));
//        model.addShape(circle1);
//
//        Circle circle2 = new Circle(500, 250, 50);
//        circle2.setFillColor(Color.BLUE);
//        model.addShape(circle2);
//
//        Circle circle3 = new Circle(580, 250, 50);
//        circle3.setFillColor(Color.BLUE);
//        model.addShape(circle3);
//
//        circle3 = new Circle(580, 250, 50);
//        circle3.setFillColor(Color.BLUE);
//        circle3.setTransform(TransformFactory.createHorizontalMirroring());
//        model.addShape(circle3);
//
//        Circle circle4 = new Circle(580, 250, 50);
//        circle4.setFillColor(Color.BLUE);
//        model.addShape(circle4);
//
//        Circle circle5 = new Circle(650, 250, 50);
//        circle5.setFillColor(Color.BLUE);
//        model.addShape(circle5);
//
//        circle5 = new Circle(650, 250, 50);
//        circle5.setFillColor(Color.BLUE);
//        circle5.setTransform(TransformFactory.createVerticalMirroring());
//        model.addShape(circle5);
//
//        Circle circle6 = new Circle(650, 250, 50);
//        circle6.setFillColor(Color.BLUE);
//        model.addShape(circle6);
//
//        Circle circle7 = new Circle(510, 390, 25);
//
//        circle7 = new Circle(510, 390, 25);
//        circle7.setFillColor(Color.BLUE);
//        circle7.setTransform(TransformFactory.createScaling(3, 3));
//        model.addShape(circle7);

//        for (int i = 0; i < model.getDrawableShapes().size(); i++) {
//            shapeList.add((Shape) model.getDrawableShapes().get(i));
//            shapeList.get(i).setSelected(false);
//        }

        for (int i = 0; i < model.getDrawableShapes().size(); i++) {
            stack.push((Shape) model.getDrawableShapes().get(i));
            Shape shape = stack.get(i);
            shape.setSelected(false);
        }


//        model.setCurrentlySelectedShapeHandler((clickEvent) -> {
//                    System.out.println(clickEvent);
//                    if (shapeList.size() > 0) {
//                        if (!(clickEvent.equals(-1))) {
//                            shapeList.get(clickEvent).setSelected(true);
//                        }
//                    }
//                }
//        );

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

//        model.setShapeCreationHandler((clickEvent) -> {
//                    System.out.println("CH:" + clickEvent);
//
//                    if (shapeList.size() > 0) {
//                        System.out.println("LAst" + shapeList.getLast());
//                    }
//                    boolean isInserted = false;
//                    Shape saveLastShape = null;
//                    for (int i = 0; i < shapeList.size(); i++) {
//                        if (( shapeList.get(i) == saveLastShape) && i + 1 < shapeList.size() && !isInserted) {
//                            isInserted = true;
//                            System.out.println("Insert1: " + (i + 1));
//
//                            saveLastShape = (Shape) clickEvent;
//                            shapeList.add(i + 1, (Shape) clickEvent);
//                        }
//                    }
//
//                    if (!isInserted) {
//                        System.out.println("Insert2: " + (shapeList.size()));
//                        shapeList.add((Shape) clickEvent);
//                    }
//                    System.out.println("ShapeList size: "+shapeList.size());
//                    System.out.println("---------------------");
//                }
//        );

        model.setShapeCreationHandler((clickEvent) -> {
                    stack.push((Shape) clickEvent);
                }
        );

        //Problem wenn man etwas löscht in der list unterhalb des letzten dann rutscht es eines rauf und kann nicht mehr gelöscht werden
//        model.setShapeDeletionHandler((clickEvent) -> {
//                    System.out.println("DH:" + clickEvent);
//                    model.removeShape(shapeList.get(clickEvent));
//                    shapeList.get(clickEvent).setSelected(false);
//                    shapeList.remove(clickEvent);
//                    System.out.println("1Removed" + (clickEvent));
//                    if (shapeList.size() >= 1) {
//                        //System.out.println(shapeList.size());
//                        for (int i = clickEvent; i < shapeList.size(); i++) {
//                            System.out.println(i);
//                            if ((i + 1 < shapeList.size())) {
//                                shapeList.add(clickEvent, shapeList.get(i + 1));
//                                shapeList.remove(i + 1);
//                                //System.out.println("2Removed" + (i + 1));
//                            }
//                        }
//                    }
//                }
//        );

        model.setShapeDeletionHandler((clickEvent) -> {
                    System.out.println("Delete");

                    model.removeShape(stack.get(clickEvent));
                    stack.removeElementAt(clickEvent);
                }
        );
    }
}