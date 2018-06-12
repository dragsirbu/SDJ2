package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class DetailedEventViewPageController implements Initializable {

    private Event selectedEvent;

    @FXML VBox detailsPanel;
    @FXML Label nameLabel;
    @FXML Label typeLabel;
    @FXML Label categoryLabel;
    @FXML Label dateLabel;
    @FXML Label totalPlacesLabel;
    @FXML Label availablePlacesLabel;
    @FXML Label lecturersLabel;
    @FXML Label priceLabel;
    @FXML Label sponsorsLabel;
    @FXML Label descriptionLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void initData(Event event){
        selectedEvent = event;
        nameLabel.setText(event.getName());
        typeLabel.setText(event.getType());
        categoryLabel.setText(event.getCategory());
        dateLabel.setText(event.getEventDate().toString());
        totalPlacesLabel.setText(event.getTotalPlaces()+"");
        availablePlacesLabel.setText(event.getAvailablePlaces()+"");

        String lecturers ="";
        for (int i = 0; i < event.getLecturers().size(); i++) {
            if (i != event.getLecturers().size()-1){
                lecturers+=event.getLecturers().get(i).get()+", ";
            }
            else {
                lecturers+=event.getLecturers().get(i).get();
            }
        }

        lecturersLabel.setText(lecturers);

        priceLabel.setText(event.getPrice()+"");

        String sponsors = "";
        for (int i = 0; i < event.getSponsors().size(); i++) {
            if (i != event.getSponsors().size()-1){
                sponsors+=event.getSponsors().get(i).get()+", ";
            }
            else {
                sponsors+=event.getSponsors().get(i).get();
            }
        }
        sponsorsLabel.setText(sponsors);
        descriptionLabel.setText(event.getDescription());
    }
    public void okButtonPressed() {
        Stage stage = (Stage) detailsPanel.getScene().getWindow();
        stage.close();
    }
}
