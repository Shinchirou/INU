import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Group root = new Group();
            Scene scene = new Scene(root, 512, 256);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            Canvas canvas = new Canvas(512, 256);
            root.getChildren().add(canvas);
            GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

            Image srcImage = new Image(
                    getClass().getResourceAsStream("smile.png"));
            int height = (int) srcImage.getHeight();
            int width = (int) srcImage.getWidth();
            graphicsContext.drawImage(srcImage, 0, 0);

            WritableImage dstImage = new WritableImage(
                    width, height);
            PixelReader reader = srcImage.getPixelReader();
            PixelWriter writer = dstImage.getPixelWriter();
            for(int x = 0; x < width; x++){
                for(int y =0; y < height; y++){
                    Color color = reader.getColor(x, y);
                    writer.setColor(x, y, Color.color(color.getRed()/2,
                            color.getGreen()/2,
                            color.getBlue()/2));
                }
            }
            graphicsContext.drawImage(dstImage, 256, 0);

            // wspolrzedne klikniecia mysza

//            canvas.setOnMouseClicked();
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
                System.out.println("x=" + mouseEvent.getX() +
                        "y=" + mouseEvent.getY());

            });

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
