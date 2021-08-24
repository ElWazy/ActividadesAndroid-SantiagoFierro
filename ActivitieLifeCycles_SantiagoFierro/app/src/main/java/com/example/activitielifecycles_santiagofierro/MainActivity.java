package com.example.activitielifecycles_santiagofierro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

    private void showMessage(String message) {
        alert.setMessage(message);
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMessage("Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showMessage("Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showMessage("Activity ¿Resumed?");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMessage("Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showMessage("Stopped Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showMessage("Activity Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showMessage("Activity Destroyed");
    }
}