package cd.view;

import cd.domain.model.CdList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

public class CdGUI extends Application implements CdView
{
   private ButtonHandler eventHandler;
   private CdList cdList;

   private static CdGUI instance;

   public CdGUI()
   {
      if (instance == null)
      {
         // first call from the main method
         instance = this;
      }
      else
      {
         // Second call by the launch method
         this.cdList = instance.cdList;
         this.eventHandler = instance.eventHandler;
      }
   }

   @Override
   public void start(CdList cdList)
   {
      this.cdList = cdList;
      this.eventHandler = new ButtonHandler(cdList);

      Thread viewThred = new Thread(new ViewLauncher(this));
      viewThred.start();
   }

   @Override
   public String get(String what)
   {
      return eventHandler.getInput(what);
   }

   @Override
   public void show(String value)
   {
      eventHandler.showOutPut(value);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      FXMLLoader loader = new FXMLLoader();

      loader.setLocation(getClass().getResource("cd_main_gui.fxml"));
      loader.setController(eventHandler); // set event handler

      SplitPane root = (SplitPane) loader.load();
      Scene scene = new Scene(root, 900, 500);
      primaryStage.setScene(scene);
      primaryStage.setTitle("CD Application");

      primaryStage.show();
   }

}