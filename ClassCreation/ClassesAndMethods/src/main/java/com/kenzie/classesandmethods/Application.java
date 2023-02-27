package com.kenzie.classesandmethods;

public class Application {
    public static int rollDice() {
        // Your Code Here
        Dice dice = new Dice();
        dice.roll();
        return dice.getTotal();
    }

    public static int[] roll1000Times() {
        int[] results = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        // Your Code Here

        for(int i=0; i < 1000; i++){
            Dice dice = new Dice();
            dice.roll();
            int total = dice.getTotal();
            results[total]++;
        }
        return results;
    }

    public static int[] roll1000TimesReRolling1s() {
        int[] results = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        // Now, the dice 1000 times again.
        // But, re-roll both dice any time either die is a 1.
        // Your Code Here
        for (int i = 0; i < 1000; i++) {
            Dice dice = new Dice();
            dice.roll();
            int total = dice.getTotal();
            while (dice.getDice1() == 1 || dice.getDice2() == 1) {
                dice.roll(); // re-roll both dice if either is a 1
                total = dice.getTotal();
            }
            results[total]++;
        }
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