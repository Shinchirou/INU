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

//        Button button = new Button();
//        button.setText("click me");
//
//        button.setOnAction(actionEvent -> System.out.println("Clicked"));
//        button.setLayoutX(200);
//        Button buttonWindow = new Button();
//        buttonWindow.setText("Open Dialog box");
//        buttonWindow.setLayoutX(100);
//        buttonWindow.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Stage stage = new Stage();
//                stage.setTitle("Dialog box");
//                stage.setScene(new Scene(new StackPane(new Label("message"))));
//                stage.initOwner(primaryStage);
//                stage.initModality(Modality.WINDOW_MODAL);
//                stage.setMinWidth(200);
//                stage.setMinHeight(200);
//                stage.show();
//            }
//        });

        try {
            BorderPane root = new BorderPane();

//            Label label = new Label("Hello World");
//            label.setLayoutX(0);
//            label.setLayoutY(120);
//            Label label2 = new Label("nr 1");
//            Label label3 = new Label("nr 2");
//            left_vbox.getChildren().add(label2);
//            left_vbox.getChildren().add(label3);
//            root.setBottom(button);
//            root.setBottom(buttonWindow);

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
            //=============================================

//            HBox hBox = new HBox(10);
//            hBox.getChildren().addAll(button1, button2);




//            root.setTop(hBox);
            //=========================================

//            button3.setOnAction(actionEvent -> {
//                if(radio1.isSelected()){
//                    System.out.println("Radio 1");
//                } else if(toggleGroup.getSelectedToggle().equals(radio2)){
//                    System.out.println("Radio 2");
//                } else {
//                    System.out.println("Radio 3");
//                }
//
//                if(textField.getText().matches("^[JA|BD|DS][0-9]{2}[LZlz][0-9]{2}[a-z]")){
//                    System.out.println("Matches");
//                } else {
//                    System.out.println("not matches");
//                }
//
//            });


            //===========================================================
//            button2.setOnAction(actionEvent -> { System.out.println("Przycisk 2");
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "ojaciepanie co sie stao");
//                Optional<ButtonType> result = alert.showAndWait();
//                if(result.isPresent() && result.get() == ButtonType.OK){
//                    System.out.println("OK");
//                }
////            alert.show();
//
//            });

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

            });

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
