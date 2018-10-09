package project.bussineslayer.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private String username;
    private String password;
    private Account account;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer(String username, String password, Account account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void withdrawMoney(double amount) {
        if (this.account.getBalance() >= amount) {
            account.updateBalance(-amount);
            System.out.println(amount+"$ withdrawn from Account "+this.account.getNumber()+" by Customer "+this.username);
        }
        else
            System.out.println("Insufficient funds on account"+account.getNumber());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Customer))
            return false;
        Customer customer = (Customer) obj;
        return ((customer.getUsername().equals(this.username) && (customer.getPassword().equals(this.password))));
    }
}
