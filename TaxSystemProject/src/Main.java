public class Main {

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator("Bob");
        DisplayTaskFee tax = new DisplayTaskFee(calculator);
        calculator.addObserver(tax);
        System.out.println("Initial\n"+calculator.toString());
        Thread t = new Thread(tax);
        t.start();
    }
}
