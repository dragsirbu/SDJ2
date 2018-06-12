package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LectureAddFormController implements Initializable {

    private ObservableList<Event> items;
    @FXML VBox addForm;
    @FXML TextField nameField;
    @FXML TextField categoryField;
    @FXML TextField totalPlacesField;
    @FXML TextField availablePlacesField;
    @FXML TextField lecturersField;
    @FXML TextField priceField;
    @FXML TextField sponsorsField;
    @FXML DatePicker dateField;
    @FXML TextField descriptionField;

    public EventList eventList= new EventList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void goBack() throws IOException {
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/EventAddFormQuestion.fxml"))));
    }

    public void setItems(ObservableList<Event> items) {
        this.items = items;
    }

    public void confirmButtonPressed() throws IOException {
        items.add(new Lecture(nameField.getText(), categoryField.getText(), dateField.getValue(), Integer.parseInt(totalPlacesField.getText()),
                Integer.parseInt(availablePlacesField.getText()), EventsPageController.getInfo(lecturersField.getText())
                , Double.parseDouble(priceField.getText()), EventsPageController.getInfo(sponsorsField.getText())
                , descriptionField.getText()));

        //eventList.updateDataFile(items);

        /*DataOutputStream outputFile = new DataOutputStream(
                new FileOutputStream("C:\\Users\\dragu\\IdeaProjects\\VIA\\src\\InfoFiles\\events.dat"));
        for (int i = 0; i < items.size(); i++) {
            outputFile.writeUTF(items.get(i).toString());
        }*/
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();

    }

}
