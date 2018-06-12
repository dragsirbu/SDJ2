public class AirportQueue implements PassengerQueue {

    private ArrayQueue<Passenger> passengers;
    private int numberOfPassengers = 0;

    public AirportQueue() {
        passengers = new ArrayQueue<>();
        numberOfPassengers = 0;
    }

    @Override
    public synchronized void putPassengerInQueue(Passenger p) {
        passengers.enqueue(p);
        numberOfPassengers++;
        notifyAll();
    }

    @Override
    public synchronized Passenger getNextPassenger() {
        while (numberOfPassengers == 0)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        numberOfPassengers--;
        notifyAll();
        return passengers.dequeue();
    }

    public boolean isEmpty() {
        return (passengers.isEmpty());
    }
}
