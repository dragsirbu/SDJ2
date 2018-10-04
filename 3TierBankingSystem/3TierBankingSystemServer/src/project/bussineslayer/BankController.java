package project.bussineslayer;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.IBankController;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class BankController implements IBankController {

    private ArrayList<Administrator> admins;
    private ArrayList<Clerk> clerks;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public BankController() {
        this.admins = new ArrayList<>();
        this.clerks = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        admins.add(new Administrator("admin","admin"));
        clerks.add(new Clerk("clerk","clerk"));
        customers.add(new Customer("customer","customer"));
    }

    @Override
    public void addAdmin(Administrator admin) {
        admins.add(admin);
    }

    @Override
    public void addClerk(Clerk clerk) {
        clerks.add(clerk);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void createAccount(Account account) throws RemoteException {
        accounts.add(account);
        System.out.println("Account created: "+account.toString());
    }

    @Override
    public void insertMoney(Account account,double amount) throws RemoteException {
        account.updateBalance(amount);
        System.out.println(amount+ "added to Account "+account.getNumber());
    }

    @Override
    public void withdrawMoney(Account account,double amount) throws RemoteException {
        if (account.getBalance() > amount) {
            account.updateBalance(-amount);
            System.out.println(amount+ "withdrawn from Account "+account.getNumber());
        }
        else
            System.out.println("Not enough funds on account: "+account.getNumber());
    }

    @Override
    public boolean isAdmin(Administrator admin) {
        boolean status = false;
        for (Administrator administrator : admins) {
            if (admin.equals(administrator))
                status = true;
        }
        return status;
    }

    @Override
    public boolean isClerk(Clerk clerk) {
        boolean status = false;
        for (Clerk clerk1 : clerks) {
            if (clerk.equals(clerk1))
                status = true;
        }
        return status;
    }

    @Override
    public boolean isCustomer(Customer customer) {
        boolean status = false;
        for (Customer customer1 : customers) {
            if (customer.equals(customer1))
                status = true;
        }
        return status;
    }

    @Override
    public Account getAccount(int number) throws RemoteException {
        for (Account account : accounts) {
            if (account.getNumber() == number)
                return account;
        }
        return null;
    }
}
