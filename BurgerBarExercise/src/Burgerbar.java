public class Burgerbar {
    private int numberOfBurgers;
    private int maxNumberOfBurgers;

    public Burgerbar(int maxNumberOfBurgers) {
        this.numberOfBurgers = 0;
        this.maxNumberOfBurgers = maxNumberOfBurgers;
    }

    public synchronized void makeBurger(String employeeName) {
        try {
            while(numberOfBurgers >= maxNumberOfBurgers) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        numberOfBurgers++;
        System.out.println(employeeName + " makes a burger (" +
                numberOfBurgers + " left)");
        notifyAll();
    }

    public synchronized void eatBurger(String who) {
        while(numberOfBurgers <= 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        numberOfBurgers--;
        System.out.println(who + " gets his burger (" +
                numberOfBurgers + " left)");
        notifyAll();
    }

    public int getNumberOfBurgers() {
        return numberOfBurgers;
    }
}
