package project.bussineslayer;

import project.bussineslayer.Bank;
import project.bussineslayer.model.interfaces.IBank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BankServer extends Bank {

    public void start() {
        try {

            Bank bank = new Bank();

            IBank stub = (IBank) UnicastRemoteObject.exportObject(bank, 0);

            Registry registry = LocateRegistry.getRegistry();

            registry.rebind("bank",stub);

            System.out.println("Server ready.");
        } catch (Exception e) {
            System.out.println("Connection error!");
            e.printStackTrace();
        }

    }
}
