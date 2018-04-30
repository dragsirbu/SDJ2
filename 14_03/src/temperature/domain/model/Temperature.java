package temperature.domain.model;
public class Temperature
{
    private int value;
    private DateTime time;

    public Temperature(int value)
    {
        this.value = value;
        time = new DateTime();
    }
    public int getValue()
    {
        return value;
    }
    public DateTime getTime()
    {
        return time;
    }
    public String toString()
    {
        return value + " measured at " + time.getTimestamp();
    }
}
