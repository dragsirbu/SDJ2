package project.bussineslayer.model.interfaces;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBankController extends Remote {

        void addAdmin(Administrator admin) throws RemoteException;

        void addClerk(Clerk clerk) throws RemoteException;

        void addCustomer(Customer customer) throws RemoteException;

        void createAccount(Account account) throws RemoteException;

        void insertMoney(Account account,double amount) throws RemoteException;

        void withdrawMoney(Account account,double amount) throws RemoteException;

        boolean isAdmin(Administrator admin) throws RemoteException;

        boolean isClerk(Clerk clerk) throws RemoteException;

        boolean isCustomer(Customer customer) throws RemoteException;

        Account getAccount(int number) throws RemoteException;

}
