package tasklist.view;
import java.util.Scanner;

import tasklist.controller.ClientTaskListController;

public class ClientTaskListConsole implements TaskListView, Runnable
{
   private ClientTaskListController controller;
   private Scanner input;

   public ClientTaskListConsole()
   {
      input = new Scanner(System.in);
   }
   
   @Override
   public void startView(ClientTaskListController controller)
   {
      this.controller = controller;
      Thread t = new Thread(this);
      t.start();
   }

   @Override
   public void run()
   {
      boolean continueWorking = true;
      while (continueWorking)
      {
         // Read input from user input.
         System.out.print("1) Type 1 for \"ADD\"\n" + "2) Type 2 to \"GET\""
               + "\n3) Type 3 to get the \"SIZE\"\n"
               + "0) Type 0 to \"EXIT\"\nEnter choice: ");
         int choice = input.nextInt();
         input.nextLine();

         controller.execute(choice);
         if (choice == 0)
         {
            continueWorking = false;
         }
      }
   }

   @Override
   public String get(String text)
   {
      System.out.print("Enter " + text +": ");
      return input.nextLine();
   }

   @Override
   public void show(String text)
   {
      System.out.println(text);
   }
}
