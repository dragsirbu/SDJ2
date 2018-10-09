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
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.interfaces.IBankController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClerkViewController implements Initializable{

    @FXML
    private AnchorPane anchorPane;
    @FXML
    TextField accountNumberField;
    @FXML TextField amountField;
    private IBankController bank;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bank = ServerConnector.getServerConnector().getBank();
    }

    public void setClerkController(Clerk clerk) {
        try {
            bank.setClerkController(clerk);
        } catch (Exception e) {
            System.out.println("Exception in setting clerk controller!");
            e.printStackTrace();
        }
    }

    public void backButtonPressed() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/LogIn.fxml"))));
    }

    public void withdrawButtonPressed() {
        try {
            bank.clerkWithdrawMoney(Integer.parseInt(accountNumberField.getText()), Double.parseDouble(amountField.getText()));
        } catch (Exception e) {
            System.out.println("Exception in clerk withdrawing money!");
            e.printStackTrace();
        }
    }

    public void insertButtonPressed() {
        try {
            bank.clerkInsertMoney(Integer.parseInt(accountNumberField.getText()), Double.parseDouble(amountField.getText()));
        } catch (Exception e) {
            System.out.println("Exception in clerk inserting money!");
            e.printStackTrace();
        }
    }
}
