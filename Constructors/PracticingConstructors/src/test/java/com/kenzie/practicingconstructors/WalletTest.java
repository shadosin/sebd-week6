package com.kenzie.practicingconstructors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    static final Object[] TWO = {"Richie Rich"};
    static final Object[] THREE = {2,"Scrooge", 1000.99};
    public static Class<?>[] PARAM_TYPES_TWO = {String.class};
    public static Class<?>[] PARAM_TYPES_THREE = {int.class, String.class, double.class};

    String ClassName = "Wallet";

    @Test void classHasField_numCreditCards_Test() {
        String fieldNameToFind = "numCreditCards";
        String fieldType = "int";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + ClassName + " class.");
        }
    }

    @Test void classHasField_owner_Test() {
        String fieldNameToFind = "owner";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + ClassName + " class.");
        }
    }

    @Test void classHasField_totalCash_Test() {
        String fieldNameToFind = "totalCash";
        String fieldType = "double";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + ClassName + " class.");
        }
    }

    @Test
    void wallet_parameterlessConstructor_Exists() {
        try {

            Class<Wallet> walletClass = Wallet.class;
            Constructor<Wallet> cons = walletClass.getConstructor();
            Wallet instance = cons.newInstance();

            int actualNumCreditCards = Integer.parseInt(getFieldValueInClassUsingReflection("numCreditCards", null, null));
            String actualOwner = getFieldValueInClassUsingReflection("owner", null, null);
            double totalCash = Double.parseDouble(getFieldValueInClassUsingReflection("totalCash", null, null));

            assertEquals(actualNumCreditCards, 0, "The numCreditCards field should be be equal to 0 when we create an object from the Wallet class with a parameterless constructor");
            assertEquals(actualOwner, "", "The actualOwner field should be an empty string when we create an object from the Wallet class with a parameterless constructor");
            assertEquals(totalCash, 0.0, "The totalCash field should be be equal to 0.0 when we create an object from the Wallet class with a parameterless constructor");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The Wallet  class should have a parameterless constructor");
        }
    }

    @Test
    void wallet_1ParameterConstructor_Exists() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            String expectedOwner = "The New Owner";
            Object [] params = {expectedOwner};

            Class<Wallet> walletClass = Wallet.class;
            Constructor<Wallet> cons = walletClass.getConstructor(PARAM_TYPES_TWO);
            Wallet instance = cons.newInstance(params);

            String actualNumCreditCardsString = getFieldValueInClassUsingReflection("numCreditCards", params, PARAM_TYPES_TWO);
            String actualTotalCashString = getFieldValueInClassUsingReflection("totalCash", params, PARAM_TYPES_TWO);

            int actualNumCreditCards = Integer.parseInt(actualNumCreditCardsString);
            String actualOwner = getFieldValueInClassUsingReflection("owner", params, PARAM_TYPES_TWO);
            double actualTotalCash = Double.parseDouble(actualTotalCashString);

            assertEquals(actualNumCreditCards, 0, "The numCreditCards field should be be equal to 0 when we create an object from the Wallet class with a parameterless constructor");
            assertEquals(expectedOwner, actualOwner, "The owner field should be set to the String provided through the class constructor. Expected " + expectedOwner + " but received " + actualOwner);
            assertEquals(actualTotalCash, 0.0, "The totalCash field should be be equal to 0.0 when we create an object from the Wallet class with a parameterless constructor");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The Wallet class should have a 1 parameter constructor");
        }
    }
    @Test
    void wallet_3ParameterConstructor_Exists() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        try {
            int expectedNumCreditCards = 5;
            String expectedOwner = "The New Owner";
            double expectedTotalCash = 50.0;

            Object [] params = {expectedNumCreditCards, expectedOwner, expectedTotalCash};

            Class<Wallet> walletClass = Wallet.class;
            Constructor<Wallet> cons = walletClass.getConstructor(PARAM_TYPES_THREE);
            Wallet instance = cons.newInstance(params);

            String actualNumCreditCardsString = getFieldValueInClassUsingReflection("numCreditCards", params, PARAM_TYPES_THREE);
            String actualTotalCashString = getFieldValueInClassUsingReflection("totalCash", params, PARAM_TYPES_THREE);

            int actualNumCreditCards = Integer.parseInt(actualNumCreditCardsString);
            String actualOwner = getFieldValueInClassUsingReflection("owner", params, PARAM_TYPES_THREE);
            double actualTotalCash = Double.parseDouble(actualTotalCashString);

            assertEquals(expectedNumCreditCards, actualNumCreditCards, "The numCreditCards field should be set to the int provided through the class constructor. Expected " + expectedNumCreditCards + " but received " + actualNumCreditCards);
            assertEquals(expectedOwner, actualOwner, "The owner field should be set to the String provided through the class constructor. Expected " + expectedOwner + " but received " + actualOwner);
            assertEquals(expectedTotalCash, actualTotalCash, "The owner totalCash should be set to the double provided through the class constructor. Expected " + expectedTotalCash + " but received " + actualTotalCash);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The Wallet class should have a 3 parameter constructor");
        }
    }

    @Test
    void canCreate_DefaultWallet_Test() {
        try{
            Constructor walletConstructor = Wallet.class.getConstructor();
            Wallet wallet = (Wallet) walletConstructor.newInstance();
            Method getOwner = Wallet.class.getMethod("getOwner");
            Method getNumCreditCards = Wallet.class.getMethod("getNumCreditCards");
            Method getTotalCash = Wallet.class.getMethod("getTotalCash");

            assertEquals("", getOwner.invoke(wallet), "Constructor default test: owner=\"\"" );
            assertEquals(0, getNumCreditCards.invoke(wallet), "Constructor default test: numCreditCards=0");
            assertEquals(0.0, getTotalCash.invoke(wallet), "Constructor default test: totalCash = 0");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Wallet and all setter/getter methods must be defined");
        }
    }

    @Test
    void canCreate_Wallet_Test() {
        try{
            Constructor walletConstructorTwo = Wallet.class.getConstructor(PARAM_TYPES_TWO);
            Wallet wallet2 = (Wallet) walletConstructorTwo.newInstance(TWO);

            Constructor walletConstructorThree = Wallet.class.getConstructor(PARAM_TYPES_THREE);
            Wallet wallet3 = (Wallet) walletConstructorThree.newInstance(THREE);


            Method getOwner = Wallet.class.getMethod("getOwner");
            Method getNumCreditCards = Wallet.class.getMethod("getNumCreditCards");
            Method getTotalCash = Wallet.class.getMethod("getTotalCash");

            assertEquals("Richie Rich", getOwner.invoke(wallet2), "Constructor default test: owner=Richie Rich" );
            assertEquals(0, getNumCreditCards.invoke(wallet2), "Constructor default test: numCreditCards=0");
            assertEquals(0.0, getTotalCash.invoke(wallet2), "Constructor default test: totalCash = 0");

            assertEquals("Scrooge", getOwner.invoke(wallet3), "Constructor default test: owner=Richie Rich" );
            assertEquals(2, getNumCreditCards.invoke(wallet3), "Constructor default test: numCreditCards=0");
            assertEquals(1000.99, getTotalCash.invoke(wallet3), "Constructor default test: totalCash = 0");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Wallet and all setter/getter methods must be defined");
        }
    }


    @Test
    void canGetAndSetField_NumCreditCards_Test() {
        try {
            Constructor walletConstructor = Wallet.class.getConstructor();
            Method getNumCreditCards = Wallet.class.getMethod("getNumCreditCards");
            Method setNumCreditCards = Wallet.class.getMethod("setNumCreditCards", int.class);

            Wallet wallet = (Wallet) walletConstructor.newInstance();
            setNumCreditCards.invoke(wallet, 10);
            assertEquals(10, getNumCreditCards.invoke(wallet), "setNumCreditCards test: numCreditCards=10");
        }  catch (Exception e) {
            System.out.println(e.toString());
            fail("Wallet and all setter/getter methods must be defined");
        }
    }


    @Test
    void canGetAndSet_Owner_Test() {
        try {
            Constructor walletConstructor = Wallet.class.getConstructor();
            Method getOwner = Wallet.class.getMethod("getOwner");
            Method setOwner = Wallet.class.getMethod("setOwner", String.class);

            Wallet wallet = (Wallet) walletConstructor.newInstance();
            setOwner.invoke(wallet, "Minnie Mouse");
            assertEquals("Minnie Mouse", getOwner.invoke(wallet), "setNumCreditCards test: numCreditCards=10");
        }  catch (Exception e) {
            System.out.println(e.toString());
            fail("Wallet and all setter/getter methods must be defined");
        }
    }


    @Test
    void canGetAndSet_TotalCash_Test() {
        try {
            Constructor walletConstructor = Wallet.class.getConstructor();
            Method getTotalCash = Wallet.class.getMethod("getTotalCash");
            Method setTotalCash = Wallet.class.getMethod("setTotalCash", double.class);

            Wallet wallet = (Wallet) walletConstructor.newInstance();
            setTotalCash.invoke(wallet, 3);
            assertEquals(3.0, getTotalCash.invoke(wallet), "setNumCreditCards test: numCreditCards=10");
            setTotalCash.invoke(wallet, .99);
            assertEquals(.99, getTotalCash.invoke(wallet), "setNumCreditCards test: numCreditCards=10");
        }  catch (Exception e) {
            System.out.println(e.toString());
            fail("Wallet and all setter/getter methods must be defined");
        }
    }

    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?> [] paramTypes) {
        try {
            Class<Wallet> myClass = Wallet.class;

            Constructor walletConstructor = myClass.getConstructor(paramTypes);
            Wallet wallet = (Wallet) walletConstructor.newInstance(params);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            field.setAccessible(true);

            if (field.get(wallet) == null){
                return "";
            }

            return field.get(wallet).toString();

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
