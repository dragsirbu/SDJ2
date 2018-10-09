package project.bussineslayer;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.IAdminController;
import project.bussineslayer.model.interfaces.IBankController;
import project.bussineslayer.model.interfaces.IClerkController;
import project.bussineslayer.model.interfaces.ICustomerController;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class BankController implements IBankController {

    private ArrayList<Administrator> admins;
    private ArrayList<Clerk> clerks;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private AdministratorController administratorController;
    private ClerkController clerkController;
    private CustomerController customerController;

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
    public void setAdministratorController(Administrator administrator) throws RemoteException {
        this.administratorController = new AdministratorController(administrator);
    }

    @Override
    public void setClerkController(Clerk clerk) throws RemoteException {
        this.clerkController = new ClerkController(clerk);
    }

    @Override
    public void setCustomerController(Customer customer) throws RemoteException {
        this.customerController = new CustomerController(customer);
    }

    @Override
    public void setAccountList() throws RemoteException {
        this.accounts = administratorController.getAccounts();
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
    public void createAccount(int number, double balance) throws RemoteException {
        Account account = new Account(number,balance);
        administratorController.createAccount(number, balance);
        System.out.println("Account created: "+account.toString());
        setAccountList();
        getAllAcounts();
    }

    @Override
    public void clerkInsertMoney(int number, double amount) throws RemoteException {
        Account insertAccount = null;
        setAccountList();
        for (Account account : accounts) {
            if (account.getNumber() == number)
                insertAccount = account;
        }
        if (insertAccount != null)
            clerkController.insertMoney(insertAccount, amount);
        else
            System.out.println("Account " + number + " not found in the system!");
    }


    @Override
    public void clerkWithdrawMoney(int number, double amount) throws RemoteException {
        Account withdrawnAccount = null;
        setAccountList();
        for (Account account: accounts) {
            if (account.getNumber() == number)
                withdrawnAccount = account;
        }
        if (withdrawnAccount != null)
            clerkController.withdrawMoney(withdrawnAccount,amount);
        else
            System.out.println("Account "+number+" not found in the system!");
    }

    @Override
    public void customerWithdrawMoney(double amount) throws RemoteException {
        customerController.withdrawMoney(amount);
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

    private void getAllAcounts() {
        System.out.println("All acounts:");
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }
}
