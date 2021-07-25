package com.example.mobiledevtestscreening;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String InNama;
    EditText nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nama = findViewById(R.id.Nama);
        Button next = findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InNama = nama.getText().toString();
                Intent a = new Intent(MainActivity.this, hlm2.class);
                Bundle b = new Bundle();
                b.putString("parse_nama", InNama);
                a.putExtras(b);
                startActivity(a);
            }
        });
    }
}