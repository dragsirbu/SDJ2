package project.bussineslayer;

import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.IBank;

import java.util.ArrayList;

public class Bank implements IBank {

    private ArrayList<Administrator> admins;
    private ArrayList<Clerk> clerks;
    private ArrayList<Customer> customers;

    public Bank() {
        this.admins = new ArrayList<>();
        this.clerks = new ArrayList<>();
        this.customers = new ArrayList<>();
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
        return customers.contains(customer);
    }
}
