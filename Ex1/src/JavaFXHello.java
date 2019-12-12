import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class JavaFXHello extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        RLE rle = new RLE();

        try {
            BorderPane root = new BorderPane();

            //============================================ Right

            Label toggleLabel = new Label("Operacja:");
            toggleLabel.setLayoutY(200);
            RadioButton radioCoding = new RadioButton("Kodowanie:");
            RadioButton radioDecoding = new RadioButton("Dekodowanie:");

            ToggleGroup toggleGroup = new ToggleGroup();
            radioCoding.setToggleGroup(toggleGroup);
            radioDecoding.setToggleGroup(toggleGroup);

            VBox bottomHbox = new VBox(10);
            bottomHbox.getChildren().addAll(toggleLabel, radioCoding, radioDecoding);
            root.setRight(bottomHbox);




            //============== Center
            Label label = new Label("Źródło:");
            label.setLayoutY(-25);
            Label label2 = new Label("Wynik operacji:");
            label2.setLayoutY(35);
            label.setLayoutY(-25);
            TextField sourceText = new TextField();
            Button buttonCopy = new Button("Kopiuj");
            buttonCopy.setLayoutY(30);
            buttonCopy.setLayoutX(100);
            TextField resultText = new TextField();
            Button buttonExecute = new Button("Wykonaj");
            resultText.setLayoutY(60);
            buttonExecute.setLayoutY(110);
            Group center_group = new Group();
            center_group.getChildren().addAll(label, sourceText, label2, buttonCopy, resultText, buttonExecute);
            root.setCenter(center_group);


            //============================================= Events

            buttonCopy.setOnAction(actionEvent -> {
                sourceText.setText(resultText.getText());
            });

            buttonExecute.setOnAction(actionEvent -> {
                String result = "";

                if(radioCoding.isSelected()) {
                    result = rle.encode(sourceText.getText());
                } else if (radioDecoding.isSelected()){
                    result = rle.decode(sourceText.getText());
                } else {
                    Stage stage = new Stage();
                    stage.setTitle("Błąd!");
                    BorderPane borderPane = new BorderPane();
                    stage.setScene(new Scene(borderPane,300,100));
                    Label msg = new Label("Wybierz operacje!");
                    borderPane.setCenter(msg);
                    stage.initOwner(primaryStage);
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.show();
                }
                resultText.setText(result);
            });

            //============================= Scene init

            Scene scene = new Scene(root, 400, 300);
          scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          primaryStage.setTitle("Run Length Encoding");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
