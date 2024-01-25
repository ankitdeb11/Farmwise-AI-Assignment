package com.farmwise.farmclub;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


// Implement permissions request logic
// Implement UI logic to collect farmer data

public class DataCollectionActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_LOCATION_PERMISSION = 2;

    private static final int REQUEST_IMAGE_CAPTURE = 3;

    String[] genderOptions = {"Male", "Female", "Other"};

    EditText editTextFarmerName, editTextAddress, editTextDOB, editTextLandArea;
    Spinner spinnerGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);



        //accessing from XML
        editTextFarmerName = findViewById(R.id.editTextFarmerName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextLandArea = findViewById(R.id.editTextLandArea);
        spinnerGender = findViewById(R.id.spinnerGender);



        // setting up gender spinner
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderOptions);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);

        // setting up location, camera, and storage permission request logic
        requestPermissions();

        // setting up date picker for DOB
        editTextDOB.setOnClickListener(v -> showDatePickerDialog());




        // Initialize UI components and set listeners
        // Request necessary permissions
        // Implement logic to capture images and videos
        // Implement basic field validations
        // Store data in a local database (SQLite)


    }






































    //functions code below
    private void requestPermissions() {
        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{permission}, PERMISSION_REQUEST_CODE);
            }
        }

        // request location updates
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
    }

    private void showDatePickerDialog() {
        // accessing current date
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // functionality for the date picker dialog for DOB
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    // updating the EditText with the selected date
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(selectedYear, selectedMonth, selectedDay);

                    // formatting the date as needed
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                    String formattedDate = dateFormat.format(selectedDate.getTime());

                    editTextDOB.setText(formattedDate);
                }, year, month, day);

        // showing the date picker dialog on screen
        datePickerDialog.show();
    }
    private boolean validateFields() {
        // Implement your validation logic
        return true;  // Return false if validation fails
    }

    public void saveFarmerData(View view) {
        if (validateFields()) {
            // Implement logic to save farmer data
            // Access the fields using editTextFarmerName.getText().toString(), etc.
            // Save to your local database or preferred storage method

            Toast.makeText(this, "Farmer data submitted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Handle permission request results
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Handle camera and storage permissions
            // ...
        } else if (requestCode == REQUEST_LOCATION_PERMISSION) {
            // Handle location permission
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Start location updates
                // ...
            } else {
                Toast.makeText(this, "Location permission denied. Location capturing disabled.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}