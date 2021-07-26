package com.example.mobiledevtestscreening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class hlm5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlm5);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(this);
        viewPager2.setAdapter(adapter);


    }
}