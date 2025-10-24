package com.example.homework1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dal.Product;
import dal.productDaMockup;

public class Activity2 extends AppCompatActivity {
    EditText editName, editPrice;
    Button btnSave;
    int index;
    Product product;
    productDaMockup da=new productDaMockup() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        editName = findViewById(R.id.edtName);
        editPrice = findViewById(R.id.edtPrice);
        btnSave = findViewById(R.id.btnSave);

        index = getIntent().getIntExtra("index", -1);
        product = da.getAllProducts().get(index);

        // Show current product info
        editName.setText(product.getName());
        editPrice.setText(String.valueOf(product.getPrice()));

        btnSave.setOnClickListener(v -> {
            String newName = editName.getText().toString();
            double newPrice = Double.parseDouble(editPrice.getText().toString());

            product.setName(newName);
            product.setPrice(newPrice);


            finish(); // go back to MainActivity
        });


    }
}