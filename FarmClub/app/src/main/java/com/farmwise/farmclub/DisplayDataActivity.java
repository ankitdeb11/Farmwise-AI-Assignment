package com.farmwise.farmclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class DisplayDataActivity extends AppCompatActivity {private RecyclerView recyclerViewFarmersData;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);


        //LAT AND LONG
        double latitude = getIntent().getDoubleExtra("LATITUDE", 0.0);
        double longitude = getIntent().getDoubleExtra("LONGITUDE", 0.0);


        TextView txtLatitude = findViewById(R.id.txtLatitude);
        TextView txtLongitude = findViewById(R.id.txtLongitude);

        // Retrieve file paths from the Intent
        String imagePath1 = getIntent().getStringExtra("IMAGE_PATH_1");
        String imagePath2 = getIntent().getStringExtra("IMAGE_PATH_2");
        String videoPath = getIntent().getStringExtra("VIDEO_PATH");

        TextView textViewImagePath1 = findViewById(R.id.txtImageFilePath1);
        TextView textViewImagePath2 = findViewById(R.id.txtImageFilePath2);
        TextView textViewVideoPath = findViewById(R.id.txtVideoFilePath);





        txtLatitude.setText("Latitude: " + latitude);
        txtLongitude.setText("Longitude: " + longitude);

        // Display file paths if available
        if (imagePath1 != null && !imagePath1.isEmpty()) {
            textViewImagePath1.setVisibility(View.VISIBLE);
            textViewImagePath1.setText("Path of Image 1: " + imagePath1);
        }

        if (imagePath2 != null && !imagePath2.isEmpty()) {
            textViewImagePath2.setVisibility(View.VISIBLE);
            textViewImagePath2.setText("Path of Image 2: " + imagePath2);
        }

        if (videoPath != null && !videoPath.isEmpty()) {
            textViewVideoPath.setVisibility(View.VISIBLE);
            textViewVideoPath.setText("Path of Video: " + videoPath);
        }



        recyclerViewFarmersData = findViewById(R.id.recyclerViewFarmersData);
        dbHelper = new DatabaseHelper(this);




        // Display the collected data in a RecyclerView
        displayFarmersData();
    }

    private void displayFarmersData() {
        ArrayList<Farmer> farmersList = dbHelper.getAllFarmersData();

        // Create an adapter and set it to the RecyclerView
        FarmersDataAdapter adapter = new FarmersDataAdapter(farmersList);
        recyclerViewFarmersData.setAdapter(adapter);

        // Set the layout manager to position the items
        recyclerViewFarmersData.setLayoutManager(new LinearLayoutManager(this));
    }






    public void goBack(View view) {
        finish(); // Close the current activity and go back
    }
}