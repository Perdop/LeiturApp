package com.example.leiturapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class autorActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout indicatorsLayout;
    private List<ImageView> indicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);

        viewPager = findViewById(R.id.viewPager);
        indicatorsLayout = findViewById(R.id.indicatorsLayout);

        List<Integer> images = Arrays.asList(
                R.drawable.avesso,
                R.drawable.beio,
                R.drawable.darkside,
                R.drawable.capadeus
        );

        MyPagerAdapter adapter = new MyPagerAdapter(images);
        viewPager.setAdapter(adapter);

        // Configurar os indicadores
        setupIndicators(images.size());

        // Ignorar todos os eventos de toque
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false; // Permite a interação com o ViewPager
            }
        });

        // Atualizar indicadores na mudança de página
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);
            }
        });
    }

    private void setupIndicators(int count) {
        indicators = new ArrayList<>();
        indicatorsLayout.removeAllViews(); // Limpar layout antes de adicionar novos indicadores

        for (int i = 0; i < count; i++) {
            ImageView indicator = new ImageView(this);
            indicator.setImageResource(R.drawable.indicator_inactive); // Define a imagem padrão para inativo
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0); // Margens entre os indicadores
            indicatorsLayout.addView(indicator, params);
            indicators.add(indicator);
        }

        updateIndicators(0); // Atualiza os indicadores para a primeira página
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicators.size(); i++) {
            indicators.get(i).setImageResource(i == position ? R.drawable.indicator_active : R.drawable.indicator_inactive);
        }
    }
}
