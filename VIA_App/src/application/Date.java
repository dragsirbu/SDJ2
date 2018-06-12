package application;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Date
{
   private int day;
   private int month;
   private int year;
   private int hour;
   private int minute;

   public Date(int day, int month, int year, int hour, int minute)
   {
      set(day, month, year, hour, minute);
   }

   public Date()
   {
      Calendar now = GregorianCalendar.getInstance();
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = now.get(Calendar.MONTH) + 1;
      this.year = now.get(Calendar.YEAR);
      this.hour = now.get(Calendar.HOUR);
      this.minute = now.get(Calendar.MINUTE);
   }

   public void set(int day, int month, int year, int hour, int minute)
   {
      if (month < 1)
         this.month = 1;
      else if (month > 12)
         this.month = 12;
      else
         this.month = month;

      if (year < 1)
         this.year = -year;
      else
         this.year = year;

      if (day < 1)
         this.day = 1;
      else if (day > numberOfDaysInMonth())
         this.day = numberOfDaysInMonth();
      else
         this.day = day;

      if (hour > 0 && hour <= 24)
         this.hour = hour;
      else if (hour < 0)
         this.hour = 0;
      else if (hour > 24)
         this.hour = 24;

      if (minute >= 0 && minute < 60)
         this.minute = minute;
      else if (minute < 0)
         this.minute = 0;
      else if (minute >= 60)
         this.minute = 59;

   }

   public void set(int day, String monthName, int year, int hour, int minute)
   {
      int month = convertToMonthNumber(monthName);
      set(day, month, year, hour, minute);
   }

   public void setYear(int year)
   {
      this.year=year;
   }

   public void setMonth(int month)
   {
      this.month=month;
   }

   public void setMonth(String monthName)
   {
      int month = convertToMonthNumber(monthName);
      this.month=month;
   }

   public void setDay(int day)
   {
      this.day=day;
   }

   public void setHour(int hour)
   {
      this.hour=hour;
   }

   public void setMinute(int minute)
   {
      this.minute=minute;
   }
   
   public int getDay()
   {
      return this.day;
   }

   public int getMonth()
   {
      return this.month;
   }

   public int getYear()
   {
      return this.year;
   }

   public int getHour()
   {
      return hour;
   }

   public int getMinute()
   {
      return minute;
   }

   public String getMonthName()
   {
      String message = null;
      if (this.month == 1)
         message = "January";
      if (this.month == 2)
         message = "February";
      if (this.month == 3)
         message = "March";
      if (this.month == 4)
         message = "April";
      if (this.month == 5)
         message = "May";
      if (this.month == 6)
         message = "June";
      if (this.month == 7)
         message = "July";
      if (this.month == 8)
         message = "August";
      if (this.month == 9)
         message = "September";
      if (this.month == 10)
         message = "October";
      if (this.month == 11)
         message = "November";
      if (this.month == 12)
         message = "December";
      return message;
   }

   public boolean isLeapYear()
   {
      return (this.year % 4 == 0
            && (this.year % 100 != 0 || this.year % 400 == 0));
   }

   public int numberOfDaysInMonth()
   {
      int days = 0;
      if (this.month == 1)
         days = 31;
      if (this.month == 2)
      {
         if (isLeapYear() == true)
            days = 29;
         else
            days = 28;
      }
      if (this.month == 3)
         days = 31;
      if (this.month == 4)
         days = 30;
      if (this.month == 5)
         days = 31;
      if (this.month == 6)
         days = 30;
      if (this.month == 7)
         days = 31;
      if (this.month == 8)
         days = 31;
      if (this.month == 9)
         days = 30;
      if (this.month == 10)
         days = 31;
      if (this.month == 11)
         days = 30;
      if (this.month == 12)
         days = 31;
      if (this.month < 1 || this.month > 12)
         return 0;
      return days;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Date))
      {
         return false;
      }
      Date d = (Date) obj;
      return this.day == d.day && this.month == d.month && this.year == d.year
            && this.hour == d.hour && this.minute == d.minute;
   }

   public String toString()
   {
      String dayW0 = "";
      String monthW0 = "";
      String digitH = "";
      String digitM = "";
      String digitS = "";
      if (this.day < 10)
         dayW0 = "0";
      if (this.month < 10)
         monthW0 = "0";
      if (hour >= 0 && hour < 10)
         digitH = "0";
      if (minute >= 0 && minute < 10)
         digitM = "0";
      return dayW0 + day + "/" + monthW0 + month + "/" + year + ", " + digitH
            + hour + ":" + digitM + minute + ":" + digitS;
   }

   public Date copy()
   {
      Date other = new Date(this.day, this.month, this.year, this.hour,
            this.minute);
      return other;
   }

   public static int convertToMonthNumber(String monthName)
   {
      monthName = monthName.toLowerCase();
      int month = 0;
      switch (monthName)
      {
         case "january":
            month = 1;
            break;
         case "february":
            month = 2;
            break;
         case "march":
            month = 3;
            break;
         case "april":
            month = 4;
            break;
         case "may":
            month = 5;
            break;
         case "june":
            month = 6;
            break;
         case "july":
            month = 7;
            break;
         case "august":
            month = 8;
            break;
         case "september":
            month = 9;
            break;
         case "october":
            month = 10;
            break;
         case "november":
            month = 11;
            break;
         case "december":
            month = 12;
            break;
         default:
            month = -999;
            break;
      }
      return month;
   }

   public boolean isBefore(Date other)
   {
      if (year < other.getYear())
         return true;
      else if (year == other.getYear())
      {
         if (month < other.getMonth())
            return true;
         else if (month == other.getMonth())
         {
            if (day < other.getDay())
               return true;
            else if (day == other.getDay())
            {
               if (hour < other.getHour())
                  return true;
               else if (hour == other.getHour())
               {
                  if (minute < other.getMinute())
                     return true;
                  else if (minute == other.getMinute())
                  {
                     return false;
                  }
                  else
                     return false;
               }
               else
                  return false;
            }
            else
               return false;
         }
         else
            return false;
      }
      else
         return false;
   }
   
   public boolean isAfter(Date other)
   {
      if (year > other.getYear())
         return true;
      else if (year == other.getYear())
      {
         if (month > other.getMonth())
            return true;
         else if (month == other.getMonth())
         {
            if (day > other.getDay())
               return true;
            else if (day == other.getDay())
            {
               if (hour > other.getHour())
                  return true;
               else if (hour == other.getHour())
               {
                  if (minute > other.getMinute())
                     return true;
                  else if (minute == other.getMinute())
                  {
                     return false;
                  }
                  else
                     return false;
               }
               else
                  return false;
            }
            else
               return false;
         }
         else
            return false;
      }
      else
         return false;
   }
   
   public static Date now()
   {
      Date today = new Date();
      return today;
   }
}
