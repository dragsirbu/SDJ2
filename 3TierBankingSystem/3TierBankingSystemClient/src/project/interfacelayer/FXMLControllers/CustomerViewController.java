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
import project.bussineslayer.model.interfaces.IBankController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerViewController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML private TextField accountNumberField;
    @FXML private TextField amountField;
    private IBankController bank;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.bank = ServerConnector.getServerConnector().getBank();
    }

    public void backButtonPressed() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/LogIn.fxml"))));
    }

    public void withdrawButtonPressed() {
        int accountNumber = Integer.parseInt(accountNumberField.getText());
        double amount = Double.parseDouble(amountField.getText());
        try {
            Account account = bank.getAccount(accountNumber);
            if (account != null) {
                bank.withdrawMoney(account,amount);
                System.out.println(amount+" withdrawn from Account "+account.getNumber());
            } else {
                System.out.println("Account "+accountNumber+" not found!");
            }
        } catch (Exception e) {
            System.out.println("Exception withdrawing money!");
            e.printStackTrace();
        }
    }
}
