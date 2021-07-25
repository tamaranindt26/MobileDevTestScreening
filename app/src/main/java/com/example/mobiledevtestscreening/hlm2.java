package com.example.mobiledevtestscreening;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hlm2 extends AppCompatActivity {
    String OutNama;
    TextView TFNama2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlm2);

        TextView TFNama2 = findViewById(R.id.Nama2);
        Bundle b = getIntent().getExtras();

        OutNama = b.getString("parse_nama");
        TFNama2.setText("" + OutNama);

        Button event = findViewById(R.id.btnEvent);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hlm2.this, hlm4.class);
                startActivity(i);
            }
        });

        Button guest = findViewById(R.id.btnGuest);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(hlm2.this, hlm3.class);
                startActivity(j);
            }
        });
    }
}