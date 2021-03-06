package project.bussineslayer.model;

import java.io.Serializable;

public class Account
        implements Serializable
{
    private int number;
    private double balance;


    public Account(int number) {
        this.number = number;
    }

    public Account( int number, double balance )
    {
        this.number = number;
        this.balance = balance;
    }


    public int getNumber()
    {
        return number;
    }


    public double getBalance()
    {
        return balance;
    }


    public void updateBalance( double amount )
    {
        balance += amount;
    }

    public boolean equals(int number) {
        return (this.number == number);
    }

    @Override
    public String toString() {
        return "Number: "+this.getNumber()+", Balance: "+this.getBalance();
    }
}
