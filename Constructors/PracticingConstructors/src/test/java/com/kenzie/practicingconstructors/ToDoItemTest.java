package com.kenzie.practicingconstructors;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ToDoItemTest {

    public static final Object[] ITEM = {"walk the cat", "high"};
    public static final Class<?>[] PARAM_TYPES = {String.class, String.class};
    public static final String CLASS_NAME = "ToDoItem";

    @Test void classHasField_description_Test() {
        String fieldNameToFind = "description";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_priority_Test() {
        String fieldNameToFind = "priority";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_isDone_Test() {
        String fieldNameToFind = "isDone";
        String fieldType = "boolean";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test
    void todoItem_parameterlessConstructor_Exists_Test() {
        try {
            Class<ToDoItem> toDoItemClass = ToDoItem.class;
            Constructor<ToDoItem> cons = toDoItemClass.getConstructor();
            ToDoItem instance = cons.newInstance();

            String actualDescription = getFieldValueInClassUsingReflection("description", null, null);
            String actualPriority = getFieldValueInClassUsingReflection("priority", null, null);
            boolean actualIsDone = Boolean.parseBoolean(getFieldValueInClassUsingReflection("isDone", null, null));

            assertEquals(actualDescription, "", "The description field should be an empty string when we create an object from the ToDoItem class with a parameterless constructor");
            assertEquals(actualPriority, "", "The priority field should be an empty string when we create an object from the ToDoItem class with a parameterless constructor");
            assertEquals(actualIsDone, false, "The isDone field should be set to false by default when we create an object from the ToDoItem class with a parameterless constructor");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The TodoItem  class should have a parameterless constructor");
        }
    }

    @Test
    void todoItem_2ParameterConstructor_Exists_Test() {
        try {
            String expectedDescription = "My Description";
            String expectedPriority = "My Priority";

            Object [] params = {expectedDescription, expectedPriority};

            Class<ToDoItem> toDoItemClass = ToDoItem.class;
            Constructor toDoItemConstructor = toDoItemClass.getConstructor(PARAM_TYPES);
            ToDoItem newToDoItem = (ToDoItem) toDoItemConstructor.newInstance(params);

            String actualDescription = getFieldValueInClassUsingReflection("description", params, PARAM_TYPES);
            String actualPriority = getFieldValueInClassUsingReflection("priority", params, PARAM_TYPES);
            boolean actualIsDone = Boolean.parseBoolean(getFieldValueInClassUsingReflection("isDone", params, PARAM_TYPES));

            assertEquals(expectedDescription, actualDescription, "The description field should be set to the String provided through the ToDoItem class constructor. Expected " + expectedDescription + " but received " + actualDescription);
            assertEquals(expectedPriority, actualPriority, "The priority field should be set to the String provided through the ToDoItem constructor. Expected " + expectedPriority + " but received " + actualPriority);;
            assertEquals(actualIsDone, false, "The isDone field should be set to false by default when we create an object from the ToDoItem class with a parameterless constructor");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The TodoItem class should have a 2 parameter constructor");
        }
    }

    @Test
    void canGetAndSetField_isDone_Test() {
        try {
            Constructor toDoItemConstructor = ToDoItem.class.getConstructor(PARAM_TYPES);
            ToDoItem item2 = (ToDoItem) toDoItemConstructor.newInstance(ITEM);
            Method getIsDone = ToDoItem.class.getMethod("getIsDone");
            Method setIsDone = ToDoItem.class.getMethod("setIsDone", boolean.class);

            setIsDone.invoke(item2, true);
            boolean value = (boolean) getIsDone.invoke(item2);
            assertEquals(true, value, "setIsDone: isDone =true" );
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoItem and all setter/getter methods must be defined for getIsDone and setIsDone");
        }
    }

    @Test
    void canGetAndSetField_Priority_Test() {
        try {
            Constructor toDoItemConstructor = ToDoItem.class.getConstructor(PARAM_TYPES);
            ToDoItem item2 = (ToDoItem) toDoItemConstructor.newInstance(ITEM);
            Method getPriority = ToDoItem.class.getMethod("getPriority");
            Method setPriority = ToDoItem.class.getMethod("setPriority", String.class);

            setPriority.invoke(item2, "low");
            String value = (String) getPriority.invoke(item2);
            assertEquals("low", value, "setPriority test: priority=low");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoItem and all setter/getter methods must be defined for getPriority and setPriority");
        }


    }

    @Test
    void canGetAndSetField_Description_Test() {
        try {
            Constructor toDoItemConstructor = ToDoItem.class.getConstructor(PARAM_TYPES);
            ToDoItem item2 = (ToDoItem) toDoItemConstructor.newInstance(ITEM);
            Method getDescription = ToDoItem.class.getMethod("getDescription");
            Method setDescription = ToDoItem.class.getMethod("setDescription", String.class);

            setDescription.invoke(item2, "My Description 1");
            String value = (String) getDescription.invoke(item2);
            assertEquals(value, "My Description 1","setDescription: description =My Description 1");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoItem and all setter/getter methods must be defined for getDescription and setDescription");
        }
    }


    @Test
    void canCreateDefault_ToDoItem_Test() {
        try {
            Constructor toDoItemConstructor = ToDoItem.class.getConstructor();
            ToDoItem item1 = (ToDoItem) toDoItemConstructor.newInstance();

            Method getDescription = ToDoItem.class.getMethod("getDescription");
            Method getPriority = ToDoItem.class.getMethod("getPriority");
            Method getIsDone = ToDoItem.class.getMethod("getIsDone");

            String value = (String) getDescription.invoke(item1);
            assertEquals("", value, "Constructor default test: description=\"\"");

            value = (String) getPriority.invoke(item1);
            assertEquals("", value, "Constructor default test: priority=\"\"");

            boolean priority = (boolean) getIsDone.invoke(item1);
            assertEquals(false, priority, "Constructor default test: isDone =false");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoItem and all setter/getter methods must be defined");
        }
    }

    @Test
    void canCreate_ToDoItem_Test() {
        try {
            Constructor toDoItemConstructor = ToDoItem.class.getConstructor(PARAM_TYPES);
            ToDoItem item2 = (ToDoItem) toDoItemConstructor.newInstance(ITEM);

            Method getDescription = ToDoItem.class.getMethod("getDescription");
            Method getPriority = ToDoItem.class.getMethod("getPriority");
            Method getIsDone = ToDoItem.class.getMethod("getIsDone");

            String value = (String) getDescription.invoke(item2);
            assertEquals("walk the cat", value, "Constructor value test: description=walk the cat" );

            value = (String) getPriority.invoke(item2);
            assertEquals("high", value, "Constructor value test: priority=high");

            boolean priority = (boolean) getIsDone.invoke(item2);
            assertEquals(false, priority, "Constructor value test: isDone =false");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoItem and all setter/getter methods must be defined");
        }
    }


    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?> [] paramTypes) {
        try {
            Class<ToDoItem> myClass = ToDoItem.class;

            Constructor toDoItemConstructor = myClass.getConstructor(paramTypes);
            ToDoItem toDoItem = (ToDoItem) toDoItemConstructor.newInstance(params);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            field.setAccessible(true);

            if (field.get(toDoItem) == null){
                return "";
            }
            return field.get(toDoItem).toString();

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