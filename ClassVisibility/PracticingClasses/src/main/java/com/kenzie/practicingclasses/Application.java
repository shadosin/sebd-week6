package com.kenzie.practicingclasses;

public class Application {

    public static void transferBetween(Account source, Account recipient, double amount) {
        // This method should attempt to withdraw the amount from the source account,
        // and deposit it into the recipient account.
        //
        // You must print a message exactly like:
        // "Payment completed. Transferred 1000.0 from ken258192 to joe786471"
        // For the given amount, source accountId, and recipient accountId
        //
        // If the source account does not have enough money, then neither account should be changed.
        // A message exactly like this should be printed:
        // "Payment failed. Insufficient Funds."
        //
        // Your Code Here

    }

    public static void main(String[] args) {
        // The following code is here for testing purposes, and does not need to be changed.
        // Run this code and verify your output to make sure everything is working properly.

        System.out.println("*** Kenzie Budget System ***");

        // Create Three accounts
        Account companyAccount = new Account("Kenzie", "ken258192", 10000.0);
        Account employee = new Account("JoeTheManager");
        Account contractor = new Account("AnnaTheContractor", "con250192");

        System.out.println(companyAccount.getUserName() + " - " + companyAccount.getAccountId() + " - " + companyAccount.getBalance());
        // This should print: Kenzie - ken258192 - 10000.0
        System.out.println(employee.getUserName() + " - " + employee.getAccountId() + " - " + employee.getBalance());
        // This should print: JoeTheManager - joe528511 - 0.0
        // The numbers of your ID will vary.
        System.out.println(contractor.getUserName() + " - " + contractor.getAccountId() + " - " + contractor.getBalance());
        // This should print: AnnaTheContractor - con250192 - 0.0

        // Payout employee
        transferBetween(companyAccount, employee, 1000);
        System.out.println(employee.getUserName() + " - " + employee.getBalance());
        // This should print: JoeTheManager - 1000.0
        System.out.println(companyAccount.getUserName() + " - " + companyAccount.getBalance());
        // This should print: Kenzie - 9000.0

        // Employee Make Three payments to the contractor
        transferBetween(employee, contractor, 400);
        System.out.println(contractor.getUserName() + " - " +contractor.getBalance());
        // This should print: AnnaTheContractor - 400.0
        transferBetween(employee, contractor, 400);
        System.out.println(contractor.getUserName() + " - " +contractor.getBalance());
        // This should print: AnnaTheContractor - 800.0

        // The last payment should fail because Joe doesn't have enough.
        transferBetween(employee, contractor, 400);
        System.out.println(contractor.getUserName() + " - " +contractor.getBalance());
        // This should print: AnnaTheContractor - 800.0
        System.out.println(employee.getUserName() + " - " + employee.getBalance());
        // This should print: JoeTheManager - 200.0
    }
}