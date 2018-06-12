public class Writer implements Runnable {

    private ReadWrite lock;

    public Writer(ReadWrite lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true) {
            timeToSleep(1000,2000);
            lock.acquireWrite();
            timeToSleep(3000,4000);
            lock.releaseWrite();
            timeToSleep(2000, 3000);
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
