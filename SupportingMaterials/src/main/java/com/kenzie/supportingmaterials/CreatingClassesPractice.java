package com.kenzie.supportingmaterials;

public class CreatingClassesPractice {
    public static void practiceOne() {
        // Create an AnimalCharacter
        AnimalCharacter sparklePony = new AnimalCharacter();
        sparklePony.firstName = "Beauty";
        sparklePony.lastName = "Princess";
        sparklePony.age = 50;
        System.out.println("Hello " + sparklePony.firstName + " " + sparklePony.lastName + "!");
    }
    public static void main(String args[]){
        practiceOne();
    }
}
