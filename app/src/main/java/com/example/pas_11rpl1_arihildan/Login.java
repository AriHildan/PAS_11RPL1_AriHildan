package com.example.pas_11rpl1_arihildan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getSharedPreferences("login", MODE_PRIVATE);
        txtusername = (EditText)findViewById(R.id.user);
        txtpassword = (EditText)findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtusername.getText().toString().equalsIgnoreCase("admin")
                        && txtpassword.getText().toString().equalsIgnoreCase("admin")){
                    //saving ke SP
                    editor = pref.edit();
                    editor.putString("username", txtusername.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    //menuju ke main menu
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
}