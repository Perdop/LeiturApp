package com.example.leiturapp;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class historiaActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private ViewPager viewPager;
    private CustomPagerAdapter adapter;
    private LinearLayout indicatorsLayout;
    private int indicatorsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        ratingBar = findViewById(R.id.ratingBar);
        viewPager = findViewById(R.id.viewPager);
        indicatorsLayout = findViewById(R.id.indicatorsLayout);

        // Passar o ViewPager para o CustomPagerAdapter
        adapter = new CustomPagerAdapter(this, viewPager);
        viewPager.setAdapter(adapter);

        // Configurar os indicadores
        indicatorsCount = adapter.getCount(); // Total de páginas
        setupIndicators();

        // Adicionar um listener para o ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            // Ação quando a classificação muda
        });
    }

    private void setupIndicators() {
        for (int i = 0; i < indicatorsCount; i++) {
            ImageView indicator = new ImageView(this);
            indicator.setImageResource(R.drawable.indicator_inactive); // Imagem padrão inativa
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(4, 0, 4, 0);
            indicatorsLayout.addView(indicator, params);
        }
        updateIndicators(0); // Ativar o primeiro indicador
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicatorsLayout.getChildCount(); i++) {
            ImageView indicator = (ImageView) indicatorsLayout.getChildAt(i);
            if (i == position) {
                indicator.setImageResource(R.drawable.indicator_active); // Imagem ativa
            } else {
                indicator.setImageResource(R.drawable.indicator_inactive); // Imagem inativa
            }
        }
    }
}
