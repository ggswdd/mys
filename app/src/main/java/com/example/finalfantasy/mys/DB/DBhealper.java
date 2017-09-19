package com.example.finalfantasy.mys.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FinalFantasy on 19.09.2017.
 */

public class DBhealper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FAVORITS_CITYS";
    public static final String TABLE_CONTACTS = "citys";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";


    public DBhealper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table citys ("
                + "id integer primary key autoincrement,"
                + "name text"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_CONTACTS);
        onCreate(sqLiteDatabase);
    }
}
