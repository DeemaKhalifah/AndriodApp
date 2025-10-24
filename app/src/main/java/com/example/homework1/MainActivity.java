package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import dal.Product;
import dal.productDaMockup;

public class MainActivity extends AppCompatActivity {
    private ListView lstIteams;
    List<Product> products;
    ArrayAdapter<Product> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSave), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstIteams = findViewById(R.id.lstIteam);
        productDaMockup da =new productDaMockup();
        products=da.getAllProducts();
     adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,products);
        lstIteams.setAdapter(adapter);

        lstIteams.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("index", position);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh list when returning from DetailActivity
        adapter.notifyDataSetChanged();
    }
}




