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

public class LecturersPageController implements Initializable {
    @FXML AnchorPane lecturersPanel;
    @FXML TextField searchField;
    @FXML TextField searchField1;
    @FXML Button removeButton;
    @FXML private TableView<Lecturer> lecturersTable;
    @FXML private TableColumn<Lecturer,String> nameColumn;
    @FXML private TableColumn<Lecturer,LocalDate> birthdateColumn;
    @FXML private TableColumn<Lecturer,String> categoryColumn;
    @FXML private TableColumn<Lecturer,String> phoneColumn;
    @FXML private TableColumn<Lecturer,String> emailColumn;
    public LecturerList lecturerList;

    public void changeNameEvent(TableColumn.CellEditEvent editedCell) {
        Lecturer lecturerSelected = lecturersTable.getSelectionModel().getSelectedItem();
        lecturerSelected.setName(editedCell.getNewValue().toString());
    }


    public void changeCategoryEvent(TableColumn.CellEditEvent editedCell) {
        Lecturer lecturerSelected = lecturersTable.getSelectionModel().getSelectedItem();
        lecturerSelected.setAddress(editedCell.getNewValue().toString());
    }


    public void changePhoneEvent(TableColumn.CellEditEvent editedCell) {
        Lecturer lecturerSelected = lecturersTable.getSelectionModel().getSelectedItem();
        lecturerSelected.setPhoneNumber(editedCell.getNewValue().toString());
    }


    public void changeEmailEvent(TableColumn.CellEditEvent editedCell) {
        Lecturer lecturerSelected = lecturersTable.getSelectionModel().getSelectedItem();
        lecturerSelected.setEmail(editedCell.getNewValue().toString());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Lecturer,String>("name"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<Lecturer,LocalDate>("birthdate"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Lecturer,String>("category"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Lecturer,String>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Lecturer,String>("email"));

        lecturerList = new LecturerList();
        lecturersTable.setItems(lecturerList.getLecturers());

        makeFilteredList(lecturerList.getLecturers());





        lecturersTable.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    public void goBack() throws IOException {
        Stage stage = (Stage) lecturersPanel.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/MainPage.fxml"))));
    }
    public void detailsButtonPressed() throws IOException {
        Lecturer selectedLecturer = lecturersTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML Pages/DetailedLecturerViewPage.fxml"));
        loader.load();
        DetailedLecturerViewPageController controller = loader.<DetailedLecturerViewPageController>getController();
        controller.initData(selectedLecturer);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }
    public void addButtonPressed() throws IOException{
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add new lecturer");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/LecturerAddForm.fxml"));
        window.setScene(new Scene(loader.load()));
        LecturerAddFormController controller = loader.getController();
        controller.setItems(lecturerList.getLecturers());
        window.showAndWait();
    }
    public void removeButtonPressed() throws IOException {
        ObservableList<Lecturer> lecturers = lecturerList.getLecturers();
        ObservableList<Lecturer> selected = lecturersTable.getSelectionModel().getSelectedItems();
        selected.forEach(lecturers::remove);
        makeFilteredList(lecturers);
        lecturerList.updateDataFile(lecturers);
    }
    public void makeFilteredList(ObservableList<Lecturer> list) {
        FilteredList<Lecturer> filteredList = new FilteredList<>(list, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                if (person.getName().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Lecturer> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(lecturersTable.comparatorProperty());
        lecturersTable.setItems(sortedList);
    }
    public void removeButtonAppear() {
        removeButton.setVisible(true);
    }
}
