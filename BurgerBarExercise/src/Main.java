public class Main {

    public static void main(String[] args) {

        Burgerbar burgerbar = new Burgerbar(20);

        BurgerBarEmployee employee1 = new BurgerBarEmployee("Employee1",burgerbar);
        BurgerBarEmployee employee2 = new BurgerBarEmployee("Employee2",burgerbar);

        BurgerBarCustomer customer1 = new BurgerBarCustomer("Customer1",burgerbar,3);
        BurgerBarCustomer customer2 = new BurgerBarCustomer("Customer2",burgerbar,4);
        BurgerBarCustomer customer3 = new BurgerBarCustomer("Customer3",burgerbar,2);


        Thread t1 = new Thread(employee1);
        Thread t2 = new Thread(employee2);
        Thread t3 = new Thread(customer1);
        Thread t4 = new Thread(customer2);
        Thread t5 = new Thread(customer3);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
