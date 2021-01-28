package com.example.mycards.Activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycards.Utils.Util;

public class ValidateActivity extends AppCompatActivity {
    private SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentCards = new Intent(this, CardActivity.class);
        if(!TextUtils.isEmpty(Util.getUNamePrefs(prefs)) &&
            !TextUtils.isEmpty(Util.getUKeyPrefs(prefs))){
            startActivity(intentCards);
        }else{
            startActivity(intentLogin);
        }
        finish();
    }
}
