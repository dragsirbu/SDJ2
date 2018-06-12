package Controller.Add;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.Airplane;
import Domain.Model.AirplaneList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class A_Airplane implements Initializable{

    @FXML AnchorPane anchorPane;
    @FXML TextField addIDNumber;
    @FXML TextField addModel;
    @FXML TextField addNumberOfSeats;
    @FXML DatePicker addPurchaseDate;
    @FXML DatePicker addLastMaintenance;
    ObservableList<Airplane> items;
    public AirplaneList airplaneList= new AirplaneList();
    DatabaseAdapter adapter= new DatabaseAdapter();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(ObservableList <Airplane> items) {
        this.items= items;
    }
    public void addAirplaneFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    public void addAirplaneToTheList(ActionEvent actionEvent) {
        items.add(new Airplane(addIDNumber.getText(), addModel.getText(), Integer.parseInt(addNumberOfSeats.getText()), addPurchaseDate.getValue(), addLastMaintenance.getValue()));

        adapter.addAirplane(new Airplane(addIDNumber.getText(), addModel.getText(), Integer.parseInt(addNumberOfSeats.getText()), addPurchaseDate.getValue(), addLastMaintenance.getValue()));
        airplaneList.updateList(items);

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }



}
