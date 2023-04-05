package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.features.*;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Veccy extends Application {
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

              /*
            -------------------------------------- REC--------------------------------------
             */

        Rectangle rectangle1 = new Rectangle(200, 50, 100, 100);
        rectangle1.setFillColor(Color.BLUE);
        model.addShape(rectangle1);

        rectangle1.setTransform(TransformFactory.createRotation(Math.PI / 4));
        model.addShape(rectangle1);

        Rectangle rectangle2 = new Rectangle(200, 200, 100, 100);
        rectangle2.setFillColor(Color.RED);
        model.addShape(rectangle2);

        rectangle2.setTransform(TransformFactory.createTranslation(110, 0));
        model.addShape(rectangle2);

        Rectangle rectangle3 = new Rectangle(200, 450, 120, 100);
        rectangle3.setFillColor(Color.GREEN);
        model.addShape(rectangle3);

        rectangle3.setTransform(TransformFactory.createHorizontalMirroring(), true);
        model.addShape(rectangle3);

        Rectangle rectangle4 = new Rectangle(200, 600, 120, 100);
        rectangle4.setFillColor(Color.YELLOWGREEN);
        model.addShape(rectangle4);

        rectangle4.setTransform(TransformFactory.createVerticalMirroring(), true);
        model.addShape(rectangle4);

        Rectangle rectangle5 = new Rectangle(500, 50, 50, 50);
        rectangle5.setFillColor(Color.DARKGREEN);
        model.addShape(rectangle5);

        rectangle5.setTransform(TransformFactory.createScaling(2, 2));
        model.addShape(rectangle5);

        Rectangle rectangle6 = new Rectangle(500, 50, 50, 50);
        rectangle6.setFillColor(Color.DARKGREEN);
        model.addShape(rectangle6);

                 /*
            -------------------------------------- CIRCLE--------------------------------------
             */

        Circle circle1 = new Circle(500, 250, 50);
        circle1.setFillColor(Color.BLUE);
        model.addShape(circle1);

        circle1.setTransform(TransformFactory.createTranslation(-50, 50));
        model.addShape(circle1);

        Circle circle2 = new Circle(500, 250, 50);
        circle2.setFillColor(Color.BLUE);
        model.addShape(circle2);

        Circle circle3 = new Circle(580, 250, 50);
        circle3.setFillColor(Color.BLUE);
        model.addShape(circle3);

        circle3.setTransform(TransformFactory.createHorizontalMirroring());
        model.addShape(circle3);

        Circle circle4 = new Circle(580, 250, 50);
        circle4.setFillColor(Color.BLUE);
        model.addShape(circle4);

        Circle circle5 = new Circle(650, 250, 50);
        circle5.setFillColor(Color.BLUE);
        model.addShape(circle5);

        circle5.setTransform(TransformFactory.createVerticalMirroring());
        model.addShape(circle5);

        Circle circle6 = new Circle(650, 250, 50);
        circle6.setFillColor(Color.BLUE);
        model.addShape(circle6);

        Circle circle7 = new Circle(510, 390, 25);
        circle7.setFillColor(Color.BLUE);
        model.addShape(circle7);

        circle7.setTransform(TransformFactory.createScaling(3, 3));
        model.addShape(circle7);
    }
}