package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView productList;
    String[] products = {
            "Baut M6 - Rp 500",
            "Mur M6 - Rp 400",
            "Baut M8 - Rp 600",
            "Mur M8 - Rp 450"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = findViewById(R.id.productList);

        // Menampilkan daftar produk dengan harga di ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        productList.setAdapter(adapter);

        // Menangani klik pada item dalam daftar
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                // Ambil nama produk yang dipilih
                String selectedProduct = products[position];

                // Tampilkan pesan atau navigasi ke halaman pemesanan
                Toast.makeText(MainActivity.this, "Memilih: " + selectedProduct, Toast.LENGTH_SHORT).show();

                // Navigasi ke halaman pemesanan, misalnya ke activity Pemesanan
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                // Pastikan data yang dikirim tidak null
                if (selectedProduct != null && !selectedProduct.isEmpty()) {
                    intent.putExtra("selectedProduct", selectedProduct);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Produk tidak valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
