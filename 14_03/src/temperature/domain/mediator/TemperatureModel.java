package temperature.domain.mediator;
import temperature.domain.model.Temperature;
public interface TemperatureModel
{
    public void addTemperature(int temperature);
    public Temperature getLastInsertedTemperature();
}
