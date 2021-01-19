package com.example.mycards.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mycards.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"La app funciona de manera local, es necesario otorgar permiso de lectura de dispositivo",Toast.LENGTH_LONG).show();
        Toast.makeText(this,"La app funciona de manera local, es necesario otorgar permiso de lectura de dispositivo",Toast.LENGTH_LONG).show();
    }
}