package project.bussineslayer;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.interfaces.IAdminController;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class AdministratorController implements IAdminController {

    private Administrator admin;


    public AdministratorController(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public void createAccount(int number, double balance) {
        admin.createAccount(number,balance);
    }

    @Override
    public ArrayList<Account> getAccounts() throws RemoteException {
        return admin.getAccounts();
    }


}
