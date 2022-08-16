package edu.qc.seclass.glm;

public class Item {
    private int id;
    private String itemName;
    private String itemType;

    public Item(int id,String itemName, String itemType){
        this.id = id;
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public Item(){
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemType(){
        return itemType;
    }

    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
