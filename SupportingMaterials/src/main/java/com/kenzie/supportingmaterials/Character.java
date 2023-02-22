package com.kenzie.supportingmaterials;

public class Character {

    // Class Properties
    public String firstName;
    public String lastName;

    public void setFirstName(String firstName) {
        // this.firstName refers to the class property
        // firstName (without this) refers to the parameter
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        // this.lastName refers to the class property
        // lastName (without this) refers to the parameter
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String makeAnnouncement() {
        String message = getFullName() + " is joining the team!";
        return message;
    }
}
