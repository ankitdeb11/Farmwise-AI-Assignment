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

    private static final int DATABASE_VERSION = 2;


    // defining table and columns
    private static final String TABLE_FARMERS = "farmers";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_LAND_AREA = "land_area";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";

    // creating table query
    private static final String CREATE_TABLE_FARMERS = "CREATE TABLE " + TABLE_FARMERS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_ADDRESS + " TEXT, " +
            COLUMN_DOB + " TEXT, " +
            COLUMN_GENDER + " TEXT, " +
            COLUMN_LAND_AREA + " TEXT, " +
            COLUMN_LATITUDE + " REAL, " + // REAL is used for double values
            COLUMN_LONGITUDE + " REAL);"; // REAL is used for double values


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating the table
        db.execSQL(CREATE_TABLE_FARMERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // extra function for handling database upgrade if needed
    }






    public long insertFarmerData(String name, String address, String dob, String gender, String landArea, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_DOB, dob);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_LAND_AREA, landArea);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);

        // inserting Row data
        long result = db.insert(TABLE_FARMERS, null, values);
        db.close(); // Closing database connection
        return result;
    }




    public ArrayList<Farmer> getAllFarmersData() {
        ArrayList<Farmer> farmersList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // defining the columns we want to retrieve, including latitude and longitude
        String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_ADDRESS, COLUMN_DOB, COLUMN_GENDER, COLUMN_LAND_AREA, COLUMN_LATITUDE, COLUMN_LONGITUDE};

        Cursor cursor = db.query(TABLE_FARMERS, columns, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // retrieving column indices
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
                int addressIndex = cursor.getColumnIndex(COLUMN_ADDRESS);
                int dobIndex = cursor.getColumnIndex(COLUMN_DOB);
                int genderIndex = cursor.getColumnIndex(COLUMN_GENDER);
                int landAreaIndex = cursor.getColumnIndex(COLUMN_LAND_AREA);
                int latitudeIndex = cursor.getColumnIndex(COLUMN_LATITUDE);
                int longitudeIndex = cursor.getColumnIndex(COLUMN_LONGITUDE);

                // declaring variables outside the if blocks
                int id = -1; // Initialize with a default value
                String name = "";
                String address = "";
                String dob = "";
                String gender = "";
                String landArea = "";
                double latitude = 0.0; // Initialize with a default value
                double longitude = 0.0; // Initialize with a default value

                // checking if column indices are valid
                if (idIndex >= 0) {
                    id = cursor.getInt(idIndex);
                }

                if (nameIndex >= 0) {
                    name = cursor.getString(nameIndex);
                    Log.d("FarmerData", "Name: " + name);
                }

                if (addressIndex >= 0) {
                    address = cursor.getString(addressIndex);
                    Log.d("FarmerData", "Address: " + address);
                }

                if (dobIndex >= 0) {
                    dob = cursor.getString(dobIndex);
                    Log.d("FarmerData", "DOB: " + dob);
                }

                if (genderIndex >= 0) {
                    gender = cursor.getString(genderIndex);
                    Log.d("FarmerData", "Gender: " + gender);
                }

                if (landAreaIndex >= 0) {
                    landArea = cursor.getString(landAreaIndex);
                    Log.d("FarmerData", "Land Area: " + landArea);
                }

                if (latitudeIndex >= 0) {
                    latitude = cursor.getDouble(latitudeIndex);
                    Log.d("FarmerData", "Latitude: " + latitude);
                }

                if (longitudeIndex >= 0) {
                    longitude = cursor.getDouble(longitudeIndex);
                    Log.d("FarmerData", "Longitude: " + longitude);
                }

                // creating a Farmer object and adding it to the list
                Farmer farmer = new Farmer(id, name, address, dob, gender, landArea, latitude, longitude);
                farmersList.add(farmer);

            } while (cursor.moveToNext());

            cursor.close();
        }

        // closing the database
        db.close();

        return farmersList;
    }

}
