package com.example.leiturapp;

import android.os.Bundle;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class historiaActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        ratingBar = findViewById(R.id.ratingBar);
        viewPager = findViewById(R.id.viewPager);

        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(adapter);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
        });
    }
}
