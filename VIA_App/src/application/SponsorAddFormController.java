package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SponsorAddFormController implements Initializable {

    private SponsorList sponsorList = new SponsorList();

    private ObservableList<Sponsor> items;

    @FXML AnchorPane addForm;
    @FXML TextField nameField;
    @FXML TextField phoneField;
    @FXML TextField emailField;
    @FXML TextField addressField;
    @FXML TextField typeField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void cancelProcess() {
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();
    }
    public void setItems(ObservableList<Sponsor> items) {
        this.items = items;
    }
    public void confirmButtonPressed() throws IOException {
        items.add(new Sponsor(nameField.getText(),phoneField.getText(),emailField.getText(),addressField.getText(),
                typeField.getText()));
        sponsorList.updateDataFile(items);
        Stage stage = (Stage) addForm.getScene().getWindow();
        stage.close();
    }
}
