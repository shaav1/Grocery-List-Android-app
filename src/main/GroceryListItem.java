package edu.qc.seclass.glm;

import java.util.ArrayList;

public class GroceryListItem {
    private int id;
    private String name;
    private int isChecked;
    private String quantity;

    public GroceryListItem(int id, int isChecked, String quantity, String name) {
        this.id = id;
        this.isChecked = isChecked;
        this.quantity = quantity;
        this.name = name;
    }

    public GroceryListItem() {}

    public GroceryListItem(int id) {
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

    public int getIsChecked(){
        return this.isChecked;
    }

    public void setIsChecked(int isChecked){
        this.isChecked = isChecked;
    }

    public String getQuantity(){
        return quantity;
    }

    public void setQuantity(String quantity){
        this.quantity = quantity;
    }

}
