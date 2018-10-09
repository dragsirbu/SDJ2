package project.bussineslayer.model.interfaces;

import project.bussineslayer.model.Account;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IAdminController extends Remote {

    void createAccount(int number, double balance) throws RemoteException;

    ArrayList<Account> getAccounts() throws RemoteException;
}
