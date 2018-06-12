package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailedMemberViewPageController implements Initializable {
    public Member selectedMember;
    @FXML public VBox detailsPanel;
    @FXML public Label nameField;
    @FXML public Label birthdateField;
    @FXML public Label addressField;
    @FXML public Label phoneField;
    @FXML public Label emailField;
    @FXML public Label eventsField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void initData(Member member) {
        selectedMember = member;
        nameField.setText(selectedMember.getName());
        birthdateField.setText(selectedMember.getBirthdate().toString());
        addressField.setText(selectedMember.getAddress());
        phoneField.setText(selectedMember.getPhoneNumber());
        emailField.setText(selectedMember.getEmail());
//        eventsField.setText(selectedMember.getAttendedEvents().toString());
    }
    public void okButtonPressed() {
        Stage stage = (Stage) detailsPanel.getScene().getWindow();
        stage.close();
    }
}
