package com.example.operaciones_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Me tiraba error el editor xml al añadir una imagen a si que tuve que eliminarla
 * pero si sirve de algo, si aprendi como agregar un ImageView
 */
public class MainActivity extends AppCompatActivity {

    private EditText txtNum1, txtNum2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);

        btnAdd      = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubstract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide   = (Button) findViewById(R.id.btnDivide);

        lblResult = (TextView) findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(this::add);
        btnSubtract.setOnClickListener(this::subtract);
        btnMultiply.setOnClickListener(this::multiply);
        btnDivide.setOnClickListener(this::divide);
    }

    private void calculate(String operation) {
        try {
            int result = 0;
            int num1 = Integer.parseInt(txtNum1.getText().toString());
            int num2 = Integer.parseInt(txtNum2.getText().toString());

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;

                    break;
                case "*":
                    result = num1 * num2;

                    break;
                case "/":
                    result = num1 / num2;

                    break;
                default:
                    result = 0;
                    break;
            }

            lblResult.setText("Result: " + result);
        } catch (ArithmeticException | NumberFormatException ex) {
            lblResult.setText("Error: " + ex.getMessage());
        }
    }

    private void add(View view) {
        calculate("+");
    }

    private void subtract(View view) {
        calculate("-");
    }

    private void multiply(View view) {
        calculate("*");
    }

    private void divide(View view) {
        calculate("/");
    }
}