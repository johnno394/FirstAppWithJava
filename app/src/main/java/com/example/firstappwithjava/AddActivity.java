package com.example.firstappwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText nameInput, titleInput, phoneInput, emailInput;
    Button createBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameInput = findViewById(R.id.nameInput);
        titleInput = findViewById(R.id.titleInput);
        phoneInput = findViewById(R.id.phoneInput);
        emailInput = findViewById(R.id.emailInput);
        createBtn = findViewById(R.id.createBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addMember(nameInput.getText().toString()
                        , titleInput.getText().toString()
                        , emailInput.getText().toString()
                        , Integer.valueOf(phoneInput.getText().toString()));

                Intent intent = new Intent(AddActivity.this, ViewMembers.class);
                startActivity(intent);
            }

        });
    }
}