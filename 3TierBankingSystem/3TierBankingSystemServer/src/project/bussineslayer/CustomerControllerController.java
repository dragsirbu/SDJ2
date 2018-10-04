package project.bussineslayer;

import project.bussineslayer.model.Customer;
import project.bussineslayer.model.interfaces.ICustomerController;

public class CustomerControllerController implements ICustomerController {

    private Customer customer;

    public CustomerControllerController(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void withdrawMoney(double amount) {
        customer.withdrawMoney(amount);
    }
}
