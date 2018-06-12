package application;
public class DateInterval
{
   private int day;
   private int hour;
   private int minute;
   
   public DateInterval(int day, int hour, int minute)
   {
      setDateInterval(day, hour, minute);
   }
   
   public void setDateInterval(int day, int hour, int minute)
   {
      this.day=day;
      this.hour=hour;
      this.minute=minute;
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
      return day;
   }
   
   public int getHour()
   {
      return hour;
   }

   public int getMinute()
   {
      return minute;
   }

   public boolean equals(Object obj)
   {
      if(!(obj instanceof DateInterval)) return false;
      DateInterval other = (DateInterval)obj;
      return day==other.day&&hour==other.hour&&minute==other.minute;
   }
   
   public String toString()
   {
      if(day<1)
      {
         if(hour<1)
            return minute+" minutes";
         else return hour+" hours, "+minute+" minutes";
      }
      if(day==1)
         return day+" day, "+hour+" hours, "+minute+" minutes";
      return day+" days, "+hour+" hours, "+minute+" minutes";
   }
   
   public DateInterval copy()
   {
      DateInterval other = new DateInterval(this.day, this.hour, this.minute);
      return other;
   }

}
