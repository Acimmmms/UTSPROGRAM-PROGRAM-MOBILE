package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    TextView selectedProduct;
    Button btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        selectedProduct = findViewById(R.id.selectedProduct);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);

        // Ambil data produk yang dipilih dari intent
        String product = getIntent().getStringExtra("selectedProduct");

        // Periksa apakah data produk yang dipilih valid
        if (product != null && !product.isEmpty()) {
            selectedProduct.setText("Produk: " + product);
        }

        // Tombol untuk mengonfirmasi pemesanan
        btnConfirmOrder.setOnClickListener(v -> {
            // Arahkan pengguna ke halaman sukses setelah konfirmasi
            Intent intent = new Intent(OrderActivity.this, SuccessActivity.class);
            intent.putExtra("selectedProduct", product); // Kirim data produk yang dipilih ke halaman sukses
            startActivity(intent);
            finish(); // Menutup OrderActivity setelah pemesanan berhasil
        });
    }
}
