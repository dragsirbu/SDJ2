package project.bussineslayer;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.interfaces.IClerkController;

public class ClerkController implements IClerkController {

    private Clerk clerk;

    public ClerkController(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void insertMoney(Account account, double amount) {
        clerk.insertMoney(account,amount);
    }

    @Override
    public void withdrawMoney(Account account, double amount) {
        clerk.withdrawMoney(account, amount);
    }
}
