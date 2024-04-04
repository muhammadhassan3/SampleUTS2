package com.muhammhassan.sampleuts2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class FormActivity extends AppCompatActivity {
    TextInputEditText edtId, edtNama, edtJumlah, edtDurasi;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtId = findViewById(R.id.edtId);
        edtNama = findViewById(R.id.edtNama);
        edtJumlah = findViewById(R.id.edtJumlah);
        edtDurasi = findViewById(R.id.edtDurasi);
        btnSave = findViewById(R.id.btnSimpan);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtId.getText().toString().trim();
                String nama = edtNama.getText().toString().trim();
                int jumlah = Integer.parseInt(edtJumlah.getText().toString());
                int durasi = Integer.parseInt(edtDurasi.getText().toString());
                // TODO: Membuka halaman Hasil
                Intent intent = new Intent(FormActivity.this, HasilActivity.class);
                intent.putExtra(HasilActivity.EXTRA_ID, id);
                intent.putExtra(HasilActivity.EXTRA_NAMA, nama);
                intent.putExtra(HasilActivity.EXTRA_DURASI_PEMINJAMAN, durasi);
                intent.putExtra(HasilActivity.EXTRA_JUMLAH_PEMINJAMAN, jumlah);
                startActivity(intent);
            }
        });
    }
}