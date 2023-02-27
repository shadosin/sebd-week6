package com.kenzie.practicingconstructors;

public class ToDoItem {
    String description;
    String priority;
    boolean isDone;
    public ToDoItem(){
        description = "";
        priority = "";
        isDone = false;
    }
    public ToDoItem(String description, String priority){
        this.description = description;
        this.priority = priority;
        isDone = false;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    public String getPriority(){
        return priority;
    }
    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }
    public boolean getIsDone(){
        return isDone;
    }
}