package com.example.mycards.Utils;

import android.content.SharedPreferences;

public class Util {
    /** Recupera el nombre de usuario del usuario */
    public static String getUNamePrefs(SharedPreferences preferences){
        return preferences.getString("name","");
    }
    /** Recupera la contraseña del usuario */
    public static String getUKeyPrefs(SharedPreferences preferences){
        return preferences.getString("keypass","");
    }
}
