package com.kenzie.practicingclasses;

public class Account {
    //create class instance variables here


    //implement the following class constructors
    public Account(String userName, String accountId, double balance) {

    }

    public Account(String userName, String accountId) {

    }

    public Account(String userName) {

    }





    public String getUserName() {
        // return the user name of the current account
        return "";
    }

    public String getAccountId() {
        // return the account id fo the current account
        return "";
    }

    public double getBalance() {
        // return the current balance of the account
        return 0.0;
    }

    public void makeDeposit(double amount) {
        // Add the given amount to the balance of the account

    }

    public double makeWithdrawal(double amount) {
        // If the account does not have enough money, then return 0 and do not modify the balance
        // If the account has enough money, then adjust the balance by the given amount
        // And then return the amount that was withdrawn
        return 0;
    }
}