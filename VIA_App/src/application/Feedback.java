//package application;
//public class Feedback
//{
//   private String message;
//   private String authorName;
//   private Date date;
//
//   public Feedback(String message, String authorName, Date date)
//   {
//      this.message = message;
//      this.authorName = authorName;
//      this.date = date.copy();
//   }
//
//   public String getMessage()
//   {
//      return message;
//   }
//
//   public String getAuthor()
//   {
//      return authorName;
//   }
//
//   public Date getDate()
//   {
//      return date.copy();
//   }
//
//   public String toString()
//   {
//      return "Author: " + authorName + ", date: " + date + "\n" + message;
//   }
//
//   public boolean equals(Object obj)
//   {
//      if (!(obj instanceof Feedback))
//         return false;
//      Feedback other = (Feedback) obj;
//      return message.equals(other.message)
//            && authorName.equals(other.authorName) && date.equals(other.date);
//   }
//}
