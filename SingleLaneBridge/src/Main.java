import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Bridge bridge = new Bridge(10,30);

        Thread[] blueCars = new Thread[30];
        for (int i = 0; i < blueCars.length; i++) {
            BlueCar blueCar = new BlueCar(bridge);
            blueCars[i] = new Thread(blueCar,"Blue Car "+i);
            blueCars[i].start();
        }

        Thread[] redCars = new Thread[10];
        for (int i = 0; i < redCars.length; i++) {
            RedCar redCar = new RedCar(bridge);
            redCars[i] = new Thread(redCar,"Red Car "+i);
            redCars[i].start();
        }



    }
}
