package com.example.firstappwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText username;
    private EditText password;
    private TextView prompt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button)findViewById(R.id.loginBtn);
        username = (EditText)findViewById(R.id.loginName);
        password = (EditText)findViewById(R.id.loginPassword);
        prompt = (TextView)findViewById(R.id.loginPrompt);


        prompt.setText("Hi!");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticateUser(username.getText().toString(),password.getText().toString());
                username.setText("");
                password.setText("");
            }
        });

    }

    private void authenticateUser (String name, String password) {
        if (name.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);

        } else {
            prompt.setText("Invalid Credentials. Try Again.");

        }
    }







}