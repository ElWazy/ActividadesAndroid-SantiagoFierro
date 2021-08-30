package com.example.shop_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ProductsActivity extends AppCompatActivity {

    private RadioButton rCalculate1, rCalculate2;
    private TextView txtProductsMessage;
    private Button btnCalculate, btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        rCalculate1 = findViewById(R.id.rCalculate1);
        rCalculate2 = findViewById(R.id.rCalculate2);

        txtProductsMessage = findViewById(R.id.txtProductsMessage);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnGoBack    = findViewById(R.id.btnGoBack);

        btnCalculate.setOnClickListener(this::calculate);
        btnGoBack.setOnClickListener(this::goBack);
    }

    private void calculate(View view) {
        if (rCalculate1.isChecked()) this.result(1);
        if (rCalculate2.isChecked()) this.result(2);
    }
    
    private void result(int multiple) {
        int result = 1000 * multiple;
        txtProductsMessage.setText("The kilogram is: " + result);
    }

    private void goBack(View view) {
        this.goToActivity(MainActivity.class);
    }

    private void goToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}