import external.DataLogger;
import temperature.controller.TemperatureController;
import temperature.domain.mediator.TemperatureModelManager;
import temperature.domain.mediator.TemperatureModel;
import temperature.view.GuiTemperature;
import temperature.view.TemperatureView;
public class Main
{
    public static void main(String[] args)
    {
        TemperatureModel model = new TemperatureModelManager();
        TemperatureView view = new GuiTemperature();
        TemperatureController controller =
                new TemperatureController(model, view);
        view.startView(controller);


        // external system
        DataLogger dataLogger = new DataLogger(model, 3000);
        Thread dataLoggerThread = new Thread(dataLogger, "DataLogger");
        dataLoggerThread.start();
    }
}