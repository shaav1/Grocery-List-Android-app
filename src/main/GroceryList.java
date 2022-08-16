package edu.qc.seclass.glm;

import java.util.ArrayList;

public class GroceryList {
    private int id;
    private String name;

    public GroceryList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroceryList() {}

    public GroceryList(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return name;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public void setName(String Name) {
        this.name = Name;
    }

}
