

public class Show implements Runnable
{
    private Clock clock;
    public Show(Clock clock)
    {
        this.clock = clock;
    }
    public synchronized void run()
    {
        for (int i=0; i<5*60; i++)
        {
            System.out.println(clock);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}