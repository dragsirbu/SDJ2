package application;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.ArrayList;

public class Member {
    private SimpleStringProperty name;
    private SimpleStringProperty address;
    private SimpleStringProperty email;
    private SimpleStringProperty phoneNumber;
    private LocalDate birthdate;
    private LocalDate paymentYear;
    private  LocalDate dateForMembership;
//    private ArrayList<Event> attendedEvents;

    public Member(String name, LocalDate birthdate, String address, String email, String phoneNumber) {
        this.name = new SimpleStringProperty(name);
        this.birthdate = birthdate;
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
//        this.paymentYear = new Date().copy();
//        this.dateForMembership = new Date().copy();
//        attendedEvents = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

//    public void setPaymentYear(Date paymentYear) {
//        this.paymentYear = paymentYear.copy();
//    }

//    public void addEvent(Event event) {
//        attendedEvents.add(event);
//    }

    public String getName() {
        return name.get().trim();
    }

    public String getAddress() {
        return address.get().trim();
    }

    public String getEmail() {
        return email.get().trim();
    }

    public String getPhoneNumber() {
        return phoneNumber.get().trim();
    }

//    public Date getPaymentYear() {
//        return paymentYear.copy();
//    }

//    public Date getDateForMembership() {
//        return dateForMembership.copy();
//    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

//    public ArrayList<Event> getAttendedEvents() {
//        return attendedEvents;
//    }

//    public boolean isFeePaid() {
//        Date now = new Date();
//        if (!(paymentYear.getYear() < now.getYear()))
//            return true;
//        return false;
//    }

//    public void updatePaymentStatus() {
//        if (isFeePaid())
//            paymentYear = new Date();
//    }

//
    public String toString() {
        return this.getName() + "; " + this.getBirthdate() + ";" + this.getPhoneNumber() + "; " + this.getAddress() + "; " + this.getEmail() + ";";
    }

}
