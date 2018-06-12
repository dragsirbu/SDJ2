public class Main {
    public static void main(String[] args) {
        WashingHall washingHalls = new WashingHall(3);
        Car car1 = new Car(washingHalls);
        Car car2 = new Car(washingHalls);
        Car car3 = new Car(washingHalls);
        Car car4 = new Car(washingHalls);
        Car car5 = new Car(washingHalls);

        Thread t1 = new Thread(car1);
        Thread t2 = new Thread(car2);
        Thread t3 = new Thread(car3);
        Thread t4 = new Thread(car4);
        Thread t5 = new Thread(car5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
