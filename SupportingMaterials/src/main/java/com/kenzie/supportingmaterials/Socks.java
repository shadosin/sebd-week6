package com.kenzie.supportingmaterials;

import java.util.Random;

// Do not change this class!
public class Socks {
    public int state; // 0 for folded, 1 for unfolded

    public String fold() {
        Random folder = new Random();

        // Generate random integers in range 0 to 1; we set it to 2 here
        // so that the possible values will be 0 and 1, since the nextInt()
        // method does not include the number passed in, in this case "2"
        int randomInt = folder.nextInt(2);

        this.state = randomInt;

        return this.getState();
    }

    public String getState() {
        if (this.state == 0) {
            return "Folded";
        } else {
            return "Unfolded";
        }
    }
}