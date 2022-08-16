package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button createList;
    Button rename;
    DbHandler dbh;
    ArrayAdapter glAdapter;
    ListView viewLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh = new DbHandler(MainActivity.this);
        listView = (ListView) findViewById((R.id.listOfItems));
        createList = (Button) findViewById(R.id.createListButton);
        rename = findViewById(R.id.renameButton);
        glAdapter = new gListAdapter(MainActivity.this, dbh.getAllGroceryLists());
        listView = findViewById(R.id.grocerylist);
        listView.setAdapter(glAdapter);
        dbh.close();

        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddList();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroceryList selectedGL = (GroceryList)parent.getItemAtPosition(position);
                //openNewListManager(selectedGL.getName(), selectedGL.getId());
            }
        });

        rename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editListActivity();
            }
        });

    }


    public void openAddList(){
        Intent intent = new Intent(this, AddListName.class);
        startActivity(intent);
    }

    public void editListActivity(){
        Intent intent = new Intent(this, editListActivity.class);
        startActivity(intent);
    }

}