package project.interfacelayer.FXMLControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.bussineslayer.ServerConnector;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.IBankController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LogInController implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    private IBankController bank;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bank = ServerConnector.getServerConnector().getBank();
    }

    public void logInButtonPressed() throws IOException {
       Stage stage = (Stage) anchorPane.getScene().getWindow();
       FXMLLoader loader = new FXMLLoader();
       if (bank.isAdmin(new Administrator(usernameField.getText(),passwordField.getText()))) {
           Administrator administrator = new Administrator(usernameField.getText(),passwordField.getText());
           loader.setLocation(getClass().getResource("../FXML/AdminView.fxml"));
           loader.load();
           AdminViewController controller = loader.getController();
           controller.setAdministratorController(administrator);
           Parent window = loader.getRoot();
           stage.setScene(new Scene(window));
       }
       else if (bank.isClerk(new Clerk(usernameField.getText(),passwordField.getText()))) {
           Clerk clerk = new Clerk(usernameField.getText(), passwordField.getText());
           loader.setLocation(getClass().getResource("../FXML/ClerkView.fxml"));
           loader.load();
           ClerkViewController controller = loader.getController();
           controller.setClerkController(clerk);
           Parent window = loader.getRoot();
           stage.setScene(new Scene(window));
       }
       else if (bank.isCustomer(new Customer(usernameField.getText(),passwordField.getText()))) {
           Customer customer = new Customer(usernameField.getText(),passwordField.getText());
           loader.setLocation(getClass().getResource("../FXML/CustomerView.fxml"));
           loader.load();
           CustomerViewController controller = loader.getController();
           controller.setCustomerController(customer);
           Parent window = loader.getRoot();
           stage.setScene(new Scene(window));
       }
   }
}
