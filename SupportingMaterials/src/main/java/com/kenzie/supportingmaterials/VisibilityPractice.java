package com.kenzie.supportingmaterials;

public class VisibilityPractice {

    public static void practiceOne() {
        Person dataRecord; // Initial declaration of variable - no object created yet

        dataRecord = new Person(); // Person object is now instantiated

        /* UNCOMMENT ME
        dataRecord.firstName = "Sam";
        dataRecord.lastName = "Smith";
        dataRecord.idNumber = 12345;   // Error: java: idNumber has private access in Person
        */

        System.out.println(dataRecord.firstName + " " + dataRecord.lastName);
    }
}
