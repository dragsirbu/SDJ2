package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class LecturerAddFormController implements Initializable {

    private ObservableList<Lecturer> items;

    public LecturerList lecturerList = new LecturerList();

    @FXML AnchorPane addForm;
    @FXML TextField nameField;
    @FXML DatePicker dateField;
    @FXML TextField categoryField;
    @FXML TextField phoneField;
    @FXML TextField emailField;
    @FXML TextField addressField;
    @FXML TextField rewardField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void cancelProcess() {
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();
    }
    public void setItems(ObservableList<Lecturer> items) {

        this.items = items;
    }
    public void confirmButtonPressed() throws IOException {
        items.add(new Lecturer(nameField.getText(),dateField.getValue(),categoryField.getText(),phoneField.getText()
                ,emailField.getText(),addressField.getText(),rewardField.getText()));
        lecturerList.updateDataFile(items);
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();
    }
}
