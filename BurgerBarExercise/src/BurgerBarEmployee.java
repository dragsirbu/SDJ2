public class BurgerBarEmployee implements Runnable {
    private Burgerbar burgerBar;
    private String name;

    public BurgerBarEmployee(String name, Burgerbar burgerBar) {
        this.burgerBar = burgerBar;
        this.name = name;
    }

    public void run() {
        while (true) {
            burgerBar.makeBurger(name);
            timeForMakingTheBurger();
        }
    }

    private void timeForMakingTheBurger() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
// ...
        }
    }
}