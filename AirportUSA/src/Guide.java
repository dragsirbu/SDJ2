import java.util.Random;

public class Guide implements Runnable {

//    private PassengerQueue queue;
    private AirportQueue americanQueue;
    private AirportQueue otherQueue;

    public Guide(AirportQueue americanQueue, AirportQueue otherQueue) {
        this.americanQueue = americanQueue;
        this.otherQueue = otherQueue;
    }

    @Override
    public void run() {
        Passenger passenger;
        while (true) {
            passenger = generatePassenger();
            if (passenger.getNationality().equals("USA"))
                americanQueue.putPassengerInQueue(passenger);
            else if (passenger.getNationality().equals("non-USA"))
                otherQueue.putPassengerInQueue(passenger);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

//    public PassengerQueue makeAmericanQueue(Passenger passenger) {
//        if (passenger.getNationality().equals("USA"))
//            americanQueue.putPassengerInQueue(passenger);
//        return americanQueue;
//    }
//
//    public PassengerQueue makeNonAmericanQueue(Passenger passenger) {
//        if (passenger.getNationality().equals("non-USA"))
//            otherQueue.putPassengerInQueue(passenger);
//        return otherQueue;
//    }
//
//
//    public PassengerQueue getAmericanCitizens() {
//        return americanQueue;
//    }
//
//    public PassengerQueue getNonAmericanCitizens() {
//        return otherQueue;
//    }

    private Passenger generatePassenger() {
        int number = randomNumberInRange(0,1);
        switch (number) {
            case 0:
                return new Passenger("USA",randomNumberInRange(1000,2000));
            case 1:
                return new Passenger("non-USA",randomNumberInRange(2000,3000));
        }
        return null;
    }
    private static int randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
