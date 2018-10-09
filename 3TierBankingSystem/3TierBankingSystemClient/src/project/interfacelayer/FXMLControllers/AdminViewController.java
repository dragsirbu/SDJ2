package project.interfacelayer.FXMLControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.bussineslayer.ServerConnector;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.interfaces.IBankController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private TextField accountNumberField;
    @FXML private TextField balanceField;
    private IBankController bank;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bank = ServerConnector.getServerConnector().getBank();
    }

    public void setAdministratorController(Administrator administrator) {
        try {
            bank.setAdministratorController(administrator);
        } catch (Exception e) {
            System.out.println("Exception in setting administrator controller!");
            e.printStackTrace();
        }
    }

    public void backButtonPressed() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/LogIn.fxml"))));
    }

    public void createAccountButtonPressed() {
        int accountNumber = Integer.parseInt(accountNumberField.getText());
        double balance = Double.parseDouble(balanceField.getText());
        try {
            bank.createAccount(accountNumber, balance);
            System.out.println("Account created: ");
            accountNumberField.clear();
            balanceField.clear();
        } catch (Exception e) {
            System.out.println("Error creating account!");
            e.printStackTrace();
        }
    }


}
