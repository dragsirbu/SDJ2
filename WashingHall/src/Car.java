public class Car implements Runnable {

    private String customerName;
    private WashingHall washingHall;

    public Car(WashingHall washingHall) {
        this.customerName = customerName;
        this.washingHall = washingHall;
    }

    @Override
    public void run() {
        Hall hall = washingHall.enterForWashing();
        timeForWashingTheCar();
        washingHall.leaveWashing(hall);
    }

    private void timeForWashingTheCar()
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
