public class WashingHall
{
    private QueueADT<Hall> availableHalls;
    private int occupiedHalls;
    public WashingHall(int numberOfWashingHalls)
    {
        availableHalls = new ArrayQueue<>(numberOfWashingHalls);
        this.occupiedHalls = 0;
        for (int i = 1; i <= numberOfWashingHalls;i++) {
            availableHalls.enqueue(new Hall(i));
        }
    }
    /* Customer enters for washing the car. A customer waits if all
    washing places are occupied
    */
    public synchronized Hall enterForWashing()
    {
        while (this.occupiedHalls >= availableHalls.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        occupiedHalls++;
        Hall hall = availableHalls.dequeue();
        System.out.println(hall.toString()+" is now occupied.");
        notifyAll();
        return hall;
    }
    /* Car washing has finished and customer leaves the washing place
    so that the next waiting car can enter.
    */
    public synchronized void leaveWashing(Hall hall)
    {
        occupiedHalls--;
        availableHalls.enqueue(hall);
        System.out.println(hall.toString()+" is now free.");
        notifyAll();
    }
    public synchronized int getFreePlaces()
    {
        return availableHalls.size();
    }
}
