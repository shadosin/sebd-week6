package com.kenzie.supportingmaterials;

public class VisibilityPractice {

    public static void practiceOne() {
        Person dataRecord; // Initial declaration of variable - no object created yet

        dataRecord = new Person(); // Person object is now instantiated


        dataRecord.firstName = "Sam";
        dataRecord.lastName = "Smith";
//        dataRecord.idNumber = 12345;   // Error: java: idNumber has private access in Person
        dataRecord.setIdNumber(12345);

        System.out.println(dataRecord.firstName + " " + dataRecord.lastName);
        System.out.println("ID: " + dataRecord.getIdNumber());
    }
    public static void main (String [] args){
        practiceOne();
    }
}
