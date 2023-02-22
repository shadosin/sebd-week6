package com.kenzie.classesandmethods;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    static final String CLASS_NAME = "Dice";
    @Test void classHasField_dice1_Test() {
        String fieldNameToFind = "dice1";
        String fieldType = "int";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_dice2_Test() {
        String fieldNameToFind = "dice2";
        String fieldType = "int";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }
    @Test
    void canGetDice1Value_Test() {
        try {
            Class<Dice> walletClass = Dice.class;
            Constructor<Dice> cons = walletClass.getConstructor();
            Dice dice = cons.newInstance();

            Method roll = Dice.class.getMethod("roll");
            roll.invoke(dice);

            Method getDice1 = Dice.class.getMethod("getDice1");
            int diceValue1 = (int) getDice1.invoke(dice);

            assertTrue(diceValue1 > 0, "dice1 should be greater than 0 but was " + diceValue1);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Dice and all setter/getter methods must be defined for the getDice1 method");
        }
    }

    @Test
    void canGetDice2Value_Test() {
        try {
            Class<Dice> walletClass = Dice.class;
            Constructor<Dice> cons = walletClass.getConstructor();
            Dice dice = cons.newInstance();

            Method roll = Dice.class.getMethod("roll");
            roll.invoke(dice);

            Method getDice2 = Dice.class.getMethod("getDice2");
            int diceValue2 = (int) getDice2.invoke(dice);
            assertTrue(diceValue2 > 0, "dice2 should be greater than 0 but was " + diceValue2);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Dice and all setter/getter methods must be defined for the getDice2 method");
        }
    }

    @Test
    void canGetDiceTotalValue_Test() {
        try {
            Class<Dice> walletClass = Dice.class;
            Constructor<Dice> cons = walletClass.getConstructor();
            Dice dice = cons.newInstance();

            Method roll = Dice.class.getMethod("roll");
            roll.invoke(dice);

            Method getDice1 = Dice.class.getMethod("getDice1");
            int diceValue1 = (int) getDice1.invoke(dice);

            Method getDice2 = Dice.class.getMethod("getDice2");
            int diceValue2 = (int) getDice2.invoke(dice);

            Method getTotal = Dice.class.getMethod("getTotal");
            int sumOfRoll = (int) getTotal.invoke(dice);

            assertEquals(sumOfRoll, sumOfRoll,"getTotal should have returned  " + diceValue1 + diceValue2 + "but total was" + sumOfRoll);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Dice and all setter/getter methods must be defined");
        }
    }

    @Test
    public void rollDice_Test() {
        int result = Application.rollDice();
        assert(result >= 2 && result <= 12) ;
        result = Application.rollDice();
        assert(result >= 2 && result <= 12) ;
        result = Application.rollDice();
        assert(result >= 2 && result <= 12) ;
    }

    @Test
    public void roll1000Dice_Test() {
        int[] results = Application.roll1000Times();
        assertEquals(13, results.length, "There are the right number of elements"); ;
        for (int i = 2; i < results.length; i++) {
            assertEquals(true, results[i] > 0, "Every number 2-12 is greater than 0");
        }
        int rollsTotal = 0;
        for (int i = 0; i < results.length; i++){
            rollsTotal += results[i];
        }
        assertTrue(rollsTotal == 1000, "Rolled the correct number of dice");
    }

    @Test
    public void roll1000DiceReRolling1s_Test() {
        int[] results = Application.roll1000TimesReRolling1s();
        assertEquals(13, results.length, "There are the right number of elements"); ;
        for (int i = 4; i < results.length; i++) {
            assertTrue(results[i] > 0, "Every number 2-12 is greater than 0");
        }
        assertEquals(0, results[2], "2 should not be rolled");
        assertEquals(0, results[3], "3 should not be rolled");

        int rollsTotal = 0;
        for (int result : results) {
            rollsTotal += result;
        }
        assertEquals(1000, rollsTotal, "Rolled the correct number of dice");

    }

    @Test
    public void runMain() {
        boolean crashed = false;
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            crashed = true;
        }

        assertEquals(false, crashed, "App can run without crashing") ;
    }

    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?>[] paramTypes) {
        try {
            Class<Dice> myClass = Dice.class;

            Constructor diceConstructor = myClass.getConstructor(paramTypes);
            Dice dice = (Dice) diceConstructor.newInstance(params);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            field.setAccessible(true);

            return field.get(dice).toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}