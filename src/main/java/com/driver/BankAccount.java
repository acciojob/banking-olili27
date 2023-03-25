package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        // initialize the attributes

        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String getName() {
        return name;
    }

    // setter for balance
    public void setBalance(double amount) {
        this.balance = amount;
    }

    // getter for balance
    public double getBalance() {
        return this.balance;
    }

    // generate account number
    public String generateAccountNumber(int digits, int sum) throws Exception{
        if(sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }

        String accountNumber = "";
        while (sum > 9) {
            accountNumber += "9";
            sum -= 9;
        }

        accountNumber += sum + "";
        while (accountNumber.length() > digits) {
            accountNumber += "0";
        }

        return accountNumber;
    }

    // make a deposit
    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    // make a withdraw
    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

            double newBalance = balance - amount;

            if (newBalance < minBalance) throw new Exception("Insufficient Balance");  // if balance is not enough

            else {
                balance = newBalance; // if balance is sufficient
            }
    }

}