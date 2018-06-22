package com.example.tsuka.sqliteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks;
    ImageButton btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editTextName);
        editSurname = findViewById(R.id.editTextSurname);
        editMarks = findViewById(R.id.editTextMarks);
        btnAddData = findViewById(R.id.imageButtonAdd);

        addData();
    }

    public void addData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString() );

                        if (isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
