package com.farmwise.farmclub;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FarmersDatabase";
    private static final int DATABASE_VERSION = 1;

    // Define your table and columns
    private static final String TABLE_FARMERS = "farmers";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_LAND_AREA = "land_area";

    // Create table query
    private static final String CREATE_TABLE_FARMERS = "CREATE TABLE " + TABLE_FARMERS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_ADDRESS + " TEXT, " +
            COLUMN_DOB + " TEXT, " +
            COLUMN_GENDER + " TEXT, " +
            COLUMN_LAND_AREA + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table
        db.execSQL(CREATE_TABLE_FARMERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed
    }






    public long insertFarmerData(String name, String address, String dob, String gender, String landArea) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_DOB, dob);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_LAND_AREA, landArea);

        // Inserting Row
        long result = db.insert(TABLE_FARMERS, null, values);
        db.close(); // Closing database connection
        return result;
    }
}
