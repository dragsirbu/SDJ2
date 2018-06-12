package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lecture extends Event
{
    private SimpleStringProperty type;
   public Lecture(String name, String category, LocalDate eventDate, int availablePlaces, int numberOfParticipants,
                  ArrayList<SimpleStringProperty> lecturers, double price, ArrayList<SimpleStringProperty > sponsors,
                  String description)
   {
      super(name, category, eventDate,availablePlaces, numberOfParticipants, lecturers, price, sponsors, description);
      this.type = new SimpleStringProperty(LECTURE);

   }
    public String getType(){
       return this.type.get();
    }

    @Override
    public String getTravelAgencyName() {
        return null;
    }

    @Override
    public LocalDate getEndDate() {
        return null;
    }

    public String toString() {
       return this.getType()+"; "+super.toString();
    }
}
