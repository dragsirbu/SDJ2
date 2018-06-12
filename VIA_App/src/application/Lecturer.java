package application;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Lecturer
{
   private SimpleStringProperty name;
   private SimpleStringProperty address;
   private SimpleStringProperty email;
   private SimpleStringProperty phoneNumber;
   private LocalDate birthdate;
   private SimpleStringProperty category;
   private SimpleStringProperty typeOfReward;

   public Lecturer(String name, LocalDate birthdate, String category, String phoneNumber, String email, String address,
                   String typeOfReward)
   {
      this.name = new SimpleStringProperty(name);
      this.birthdate = birthdate;
      this.category = new SimpleStringProperty(category);
      this.phoneNumber = new SimpleStringProperty(phoneNumber);
      this.email = new SimpleStringProperty(email);
      this.address = new SimpleStringProperty(address);
      this.typeOfReward = new SimpleStringProperty(typeOfReward);
   }
   public Lecturer(String name,LocalDate birthdate, String address, String phoneNumber,String email){
      this.name = new SimpleStringProperty(name);
      this.birthdate = birthdate;
      this.address = new SimpleStringProperty(address);
      this.email = new SimpleStringProperty(email);
      this.phoneNumber = new SimpleStringProperty(phoneNumber);
   }

   public void setName(String name)
   {
      this.name =new SimpleStringProperty(name);
   }

   public void setAddress(String address)
   {
      this.address = new SimpleStringProperty(address);
   }

   public void setEmail(String email){ this.email= new SimpleStringProperty(email);}

   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = new SimpleStringProperty(phoneNumber);
   }

   public void setCategory(String category)
   {
      this.category = new SimpleStringProperty(category);
   }

   public void setTypeOfReward(String typeOfReward)
   {
      this.typeOfReward = new SimpleStringProperty(typeOfReward);
   }

   public String getName()
   {
      return name.get().trim();
   }

   public LocalDate getBirthdate() {
      return birthdate;
   }

   public String getAddress()
   {
      return address.get().trim();
   }

   public String getEmail(){return email.get().trim();}

   public String getPhoneNumber()
   {
      return phoneNumber.get().trim();
   }

   public String getCategory()
   {
      return category.get().trim();
   }

   public String getTypeOfReward()
   {
      return typeOfReward.get().trim();
   }

   public String toString()
   {
     return this.getName() +"; "+this.getBirthdate()+"; "+this.getCategory()+"; "+this.getPhoneNumber()+"; "
             +this.getEmail()+"; "+this.getAddress()+"; "+this.getTypeOfReward();
   }
}
