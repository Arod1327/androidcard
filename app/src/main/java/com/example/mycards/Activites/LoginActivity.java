package com.example.mycards.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mycards.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "MyCardsApp";

    private SharedPreferences prefrs;
    public String user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inflate the UI elements
        EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        Button btnLogin = (Button) findViewById(R.id.BtnLogin);

        prefrs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        //Get info and save to SharedPreferences
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();

                Log.e(TAG, "ID Usuario logeado: " +user);
                SharedPreferences.Editor editor = prefrs.edit();

                editor.putString("name",user);
                editor.putString("keypass",password);
                //editor.commit();
                editor.apply();
                Intent intentCards = new Intent(LoginActivity.this, CardActivity.class);
                startActivity(intentCards);
                finish();
            }
        });
    }
}
