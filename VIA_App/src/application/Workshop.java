package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Workshop extends Event
{

   public Workshop(String name, String category, LocalDate eventDate, int totalPlaces, int numberOfParticipants,
                   ArrayList<SimpleStringProperty> lecturers, double price, ArrayList<SimpleStringProperty> sponsors,
                   String description)
   {
      super(name, category, eventDate, totalPlaces, numberOfParticipants, lecturers, price, sponsors, description);
   }

   public String getType()
   {
      return WORKSHOP;
   }
   public String toString() {
      return this.getType()+"; "+super.toString();
   }

   @Override
   public String getTravelAgencyName() {
      return null;
   }

   @Override
   public LocalDate getEndDate() {
      return null;
   }
}
