package com.bignerdranch.android.personaltrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Joe on 4/14/2018.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String DATABASE_TABLE = "user_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "AGE";
    private static final String COL4 = "CREDIT_CARD";

    // SQL Statement to create a new database.
    private static final String DATABASE_CREATE = "create table " +
            DATABASE_TABLE + " (" + COL1 +
            " integer primary key autoincrement, " +
            COL2 + " text not null, " +
            COL3 + " integer, " +
            COL4 + " integer);";


    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + DATABASE_TABLE + " (ID " + "NAME, AGE, CREDIT CARD)";

        db.execSQL(DATABASE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public boolean addData(String name2, String age2, String creditCard2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name2);
        contentValues.put(COL3, age2);
        contentValues.put(COL4, creditCard2);

        long result = db.insert(DATABASE_TABLE, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
        public Cursor getData() {
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM " + DATABASE_TABLE;
            Cursor data = db.rawQuery(query, null);
            return data;
        }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + DATABASE_TABLE +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + DATABASE_TABLE + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        db.execSQL(query);
    }

}