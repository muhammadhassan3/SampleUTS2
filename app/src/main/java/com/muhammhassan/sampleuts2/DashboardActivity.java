package com.muhammhassan.sampleuts2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    TextView tvNama;

    ImageButton btnForm, btnMenu;

    static final String EXTRA_USERNAME = "extra_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvNama = findViewById(R.id.tvNama);
        btnForm = findViewById(R.id.btnForm);
        btnMenu = findViewById(R.id.btnMenu);

        String nama = getIntent().getStringExtra(EXTRA_USERNAME);

        tvNama.setText(nama);

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(btnMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.songs_genre_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int selectedId = item.getItemId();
        Intent intent = new Intent(this, ContextMenuActivity.class);
        String lirik = "";
        if (selectedId == R.id.menu_dangdut) {
            lirik = getResources().getString(R.string.lirik_lagu_2);
            intent.putExtra(ContextMenuActivity.EXTRA_LIRIK, lirik);
            startActivity(intent);
            Toast.makeText(this, "Menu dangdut terpilih", Toast.LENGTH_SHORT).show();
        } else if (selectedId == R.id.menu_pop) {
            lirik = getResources().getString(R.string.lirik_lagu_1);
            intent.putExtra(ContextMenuActivity.EXTRA_LIRIK, lirik);
            startActivity(intent);
            Toast.makeText(this, "Menu POP Terpilih", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}