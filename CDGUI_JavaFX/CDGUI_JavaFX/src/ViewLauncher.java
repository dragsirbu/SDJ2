
import javafx.application.Application;

public class ViewLauncher implements Runnable
{
   private Application view;

   public ViewLauncher(Application view)
   {
      this.view = view;
   }

   @Override
   public void run()
   {
      Application.launch(view.getClass());
   }
}
