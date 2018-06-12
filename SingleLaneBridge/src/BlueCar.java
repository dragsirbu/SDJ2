public class BlueCar implements Runnable{

    private Bridge bridge;

    public BlueCar(Bridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void run() {
        bridge.enterFromTheRight();
        timeToWait(1000,4000);
        bridge.exitToTheLeft();
        timeToWait(1000,3000);
    }

    private void timeToWait(int min, int max)
    {
        long time = (long)(Math.random() * (max - min) + min);
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
