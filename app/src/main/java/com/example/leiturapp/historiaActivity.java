package com.example.leiturapp;

import android.os.Bundle;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class historiaActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private ViewPager viewPager;
    private CustomPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        ratingBar = findViewById(R.id.ratingBar);
        viewPager = findViewById(R.id.viewPager);

        // Passar o ViewPager para o CustomPagerAdapter
        adapter = new CustomPagerAdapter(this, viewPager);
        viewPager.setAdapter(adapter);

        // Iniciar o auto-scroll
        adapter.startAutoScroll();

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            // Ação quando a classificação muda
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        adapter.stopAutoScroll(); // Parar o auto-scroll ao pausar
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.startAutoScroll(); // Reiniciar o auto-scroll ao retomar
    }
}
