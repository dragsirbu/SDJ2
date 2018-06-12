public class PassportController implements Runnable {

    private PassengerQueue queue;

    public PassportController(PassengerQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Passenger next;
        while(true) {
            next = queue.getNextPassenger();
            timeForCheck();
            if (next.getPassportNumber() < 2000 && next.getPassportNumber() >= 1000)
                System.out.println("Passenger with number "+next.getPassportNumber()+" has been controlled by the US citizens customs.");
            else
                System.out.println("Passenger with number "+next.getPassportNumber()+" has been controlled by the non-US citizens customs.");

        }
    }
    private void timeForCheck()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
