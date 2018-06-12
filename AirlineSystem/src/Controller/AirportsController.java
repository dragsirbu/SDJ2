package Controller;


import Domain.Model.Airport;
import Domain.Model.AirportList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AirportsController implements Initializable{

    @FXML AnchorPane anchorPane;

    AirportList airportList;

    @FXML protected TableView<Airport> airportsTable;
    @FXML protected TableColumn<Airport, String> code;
    @FXML protected TableColumn<Airport, String> name;
    @FXML protected TableColumn<Airport, String> city;
    @FXML protected TableColumn<Airport, String> postcode;
    @FXML protected TableColumn<Airport, String> country;
    @FXML protected TableColumn<Airport, String> numberOfGates;
    @FXML private Button removeButton;
    @FXML private TextField searchField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        code.setCellValueFactory(new PropertyValueFactory<Airport, String>("code"));
        name.setCellValueFactory(new PropertyValueFactory<Airport, String>("name"));
        city.setCellValueFactory(new PropertyValueFactory<Airport, String>("city"));
        postcode.setCellValueFactory(new PropertyValueFactory<Airport, String>("postcode"));
        country.setCellValueFactory(new PropertyValueFactory<Airport, String>("country"));
        numberOfGates.setCellValueFactory(new PropertyValueFactory<Airport, String>("numberOfGates"));

        airportList= new AirportList();
        airportsTable.setItems(airportList.getAirports());

        airportsTable.setEditable(true);
        code.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        city.setCellFactory(TextFieldTableCell.forTableColumn());
        postcode.setCellFactory(TextFieldTableCell.forTableColumn());
        country.setCellFactory(TextFieldTableCell.forTableColumn());
        numberOfGates.setCellFactory(TextFieldTableCell.forTableColumn());

        airportsTable.getColumns().clear();
        airportsTable.getColumns().addAll(code, name, city, postcode, country, numberOfGates);

    }

    //Associate data with column

    public void addAirportButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Airport Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddAirportForm.fxml")));
        window.setScene(new Scene(loader.load()));
        AddAirportFormController controller = loader.getController();
        controller.setItems(airportList.getAirports());
        window.showAndWait();
    }

    public void removeAirportButtonPressed() throws IOException {
        ObservableList<Airport> airports= airportList.getAirports();
        ObservableList<Airport> selected= airportsTable.getSelectionModel().getSelectedItems();
        selected.forEach(airports::remove);
        makeFilteredList(airports);
        airportList.updateList(airports);

    }
    public void makeFilteredList(ObservableList<Airport> list){
        FilteredList<Airport> filteredList= new FilteredList<>(list, p->true);

        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(airport -> {
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                if(airport.getName().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Airport> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(airportsTable.comparatorProperty());
        airportsTable.setItems(sortedList);
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }

    public void ManageAirportsGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeAirportButtonPressed(ActionEvent actionEvent) throws IOException {
        ObservableList<Airport> airports= airportList.getAirports();
        ObservableList<Airport> selected= airportsTable.getSelectionModel().getSelectedItems();
        selected.forEach(airports::remove);
        makeFilteredList(airports);
        airportList.updateList(airports);
    }

}
