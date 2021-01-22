package com.example.mycards.Splash;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.mycards.R;

public class SplashActivity extends AppCompatActivity {
    //private SharedPreferences prefs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //nada
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(this,"es marshmallow",Toast.LENGTH_LONG).show();
        }
        //prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        /*Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MiddleActivity.class);
        if(!TextUtils.isEmpty(Util.getUNamePrefs(prefs)) &&
                !TextUtils.isEmpty(Util.getUKeyPrefs(prefs))){
            startActivity(intentMain);
        }else{
            startActivity(intentLogin);
        }
        finish();*/
    }

    /*public boolean checkPermissionForReadExternalStorage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    public void requestPermissionForReadExternalStorage() throws Exception {
        try {
            ActivityCompat.requestPermissions((Activity) ContextCompat, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_STORAGE_PERMISSION_REQUEST_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }*/
}
