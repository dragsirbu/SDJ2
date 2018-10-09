package project.bussineslayer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Administrator implements Serializable {

    private String username;
    private String password;
    private ArrayList<Account> accounts;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Administrator))
            return false;
        Administrator admin = (Administrator) obj;
        return ((admin.getUsername().equals(this.username) && (admin.getPassword().equals(this.password))));
    }

    public void createAccount(int number, double balance) {
        Account account = new Account(number,balance);
        boolean status = true;
        for (Account account1 : accounts) {
            if (account.equals(account1.getNumber()))
                status = false;
        }
        if (status)
            accounts.add(account);
        else
            System.out.println("Account already exists!");
    }

}
