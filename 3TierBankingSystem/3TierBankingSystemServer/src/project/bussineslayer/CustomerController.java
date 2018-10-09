package project.bussineslayer;

import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.ICustomerController;

public class CustomerController implements ICustomerController {

    private Customer customer;

    public CustomerController(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void withdrawMoney(double amount) {
        customer.withdrawMoney(amount);
    }
}
