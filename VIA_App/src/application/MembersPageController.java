package application;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;

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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ResourceBundle;

    public class MembersPageController implements Initializable {


    public MemberList memberList;

    @FXML private AnchorPane membersPanel;
    @FXML private TextField searchField;
    @FXML protected TableView<Member> membersTable;
    @FXML protected  TableColumn<Member,String> nameColumn;
    @FXML protected  TableColumn<Member, LocalDate> birthdateColumn;
    @FXML protected  TableColumn<Member,String>  addressColumn;
    @FXML protected  TableColumn<Member,String>  emailColumn;
    @FXML private Button removeButton;

    @FXML protected  TableColumn<Member,String>  phoneColumn;


    public void changeNameEvent(CellEditEvent editedCell) {
        Member memberSelected = membersTable.getSelectionModel().getSelectedItem();
        memberSelected.setName(editedCell.getNewValue().toString());
        try {
            memberList.updateDataFile(membersTable.getItems());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void changeAddressEvent(CellEditEvent editedCell) {
        Member memberSelected = membersTable.getSelectionModel().getSelectedItem();
        memberSelected.setAddress(editedCell.getNewValue().toString());
        try {
            memberList.updateDataFile(membersTable.getItems());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void changePhoneEvent(CellEditEvent editedCell) {
        Member memberSelected = membersTable.getSelectionModel().getSelectedItem();
        memberSelected.setPhoneNumber(editedCell.getNewValue().toString());
        try {
            memberList.updateDataFile(membersTable.getItems());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void changeEmailEvent(CellEditEvent editedCell) {
        Member memberSelected = membersTable.getSelectionModel().getSelectedItem();
        memberSelected.setEmail(editedCell.getNewValue().toString());
        try {
            memberList.updateDataFile(membersTable.getItems());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){


        //set up the data in the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("name"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<Member,LocalDate>("birthdate"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("phoneNumber"));

        memberList = new MemberList();
        membersTable.setItems(memberList.getMembers());

        makeFilteredList(memberList.getMembers());


        membersTable.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void addNewMemberButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add new member");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/MemberAddForm.fxml"));
        window.setScene(new Scene(loader.load()));
        MemberAddFormController controller = loader.getController();
        controller.setItems(memberList.getMembers());
        window.showAndWait();
    }
    public void removeButtonAppear() {
        removeButton.setVisible(true);
    }
    public void detailsButtonPressed() throws IOException {
        Member selectedMember = membersTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML Pages/DetailedMemberViewPage.fxml"));
        loader.load();
        DetailedMemberViewPageController controller = loader.getController();
        controller.initData(selectedMember);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }
    public void removeButtonPressed() throws IOException {
        ObservableList<Member> members = memberList.getMembers();
        ObservableList<Member> selected = membersTable.getSelectionModel().getSelectedItems();
        selected.forEach(members::remove);
        makeFilteredList(members);
        memberList.updateDataFile(members);
    }
    public void goBack() throws IOException {
        Stage stage = (Stage) membersPanel.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/MainPage.fxml"))));
    }
    public void makeFilteredList(ObservableList<Member> list) {
        FilteredList<Member> filteredList = new FilteredList<>(list,p -> true);

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
        SortedList<Member> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(membersTable.comparatorProperty());
        membersTable.setItems(sortedList);
    }

}
