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

        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < digits; i++) {
            int digit;
            if (i == digits - 1) {
                digit = sum;
            } else {
                digit = random.nextInt(Math.min(9, sum) + 1);
            }

            accountNumber.append(digit);
            sum -= digit;
        }

        return accountNumber.toString();
    }

    // make a deposit
    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    // make a withdraw
    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        try {
            double newBalance = balance - amount;

            if (newBalance < minBalance) throw new Exception();  // if balance is not enough

            else {
                balance = newBalance; // if balance is sufficient
            }
        } catch ( Exception e) {
            System.out.println("Insufficient Balance");
        }
    }

}