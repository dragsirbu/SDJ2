package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static application.MemberList.getDate;

public class EventList {
    private ArrayList<Event> eventList;

    public EventList() {
        eventList = new ArrayList<>();
    }



    public void addEvent(Event event) {
        eventList.add(event);
    }

    public Event getEvent(String name) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getName().equalsIgnoreCase(name)) return eventList.get(i);
        }
        return null;
    }

    public void editEvent(String name) {
        Scanner input =new Scanner(System.in);
        String userInput;
        System.out.println("What  do you want to edit? (Enter one field) ");
        userInput=input.nextLine();

        while(userInput!="name" || userInput!="category" || userInput!="event date"||userInput!="duration"
                || userInput!="available places" || userInput!="number of paricipants" || userInput!="lecturers"
                || userInput!="price" || userInput!="sponsors" || userInput!="description"
                || userInput!="feedback list"){
            System.out.println("Fields does not exist, enter one of the valid fields again: ");
            userInput=input.nextLine();
        }
        System.out.print("Enter new value: ");

    }

    public void removeEvent(String name) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getName() == name) eventList.remove(i);
        }
    }

    public Event[] getFinalizedEvents() {
        Date currentDay = new Date();
        int counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventDate().isBefore((ChronoLocalDate) currentDay))
                counter++;
        }
        Event[] temp = new Event[counter];
        counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventDate().isBefore((ChronoLocalDate) currentDay)) {
                temp[counter] = eventList.get(i);
                counter++;            }

        }
        return temp;
    }

    public Event[] NonFinalizedEvents() {
        Date currentDay = new Date();
        int counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventDate().isAfter((ChronoLocalDate) currentDay))
                counter++;
        }
        Event[] temp = new Event[counter];
        counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventDate().isBefore((ChronoLocalDate) currentDay)) {
                temp[counter] = eventList.get(i);
                counter++;
            }

        }
        return temp;
    }

    /*public Feedback[] getEventsByType(String type) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getType().equalsIgnoreCase(type))
                return eventList.get(i).getFeedback();
        }

        return null;
    }*/

    public Event[] getEventsInInterval(Date startDate, Date endDate) {
        int counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventDate().isAfter((ChronoLocalDate) startDate) && eventList.get(i).getEventDate().isBefore((ChronoLocalDate) endDate))
                counter++;
        }
        Event[] temp = new Event[counter];
        counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventDate().isAfter((ChronoLocalDate) startDate) && eventList.get(i).getEventDate().isBefore((ChronoLocalDate) endDate)) {
                temp[counter] = eventList.get(i);
                counter++;
            }
        }
        return temp;
    }

    public Event[] getEventBySponsor(Sponsor sponsor) {
        int counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getSponsors().equals(sponsor)) counter++;
        }
        Event[] temp = new Event[counter];
        counter = 0;
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getSponsors().equals(sponsor)) {
                temp[counter] = eventList.get(i);
                counter++;
            }
        }
        return temp;
    }

    /*public Feedback[] getFeedbackForEvent(Event event) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).equals(event)) {
                return eventList.get(i).getFeedback();
            }
        }
        return null;
    }*/
    public Event[] getAllEvents(){
        Event[] allEvents= new Event[eventList.size()];
        for(int i=0; i<eventList.size();i++){
            allEvents[i]= eventList.get(i);
        }return allEvents;
    }
}

