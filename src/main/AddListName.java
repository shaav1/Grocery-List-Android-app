package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddListName extends AppCompatActivity {

    Button button;
    String newGList;
    EditText listName;
    DbHandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list_name);

        button = (Button)findViewById(R.id.addButton);
        listName = (EditText)findViewById(R.id.NewListName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGList = listName.getText().toString();

                dbh = new DbHandler(AddListName.this);
                dbh.createNewList(newGList);
                dbh.close();
                Intent intent = new Intent(AddListName.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}