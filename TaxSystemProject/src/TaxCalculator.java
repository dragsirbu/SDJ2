import java.util.Observable;

public class TaxCalculator extends Observable {

    private String name;
    private double income;
    private double tax;

    public TaxCalculator(String name) {
        this.name = name;
        this.tax = 0;
        this.income = 0;
    }

    public void addIncome(double income) {
        this.income+=income;
    }

    public void setTaxPercent() {
        this.tax = this.calculateTaxPercent();
        setChanged();
        notifyObservers(this.getTaskFee());
    }
    private double calculateTaxPercent() {
        if (this.getIncome() >= 5000 && this.getIncome()<10000) {
            return  0.05;
        } else if(this.getIncome() >= 10000 && this.getIncome()<15000) {
            return 0.1;
        } else if(this.getIncome() >= 15000 && this.getIncome()<20000) {
            return 0.15;
        } else if(this.getIncome() >= 20000)
            return 0.2;
        return 0;
    }
    public double getTaskFee() {
        return this.income * this.tax;
    }
    public String getName() {
        return name;
    }
    public double getIncome() {
        return income;
    }
    public double getTax() {
        return tax;
    }
    public String toString() {
        return "Name: "+this.getName()+"\nTotal income: "+this.getIncome()+
                "\nTax: "+this.getTax()+"\nTax fee: "+this.getTaskFee();
    }
}
