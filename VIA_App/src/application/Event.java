package application;



import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Event
{
   public static final String LECTURE="Lecture";
   public static final String SEMINAR="Seminar";
   public static final String WORKSHOP="Workshop";
   public static final String SPIRITUAL_TRIP="Spiritual trip";
   private SimpleStringProperty name;
   private SimpleStringProperty category;
   private LocalDate eventDate;
//   private int eventDuration;
   private int totalPlaces;
   private int numberOfParticipants;
   private ArrayList<SimpleStringProperty > lecturers;
   private double price;
   private int availablePlaces;
   private ArrayList<SimpleStringProperty > sponsors;
   private SimpleStringProperty description;
//   private ObservableList<Feedback> feedbackList;

   public Event(String name, String category, LocalDate eventDate, int totalPlaces, int numberOfParticipants,
         ArrayList<SimpleStringProperty> lecturers, double price, ArrayList<SimpleStringProperty > sponsors,
         String description)
   {
      this.name = new SimpleStringProperty(name);
      this.category = new SimpleStringProperty(category);
      this.eventDate = eventDate;
      this.totalPlaces = totalPlaces;
      this.numberOfParticipants = numberOfParticipants;
      this.lecturers = lecturers;
      this.price = price;
      this.sponsors = sponsors;
      this.description = new SimpleStringProperty(description);
//      feedbackList = new ArrayList<>();
   }


   public void setName(String name) {
      this.name = new SimpleStringProperty(name);
   }

   public void setCategory(String category) {
      this.category = new SimpleStringProperty(category);
   }

   public void setEventDate(LocalDate eventDate) {
      this.eventDate = eventDate;
   }

   public void setTotalPlaces(int availablePlaces) {
      this.totalPlaces= availablePlaces;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public void setDescription(String description) {
      this.description = new SimpleStringProperty(description);
   }

   public void addParticipant()
   {
      this.numberOfParticipants++;
   }

   public void addLecturer(SimpleStringProperty  lecturer) {
      lecturers.add(lecturer);
   }

   public void addSponsor(SimpleStringProperty  sponsor) {
      sponsors.add(sponsor);
   }

   public void removeParticipant()
   {
      this.numberOfParticipants--;
   }

   public void removeLecturer(SimpleStringProperty lecturer) {
      lecturers.remove(lecturer);
   }

   public void removeSponsor(SimpleStringProperty sponsor) {
      sponsors.remove(sponsor);
   }

   public String getName() {
      return this.name.get().trim();
   }

   public String getCategory() {
      return category.get().trim();
   }

   public LocalDate getEventDate() {
      return eventDate;
   }
   public abstract String getType();

   public int getTotalPlaces() {
      return totalPlaces;
   }

   public abstract LocalDate getEndDate();
   public abstract String getTravelAgencyName();

   public int getAvailablePlaces() {
      availablePlaces = totalPlaces - numberOfParticipants;
      return availablePlaces;
   }

   public int getNumberOfParticipants() {
      return numberOfParticipants;
   }
//
//   public Feedback[] getFeedback(){
//      Feedback[] temp= new Feedback[feedbackList.size()];
//      for(int i=0; i<feedbackList.size();i++){
//         temp[i]=feedbackList.get(i);
//      }return temp;
//   }
//
   public double getPrice() {
      return price;
   }

   public String getDescription() {
      return description.get().trim();
   }

   public ArrayList<SimpleStringProperty > getLecturers() {
      return lecturers;
   }

   public ArrayList<SimpleStringProperty > getSponsors() {
      return sponsors;
   }
   public static void updateDataFile(ObservableList<Event> events) throws IOException{
      DataOutputStream outputFile = new DataOutputStream(new FileOutputStream(""));
      for (int i = 0; i < events.size(); i++) {
         outputFile.writeUTF(events.get(i).toString());
      }
   }
    public String toString() {
        String s = getName()+"; "+getCategory()+"; "+getEventDate()+"; "+getTotalPlaces()+"; "
                +getNumberOfParticipants()+"; ";
        for (int i = 0; i < lecturers.size(); i++) {
            if (i != lecturers.size() - 1) {
                s += lecturers.get(i).get() + ", ";
            } else {
                s += lecturers.get(i).get();
            }
        }
        s+="; "+getPrice()+"; ";
        for (int i = 0; i < sponsors.size(); i++) {
            if (i != sponsors.size() - 1) {
                s += sponsors.get(i).get() + ", ";
            } else {
                s += sponsors.get(i).get();
            }
        }
        s+="; "+getDescription();
        return s;
    }
}