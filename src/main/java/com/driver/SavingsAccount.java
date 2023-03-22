package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // initialize the attributes

        super(name, balance, 0); // call the default bank account constructor

        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    // make withdraw
    public void withdraw(double amount) throws Exception {
        if (amount > this.getBalance()) { // if balance is not enough
            throw new Exception("Insufficient Balance");
        } else if (amount > this.maxWithdrawalLimit) { // if withdraw amount is beyond the limit
            throw  new Exception("Maximum Withdraw Limit Exceed");
        }

        // successful withdraw
        double currentBalance = this.getBalance();
        currentBalance -= amount;

        this.setBalance(currentBalance); // update the balance
    }

    // calculate simple interest
    public double getSimpleInterest(int years){
        double interest = this.rate * this.getBalance();
        double accumulatedInterest = interest * years;

        double newBalance = this.getBalance() + accumulatedInterest;

        this.setBalance(newBalance); // update the account balance

        return newBalance;
    }

    // calculate compound interest
    public double getCompoundInterest(int times, int years){
       for (int year = 1; year <= years; year++) {

           while (times > 0) {
               double currentBalance = this.getBalance();

               double interest = rate * currentBalance;
               double newBalance = currentBalance + interest;

               this.setBalance(newBalance); // update the account balance

               times--;
           }
       }

       return this.getBalance();
    }

}
