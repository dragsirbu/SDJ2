package project.bussineslayer.model;

public class Customer {

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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void WithdrawMoney(double amount) {
        account.updateBalance(-amount);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Customer))
            return false;
        Customer customer = (Customer) obj;
        return ((customer.getUsername().equals(this.username) && (customer.getPassword().equals(this.password))));
    }
}
