package com.kenzie.classesandmethods;

import java.util.Random;

public class Dice {
    // Define class variables here
   int dice1;
   int dice2;

    // Define class methods here
    public void roll(){
        Random rolls = new Random();
        dice1 = rolls.nextInt(6)+1;
        dice2 = rolls.nextInt(6)+1;
    }
    public int getTotal(){
        return dice1+dice2;
    }
    public int getDice1(){
        return dice1;
    }
    public int getDice2(){
        return dice2;
    }
}