package com.kenzie.practicingconstructors;

import java.util.ArrayList;

public class ToDoList {
    String listName;
    int maxItems;
    ArrayList<ToDoItem> itemList = new ArrayList<>();

    public ToDoList(){
        this.listName = "";
        this.maxItems = 10;
        this.itemList = new ArrayList<ToDoItem>();
    }
    public ToDoList(String listName, int maxItems){
        this.listName = listName;
        this.maxItems = maxItems;
        this.itemList = new ArrayList<ToDoItem>();
    }
    public ToDoList(String listName, int maxItems, ArrayList<ToDoItem> itemList){
        this.listName = listName;
        this.maxItems = maxItems;
        this.itemList = new ArrayList<ToDoItem>();
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
    public String getListName(){
        return listName;
    }

    public void setItemList(ArrayList<ToDoItem> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<ToDoItem> getItemList() {
        return itemList;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public int getMaxItems() {
        return maxItems;
    }
}
