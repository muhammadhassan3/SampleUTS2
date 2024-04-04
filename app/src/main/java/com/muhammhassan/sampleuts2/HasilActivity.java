package com.muhammhassan.sampleuts2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HasilActivity extends AppCompatActivity {
    static final String EXTRA_ID = "extra_id";
    static final String EXTRA_NAMA = "extra_nama";
    static final String EXTRA_JUMLAH_PEMINJAMAN = "extra_jumlah_peminjaman";
    static final String EXTRA_DURASI_PEMINJAMAN = "extra_durasi_peminjaman";

    TextView tvIdPeminjaman, tvNamaPeminjam, tvJumlahPeminjaman, tvDurasiPeminjaman, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvIdPeminjaman = findViewById(R.id.tvIdPeminjaman);
        tvNamaPeminjam = findViewById(R.id.tvNamaPeminjaman);
        tvJumlahPeminjaman = findViewById(R.id.tvJumlahPeminjaman);
        tvDurasiPeminjaman = findViewById(R.id.tvDurasiPeminjaman);
        tvTotal = findViewById(R.id.tvTotalBayar);

        String id = getIntent().getStringExtra(EXTRA_ID);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        int jumlahPeminjaman = getIntent().getIntExtra(EXTRA_JUMLAH_PEMINJAMAN, 0);
        int durasiPeminjaman = getIntent().getIntExtra(EXTRA_DURASI_PEMINJAMAN, 0);

        tvIdPeminjaman.setText(id);
        tvNamaPeminjam.setText(nama);
        tvJumlahPeminjaman.setText(String.valueOf(jumlahPeminjaman));
        tvDurasiPeminjaman.setText(String.valueOf(durasiPeminjaman));
        tvTotal.setText(String.valueOf(5000 * jumlahPeminjaman ));
    }
}