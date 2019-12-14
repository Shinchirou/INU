import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Group root = new Group();
            Scene scene = new Scene(root, 400, 400, Color.GRAY);

            //========= REDLINE

            Line redLine = new Line(10, 10, 200, 10);
            redLine.setStroke(Color.RED);
            redLine.setStrokeWidth(10);
            redLine.setStrokeLineCap(StrokeLineCap.ROUND);
            root.getChildren().add(redLine);

            // ========== BLUE LINE przerywana

            Line blueLine = new Line(10, 40, 200, 40);
            blueLine.setStroke(Color.BLUE);
            blueLine.setStrokeWidth(10);
            blueLine.setStrokeLineCap(StrokeLineCap.BUTT);
            blueLine.getStrokeDashArray().addAll(30.0, 15.0, 5.0, 30.0);
            blueLine.setStrokeDashOffset(45);
            root.getChildren().add(blueLine);

            //suwak zwiazy z strokeDashOffset

            Slider slider = new Slider(0, 80, 45);
            //0 - wartość min.
            //80 - wartosc max.
            //45 - wartosc bierzaca
            slider.setLayoutX(10);
            slider.setLayoutY(70);
            slider.setOrientation(Orientation.HORIZONTAL);
            blueLine.strokeDashOffsetProperty().bind(slider.valueProperty());
            root.getChildren().add(slider);

            // ========= rysowanie po sciezce
            Path path = new Path();
            path.setStrokeWidth(5);
            MoveTo moveTo = new MoveTo(50, 150);
            QuadCurveTo quadCurveTo = new QuadCurveTo();
            quadCurveTo.setX(150);
            quadCurveTo.setY(150);
            quadCurveTo.setControlX(100);
            quadCurveTo.setControlY(50);
            LineTo lineTo1 = new LineTo(50 ,150);
            LineTo lineTo2 = new LineTo(100 ,275);
            LineTo lineTo3 = new LineTo(150 ,150);
            path.getElements().addAll(
                    moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3
            );
            root.getChildren().add(path);

            Slider slider2 = new Slider(-100, 100, 50);
            slider2.setOrientation(Orientation.VERTICAL);
            root.getChildren().add(slider2);
            slider2.setLayoutY(100);
            quadCurveTo.controlYProperty().bind(slider2.valueProperty());
            slider2.setRotate(180);

            //donut z dwoch elips
            Ellipse bigEllipse = new Ellipse(
                     100,100, //srodek
                    50, //promien X
                    36 //promien Y
            );


            Ellipse smallEllipse = new Ellipse(
                    100,100, //srodek
                    17, //promien X
                    12 //promien Y
            );

            Shape donut = Path.subtract(bigEllipse, smallEllipse);
            donut.setFill(Color.rgb(255, 200, 0));
            donut.setStroke(Color.BLACK);
            donut.setStrokeWidth(3);
            donut.setTranslateX(200);

            //efekt cienia
            DropShadow dropShadow = new DropShadow(
                    5, // grubosc cienia
                    -12.0, //przesuniecie cienia
                    -12.0, // przesuniecie cienia
                    Color.rgb(200, 200,200));

            donut.setEffect(dropShadow);

            root.getChildren().add(donut);


            //prostokat wypelniony gradientem
            Rectangle roundRect = new Rectangle(
                    250, 250, // polozenie
                    100, 70 // rozmiar
            );

            roundRect.setArcHeight(20);
            roundRect.setArcWidth(20);
            root.getChildren().add(roundRect);

            LinearGradient linearGradient = new LinearGradient(
               0.25, 0.25,
               0.75, 0.75,
               true,
               CycleMethod.REPEAT,
               new Stop(0, Color.RED),
               new Stop(0.5, Color.GREEN),
               new Stop(1, Color.AQUA)
            );
            roundRect.setFill(linearGradient);

            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
