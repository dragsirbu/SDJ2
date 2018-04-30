package external;

import temperature.domain.mediator.TemperatureModel;
import temperature.domain.model.Temperature;

public class DataLogger implements Runnable
{
    private int timeBetweenEachUpdate;
    private TemperatureModel model;
    public DataLogger(TemperatureModel model, int timeBetweenEachUpdate)
    {
        this.model = model;
        this.timeBetweenEachUpdate = timeBetweenEachUpdate;
    }
    @Override
    public void run()
    {
        int temperature = 20;
        while (true)
        {
            temperature = measureTemperature(temperature);
            System.out.println("Datalogger: " + temperature);
            model.addTemperature(temperature);
            waiting();
        }

    }

    private int measureTemperature(int temperature)
    {
        int diff = (int) (Math.random() * 5 - 2);
        temperature += diff;
        return temperature;
    }
    private void waiting()
    {
        try
        {
            Thread.sleep(timeBetweenEachUpdate);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}