package project.interfacelayer.FXMLControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.bussineslayer.ServerConnector;
import project.bussineslayer.model.interfaces.IBankController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClerkViewController implements Initializable{

    @FXML
    private AnchorPane anchorPane;
    private IBankController bank;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bank = ServerConnector.getServerConnector().getBank();
    }

    public void backButtonPressed() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/LogIn.fxml"))));
    }
}
