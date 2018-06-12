package Domain.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class Airplane {
    private SimpleStringProperty IDNumber;
    private SimpleStringProperty model;
    private SimpleIntegerProperty numberOfSeats;
    private LocalDate purchaseDate;
    private LocalDate lastMaintenance;

    public Airplane(String IDNumber, String model, int numberOfSeats, LocalDate purchaseDate, LocalDate lastMaintenance) {
        this.IDNumber = new SimpleStringProperty(IDNumber);
        this.model = new SimpleStringProperty(model);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
        this.purchaseDate = purchaseDate;
        this.lastMaintenance = lastMaintenance;
    }


    public void setIDNumber(String IDNumber) {
        this.IDNumber = new SimpleStringProperty(IDNumber);
    }

    public void setModel(String model) {
        this.model = new SimpleStringProperty(model);
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setLastMaintenance(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public String getModel() {
        return model.get();
    }

    public String getIDNumber() {
        return IDNumber.get();
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats.get();
    }

    public LocalDate getLastMaintenance() {
        return lastMaintenance;
    }

    @Override
    public String toString() {
        return "Model: "+getModel()+"Number: "+getIDNumber()+"; Purchase date: "+getPurchaseDate()+"; Number of seats: "
                +getNumberOfSeats()+"; Last maintenance: "+getLastMaintenance();
    }
}

