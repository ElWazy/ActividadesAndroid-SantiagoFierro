package com.example.shop_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shop_santiagofierro.usecases.LoadMyProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private CheckBox chbRate, chbProducts;
    private TextView txtMessage;
    private Button btnLoad, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        chbRate     = findViewById(R.id.chbRate);
        chbProducts = findViewById(R.id.chbProducts);

        txtMessage = findViewById(R.id.txtMessage);

        btnLoad = findViewById(R.id.btnLoad);
        btnMenu = findViewById(R.id.btnMenu);

        btnLoad.setOnClickListener(this::load);
        btnMenu.setOnClickListener(this::menu);
    }

    private void load(View view) {
        final Timer timer = new Timer();

        TimerTask timerTask = new LoadMyProgressBar(this.progressBar);
        timer.schedule(timerTask, 0, 100);
    }

    private void menu(View view) {
        boolean allChecked = chbRate.isChecked() && chbProducts.isChecked();

        if (allChecked) {
            txtMessage.setText("Please select 1 option");
        } else {
            if (chbRate.isChecked()) {
                this.goToActivity(CalificationsActivity.class);
            }
            if (chbProducts.isChecked()) {
                this.goToActivity(ProductsActivity.class);
            }
        }
    }

    private void goToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}