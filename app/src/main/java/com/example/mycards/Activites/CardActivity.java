package com.example.mycards.Activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycards.R;

public class CardActivity extends AppCompatActivity {
    private SharedPreferences prefrs;
    //public String nameuser="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
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
        Intent intentLogout = new Intent();
        intentLogout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentLogout);
    }
    /**Fuction to delete preferences storage on cache*/
    private void removeSharedPreferences(){
        prefrs.edit().clear().apply();
    }
}
