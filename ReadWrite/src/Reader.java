public class Reader implements Runnable {

    private ReadWrite lock;

    public Reader(ReadWrite lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true) {
            timeToSleep(1000,2000);
            lock.acquireRead();
            timeToSleep(1000,2000);
            lock.releaseRead();
            timeToSleep(1000, 2000);
        }
    }

    private void timeToSleep(int min, int max)
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
