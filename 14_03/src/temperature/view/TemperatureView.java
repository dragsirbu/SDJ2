package temperature.view;
import javafx.beans.Observable;
import temperature.controller.TemperatureController;

import java.util.Observer;

public interface TemperatureView extends Observer
{
    void startView(TemperatureController controller);
    void show(String text);
}