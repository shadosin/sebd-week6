package com.kenzie.practicingconstructors;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    public static final Object[] CLOCK_ONE = {};
    public static final Object[] CLOCK_TWO = {3, 15, "PM", "Central"};
    public static final Object[] CLOCK_THREE = {15, 65, "morning", "new york"};

    public static final Class<?>[] PARAM_TYPES = {int.class, int.class, String.class, String.class};
    public static final String CLASS_NAME = "Clock";


    @Test void classHasField_hour_Test() {
        String fieldNameToFind = "hour";
        String fieldType = "int";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_minute_Test() {
        String fieldNameToFind = "minute";
        String fieldType = "int";

        try {
            String value = getFieldValueInClassUsingReflection(fieldNameToFind);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_period_Test() {
        String fieldNameToFind = "period";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_timeZone_Test() {
        String fieldNameToFind = "timeZone";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test
    void clockClass_hourGetterAndSetter_Exists_Test() {
        try {
            Clock.class.getMethod("getHour");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a getter method named getHour");
        }

        try {
            Clock.class.getMethod("setHour", int.class);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a setter method named setHour");
        }
    }

    @Test
    void clockClass_minuteGetterAndSetter_Exists_Test() {
        try {
            Clock.class.getMethod("getMinute");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a getter method named getMinute");
        }

        try {
            Clock.class.getMethod("setMinute", int.class);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a setter method named setMinute");
        }
    }

    @Test
    void clockClass_periodGetterAndSetter_Exists_Test() {
        try {
            Clock.class.getMethod("getPeriod");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a getter method named getPeriod");
        }

        try {
            Clock.class.getMethod("setPeriod", String.class);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a setter method named setPeriod");
        }
    }

    @Test
    void clockClass_timeZoneGetterAndSetter_Exists_Test() {
        try {
            Clock.class.getMethod("getTimeZone");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a getter method named getTimeZone");
        }

        try {
            Clock.class.getMethod("setTimeZone", String.class);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class must have a setter method named setTimeZone");
        }
    }

    @Test
    void clockClass_parameterlessConstructor_Exists_Test() {

        try {
            Class clockClass = Clock.class;
            Object newInstance = clockClass.newInstance();
            Class<?>[] type = { };
            Constructor<?> cons = clockClass.getConstructor(type);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class should have a parameterless constructor");
        }
    }

    @Test
    void clockClass_4ParameterConstructor_Exists_Test()  {

        try {
            Class clockClass = Clock.class;
            Object newInstance = clockClass.newInstance();
            Class<?>[] type = { int.class, int.class, String.class, String.class};
            Constructor<?> cons = clockClass.getConstructor(type);
            Object[] obj = { 2, 10, "AM", "Eastern"};
            Object newInstancePCObj = cons.newInstance(obj);
            Clock newClock = (Clock) cons.newInstance(obj);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class should have a constructor that takes four variables, an int hour, an int minute, a String period, and a String timeZone ");
        }
    }

    @Test
    void canSetAndGetHour_Test() {
        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setHour = Clock.class.getMethod("setHour", int.class);
            setHour.invoke(clock, 10);
            Method getHour = Clock.class.getMethod("getHour");
            int hourValue  = (int) getHour.invoke(clock);
            assertEquals(10, hourValue, "setHour test: hour valid set to 10");

            setHour.invoke(clock, 0);
            hourValue  = (int) getHour.invoke(clock);
            assertEquals(10, hourValue, "setHour test: invalid remains 10");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }
    }

    @Test
    void canSetAndGetMinute_Test() {
        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setMinute = Clock.class.getMethod("setMinute", int.class);
            setMinute.invoke(clock, 10);
            Method getMinute = Clock.class.getMethod("getMinute");
            int minuteValue  = (int) getMinute.invoke(clock);
            assertEquals(10, minuteValue, "setMinute test: minute valid set to 10");

            setMinute.invoke(clock, 0);
            minuteValue  = (int) getMinute.invoke(clock);
            assertEquals(0, minuteValue, "setMinute test: minute valid set to 0");

            setMinute.invoke(clock, 100);
            minuteValue = (int) getMinute.invoke(clock);
            assertEquals(0, minuteValue, "setMinute test: minute invalid remains 0" );

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }
    }

    @Test
    void canSetAndGetPeriodTo_AM_Test() {
        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setPeriod = Clock.class.getMethod("setPeriod", String.class);
            Method getPeriod = Clock.class.getMethod("getPeriod");

            setPeriod.invoke(clock, "AM");
            String periodValue = (String) getPeriod.invoke(clock);
            assertEquals("AM", periodValue, "setPeriod test: period valid set to AM");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }
    }

    @Test
    void canSetAndGetPeriodTo_PM_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setPeriod = Clock.class.getMethod("setPeriod", String.class);
            Method getPeriod = Clock.class.getMethod("getPeriod");

            setPeriod.invoke(clock, "PM");
            String periodValue = (String) getPeriod.invoke(clock);
            assertEquals("PM", periodValue, "setPeriod test: period valid set to PM");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }

    }

    @Test
    void canSetAndGetPeriodTo_NightTime_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setPeriod = Clock.class.getMethod("setPeriod", String.class);
            Method getPeriod = Clock.class.getMethod("getPeriod");

            setPeriod.invoke(clock, "night time");
            String periodValue = (String) getPeriod.invoke(clock);
            assertEquals("AM", periodValue, "setPeriod test: period should return the default period value of AM when an invalid Period is passed into the constructor.");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }

    }

    @Test
    void canSetAndGetTimeZoneTo_MountainTime_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setTimeZone = Clock.class.getMethod("setTimeZone", String.class);
            Method getTimeZone = Clock.class.getMethod("getTimeZone");

            setTimeZone.invoke(clock, "Mountain");
            String timeZone = (String) getTimeZone.invoke(clock);
            assertEquals("Mountain", timeZone, "setTimeZone test: timeZone valid set to Mountain");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }

    }

    @Test
    void canSetAndGetTimeZoneTo_CentralTime_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setTimeZone = Clock.class.getMethod("setTimeZone", String.class);
            Method getTimeZone = Clock.class.getMethod("getTimeZone");

            setTimeZone.invoke(clock, "Central");
            String timeZone = (String) getTimeZone.invoke(clock);
            assertEquals("Central", timeZone, "setTimeZone test: timeZone valid set to Central");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }

    }

    @Test
    void canSetAndGetTimeZoneTo_PacificTime_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setTimeZone = Clock.class.getMethod("setTimeZone", String.class);
            Method getTimeZone = Clock.class.getMethod("getTimeZone");

            setTimeZone.invoke(clock, "Pacific");
            String timeZone = (String) getTimeZone.invoke(clock);
            assertEquals("Pacific", timeZone, "setTimeZone test: timeZone valid set to Pacific");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }

    }

    @Test
    void canSetAndGetTimeZoneTo_EasternTime_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setTimeZone = Clock.class.getMethod("setTimeZone", String.class);
            Method getTimeZone = Clock.class.getMethod("getTimeZone");

            setTimeZone.invoke(clock, "Eastern");
            String timeZone = (String) getTimeZone.invoke(clock);
            assertEquals("Eastern", timeZone, "setTimeZone test: timeZone valid set to Eastern");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }
    }

    @Test
    void canSetAndGetTimeZoneTo_GreenwichTime_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method setTimeZone = Clock.class.getMethod("setTimeZone", String.class);
            Method getTimeZone = Clock.class.getMethod("getTimeZone");

            setTimeZone.invoke(clock, "Greenwich");
            String timeZone = (String) getTimeZone.invoke(clock);
            assertEquals("Eastern", timeZone, "setTimeZone test: When an invalid timeZone is passed into our constructor we should return the default timeZone of Eastern");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }
    }

    @Test
    void clockClass_UsingInvalidInputs_ReturnsDefault_Test()  {

        int invalidHour = 50;
        int invalidMinute = 100;
        String invalidPeriod = "XYZ";
        String invalidTimeZone = "NOTATIMEZONE";

        try {
            Class clockClass = Clock.class;
            Object newInstance = clockClass.newInstance();
            Class<?>[] type = { int.class, int.class, String.class, String.class};
            Constructor<?> cons = clockClass.getConstructor(type);
            Object[] obj = { invalidHour, invalidMinute, invalidPeriod, invalidTimeZone};
            Object newInstancePCObj = cons.newInstance(obj);
            Clock newClock = (Clock) cons.newInstance(obj);

            Method getHour = Clock.class.getMethod("getHour");
            int hour = (int) getHour.invoke(newClock);

            Method getMinute = Clock.class.getMethod("getMinute");
            int minute = (int) getMinute.invoke(newClock);

            Method getPeriod = Clock.class.getMethod("getPeriod");
            String period = (String) getPeriod.invoke(newClock);

            Method getTimeZone = Clock.class.getMethod("getTimeZone");
            String timeZone = (String) getTimeZone.invoke(newClock);

            assertEquals(hour, 12, "When an invalid hour is passed into our constructor we should default it to 12, instead we set it to: " + invalidHour);
            assertEquals(minute, 00, "When an invalid minute is passed into our constructor we should default it to 00, instead we set it to: " + invalidMinute);
            assertEquals(period, "AM", "When an invalid period is passed into our constructor we should default it to AM, instead we set it to: " + invalidPeriod);
            assertEquals(timeZone, "Eastern", "When an invalid time zone is passed into our constructor we should default it to Eastern, instead we set it to: " + invalidTimeZone);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class should have a constructor that takes four variables, an int hour, an int minute, a String period, and a String timeZone.");
        }
    }

    @Test
    void clockClass_UsingValidInputs_ReturnsConstructorValues_Test()  {

        int validHour = 1;
        int validMinute = 02;
        String validPeriod = "PM";
        String validTimeZone = "Pacific";

        try {
            Class clockClass = Clock.class;
            Object newInstance = clockClass.newInstance();
            Class<?>[] type = { int.class, int.class, String.class, String.class};
            Constructor<?> cons = clockClass.getConstructor(type);
            Object[] obj = { validHour, validMinute, validPeriod, validTimeZone};
            Object newInstancePCObj = cons.newInstance(obj);
            Clock newClock = (Clock) cons.newInstance(obj);

            Method getHour = Clock.class.getMethod("getHour");
            int hour = (int) getHour.invoke(newClock);

            Method getMinute = Clock.class.getMethod("getMinute");
            int minute = (int) getMinute.invoke(newClock);

            Method getPeriod = Clock.class.getMethod("getPeriod");
            String period = (String) getPeriod.invoke(newClock);

            Method getTimeZone = Clock.class.getMethod("getTimeZone");
            String timeZone = (String) getTimeZone.invoke(newClock);

            assertEquals(hour, validHour, "When an valid hour is passed into our constructor we should use the value provided through the constructor, instead we set it to: " + hour);
            assertEquals(minute, validMinute, "When an valid minute is passed into our constructor we should default it to 00, instead we set it to: " + minute);
            assertEquals(period, validPeriod, "When an valid period is passed into our constructor we should default it to AM, instead we set it to: " + period);
            assertEquals(timeZone, validTimeZone, "When an valid time zone is passed into our constructor we should default it to Eastern, instead we set it to: " + timeZone);

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock class should have a constructor that takes four variables, an int hour, an int minute, a String period, and a String timeZone.");
        }
    }

    @Test
    void canCreateDefaultClock_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor();
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_ONE);

            Method getHour = Clock.class.getMethod("getHour");
            int hourValue  = (int) getHour.invoke(clock);
            assertEquals(12, hourValue, "Constructor default test: Hour=12");

            Method getMinute = Clock.class.getMethod("getMinute");
            int minuteValue  = (int) getMinute.invoke(clock);
            assertEquals(0, minuteValue, "Constructor default test: minute=0");

            Method getPeriod = Clock.class.getMethod("getPeriod");
            String periodValue  = (String) getPeriod.invoke(clock);
            assertEquals("AM", periodValue, "Constructor default test: period = AM");

            Method getTimeZone = Clock.class.getMethod("getTimeZone");
            String timeZoneValue  = (String) getTimeZone.invoke(clock);
            assertEquals("Eastern", timeZoneValue, "Constructor default test: time zone = Eastern");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }
    }

    @Test
    void canCreateClock_Test() {

        try {
            Constructor clockConstructor = Clock.class.getConstructor(PARAM_TYPES);
            Clock clock = (Clock) clockConstructor.newInstance(CLOCK_TWO);

            //Clock 2
            Method getHour = Clock.class.getMethod("getHour");
            int hourValue  = (int) getHour.invoke(clock);
            assertEquals(3, hourValue, "Constructor value test: Hour=3");
            Method getMinute = Clock.class.getMethod("getMinute");
            int minuteValue  = (int) getMinute.invoke(clock);
            assertEquals(15, minuteValue, "Constructor value test: minute=15");
            Method getPeriod = Clock.class.getMethod("getPeriod");
            String periodValue  = (String) getPeriod.invoke(clock);
            assertEquals("PM", periodValue, "Constructor default test: period = PM");
            Method getTimeZone = Clock.class.getMethod("getTimeZone");
            String timeZoneValue  = (String) getTimeZone.invoke(clock);
            assertEquals("Central", timeZoneValue, "Constructor default test: time zone = Central");


            Clock otherClock = (Clock) clockConstructor.newInstance(CLOCK_THREE);

            //Clock 3
            hourValue  = (int) getHour.invoke(otherClock);
            assertEquals(12, hourValue, "Constructor value test: Hour = 12");
            minuteValue  = (int) getMinute.invoke(otherClock);
            assertEquals(0, minuteValue, "Constructor value test: minute = 0");
            periodValue  = (String) getPeriod.invoke(otherClock);
            assertEquals("AM", periodValue, "Constructor default test: period = AM");
            timeZoneValue  = (String) getTimeZone.invoke(otherClock);
            assertEquals("Eastern", timeZoneValue, "Constructor invalid test: time zone = Eastern");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("Clock and all setter/getter methods must be defined");
        }

    }

    private String getFieldValueInClassUsingReflection(String variableName) {
        try {
            Class<Clock> myClass = Clock.class;

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            Clock clockInstance = new Clock();

            field.setAccessible(true);

            if (field.get(clockInstance) == null){
                return "";
            }
            return field.get(clockInstance).toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
