package project.bussineslayer.model;

import java.io.Serializable;

public class Clerk implements Serializable {

    private String username;
    private String password;

    public Clerk(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Clerk))
            return false;
        Clerk clerk = (Clerk) obj;
        return ((clerk.getUsername().equals(this.username) && (clerk.getPassword().equals(this.password))));
    }

    public void insertMoney(Account account, double amount) {
        account.updateBalance(amount);
        System.out.println(amount+"$ added to Account "+account.getNumber()+" by Clerk "+this.getUsername());
    }

    public void withdrawMoney(Account account, double amount) {
        if (account.getBalance() >= amount) {
            account.updateBalance(-amount);
            System.out.println(amount + "$ withdrawn from Account "+account.getNumber()+" by Clerk "+this.getUsername());
        }
        else
            System.out.println("Insufficient funds on account "+account.getNumber());
    }

}
