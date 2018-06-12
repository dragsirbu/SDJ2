package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TripAddFormController implements Initializable {
    @FXML VBox addForm;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void goBack() throws IOException {
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/EventAddFormQuestion.fxml"))));
    }
}
