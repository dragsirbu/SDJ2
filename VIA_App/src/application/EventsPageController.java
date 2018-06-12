package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class EventsPageController implements Initializable {
    @FXML HBox eventsPanel;
    @FXML Button removeEventButton;
    @FXML Button addParticipantButton;
    @FXML TextField searchField;
    @FXML TableView<Event> eventsTable;
    @FXML TableColumn<Event,String> nameColumn;
    @FXML TableColumn<Event,String> typeColumn;
    @FXML TableColumn<Event,LocalDate> dateColumn;
    @FXML TableColumn<Event,String> placesColumn;
    @FXML TableColumn<Event,String> priceColumn;
    public EventList eventList;



    @Override
    public void initialize (URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Event,String>("type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Event,LocalDate>("eventDate"));
        placesColumn.setCellValueFactory(new PropertyValueFactory<Event,String>("availablePlaces"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Event,String>("price"));

        eventsTable.setItems(getItems());

        FilteredList<Event> filteredList = new FilteredList<>(getItems(), p -> true);

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
        SortedList<Event> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(eventsTable.comparatorProperty());
        eventsTable.setItems(sortedList);

    }
    public ObservableList<Event> getItems() {

        ObservableList<Event> events = FXCollections.observableArrayList();
        String name, category, description, type, travelAgencyName="";
        LocalDate eventDate;
        LocalDate endDate = LocalDate.now();
        int totalPlaces, numberOfParticipants;
        double price;
        ArrayList<SimpleStringProperty> sponsors = new ArrayList<>();
        ArrayList<SimpleStringProperty> lecturers = new ArrayList<>();
        boolean endOfFile = false;
        try {
            DataInputStream inputFile = new DataInputStream(
                    new FileInputStream("src\\InfoFiles\\events.dat"));
            while(!endOfFile) {
                String info = inputFile.readUTF();
                StringTokenizer tokenizer = new StringTokenizer(info,";");
                type = tokenizer.nextToken().trim();
                name = tokenizer.nextToken().trim();
                category = tokenizer.nextToken().trim();
                eventDate = MemberList.getDate(tokenizer.nextToken());
                totalPlaces = Integer.parseInt(tokenizer.nextToken().trim());
                numberOfParticipants = Integer.parseInt(tokenizer.nextToken().trim());
                lecturers = getInfo(tokenizer.nextToken().trim());
                price = Double.parseDouble(tokenizer.nextToken().trim());
                sponsors = getInfo(tokenizer.nextToken().trim());
                description = tokenizer.nextToken();
                if (type.equals(Event.LECTURE)) {
                    events.add(new Lecture(name,category,eventDate,totalPlaces,numberOfParticipants,lecturers,price
                            ,sponsors,description));
                }
                else if(type.equals(Event.SEMINAR)) {
                    events.add(new Seminar(name,category,eventDate,totalPlaces,numberOfParticipants,lecturers,price
                            ,sponsors,description));
                }
                else if(type.equals(Event.WORKSHOP)) {
                    events.add(new Workshop(name,category,eventDate,totalPlaces,numberOfParticipants,lecturers,price
                            ,sponsors,description));
                }
                else if(type.equals(Event.SPIRITUAL_TRIP)){
                    endDate = MemberList.getDate(tokenizer.nextToken());
                    travelAgencyName = tokenizer.nextToken().trim();
                    events.add(new SpiritualTrip(name,category,eventDate,endDate,totalPlaces,numberOfParticipants,lecturers,price
                            ,sponsors,description,travelAgencyName));
                }
            }
        }
        catch (IOException e){
            endOfFile = true;
        }
        return events;
    }
    public static ArrayList<SimpleStringProperty> getInfo(String info) {
        ArrayList<SimpleStringProperty> lecturers = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(info.trim(),", ");
        while(tokenizer.hasMoreTokens()) {
            lecturers.add(new SimpleStringProperty(tokenizer.nextToken().trim()));
        }
        return lecturers;
    }
    public void goBack() throws IOException {
        Stage stage = (Stage) eventsPanel.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../FXML Pages/MainPage.fxml"))));
    }
    public void detailsButtonPressed() throws IOException {
        Event selectedEvent = eventsTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        if(selectedEvent.getType().equals(Event.WORKSHOP) || selectedEvent.getType().equals(Event.LECTURE) ||
                selectedEvent.getType().equals(Event.SEMINAR)) {
            loader.setLocation(getClass().getResource("../FXML Pages/DetailedEventView.fxml"));
            loader.load();
            DetailedEventViewPageController controller = loader.getController();
            controller.initData(selectedEvent);
        }
        else if(selectedEvent.getType().equals(Event.SPIRITUAL_TRIP)){
            loader.setLocation(getClass().getResource("../FXML Pages/DetailedTripView.fxml"));
            loader.load();
            DetailedTripViewPageController controller = loader.getController();
            controller.initData(selectedEvent);
        }


        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Event details");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }
    public void addButtonPressed() throws IOException{
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add new event");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML Pages/EventAddFormQuestion.fxml"));
        window.setScene(new Scene(loader.load()));
        EventAddFormQuestionController controller = loader.getController();
        controller.setItems(this.getItems());

        window.showAndWait();
    }
    /*public void removeButtonPressed() throws IOException {
        ObservableList<Event> events = eventList.getAllEvents();
        ObservableList<Event> selected = eventsTable.getSelectionModel().getSelectedItems();
        selected.forEach(events::remove);
        eventsTable.setItems(lecturers);
        lecturerList.updateDataFile(lecturers);
    }*/
    public void ButtonsAppear() {
        removeEventButton.setVisible(true);
        addParticipantButton.setVisible(true);
    }
}
