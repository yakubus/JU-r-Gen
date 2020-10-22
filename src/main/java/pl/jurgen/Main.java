package pl.jurgen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
    public static void Main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/StagPaneWindow.fxml"));
        GridPane stackPane = loader.load();

        Image icon = new Image("/icon.ico");
        primaryStage.getIcons().add(new Image("/icon.ico"));

        Scene scene = new Scene(stackPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JU(r)Gen - jUnitGnerator");
        primaryStage.show();
    }

}
