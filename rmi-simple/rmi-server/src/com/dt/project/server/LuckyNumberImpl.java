/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.server;

import com.dt.project.api.LuckyNumber;
import java.rmi.RemoteException;

/**
 *
 * @author dell
 */
public class LuckyNumberImpl implements LuckyNumber {

    private int luckyNumber = 100;
    
    @Override
    public String process(String value) throws RemoteException {
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (Exception e) {
            return "Please input a number.";
        }
        
        if (num == luckyNumber) {
            return "Congratulation!!!";
        }else {
            return "Sorry, please try again.";
        }
    }
    
}
