package project.interfacelayer.FXMLControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.bussineslayer.Bank;

import java.io.IOException;

public class AdminViewController {

    @FXML private AnchorPane anchorPane;
    Bank bank = new Bank();

    public void backButtonPressed() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/LogIn.fxml"))));
    }

    public void createAccountButtonPressed() {

    }


}
