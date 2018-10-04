package project.bussineslayer.model.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICustomerController extends Remote {

    void withdrawMoney(double amount) throws RemoteException;
}
