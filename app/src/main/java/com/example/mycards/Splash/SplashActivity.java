package com.example.mycards.Splash;

import android.Manifest;
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
import androidx.core.content.ContextCompat;

import com.example.mycards.Activites.CardActivity;
import com.example.mycards.Activites.LoginActivity;
import com.example.mycards.R;
import com.example.mycards.Utils.Util;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private int ContadorDePermisos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        ContadorDePermisos=0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_FINE_LOCATION }, 0);
                ContadorDePermisos=ContadorDePermisos+1;
                CheckSessionSaved();
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE }, 0);
                ContadorDePermisos=ContadorDePermisos+1;
                CheckSessionSaved();
            }
        }

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
    public void CheckSessionSaved(){
        if(ContadorDePermisos==2){
            //Valida si existe sesión guardada o muestra el login
            Toast.makeText(this,"Validando shared preferences",Toast.LENGTH_LONG).show();
            Intent intentLogin = new Intent(this, LoginActivity.class);
            Intent intentCards = new Intent(this, CardActivity.class);
            if(!TextUtils.isEmpty(Util.getUNamePrefs(prefs)) &&
                    !TextUtils.isEmpty(Util.getUKeyPrefs(prefs))){
                startActivity(intentCards);
            }else{
                startActivity(intentLogin);
            }
            finish();
        }else{
            //Mostrar mensaje de error y pedir que nos conceda permisos el usuario
            //Toast.makeText(this,"es marshmallow",Toast.LENGTH_LONG).show();
        }
    }
}
