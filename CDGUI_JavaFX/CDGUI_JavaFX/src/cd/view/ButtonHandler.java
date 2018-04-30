package cd.view;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import cd.domain.model.Cd;
import cd.domain.model.CdList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

public class ButtonHandler
{
   private CdList cdList;

   @FXML
   private TextArea textArea;

   @FXML
   private URL location;

   @FXML
   private ResourceBundle resources;

   public ButtonHandler(CdList cdList)
   {
      this.cdList = cdList;
   }

   public void showOutPut(String txt) // View related
   {
      textArea.setText(txt);
   }

   public String getInput(String what)
   {
      TextInputDialog dialog = new TextInputDialog();
      dialog.setTitle("Input dialog");
      dialog.setHeaderText(what);

      Optional<String> result = dialog.showAndWait();
      String entered = null;

      if (result.isPresent())
      {
         entered = result.get();
      }
      return entered;
   }

   @FXML
   private void listAll()
   {
      String result = "" + cdList;
      textArea.setText(result);
   }

   @FXML
   private void add()
   {
      String result = "Add method not implemented...";
      textArea.setText(result);
   }

   @FXML
   private void remove()
   {
      String msg = "";
      String title = getInput("Enter title for CD to remove");
      if (title != null)
      {
         Cd cd = cdList.removeFirstCdByTitle(title);
         if (cd != null)
         {
            msg = "REMOVED: \n" + cd.toString();
         }
         else
         {
            msg = "No CD with title: \"" + title + "\" found";
         }
      }
      else
      {
         msg = "Operation cancelled";
      }
      textArea.setText(msg);
   }

   @FXML
   private void search()
   {
      String msg = "";
      String title = getInput("Enter title for CD to find");
      if (title != null)
      {
         CdList list = cdList.getCdsByTitle(title);
         if (list.getNumberOfCds() == 0)
         {
            msg = "No CD with title: \"" + title + "\" found";
         }
         else
         {
            msg = "" + list;
         }
      }
      else
      {
         msg = "Operation cancelled";
      }
      textArea.setText(msg);
   }

   @FXML
   private void quit()
   {
      System.exit(0);
   }

}