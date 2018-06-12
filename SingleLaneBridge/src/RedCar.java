public class RedCar implements Runnable {

    private Bridge bridge;

    public RedCar(Bridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void run() {
        bridge.enterFromTheLeft();
        timeToWait(1000,4000);
        bridge.exitToTheRight();
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
