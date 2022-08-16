package edu.qc.seclass.glm;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class gListAdapter extends ArrayAdapter {

    private Context context;
    private List<GroceryList> gList;
    public static final String  COLUMN_USER_LIST_NAME = "UserListName";
    public static final String  COLUMN_USER_LIST_ID = "UserListID";

    public gListAdapter(@NonNull Context context, List<GroceryList> allGroceryLists) {
        super(context, 0, allGroceryLists);
        this.context = context;
        this.gList = allGroceryLists;
    }
}
