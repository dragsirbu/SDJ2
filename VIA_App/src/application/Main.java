package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Parent root = FXMLLoader.load(getClass().getResource("../FXML Pages/LogInPage.fxml"));
        primaryStage.setTitle("Vipassana Insight Awareness");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



}
