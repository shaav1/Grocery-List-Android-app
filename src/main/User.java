package edu.qc.seclass.glm;

public class User {
    private String name;
    private String listName;

    public User(String name, String listName) {
        this.name = name;
        this.listName = listName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void addList(String name){

    }

    public String toString(){
        return ("User name: " + name + "List name: " + listName);
    }
}
