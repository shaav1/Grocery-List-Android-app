package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.Item;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "ItemsList.db";
    private static DbHandler mInstance = null;

    public DbHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DbHandler getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DbHandler(ctx.getApplicationContext());
        }
        return mInstance;
    }

    private static final String TABLE_ITEM_TYPE = "itemType";
    private static final String COLUMN_ITEM_TYPE_NAME = "itemTypeName";
    private static final String COLUMN_ITEM_TYPE_ID = "itemID";
    private static final String CREATE_TABLE_ITEM_TYPE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_ITEM_TYPE + "("
            + COLUMN_ITEM_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ITEM_TYPE_NAME + " TEXT" + ")" ;

    private static final String  TABLE_USER_LIST = "UserList";
    private static final String  COLUMN_USER_LIST_NAME = "UserListName";
    private static final String  COLUMN_USER_LIST_ID = "UserListID";

    private static final String CREATE_TABLE_USER_LIST = "CREATE TABLE IF NOT EXISTS "
            + TABLE_USER_LIST + "("
            + COLUMN_USER_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USER_LIST_NAME + " TEXT"
            + ")" ;

    private static final String TABLE_ITEM = "Item";
    private static final String COLUMN_ITEM_ID = "itemID";
    private static final String COLUMN_ITEM_NAME = "itemName";

    private static final String CREATE_TABLE_ITEM = "CREATE TABLE IF NOT EXISTS "
            + TABLE_ITEM + "("
            + COLUMN_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ITEM_NAME + " TEXT, "
            + COLUMN_ITEM_TYPE_NAME + " TEXT"
            + ")" ;

    private static final String TABLE_USER_LIST_ITEMS = "userListItems";
    private static final String COLUMN_USER_LIST_ITEMS_ID = "userListItemsID";
    private static  final String COLUMN_USER_LIST_ITEMS_IS_CHECKED = "isChecked";
    private static final String COLUMN_USER_LIST_ITEMS_QUANTITY = "itemQuantity";
    private static final String COLUMN_ITEM_FK = "itemFK";

    private static final String CREATE_TABLE_USER_LIST_ITEMS = " CREATE TABLE IF NOT EXISTS "
            + TABLE_USER_LIST_ITEMS + "(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_LIST_ITEMS_ID + " INTEGER, "
            + COLUMN_USER_LIST_ITEMS_IS_CHECKED + " INTEGER DEFAULT 0, "
            + COLUMN_USER_LIST_ITEMS_QUANTITY + " INTEGER, "
            + COLUMN_USER_LIST_ID + " INTEGER, "
            + COLUMN_ITEM_ID + " INTEGER "
            + ")" ;


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println();
        try{
            db.execSQL(CREATE_TABLE_USER_LIST);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            db.execSQL(CREATE_TABLE_ITEM);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            db.execSQL(CREATE_TABLE_ITEM_TYPE);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            db.execSQL(CREATE_TABLE_USER_LIST_ITEMS);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        insertItem(db, "Apple", "Produce");
        insertItem(db, "Strawberry","Produce");
        insertItem(db, "Blueberry","Produce");
        insertItem(db, "Broccoli","Produce");
        insertItem(db, "Cauliflower","Produce");
        insertItem(db, "Yogurt","Dairy");
        insertItem(db, "Butter","Dairy");
        insertItem(db, "Egg","Dairy");
        insertItem(db, "Fish","Seafood");
        insertItem(db, "Shrimp","Seafood");
        insertItem(db, "Lobster","Seafood");
        insertItem(db, "Crab","Seafood");
        insertItem(db, "Clams","Seafood");
        insertItem(db, "Chicken","Meat");
        insertItem(db, "Beef","Meat");
        insertItem(db, "Pork","Meat");
        insertItem(db, "Banana","Produce");
        insertItem(db, "Coffee","Beverage");
        insertItem(db, "Tea","Beverage");
        insertItem(db, "Soda","Beverage");
        insertItem(db, "Flour","Baking Goods");
        insertItem(db, "Cookie Mix","Baking Goods");
        insertItem(db, "Pancake Mix","Baking Goods");
        insertItem(db, "Waffles","Frozen Foods");
        insertItem(db, "Ice Cream","Frozen Foods");
        insertItem(db, "Pizza","Frozen Foods");
        insertItem(db, "Beans","Canned Goods");
        insertItem(db, "Tomato Sauce","Canned Goods");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS ' " +  TABLE_USER_LIST + " ' ");
        db.execSQL(" DROP TABLE IF EXISTS ' " +  TABLE_ITEM + " ' ");
        db.execSQL(" DROP TABLE IF EXISTS ' " +  TABLE_ITEM_TYPE + " ' ");
        db.execSQL(" DROP TABLE IF EXISTS ' " +  TABLE_USER_LIST_ITEMS + " ' ");
    }

    public int deleteGroceryListId(int listID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USER_LIST, COLUMN_USER_LIST_ID + "= ? ",
                new String[] { String.valueOf(listID)});
    }

    public int deleteGroceryLists(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USER_LIST, null, null);
    }

    public int updateGroceryListName(int listID, String  newListName ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_LIST_NAME, newListName);
        return db.update(TABLE_USER_LIST, values, COLUMN_USER_LIST_ID + " = ? ",
                new String[] {String.valueOf(listID)});
    }

    public long insertGroceryList(String listName){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues insertValues = new ContentValues();
        insertValues.put(COLUMN_USER_LIST_NAME, listName);
        return db.insert(TABLE_USER_LIST , null, insertValues);
    }

    public long insertItem(SQLiteDatabase db, String itemName, String itemType){
        ContentValues insertValues = new ContentValues();
        insertValues.put(COLUMN_ITEM_NAME, itemName);
        insertValues.put(COLUMN_ITEM_TYPE_NAME, itemType);

        return  db.insert(TABLE_ITEM , null, insertValues);
    }

    public long insertToDb(String itemName, String itemType){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insertValues = new ContentValues();
        insertValues.put(COLUMN_ITEM_NAME, itemName);
        insertValues.put(COLUMN_ITEM_TYPE_NAME, itemType);

        return  db.insert(TABLE_ITEM , null, insertValues);
    }

    public boolean deleteCheckedItems(int userListid){
        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = COLUMN_USER_LIST_ID + "=" + userListid
                + " AND "
                + COLUMN_USER_LIST_ITEMS_IS_CHECKED + "=" + "1";
        return db.delete(TABLE_USER_LIST_ITEMS, whereClause , null) > 0;
    }

    public ArrayList<Item> getAllItems(String searchString) {
        ArrayList<Item> items = new ArrayList<>();
        String rawSQL = "SELECT * " + " FROM " + TABLE_ITEM;

        if(searchString != null){
            rawSQL += " WHERE " + COLUMN_ITEM_NAME + " LIKE " +"'" + searchString + "%" +"'";
        }

        rawSQL += " ORDER BY " + COLUMN_ITEM_TYPE_NAME + " ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(rawSQL, null);

        if (cursor.moveToFirst()) {
            do {
                items.add(new Item(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ITEM_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_NAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_ITEM_TYPE_NAME))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return items;
    }


    public List<GroceryList> getAllGroceryLists(){
        List<GroceryList> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String sqlQuery = "SELECT * FROM " + TABLE_USER_LIST;
            Cursor cursor = db.rawQuery(sqlQuery, null);


            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);

                    GroceryList newGL = new GroceryList(id, name);
                    returnList.add(newGL);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            return returnList;
        }
        catch (Exception e){
            createNewList("First List");
            String sqlQuery = "SELECT * FROM " + TABLE_USER_LIST;
            Cursor cursor = db.rawQuery(sqlQuery, null);


            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);

                    GroceryList newGL = new GroceryList(id, name);
                    returnList.add(newGL);
                } while (cursor.moveToNext());
                db.close();
            }
        }
        return returnList;
    }

    public void incrementItemQuantityInUserList(int itemId , int userListId, int quantity ){
        SQLiteDatabase db = this.getReadableDatabase();
        quantity = quantity +1;
        String rawSQL = " Update "
                + TABLE_USER_LIST_ITEMS
                +" SET "
                + COLUMN_USER_LIST_ITEMS_QUANTITY + "="+quantity
                + " where "
                + COLUMN_USER_LIST_ITEMS_ID + "=" + itemId
                + " AND "
                + COLUMN_USER_LIST_ID + "=" + userListId;
        System.out.println(rawSQL);
        Cursor c = db.rawQuery(rawSQL, null);

        if(c.moveToFirst()){
            do{
                System.out.println("incremented");
            }while(c.moveToNext());
        }

    }

    public void toggleCheckBoxinUserList(int userListItemId, int checkValue){
        // UPDATE some_table SET an_int_value = IF(an_int_value=1, 0, 1)
        String rawSQL =" UPDATE " +
                TABLE_USER_LIST_ITEMS +
                " SET " +
                COLUMN_USER_LIST_ITEMS_IS_CHECKED +
                " = " +
                checkValue+
                " WHERE "
                + COLUMN_USER_LIST_ITEMS_ID + "=" + userListItemId;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(rawSQL, null);

        if(c.moveToFirst()){
            do{
                System.out.println("Toggled");
            }while(c.moveToNext());
        }
        c.close();
    }


    public int getQuantityByItem(int itemId ,int userListId) {
        int quantity = 0;
        String itemNameColumnName = "itemName";

        String rawSQL = "SELECT  "
                + COLUMN_USER_LIST_ITEMS_QUANTITY
                + " FROM " + TABLE_USER_LIST_ITEMS
                + " JOIN  " + TABLE_ITEM + " "
                + " ON "
                + TABLE_ITEM + "."+COLUMN_ITEM_ID + "="+ TABLE_USER_LIST_ITEMS + "." + COLUMN_USER_LIST_ITEMS_ID
                + " WHERE " + COLUMN_USER_LIST_ID + "=" + userListId
                + " AND "
                + COLUMN_USER_LIST_ITEMS_ID + "=" + itemId;

        System.out.println(rawSQL);


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(rawSQL, null);

        if (c.moveToFirst()) {
            do {
                quantity = c.getInt(c.getColumnIndex(COLUMN_USER_LIST_ITEMS_QUANTITY));
            } while (c.moveToNext());
        }

        c.close();

        db.close();

        return quantity;
    }

    public boolean createNewList(String gl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_LIST_NAME, gl);
        long insert = db.insert(TABLE_USER_LIST, null, cv);
        db.close();
        if(insert == -1) return false;
        return true;
    }

    public long insertUserListItem(String userListItemName,int quantity , int itemId , int userListId){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_LIST_ID, userListId);
        contentValues.put(COLUMN_USER_LIST_ITEMS_ID, itemId);
        contentValues.put(COLUMN_USER_LIST_ITEMS_QUANTITY, quantity);
        System.out.println("user List id");
        System.out.println(userListId);

        return db.insert(TABLE_USER_LIST_ITEMS , null, contentValues);
    }

}

