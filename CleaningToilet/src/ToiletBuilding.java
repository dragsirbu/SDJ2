public class ToiletBuilding implements PublicToilet {

    private int numberOfCabins;
    private int numberOfSinks;
    private int busyCabins;
    private int busySinks;
    private boolean isBeingCleaned;

    public ToiletBuilding(int numberOfCabins, int numberOfSinks) {
        this.numberOfCabins = numberOfCabins;
        this.numberOfSinks = numberOfSinks;
        this.busyCabins = 0;
        this.busySinks = 0;
        this.isBeingCleaned = false;
    }

    public synchronized void stepIntoCabin(Person person) {
        while ((busyCabins >= numberOfCabins) || (isBeingCleaned == true)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busyCabins++;
        System.out.println(Thread.currentThread().getName()+": "+person.getName()+" enters the cabin. "
                +(numberOfCabins-busyCabins)+" free cabins, "+(numberOfSinks-busySinks)+" free sinks remaining.");
        notifyAll();
    }

    @Override
    public synchronized void leaveCabin(Person person) {
        busyCabins--;
        System.out.println(Thread.currentThread().getName()+": "+person.getName()+" leaves the cabin. "
                +(numberOfCabins-busyCabins)+" free cabins, "+(numberOfSinks-busySinks)+" free sinks remaining.");
        notifyAll();
    }
    @Override
    public synchronized void washHands(Person person) {
        while (busySinks >= numberOfSinks) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busySinks++;
        System.out.println(Thread.currentThread().getName()+": "+person.getName()+" uses the sink. "
                +(numberOfCabins-busyCabins)+" free cabins, "+(numberOfSinks-busySinks)+" free sinks remaining.");
        notifyAll();
    }

    @Override
    public synchronized void stopWashingHands(Person person) {
        busySinks--;
        System.out.println(Thread.currentThread().getName()+": "+person.getName()+" stops using the sink. "
                +(numberOfCabins-busyCabins)+" free cabins, "+(numberOfSinks-busySinks)+" free sinks remaining.");
        notifyAll();
    }

    @Override
    public synchronized void cleanToilet() {
        while (busyCabins > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isBeingCleaned = true;
        System.out.println(Thread.currentThread().getName()+": THE TOILET IS NOW BEING CLEANED!.");

    }
    @Override
    public synchronized void endCleaningToilet() {
        System.out.println(Thread.currentThread().getName()+": FINISHED CLEANING THE TOILET!");
        isBeingCleaned = false;
        notifyAll();
    }

}
