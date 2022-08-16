package edu.qc.seclass.glm;

public class ItemType {

    private int itemTypeID;
    private String itemType;

    public ItemType(String itemType){
        this.itemType = itemType;
    }

    public ItemType(){

    }

    public void setItemTypeID(int itemTypeID){
        this.itemTypeID = itemTypeID;
    }

    public int getItemTypeID(){
        return itemTypeID;
    }

    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public String getItemType(){
        return this.itemType;
    }

    public String toString(){
        return "Item Type: " + this.itemType;
    }
}
