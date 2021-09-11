package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Animesh', 'aniBoka@gmail.com','7584','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Rahul', 'rarahul@gmail.com','1258','8995641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Pushkar', 'pushkar223@gmail.com','8896','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Amil', 'Amil69429@gmail.com','7752','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Ayush', 'panchamiAyush@gmail.com','3669','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Shanu', 'shanu23@gmail.com','9985','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Abhishek', 'sadhuabhi@gmail.com','1207','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Jayesh', 'JayJay42069@gmail.com','4522','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Vivek', 'vivek@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Vickey', 'vickyplease@gmail.com','5450','8292591201', 9900)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}