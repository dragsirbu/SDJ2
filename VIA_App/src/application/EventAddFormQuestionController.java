package application;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventAddFormQuestionController implements Initializable {

    @FXML AnchorPane addItem;
    @FXML VBox addPanel;
    private ObservableList<Event> items;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(ObservableList<Event> items) {
        this.items = items;
    }

    public void cancelProcess() {
        Stage stage = (Stage) addItem.getScene().getWindow();
        stage.close();
    }
    public void lectureButtonPressed() throws IOException {
        Stage stage = (Stage) addPanel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/LectureAddForm.fxml"));
        //LectureAddFormController controller = loader.getController();
        stage.setScene(new Scene(loader.load()));
    }
    public void workshopButtonPressed() throws IOException {
        Stage stage = (Stage) addPanel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/WorkshopAddForm.fxml"));
        //WorkshopAddFormController controller = loader.getController();
        stage.setScene(new Scene(loader.load()));
    }
    public void seminarButtonPressed() throws IOException {
        Stage stage = (Stage) addPanel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/SeminarAddForm.fxml"));
        //SeminarAddFormController controller = loader.getController();
        stage.setScene(new Scene(loader.load()));
    }
    public void tripButtonPressed() throws IOException {
        Stage stage = (Stage) addPanel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/TripAddForm.fxml"));
        //TripAddFormController controller = loader.getController();
        stage.setScene(new Scene(loader.load()));
    }
}
