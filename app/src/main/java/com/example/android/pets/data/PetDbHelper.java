package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";


    private static final String COMMA = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String NOT_NULL = " NOT NULL";
    private static final String AUTO_INCREMENT = " AUTOINCREMENT";
    private static final String DEFAULT_VALUE = " DEFAULT";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + "(" +
            PetContract.PetEntry._ID + INT_TYPE + PRIMARY_KEY + AUTO_INCREMENT + COMMA +
            PetContract.PetEntry.COLUMN_PET_NAME + TEXT_TYPE + NOT_NULL + COMMA +
            PetContract.PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA +
            PetContract.PetEntry.COLUMN_PET_GENDER + INT_TYPE + NOT_NULL + COMMA +
            PetContract.PetEntry.COLUMN_PET_WEIGHT + INT_TYPE + NOT_NULL + DEFAULT_VALUE + " 0" +
            ");";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME;


    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
