/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.client;

import com.dt.project.api.LuckyNumber;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Main {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 6789);
        
        LuckyNumber luckyNumber = (LuckyNumber) registry.lookup("lucky");
        
        Scanner input = new Scanner(System.in);
        
        String again = "";
        
        while (!again.equalsIgnoreCase("no")) {
            System.out.println("Please input the lucky number??? ");
            String response = luckyNumber.process(input.nextLine());
            System.out.println(response);
            
            System.out.println("\nInput again??? yes/no ");
            again = input.nextLine();
        }
    }
}
