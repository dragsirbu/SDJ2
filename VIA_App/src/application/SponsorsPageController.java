package application;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SponsorsPageController implements Initializable {
    @FXML AnchorPane sponsorsPanel;
    @FXML private TextField searchField;
    @FXML private Button removeButton;
    @FXML private TableView<Sponsor> sponsorsTable;
    @FXML private TableColumn<Sponsor,String> nameColumn;
    @FXML private TableColumn<Sponsor,String> phoneColumn;
    @FXML private TableColumn<Sponsor,String> emailColumn;
    @FXML private TableColumn<Sponsor,String> addressColumn;
    @FXML private TableColumn<Sponsor,String> typeColumn;
    public SponsorList sponsorList;

    public void changeNameEvent(TableColumn.CellEditEvent editedCell) {
        Sponsor sponsorSelected = sponsorsTable.getSelectionModel().getSelectedItem();
        sponsorSelected.setName(editedCell.getNewValue().toString());
    }


    public void changeSponsorshipTypeEvent(TableColumn.CellEditEvent editedCell) {
        Sponsor sponsorSelected = sponsorsTable.getSelectionModel().getSelectedItem();
        sponsorSelected.setTypeOfSponsorship(editedCell.getNewValue().toString());
    }


    public void changePhoneEvent(TableColumn.CellEditEvent editedCell) {
        Sponsor sponsorSelected = sponsorsTable.getSelectionModel().getSelectedItem();
        sponsorSelected.setPhoneNumber(editedCell.getNewValue().toString());
    }


    public void changeEmailEvent(TableColumn.CellEditEvent editedCell) {
        Sponsor sponsorSelected = sponsorsTable.getSelectionModel().getSelectedItem();
        sponsorSelected.setEmail(editedCell.getNewValue().toString());
    }
    public void changeAddressEvent(TableColumn.CellEditEvent editedCell) {
        Sponsor sponsorSelected = sponsorsTable.getSelectionModel().getSelectedItem();
        sponsorSelected.setAddress(editedCell.getNewValue().toString());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("address"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Sponsor,String>("typeOfSponsorship"));

        sponsorList = new SponsorList();
        sponsorsTable.setItems(sponsorList.getSponsors());

        makeFilteredList(sponsorList.getSponsors());

        sponsorsTable.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    public void goBack() throws IOException {
        Stage stage = (Stage) sponsorsPanel.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/MainPage.fxml"))));
    }
    public void addButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add new sponsor");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/SponsorAddForm.fxml"));
        window.setScene(new Scene(loader.load()));
        SponsorAddFormController controller = loader.getController();
        controller.setItems(sponsorList.getSponsors());
        window.showAndWait();
    }
    public void removeButtonPressed() throws IOException {
        ObservableList<Sponsor> sponsors = sponsorList.getSponsors();
        ObservableList<Sponsor> selected = sponsorsTable.getSelectionModel().getSelectedItems();
        selected.forEach(sponsors::remove);
        makeFilteredList(sponsors);
        sponsorList.updateDataFile(sponsors);
    }
    public void makeFilteredList(ObservableList<Sponsor> list) {
        FilteredList<Sponsor> filteredList = new FilteredList<>(list, p -> true);

        searchField.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredList.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                if(person.getName().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Sponsor> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(sponsorsTable.comparatorProperty());
        sponsorsTable.setItems(sortedList);
    }
    public void removeButtonAppear() {
        removeButton.setVisible(true);
    }

}
