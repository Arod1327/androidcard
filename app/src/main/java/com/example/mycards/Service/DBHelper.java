package com.example.mycards.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "dbcards";
    private static final Integer DB_VERSION = 1;

    /**Defined tables*/
    public static final String TBL_USUARIOS = "usuarios";
    public static final String TBL_TARJETAS = "tarjetas";
    public static final String TBL_RETIROS = "retiros";
    public static final String TBL_ABONOS = "abonos";

    public DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        /**Created tables*/
        String create_users_table = "CREATE TABLE "+TBL_USUARIOS+ " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, UserName varchar (20), KeyUser varchar(10));";
        db.execSQL(create_users_table);

        String create_cards_table = "CREATE TABLE "+TBL_TARJETAS+ " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NameCard varchar(19), TypeCard varchar(20));";
        db.execSQL(create_cards_table);

        String create_pays_table = "CREATE TABLE "+TBL_RETIROS+ "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IdUser INTEGER (11), IdCard INTEGER(11), ExpenseQuantity varchar(20), ExpenseCreatetime varchar(20), ExpenseDescription varchar(100));";
        db.execSQL(create_pays_table);

        String create_cash_table = "CREATE TABLE "+TBL_ABONOS+ "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, IdUser INTEGER (11), IdCard INTEGER(11), CashQuantity varchar(20), CashCreatetime varchar(20), CashDescription varchar(100));";
        db.execSQL(create_cash_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
