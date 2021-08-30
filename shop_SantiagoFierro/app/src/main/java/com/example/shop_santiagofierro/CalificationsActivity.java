package com.example.shop_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class CalificationsActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnRate, btnGoBack;

    private float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_califications);

        ratingBar = findViewById(R.id.ratingBar);

        btnRate   = findViewById(R.id.btnRate);
        btnGoBack = findViewById(R.id.btnGoBack);

        this.rating = ratingBar.getRating();

        btnRate.setOnClickListener(this::rate);
        btnGoBack.setOnClickListener(this::goBack);
    }

    private void rate(View view) {
        this.rating = ratingBar.getRating();
        close();
        Toast.makeText(this, "Rate is:" + this.rating, Toast.LENGTH_SHORT).show();
    }

    private void close() {
        final boolean RATING_CLOSE_CRITERIA = this.rating == 4;

        if (RATING_CLOSE_CRITERIA) {
            finish();
        }
    }

    private void goBack(View view) {
        goToActivity(MainActivity.class);
    }

    private void goToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}