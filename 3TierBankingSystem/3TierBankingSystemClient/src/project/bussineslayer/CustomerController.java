package project.bussineslayer;

import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.ICustomer;

public class CustomerController implements ICustomer {

    private Customer customer;

    public CustomerController(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void withdrawMoney(double amount) {
        customer.WithdrawMoney(amount);
    }
}
