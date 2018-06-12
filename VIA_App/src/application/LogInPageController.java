package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInPageController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label incorrectDataLabel;
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passwordField;
    public void buttonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
//        if (userField.getText().equals("Dragos Sirbu") && (passwordField.getText().equals("1234567")))
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/MainPage.fxml"))));
//        else
//            incorrectDataLabel.setVisible(true);
    }

}
