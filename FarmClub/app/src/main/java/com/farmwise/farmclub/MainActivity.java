package com.farmwise.farmclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDataCollect, btnDisplayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnDataCollect = findViewById(R.id.btnDataCollect);
        btnDisplayData = findViewById(R.id.btnDisplayData);

        btnDataCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataCollectionActivity.class);
                startActivity(intent);
            }
        });



        btnDisplayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTwo = new Intent(MainActivity.this, DisplayDataActivity.class);
                startActivity(intentTwo);
            }
        });



    }
}