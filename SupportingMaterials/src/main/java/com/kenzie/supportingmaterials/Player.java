package com.kenzie.supportingmaterials;

public class Player {
    private String gamerHandle;
    private String realName;

    // Constructors here
    public Player() {

    }

    public Player(String gamerHandle) {
        this.gamerHandle = gamerHandle;
        this.realName = "";
    }

    public Player(String gamerHandle,String realName) {
        this.gamerHandle = gamerHandle;
        this.realName = realName;
    }

    public String getFullName() { // Class Method
        return this.gamerHandle + " " + this.realName;
    }
}
