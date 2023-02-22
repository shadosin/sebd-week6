package com.kenzie.classesandmethods;

public class Application {
    public static int rollDice() {
        // Your Code Here

        return 0;
    }

    public static int[] roll1000Times() {
        int[] results = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        // Your Code Here

        return results;
    }

    public static int[] roll1000TimesReRolling1s() {
        int[] results = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        // Now, the dice 1000 times again.
        // But, re-roll both dice any time either die is a 1.
        // Your Code Here

        return results;
    }

    public static void main(String[] args) {
        // You should not need to modify the code in this method.  Put your code in the two methods above.
        System.out.println("I rolled the dice and got: " + rollDice());

        int[] results = roll1000Times();

        System.out.println("Rolling 1000 Dice...");
        System.out.println("Results: ");
        for (int i = 2; i < results.length; i++) {
            System.out.println(i + ": " + results[i]);
        }

        results = roll1000TimesReRolling1s();

        System.out.println("Rolling 1000 Dice while re-rolling 1s...");
        System.out.println("Results: ");
        for (int i = 2; i < results.length; i++) {
            System.out.println(i + ": " + results[i]);
        }
    }
}