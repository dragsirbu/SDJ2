package temperature.controller;
import temperature.domain.mediator.TemperatureModel;
import temperature.domain.model.Temperature;
import temperature.view.TemperatureView;

import java.util.Observable;

public class TemperatureController
{
    private TemperatureModel model;
    private TemperatureView view;

    public TemperatureController(TemperatureModel model,
                                 TemperatureView view)
    {
        this.model = model;
        this.view = view;
        Observable obs = (Observable)model;
        obs.addObserver(this.view);
    }
    public void execute(String what)
    {
        if (what.equalsIgnoreCase("update"))
        {
            Temperature t = model.getLastInsertedTemperature();
            view.show(t.toString());
            System.out.println(t.toString());
        }
    }
}
