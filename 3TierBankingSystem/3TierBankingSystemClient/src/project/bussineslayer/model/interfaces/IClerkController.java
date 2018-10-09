package project.bussineslayer.model.interfaces;

import project.bussineslayer.model.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClerkController extends Remote {

    void insertMoney(Account account, double amount) throws RemoteException;

    void withdrawMoney(Account account, double amount) throws RemoteException;
}
