package com.jlabs.wallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by johan on 1/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="cards.db";
    public static final String TABLE_NAME="cards_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
  //  public static final String COL_3="IMAGE";
    public static final String COL_3="LINK";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY ,NAME TEXT,  LINK TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String link)
    {
        SQLiteDatabase db=DatabaseHelper.this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
       // contentValues.put(COL_3,image);
        contentValues.put(COL_3,link);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db=DatabaseHelper.this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }
}
