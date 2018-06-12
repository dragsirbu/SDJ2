public class Bridge implements Lane {

  private int redCars;
  private int blueCars;
  private int redCarCounter;
  private int blueCarCounter;
    private boolean bridgeIsBusy;

    public Bridge(int redCarCounter, int blueCarCounter) {
        this.redCars = 0;
        this.blueCars = 0;
        this.redCarCounter = redCarCounter;
        this.blueCarCounter = blueCarCounter;
        this.bridgeIsBusy = false;
    }

    @Override
    public synchronized void enterFromTheLeft() {
//        waitingRedCars++;
        while ( blueCars > 0 || redCars > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        redCars++;
        System.out.println(Thread.currentThread().getName()+" entered from left.");
    }

    @Override
    public synchronized void enterFromTheRight() {

        while (redCars > 0 || blueCars > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blueCars++;
        System.out.println(Thread.currentThread().getName()+" entered from right.");
    }

    @Override
    public synchronized void exitToTheLeft() {
        blueCars--;
        blueCarCounter--;
        System.out.println(Thread.currentThread().getName()+" car exited to the left. "+blueCarCounter+"/30 remaining.");
        if (blueCars == 0) {
            notify();
        }
    }

    @Override
    public synchronized void exitToTheRight() {
        redCars--;
        redCarCounter--;
        System.out.println(Thread.currentThread().getName()+" exited to the right. "+redCarCounter+"/10 remaining");
        if (redCars == 0) {
            notifyAll();
        }
    }
}
