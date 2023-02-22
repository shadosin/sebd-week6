package com.kenzie.practicingconstructors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    static final Object[] TO_DO_LIST = {"personal errands", 9};
    public static Class<?>[] paramTypes = {String.class, int.class};
    public static Class<?>[] paramTypesToDoItem = {String.class, String.class};

    String CLASS_NAME = "ToDoList";

    @Test void classHasField_listName_Test() {
        String fieldNameToFind = "listName";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_maxItems_Test() {
        String fieldNameToFind = "maxItems";
        String fieldType = "int";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test void classHasField_itemList_Test() {
        String fieldNameToFind = "itemList";
        String fieldType = "ArrayList<ToDoItem>";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, null, null);
        }
        catch (Exception e) {
            assertTrue(false, "Double check and make sure you have a field of type " + fieldType + " variable with the name " + fieldNameToFind + " in the " + CLASS_NAME + " class.");
        }
    }

    @Test
    void todoList_parameterlessConstructor_Exists() {
        try {
            Class<ToDoList> toDoListClass = ToDoList.class;
            Constructor<ToDoList> cons = toDoListClass.getConstructor();
            ToDoList instance = cons.newInstance();

            String actualItemList = getFieldValueInClassUsingReflection("itemList", null, null);
            String actualListName = getFieldValueInClassUsingReflection("listName", null, null);
            int actualMaxItems = Integer.parseInt(getFieldValueInClassUsingReflection("maxItems", null, null));

            assertEquals(actualListName, "", "The listName field should be an empty string when we create an object from this class with a parameterless constructor");
            assertEquals(actualMaxItems, 10, "The maxItems field should be an int set to 10 when we create an object from the ToDoList class with a parameterless constructor");
            assertNotNull(actualItemList, "The itemList field should be set to a new ArrayList of type ToDoItem by default when we create an object from the ToDoList class with a parameterless constructor");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The ToDoList  class should have a parameterless constructor");
        }
    }

    @Test
    void todoList_2ParameterConstructor_Exists() {
        try {
            String expectedListName = "My List Name";
            int expectedMaxItems = 20;

            Object [] params = {expectedListName, expectedMaxItems};

            Class<ToDoList> toDoListClass = ToDoList.class;
            Constructor<ToDoList> cons = toDoListClass.getConstructor(paramTypes);
            ToDoList instance = cons.newInstance(params);

            String actualItemList = getFieldValueInClassUsingReflection("itemList", params, paramTypes);
            String actualListName = getFieldValueInClassUsingReflection("listName", params, paramTypes);
            int actualMaxItems = Integer.parseInt(getFieldValueInClassUsingReflection("maxItems", params, paramTypes));

            assertEquals(expectedListName, actualListName, "The listName field should be set to the String provided through the class constructor. Expected " + expectedListName + " but received " + actualListName);
            assertEquals(actualMaxItems, expectedMaxItems, "The maxItems field should be an int set to the value passed through the ToDoList constructor when we create an object from the ToDoList class with a 2 parameters constructor. Expected " + expectedMaxItems + " but was " + actualListName);
            assertNotNull(actualItemList, "The itemList field should be set to a new ArrayList of type ToDoItem by default when we create an object from the ToDoList class with a parameterless constructor");

        } catch (Exception e) {
            System.out.println(e.toString());
            fail("The ToDoList class should have a 2 parameter constructor");
        }
    }

    @Test
    void canGetAndSetField_listName_Test() {
        try {
            Constructor toDoListConstructor = ToDoList.class.getConstructor();
            ToDoList toDoList = (ToDoList) toDoListConstructor.newInstance();
            Method getListName = ToDoList.class.getMethod("getListName");
            Method setListName = ToDoList.class.getMethod("setListName", String.class);
            setListName.invoke(toDoList, "weekend checklist");
            String listName = (String) getListName.invoke(toDoList);
            assertEquals("weekend checklist", listName, "setListName test: listName=weekend checklist");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoList and all setter/getter methods must be defined for the field listName");
        }
    }


    @Test
    void canGetAndSetField_maxItems_Test() {
        try {
            Constructor toDoListConstructor = ToDoList.class.getConstructor();
            ToDoList toDoList = (ToDoList) toDoListConstructor.newInstance();
            Method getMaxItems = ToDoList.class.getMethod("getMaxItems");
            Method setMaxItems = ToDoList.class.getMethod("setMaxItems", int.class);
            setMaxItems.invoke(toDoList, 100);
            int value = (int) getMaxItems.invoke(toDoList);
            assertEquals(100, value, "setMaxItems test: maxItems=100" );
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoList and all setter/getter methods must be defined for field maxItems");
        }
    }


    @Test
    void canGetAndSetField_itemList_Test() {
        try {
            Object[] one = {"buy cake", "high"};
            Object[] two = {"do decorations", "low"};
            Object[] three = {"send invitations", "medium"};
            Constructor toDoItemConstructor = ToDoItem.class.getConstructor(paramTypesToDoItem);
            ToDoItem item1 = (ToDoItem) toDoItemConstructor.newInstance(one);
            ToDoItem item2 = (ToDoItem) toDoItemConstructor.newInstance(two);
            ToDoItem item3 = (ToDoItem) toDoItemConstructor.newInstance(three);

            ArrayList<ToDoItem> partyList = new ArrayList<>();
            partyList.add(item1);
            partyList.add(item2);
            partyList.add(item3);

            Constructor toDoListConstructor = ToDoList.class.getConstructor();
            ToDoList toDoList = (ToDoList) toDoListConstructor.newInstance();
            Method setItemList = ToDoList.class.getMethod("setItemList", ArrayList.class);
            Method getItemList = ToDoList.class.getMethod("getItemList");
            setItemList.invoke(toDoList, partyList);
            ArrayList actualList = (ArrayList) getItemList.invoke(toDoList);
            assertEquals(partyList, actualList, "setItemList test: size=3");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoList and all setter/getter methods must be defined for field itemList");
        }
    }
    @Test
    void canCreateDefault_ToDoItem_Test() {
        try {
            Constructor toDoListConstructor = ToDoList.class.getConstructor();
            ToDoList toDoList = (ToDoList) toDoListConstructor.newInstance();
            Method getListName = ToDoList.class.getMethod("getListName");
            Method getMaxItems = ToDoList.class.getMethod("getMaxItems");
            Method getItemList = ToDoList.class.getMethod("getItemList");

            String listName = (String) getListName.invoke(toDoList);
            int maxItems = (int) getMaxItems.invoke(toDoList);
            ArrayList itemList = (ArrayList) getItemList.invoke(toDoList);

            assertEquals("", listName, "Constructor default test: listName=\"\"" );
            assertEquals(10, maxItems, "Constructor default test: maxItems=10");
            assertNotNull(itemList, "Constructor default test: ItemList not null");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoList and all setter/getter methods must be defined");
        }

    }

    @Test
    void canCreate_ToDoItem_Test() {
        try {
            Constructor toDoListConstructor = ToDoList.class.getConstructor(paramTypes);
            ToDoList toDoList = (ToDoList) toDoListConstructor.newInstance(TO_DO_LIST);
            Method getListName = ToDoList.class.getMethod("getListName");
            Method getMaxItems = ToDoList.class.getMethod("getMaxItems");
            Method getItemList = ToDoList.class.getMethod("getItemList");

            String listName = (String) getListName.invoke(toDoList);
            int maxItems = (int) getMaxItems.invoke(toDoList);
            ArrayList itemList = (ArrayList) getItemList.invoke(toDoList);

            assertEquals("personal errands", listName, "Constructor default test: listName=\"\"" );
            assertEquals(9, maxItems, "Constructor default test: maxItems=9");
            assertNotNull(itemList, "Constructor default test: ItemList not null");
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("ToDoList and all setter/getter methods must be defined");
        }
    }



    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?> [] paramTypes) {
        try {
            Class<ToDoList> myClass = ToDoList.class;
            Constructor toDoListConstructor = myClass.getConstructor(paramTypes);
            ToDoList toDoList = (ToDoList) toDoListConstructor.newInstance(params);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            field.setAccessible(true);
            if (field.get(toDoList) == null){
                return "";
            }
            return field.get(toDoList).toString();

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