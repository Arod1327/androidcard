package com.example.mycards.Activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bugsnag.android.Bugsnag;
import com.example.mycards.R;
import com.example.mycards.Utils.Util;

public class CardActivity extends AppCompatActivity {
    private SharedPreferences prefrs;
    public String nameuser="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        prefrs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        nameuser = Util.getUNamePrefs(prefrs);
        String imeino="007";
        String mailto="aspenkaeltas@gmail.com";
        Bugsnag.start(this);
        Bugsnag.setUser(
                imeino,
                mailto,
                Util.getUNamePrefs(prefrs)
        );
        Bugsnag.notify(new RuntimeException("Test error"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //Call logOut function and exit of application
        if(id == R.id.menu_logout){
            logOut();
            return true;
        }
        //Remove session and exit of application
        if(id == R.id.menu_forget_logout){
            removeSharedPreferences();
            logOut();
            return true;
        }
        if(id == R.id.menu_about){
            //Pending Logic
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**Functions*/
    /**Function to logout of appliation*/
    private void logOut(){
        Intent intentLogout = new Intent(this, LoginActivity.class);
        intentLogout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentLogout);
    }
    /**Fuction to delete preferences storage on cache*/
    private void removeSharedPreferences(){
        prefrs.edit().clear().apply();
    }
}
