package temperature.domain.mediator;
import temperature.domain.model.Temperature;
import temperature.domain.model.TemperatureList;

import java.util.Observable;
import java.util.Observer;

public class TemperatureModelManager extends Observable implements TemperatureModel
{
    private TemperatureList temperatureList;
    public TemperatureModelManager()
    {
        temperatureList = new TemperatureList();
    }

    @Override
    public void addTemperature(int value)
    {
        Temperature temperature = new Temperature(value);
        this.temperatureList.addTemperature(temperature);
        setChanged();

    }

    @Override
    public Temperature getLastInsertedTemperature()
    {
        Temperature temperature = temperatureList.getTemperature(0);
        setChanged();
        notifyObservers(temperature);
        return temperature;
    }

    public TemperatureList getAllTemperatures()
    {
        return temperatureList;
    }

    // and maybe other methods...
}