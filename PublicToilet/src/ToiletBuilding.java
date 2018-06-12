public class ToiletBuilding implements PublicToilet {

    private int numberOfCabins;
    private int numberOfSinks;
    private int numberOfDryers;
    private int busyCabins;
    private int busySinks;
    private int busyDryers;

    public ToiletBuilding(int numberOfCabins, int numberOfSinks, int numberOfDryers) {
        this.numberOfCabins = numberOfCabins;
        this.numberOfDryers = numberOfDryers;
        this.numberOfSinks = numberOfSinks;
        this.busyCabins = 0;
        this.busySinks = 0;
        this.busyDryers = 0;
    }

    @Override
    public synchronized void stepIntoCabin(Person person) {
        if (busyCabins >= numberOfCabins) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busyCabins++;
        System.out.println(person.getName()+" enters the cabin.");
        notifyAll();
    }

    @Override
    public synchronized void leaveCabin() {
        busyCabins--;
        System.out.println("The cabin is now free.");
        notifyAll();
    }

    @Override
    public synchronized void startWashingHands(Person person) {
        if (busySinks >= numberOfSinks) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busySinks++;
        System.out.println(person.getName()+" is now using the sink");
        notifyAll();
    }

    @Override
    public synchronized void stopWashingHands() {
        busySinks--;
        System.out.println("The sink is now free.");
        notifyAll();
    }

    @Override
    public synchronized void startDryingHands(Person person) {
        if (busyDryers >= numberOfDryers) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busyDryers++;
        System.out.println(person.getName()+" is now using the dryer");
        notifyAll();
    }

    @Override
    public synchronized void stopDryingHands() {
        busyDryers--;
        System.out.println("The dryer is now free.");
        notifyAll();
    }

}
