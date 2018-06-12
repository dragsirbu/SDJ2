package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class DetailedLecturerViewPageController implements Initializable {
    public Lecturer selectedLecturer;
    @FXML VBox detailsPanel;
    @FXML Label nameField;
    @FXML Label birthdateField;
    @FXML Label categoryField;
    @FXML Label phoneField;
    @FXML Label emailField;
    @FXML Label addressField;
    @FXML Label rewardField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void initData(Lecturer lecturer) {
        selectedLecturer = lecturer;
        nameField.setText(selectedLecturer.getName());
        birthdateField.setText(selectedLecturer.getBirthdate().toString());
        categoryField.setText(selectedLecturer.getCategory());
        phoneField.setText(selectedLecturer.getPhoneNumber());
        emailField.setText(selectedLecturer.getEmail());
        addressField.setText(selectedLecturer.getAddress());
        rewardField.setText(selectedLecturer.getTypeOfReward());
    }
    public void okButtonPressed() {
        Stage stage = (Stage) detailsPanel.getScene().getWindow();
        stage.close();
    }
}
