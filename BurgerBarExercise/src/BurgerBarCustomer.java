public class BurgerBarCustomer implements Runnable {

    private int burgersToEat;
    private String name;
    private Burgerbar burgerbar;

    public  BurgerBarCustomer(String name, Burgerbar burgerbar, int burgersToEat) {
        this.name = name;
        this.burgerbar = burgerbar;
        this.burgersToEat = burgersToEat;
    }

    @Override
    public  void run() {
        while(burgersToEat > 0) {
            burgerbar.eatBurger(this.name);
            timeForEatingTheBurger();
            burgersToEat--;
        }
    }

    private void timeForEatingTheBurger()
    {
        try
        {
            Thread.sleep(300);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
