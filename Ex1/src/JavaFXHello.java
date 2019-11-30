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

        Button button = new Button();
        button.setText("click me");

        button.setOnAction(actionEvent -> System.out.println("Clicked"));
        button.setLayoutX(200);
        Button buttonWindow = new Button();
        buttonWindow.setText("Open Dialog box");
        buttonWindow.setLayoutX(100);
        buttonWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                stage.setTitle("Dialog box");
                stage.setScene(new Scene(new StackPane(new Label("message"))));
                stage.initOwner(primaryStage);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setMinWidth(200);
                stage.setMinHeight(200);
                stage.show();
            }
        });

        try {
            BorderPane root = new BorderPane();
            Image image = new Image(getClass().getResourceAsStream("lenna256px.png"));
            ImageView imageView = new ImageView(image);

            Label label = new Label("Hello World");
            label.setLayoutX(0);
            label.setLayoutY(120);
            Label label2 = new Label("nr 1");
            Label label3 = new Label("nr 2");
            VBox left_vbox = new VBox(10);
            left_vbox.getChildren().add(label2);
            left_vbox.getChildren().add(label3);
            root.setBottom(button);
            root.setBottom(buttonWindow);
            root.setLeft(left_vbox);

            //============================================

            RadioButton radio1 = new RadioButton("1");
            radio1.setUserData("przycisk 1");
            RadioButton radio2 = new RadioButton("2");
            radio2.setUserData("przycisk 2");
            RadioButton radio3 = new RadioButton("3");
            radio3.setUserData("przycisk 3");

            ToggleGroup toggleGroup = new ToggleGroup();
            radio1.setToggleGroup(toggleGroup);
            radio2.setToggleGroup(toggleGroup);
            radio3.setToggleGroup(toggleGroup);

            HBox bottomHbox = new HBox(10);
            bottomHbox.getChildren().addAll(radio1, radio2, radio3);
            root.setBottom(bottomHbox);



            //==============
            TextField textField = new TextField();
            TextField textField2 = new TextField();
            textField2.setLayoutY(60);
            Group center_group = new Group();
            center_group.getChildren().add(imageView);
            center_group.getChildren().addAll(label, textField2, textField);

            //=============================================
            Button button1 = new Button("Kliknij mnie!");
            button1.getStyleClass().add("my-field");
            Button button2 = new Button("Nr 2");
            button2.getStyleClass().add("my-button");
            Button button3 = new Button( "Nr 3");
            HBox hBox = new HBox(10);
            hBox.getChildren().addAll(button1, button2, button3);



            root.setCenter(center_group);
            root.setTop(hBox);
            //=========================================

            button3.setOnAction(actionEvent -> {
//                if(radio1.isSelected()){
//                    System.out.println("Radio 1");
//                } else if(toggleGroup.getSelectedToggle().equals(radio2)){
//                    System.out.println("Radio 2");
//                } else {
//                    System.out.println("Radio 3");
//                }

                if(textField.getText().matches("^[JA|BD|DS][0-9]{2}[LZlz][0-9]{2}[a-z]")){
                    System.out.println("Matches");
                } else {
                    System.out.println("not matches");
                }

            });


            //===========================================================
            button2.setOnAction(actionEvent -> { System.out.println("Przycisk 2");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "ojaciepanie co sie stao");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    System.out.println("OK");
                }
//            alert.show();

            });

            button1.setOnAction(actionEvent -> {
                System.out.println("Przycisk 1");
                Stage stage = new Stage();
                stage.setTitle("Okno dial");
                BorderPane borderPane = new BorderPane();
                stage.setScene(new Scene(borderPane,300,100));
                Label msg = new Label("To jest okno dial");
                borderPane.setCenter(msg);
                stage.initOwner(primaryStage);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.show();
            });
            Scene scene = new Scene(root, 400, 400);
          scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          primaryStage.setTitle("Hello World");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
