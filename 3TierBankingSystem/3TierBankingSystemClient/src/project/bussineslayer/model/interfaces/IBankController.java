package project.bussineslayer.model.interfaces;

import project.bussineslayer.model.Account;
import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.Clerk;
import project.bussineslayer.model.Customer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IBankController extends Remote {

    void setAdministratorController(Administrator administrator) throws RemoteException;

    void setClerkController(Clerk clerk) throws RemoteException;

    void setCustomerController(Customer customer) throws RemoteException;

    void setAccountList() throws RemoteException;

    void addAdmin(Administrator admin) throws RemoteException;

    void addClerk(Clerk clerk) throws RemoteException;

    void addCustomer(Customer customer) throws RemoteException;

    void createAccount(int number, double balance) throws RemoteException;

    void clerkInsertMoney(int accountNumber,double amount) throws RemoteException;

    void clerkWithdrawMoney(int accountNumber,double amount) throws RemoteException;

    void customerWithdrawMoney(double amount) throws RemoteException;

    boolean isAdmin(Administrator admin) throws RemoteException;

    boolean isClerk(Clerk clerk) throws RemoteException;

    boolean isCustomer(Customer customer) throws RemoteException;

    Account getAccount(int number) throws RemoteException;

}
