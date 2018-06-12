public class ReadWriteSafe implements ReadWrite {
    private int readers;
    private int writers;
    private int waitingWriters;

    public ReadWriteSafe() {
        readers = 0;
        writers = 0;
        waitingWriters = 0;
    }

    @Override
    public synchronized void acquireRead()
    {
        while (writers > 0 || waitingWriters > 0)
        {
            System.out.println("Reader waiting. "+writers+" writers, "+readers+" readers.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
        System.out.println("Reader reading the document! "+writers+" writers, "+readers+" readers.");
    }

    @Override
    public synchronized void releaseRead()
    {
        readers--;
        System.out.println("Reader released. " +writers+" writers, "+readers+" readers.");
        if (readers == 0 && writers == 0)
        {
            System.out.println("No readers anymore. Notification sent! "+writers+" writers, "+readers+" readers.");
            notify(); // notify one waiting writer
        }
    }

    @Override
    public synchronized void acquireWrite()
    {
        waitingWriters++;
        while (readers > 0 || writers > 0)
        {
            System.out.println("Writer waiting to acquire. "+writers+" writers, "+readers+" readers.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        writers++;
        System.out.println("Writer working on document! "+writers+" writers, "+readers+" readers.");
    }

    @Override
    public synchronized void releaseWrite()
    {
        writers--;
        System.out.println("Writer released. "+writers+" writers, "+readers+" readers.");
        notifyAll(); // notify all waiting readers
    }



}