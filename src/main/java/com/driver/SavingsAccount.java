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

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }

    // make withdraw
    public void withdraw(double amount) throws Exception {
        if (amount > this.maxWithdrawalLimit) { // if withdraw amount is beyond the limit
            throw  new Exception("Maximum Withdraw Limit Exceed");
        } else {
            super.withdraw(amount);
        }
    }

    // calculate simple interest
    public double getSimpleInterest(int years){
       return getBalance() * (1 + (rate * years) / 100);
    }

    // calculate compound interest
    public double getCompoundInterest(int times, int years){

       return getBalance() * Math.pow( (1 + (rate / (100 * times) )), (years * times));
    }

}
