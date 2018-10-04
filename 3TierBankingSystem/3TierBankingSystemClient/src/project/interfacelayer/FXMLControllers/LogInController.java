package project.interfacelayer.FXMLControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.bussineslayer.Bank;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;

import java.io.IOException;


public class LogInController {

    @FXML private AnchorPane anchorPane;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;



   private Bank bank = new Bank();

   public void logInButtonPressed() throws IOException {
       Stage stage = (Stage) anchorPane.getScene().getWindow();
       if (bank.isAdmin(new Administrator(usernameField.getText(),passwordField.getText())))
           stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/AdminView.fxml"))));
       else if (bank.isClerk(new Clerk(usernameField.getText(),passwordField.getText())))
           stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/ClerkView.fxml"))));
       else if (bank.isCustomer(new Customer(usernameField.getText(),passwordField.getText())))
           stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML/CustomerView.fxml"))));
   }


}
