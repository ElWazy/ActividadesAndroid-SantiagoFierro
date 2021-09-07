package com.example.containers_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.containers_santiagofierro.client.application.CalculateSalary;
import com.example.containers_santiagofierro.client.application.ClientGenerator;
import com.example.containers_santiagofierro.client.domain.Client;
import com.example.containers_santiagofierro.client.domain.Salary;
import com.example.containers_santiagofierro.product.infrastructure.ProductGenerator;
import com.example.containers_santiagofierro.product.infrastructure.ProductScroll;
import com.example.containers_santiagofierro.shared.domain.exceptions.NegativeValue;
import com.example.containers_santiagofierro.shared.domain.exceptions.UnhandledGenerationLimit;
import com.example.containers_santiagofierro.shared.infrastructure.SpinnerLoader;
import com.example.containers_santiagofierro.product.domain.Price;
import com.example.containers_santiagofierro.product.domain.Product;
import com.example.containers_santiagofierro.shared.domain.Id;
import com.example.containers_santiagofierro.shared.domain.Name;

public class MainActivity extends AppCompatActivity {

    private Spinner    spnClient, spnProduct;
    private TextView[] txtProducts;
    private TextView   txtResult;
    private Button     btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadComponents();
        setButtonsEvents();

        Client[] clients = null;
        Product[] products = null;
        try {
            clients = new ClientGenerator(3).clients();
            products = new ProductGenerator(5).products();
        } catch (UnhandledGenerationLimit ex) {
            showMessage(ex.getMessage());
        }

        SpinnerLoader clientSpinnerLoader = new SpinnerLoader(this, clients, spnClient);
        SpinnerLoader productSpinnerLoader = new SpinnerLoader(this, products, spnProduct);

        ProductScroll.fill(txtProducts, products);
    }

    private void calculate(View view) {
        Client client = (Client) spnClient.getSelectedItem();
        Product product = (Product) spnProduct.getSelectedItem();

        try {
            CalculateSalary newSalary = new CalculateSalary(client, product);
            String message = "You select " + client.toString()
                    + "\nyours salary is " + newSalary.toString();

            txtResult.setText(message);
        } catch (NegativeValue ex) {
            showMessage(ex.getMessage());
            txtResult.setText(client.toString() + " don't have money");
        }


    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT);
    }

    private void loadComponents() {
        spnClient  = findViewById(R.id.spnClient);
        spnProduct = findViewById(R.id.spnProduct);

        txtProducts = new TextView[5];
        txtProducts[0] = findViewById(R.id.txtProduct1);
        txtProducts[1] = findViewById(R.id.txtProduct2);
        txtProducts[2] = findViewById(R.id.txtProduct3);
        txtProducts[3] = findViewById(R.id.txtProduct4);
        txtProducts[4] = findViewById(R.id.txtProduct5);

        txtResult = findViewById(R.id.txtResult);

        btnEnter = findViewById(R.id.btnEnter);
    }

    private void setButtonsEvents() {
        btnEnter.setOnClickListener(this::calculate);
    }
}