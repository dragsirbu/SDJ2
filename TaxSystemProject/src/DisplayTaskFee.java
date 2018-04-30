import java.util.Observable;
import java.util.Observer;
public class DisplayTaskFee implements Observer,Runnable {
    private TaxCalculator taxCalculator;
    public DisplayTaskFee(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Tax fee modified!");
        System.out.println(taxCalculator.toString());
    }
    @Override
    public void run() {
        for(int i = 0;i < 4;i++) {
            taxCalculator.addIncome(5000);
            taxCalculator.setTaxPercent();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
