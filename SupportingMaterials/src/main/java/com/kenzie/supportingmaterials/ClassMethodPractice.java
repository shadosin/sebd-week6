package com.kenzie.supportingmaterials;

public class ClassMethodPractice {
    public static void practiceZero() {
        // Fold socks here ;)
        Socks warmFluffy= new Socks();
        System.out.println(warmFluffy.fold());
    }

    public static void practiceOne() {
        // Create and call fortune teller here
        FortuneTeller big = new FortuneTeller();
        String fortune = big.guess();
        System.out.println(fortune);
    }
    
    public static void practiceTwo() {
        Character bear = new Character();
        bear.setFirstName("Yogi");
        bear.setLastName("Bear");
        System.out.println(bear.makeAnnouncement());
    }

public static void main(String[] args){
        practiceZero();
        practiceOne();
        practiceTwo();
}
    // You may need to create a main method :)
}
