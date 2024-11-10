package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    TextView successTitle, successMessage;
    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        successTitle = findViewById(R.id.successTitle);
        successMessage = findViewById(R.id.successMessage);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        // Ambil produk yang dipilih dari intent
        String product = getIntent().getStringExtra("selectedProduct");

        // Tampilkan informasi produk yang dipesan
        successMessage.setText("Terima kasih telah memesan " + product + ". Pemesanan Anda telah berhasil diproses.");

        // Tombol untuk kembali ke halaman utama
        btnBackToHome.setOnClickListener(v -> {
            Intent intent = new Intent(SuccessActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Menutup halaman sukses setelah kembali ke halaman utama
        });
    }
}
