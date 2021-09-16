package com.example.firstappwithjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewMembers extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addBtn;

    MyDatabaseHelper myDB;
    ArrayList<String> teamid, name, title, email, phone;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_members);

        recyclerView = findViewById(R.id.recyclerView);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewMembers.this, AddActivity.class);
                startActivity(intent);

            }
        });

        myDB = new MyDatabaseHelper(ViewMembers.this);
        teamid = new ArrayList<>();
        name = new ArrayList<>();
        title = new ArrayList<>();
        email = new ArrayList<>();
        phone = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(ViewMembers.this, teamid,name,title,email,phone);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewMembers.this));

    }


    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();

        } else {
            while (cursor.moveToNext()) {
                teamid.add(cursor.getString(0));
                name.add(cursor.getString(1));
                title.add(cursor.getString(2));
                email.add(cursor.getString(3));
                phone.add(cursor.getString(4));

            }
        }
    }
}