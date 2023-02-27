package com.kenzie.supportingmaterials;
import java.util.Random;
public class Coin {
    String currentState;
    private int state;
    public String flip(){
        Random flipper = new Random();
        int randomInt = flipper.nextInt(2);
        this.state = randomInt;
        String result = this.getHeadsOrTails();
        return result;
    }
    public Coin(int state){
        if (state == 0) {
            this.currentState = "Heads";
        }else if(state == 1) {
            this.currentState = "Tails";
        }else{
            this.currentState = "Edge";
        }
    }
    public String getHeadsOrTails(){
        if(this.state == 0){
            return "Heads";
        }else{
            return "Tails";
        }
    }
}
