import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Label lblCharacter = new Label("Postać");
            lblCharacter.setMinWidth(100);
            lblCharacter.setAlignment(Pos.BOTTOM_RIGHT);

            TextField txtCharacter = new TextField();
            txtCharacter.setMinWidth(200);
            txtCharacter.setMaxWidth(200);
            txtCharacter.setPromptText("Wprowadź postać");

            Label lblActor = new Label("Aktor");
            lblActor.setMinWidth(100);
            lblActor.setAlignment(Pos.BOTTOM_RIGHT);

            TextField txtActor = new TextField();
            txtActor.setMinWidth(200);
            txtActor.setMaxWidth(200);
            txtActor.setPromptText("Wprowadź aktora");

            Label lblRole1 = new Label("Postać");
            Label lblRole2 = new Label();
            Label lblRole3 = new Label("jest grana przez");
            Label lblRole4 = new Label();

            HBox hBoxCharacter = new HBox(20, lblCharacter, txtCharacter);
            hBoxCharacter.setPadding(new Insets(10));

            HBox hBoxActor = new HBox(20, lblActor, txtActor);
            hBoxActor.setPadding(new Insets(10));

            HBox hBoxRole = new HBox(20, lblRole1, lblRole2, lblRole3, lblRole4);
            hBoxRole.setPadding(new Insets(10));

            VBox root = new VBox(
                    10, hBoxCharacter, hBoxActor, hBoxRole
            );

            lblRole2.textProperty().bind(
                    txtCharacter.textProperty()
            );
            lblRole4.textProperty().bind(
                    txtActor.textProperty()
            );




            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
