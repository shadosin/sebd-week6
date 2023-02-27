package com.kenzie.supportingmaterials;

import java.util.Random;

public class ConstructorPractice {
    public static void practiceOne() {
         Person buzz = new Person("Buzz", "Lightyear");
    }

    public static void practiceTwo() {
        // Call each constructor once for the Player class
        // Print out each full name
        Player player1 = new Player("EasyIce2099");
        Player player2 = new Player("L33tGamer55", "Ben");
        Player defaultPlayer = new Player();
        System.out.println(player1.getFullName());
        System.out.println(player2.getFullName());
        System.out.println(defaultPlayer.getFullName());

    }

    public static void practiceThree() {
        Random random = new Random();
        int seed = random.nextInt(3);


        Coin coinToss = new Coin(seed);
        System.out.println("The coin landed on: " + coinToss.currentState);

    }

    // Maybe need to create a main method :)
    public static void main(String[] args){
        practiceOne();
        practiceTwo();
        practiceThree();
    }
}
