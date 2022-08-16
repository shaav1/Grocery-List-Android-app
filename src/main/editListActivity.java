package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editListActivity extends AppCompatActivity {

    Button confirmEdit;
    EditText listNameToBeEdited;
    String newName;
    int id;
    DbHandler DBH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);


        confirmEdit= findViewById(R.id.confirmEdit);
        listNameToBeEdited = findViewById(R.id.listNameToBeEdited);
       // Intent intent = getIntent();
       // newName= intent.getStringExtra(gListAdapter.COLUMN_USER_LIST_NAME);
        //id= intent.getIntExtra(gListAdapter.COLUMN_USER_LIST_ID,1);

        confirmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newName = listNameToBeEdited.getText().toString();

                DBH = new DbHandler(editListActivity.this);
               // DBH.updateGroceryListName(id,newName);
                DBH.close();
                Intent intent = new Intent(editListActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}