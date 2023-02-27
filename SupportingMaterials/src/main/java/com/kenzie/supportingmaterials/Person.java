package com.kenzie.supportingmaterials;

public class Person {

    // Class properties
    public String firstName;
    public String lastName;
    public String street;
    public String city;
    public String state;
    public String zip;
    private int idNumber;
    public Person(){

    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

