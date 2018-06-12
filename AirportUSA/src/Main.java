public class Main {

    public static void main(String[] args) {
        AirportQueue americanQueue = new AirportQueue();
        AirportQueue nonAmericanQueue = new AirportQueue();

        Guide guide = new Guide(americanQueue,nonAmericanQueue);

        PassportController americanController = new PassportController(americanQueue);
        PassportController nonAmericanController = new PassportController(nonAmericanQueue);


        Thread t1 = new Thread(guide);
        Thread t2 = new Thread(americanController);
        Thread t3 = new Thread(nonAmericanController);

        t1.start();
        t2.start();
        t3.start();

    }
}
