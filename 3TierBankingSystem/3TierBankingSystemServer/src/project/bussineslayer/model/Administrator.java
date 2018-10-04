package project.bussineslayer.model;

import java.util.ArrayList;

public class Administrator {

    private String username;
    private String password;
    private ArrayList<Account> accounts;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void CreateAccount(int number, double balance) {
        accounts.add(new Account(number,balance));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Administrator))
            return false;
        Administrator admin = (Administrator) obj;
        return ((admin.getUsername().equals(this.username) && (admin.getPassword().equals(this.password))));
    }

}
