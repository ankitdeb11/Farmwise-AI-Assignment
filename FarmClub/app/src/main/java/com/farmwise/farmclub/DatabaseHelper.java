package com.farmwise.farmclub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

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




    public ArrayList<Farmer> getAllFarmersData() {
        ArrayList<Farmer> farmersList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Define the columns you want to retrieve
        String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_ADDRESS, COLUMN_DOB, COLUMN_GENDER, COLUMN_LAND_AREA};

        Cursor cursor = db.query(TABLE_FARMERS, columns, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve column indices
                int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
                int addressIndex = cursor.getColumnIndex(COLUMN_ADDRESS);
                int dobIndex = cursor.getColumnIndex(COLUMN_DOB);
                int genderIndex = cursor.getColumnIndex(COLUMN_GENDER);
                int landAreaIndex = cursor.getColumnIndex(COLUMN_LAND_AREA);

                // Declare variables outside the if blocks
                String name = "";
                String address = "";
                String dob = "";
                String gender = "";
                String landArea = "";

                // Check if column indices are valid
                if (nameIndex >= 0) {
                    name = cursor.getString(nameIndex);
                    // Do something with the 'name' value
                    Log.d("FarmerData", "Name: " + name);
                }

                if (addressIndex >= 0) {
                    address = cursor.getString(addressIndex);
                    // Do something with the 'address' value
                    Log.d("FarmerData", "Address: " + address);
                }

                if (dobIndex >= 0) {
                    dob = cursor.getString(dobIndex);
                    // Do something with the 'dob' value
                    Log.d("FarmerData", "DOB: " + dob);
                }

                if (genderIndex >= 0) {
                    gender = cursor.getString(genderIndex);
                    // Do something with the 'gender' value
                    Log.d("FarmerData", "Gender: " + gender);
                }

                if (landAreaIndex >= 0) {
                    landArea = cursor.getString(landAreaIndex);
                    // Do something with the 'landArea' value
                    Log.d("FarmerData", "Land Area: " + landArea);
                }

                // Create a Farmer object and add it to the list
                Farmer farmer = new Farmer(0, name, address, dob, gender, landArea);
                farmersList.add(farmer);

            } while (cursor.moveToNext());

            // Close the cursor
            cursor.close();
        }

        // Close the database
        db.close();

        return farmersList;
    }

}
