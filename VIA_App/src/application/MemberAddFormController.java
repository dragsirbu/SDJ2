package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public  class MemberAddFormController implements Initializable {
    @FXML protected AnchorPane addForm;

    @FXML protected TextField nameField;

    @FXML protected TextField addressField;

    @FXML protected TextField phoneField;

    @FXML protected TextField emailField;

    @FXML protected DatePicker dateField;

    private ObservableList<Member> items;

    public MemberList memberList = new MemberList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void cancelProcess() {
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();
    }
    public void setItems(ObservableList<Member> items) {
        this.items = items;
    }

    public void confirmButtonPressed() throws IOException {
        items.add(new Member(nameField.getText(),dateField.getValue()
                ,addressField.getText(),emailField.getText(),phoneField.getText()));

        memberList.updateDataFile(items);

        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();
    }


}
