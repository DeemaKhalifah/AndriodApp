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
    EditText edtName, edtPrice,edtQuantity;
    Button btnSave;
    int index;
    Product product;
    productDaMockup da=new productDaMockup() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);
        edtQuantity = findViewById(R.id.edtQantity);
        btnSave = findViewById(R.id.btnSave);

        index = getIntent().getIntExtra("index", -1);
        product = da.getAllProducts().get(index);


        edtName.setText(product.getName());
        edtPrice.setText(String.valueOf(product.getPrice()));
        edtQuantity.setText(String.valueOf(product.getQuantity()));


        btnSave.setOnClickListener(v -> {
            String newName = edtName.getText().toString();
            double newPrice = Double.parseDouble(edtPrice.getText().toString());
            int newQuantity = Integer.parseInt(edtQuantity.getText().toString());


            product.setName(newName);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);


            finish();
        });


    }
}