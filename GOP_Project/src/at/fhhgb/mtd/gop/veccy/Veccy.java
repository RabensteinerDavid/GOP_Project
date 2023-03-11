package at.fhhgb.mtd.gop.veccy;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Veccy extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        System.out.println("Was wollen Sie sehen, den Blurinator 2000 (nimmt ein Bild her und erstellt Rectangles in der Farbe des xten Pixels) mit [1], oder ein Bild, welches mit einfache Formen erstellt wurde mit [2]");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inp = reader.readLine();

        if (inp.equals("1")) {
            System.out.println("Processing....(It may take a view seconds)");
            //man kann mit resizeRead angeben wie viele Pixel gelesen werden -> umso höher, umso schneller wird das Programm ausgeführt
            //man kann mit resizeWrite die Größe des neu errechneten Bildes angeben
            //drawImg(stage, 4, 16, new File("./src/at/fhhgb/mtd/gop/veccy/image/v1.jpeg"));
            drawImg(stage, 8, 16, new File("./src/at/fhhgb/mtd/gop/veccy/image/v2.jpeg"));
            System.out.println("loaded");
        } else if (inp.equals("2")) {
            Circle cer = new Circle(140, 80, 80);
            cer.setFillColor(Color.YELLOW);
            cer.setStrokeColor(Color.YELLOW);
            model.addShape(cer);

            Circle cerF1 = new Circle(80, 80, 120);
            cerF1.setFillColor(Color.BLACK);
            cerF1.setStrokeColor(Color.BLACK);
            model.addShape(cerF1);

            Circle cirRa = new Circle(400, 344, 40);
            cirRa.setFillColor(Color.WHITESMOKE);
            cirRa.setStrokeColor(Color.WHITESMOKE);
            model.addShape(cirRa);

            Random random = new Random();

            for (int i = 0; i < 2000; i++) {
                int xNew = random.nextInt(1280) + 0;
                int yNew = random.nextInt(800) + 0;
                Point pt = new Point(xNew, yNew);
                pt.setFillColor(Color.WHITE);
                model.addShape(pt);
            }

            Color[] color2 = new Color[]{Color.DARKRED, Color.ORANGE, Color.LIGHTGOLDENRODYELLOW};
            for (int i = 0; i < 15; i++) {
                int randomNumberA = random.nextInt(30) + 1;
                int randomNumberZ = random.nextInt(3) + 0;
                Rectangle rec5 = new Rectangle(-210 - i * 5, 320, 1, 2000, 40 + randomNumberA * 0.0625);
                rec5.setFillColor(color2[randomNumberZ]);
                rec5.setStrokeColor(color2[randomNumberZ]);
                model.addShape(rec5);
            }

            Rectangle rec3 = new Rectangle(565, 180, 40, 80, 65);
            rec3.setFillColor(Color.WHITESMOKE);
            rec3.setStrokeColor(Color.WHITESMOKE);
            model.addShape(rec3);

            Rectangle rec = new Rectangle(500, 200, 40, 120, 45);
            rec.setFillColor(Color.WHITESMOKE);
            rec.setStrokeColor(Color.WHITESMOKE);
            model.addShape(rec);

            Rectangle rec2 = new Rectangle(385, 390, 40, 40, 15);
            rec2.setFillColor(Color.WHITESMOKE);
            rec2.setStrokeColor(Color.WHITESMOKE);
            model.addShape(rec2);

            Rectangle rec5 = new Rectangle(385, 420, 40, 10, 15);
            rec5.setFillColor(Color.DARKRED);
            rec5.setStrokeColor(Color.DARKRED);
            model.addShape(rec5);

            Rectangle rec6 = new Rectangle(565, 250, 40, 10, 65);
            rec6.setFillColor(Color.DARKRED);
            rec6.setStrokeColor(Color.DARKRED);
            model.addShape(rec6);

            Circle cirRa1 = new Circle(404, 360, 20);
            cirRa1.setFillColor(Color.LIGHTBLUE);
            cirRa1.setStrokeColor(Color.BLACK);
            model.addShape(cirRa1);

            Circle cirRa2 = new Circle(360, 404, 20);
            cirRa2.setFillColor(Color.LIGHTBLUE);
            cirRa2.setStrokeColor(Color.BLACK);
            model.addShape(cirRa2);

            Circle cerFBig = new Circle(580, 360, 1200);
            cerFBig.setFillColor(Color.GRAY);
            cerFBig.setStrokeColor(Color.GRAY);
            model.addShape(cerFBig);

            Circle cerFBigOval = new Circle(1000, 0, 400, 800, 45);
            cerFBigOval.setFillColor(Color.DARKGREY);
            cerFBigOval.setStrokeColor(Color.DARKGREY);
            model.addShape(cerFBigOval);

            Circle cerFBigOval1 = new Circle(500, 600, 2000, 400);
            cerFBigOval1.setFillColor(Color.TRANSPARENT);
            cerFBigOval1.setStrokeColor(Color.YELLOW);
            model.addShape(cerFBigOval1);

            Circle cerFBigOval2 = new Circle(520, 560, 1600, 400);
            cerFBigOval2.setFillColor(Color.TRANSPARENT);
            cerFBigOval2.setStrokeColor(Color.YELLOW);
            model.addShape(cerFBigOval2);
        } else {
            System.err.println("Bitte geben sie [1] oder [2] ein");
        }
    }

    public void drawImg(Stage stage, int resizeRead, int resizeWrite, File file) throws IOException {
        VeccyGUI veccyGUI = new VeccyGUI(stage);
        CanvasModel model = veccyGUI.getModel();

        BufferedImage img = ImageIO.read(file);

        int newX = 0;
        int newY = 0;
        Rectangle rec;

        for (int x = 0; x < img.getWidth(); x += resizeRead) {
            for (int y = 0; y < img.getHeight(); y += resizeRead) {

                rec = new Rectangle(newX, newY, resizeWrite, resizeWrite);

                Color c = new Color(readPixel(x, y, file).getRed(), readPixel(x, y, file).getGreen(), readPixel(x, y, file).getBlue(), readPixel(x, y, file).getOpacity());

                rec.setFillColor(c);
                rec.setStrokeColor(c);
                model.addShape(rec);
                newY += resizeWrite;
            }
            newY = 0;
            newX += resizeWrite;
        }
    }

    private Color readPixel(int x, int y, File file) throws IOException {

        BufferedImage img = ImageIO.read(file);

        //Retrieving contents of a pixel
        int pixel = img.getRGB(x, y);
        //Creating a Color object from pixel value
        java.awt.Color color = new java.awt.Color(pixel, true);

        javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() / 255.0);

        return fxColor;
    }
}