package application;

import javafx.beans.property.SimpleStringProperty;

public class Sponsor {

    private SimpleStringProperty name;
    private SimpleStringProperty address;
    private SimpleStringProperty email;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty typeOfSponsorship;

    public Sponsor(String name, String phoneNumber, String email, String address,
         String typeOfSponsorship) {
      this.name = new SimpleStringProperty(name);
      this.address = new SimpleStringProperty(address);
      this.email = new SimpleStringProperty(email);
      this.phoneNumber = new SimpleStringProperty(phoneNumber);
      this.typeOfSponsorship= new SimpleStringProperty(typeOfSponsorship);
   }

   public void setName(String name) {
      this.name = new SimpleStringProperty(name);
   }

   public void setAddress(String address) {
      this.address = new SimpleStringProperty(address);
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = new SimpleStringProperty(phoneNumber);
   }

   public void setEmail(String email) {
	   this.email=new SimpleStringProperty(email);
   }

   public void setTypeOfSponsorship(String typeOfSponsorship) {
      this.typeOfSponsorship=new SimpleStringProperty(typeOfSponsorship);
   }

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

   public String getTypeOfSponsorship() {
      return typeOfSponsorship.get().trim();
   }
   public String toString(){
        return this.getName()+"; "+this.getPhoneNumber()+"; "+this.getEmail()+"; "+this.getAddress()+"; "
                +this.getTypeOfSponsorship();
   }
}

