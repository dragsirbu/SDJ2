package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class SpiritualTrip extends Event
{
   private SimpleStringProperty travelAgencyName;
   private LocalDate endDate;

   public SpiritualTrip(String name, String category, LocalDate eventDate, LocalDate endDate, int availablePlaces,
                        int numberOfParticipants, ArrayList<SimpleStringProperty > lecturers, double price,
                        ArrayList<SimpleStringProperty > sponsors, String description, String travelAgencyName)
   {
      super(name, category, eventDate, availablePlaces, numberOfParticipants, lecturers, price, sponsors, description);
      this.travelAgencyName= new SimpleStringProperty(travelAgencyName);
      this.endDate = endDate;
   }

   public void setTravelAgencyName(String travelAgencyName)
   {
      this.travelAgencyName=new SimpleStringProperty(travelAgencyName);
   }

   public String getTravelAgencyName()
   {
      return travelAgencyName.get().trim();
   }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getType()
   {
      return SPIRITUAL_TRIP;
   }
   public String toString(){

      return this.getType()+"; "+super.toString()+"; "+this.getEndDate()+"; "+this.getTravelAgencyName();
   }
}
