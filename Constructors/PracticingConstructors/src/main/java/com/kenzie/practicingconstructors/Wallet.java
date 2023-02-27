package com.kenzie.practicingconstructors;

public class Wallet {
    private int numCreditCards;
    private String owner;
    private double totalCash;
public Wallet(){
    numCreditCards=0;
    totalCash=0;
    owner="";
}
public Wallet(String owner){
    numCreditCards=0;
    totalCash=0;
    this.owner=owner;
}
public Wallet( int numCreditCards, String owner, double totalCash){
    this.owner = owner;
    this.numCreditCards = numCreditCards;
    this.totalCash = totalCash;
}
public void setOwner(String owner){
    this.owner = owner;
}
public String getOwner(){
    return owner;
}
public void setNumCreditCards(int numCreditCards){
    this.numCreditCards = numCreditCards;
}
public int getNumCreditCards(){
    return numCreditCards;
}
public void setTotalCash(double totalCash){
    this.totalCash = totalCash;
}
public double getTotalCash(){
    return totalCash;
}
}