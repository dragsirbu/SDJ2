package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class PassengerList {
    private ObservableList<Passenger> passengers;
    DatabaseAdapter adapter;

    public PassengerList() {
        this.passengers = adapter.loadPassengers();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void deletePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    public void setPassengers(ObservableList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ObservableList<Passenger> getPassengers() {
        return passengers;
    }


}
