package com.kenzie.practicingclasses;

import java.util.Random;

public class Account {
    // Create class instance variables here
    private String userName;
    private String accountId;
    private double balance;


    // Implement the following class constructors
    public Account(String userName, String accountId, double balance) {
    this.userName = userName;
    this.accountId = accountId;
    this.balance = balance;
    }

    public Account(String userName, String accountId) {
    this.userName = userName;
    this.accountId = accountId;
    }

    public Account(String userName) {
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character by padding with zeros if necessary
        String idNumber =  String.format("%06d", number);
        this.userName = userName;
        userName.toLowerCase();
        accountId = userName.substring(0,3) + idNumber;
        if(accountId.length() < 9){
            accountId = userName.substring(0,3) + idNumber + rnd.nextInt(9);
        }
    }

    public String getUserName() {
        // Return the username of the current account
        return userName;
    }
    public void setUsername(String username){
        this.userName = getUserName();
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        // Return the account id fo the current account
        return accountId;
    }



    public double getBalance() {
        // Return the current balance of the account
        return balance;
    }

    public void makeDeposit(double amount) {
        // Add the given amount to the balance of the account
        balance += amount;
    }

    public double makeWithdrawal(double amount) {
        // If the account does not have enough money, then return 0 and do not modify the balance
        if (balance < amount) {
            return 0;

        } else {
            balance -= amount;
            // If the account has enough money, then adjust the balance by the given amount
            // And then return the amount that was withdrawn
        }
        return amount;
    }
}