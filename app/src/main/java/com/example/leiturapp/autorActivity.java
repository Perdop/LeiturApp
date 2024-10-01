package com.example.leiturapp;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.List;

public class autorActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Handler handler;
    private static final int PAGE_DELAY = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);

        viewPager = findViewById(R.id.viewPager);

        List<Integer> images = Arrays.asList(
                R.drawable.avesso,
                R.drawable.beio,
                R.drawable.darkside,
                R.drawable.capadeus
        );

        MyPagerAdapter adapter = new MyPagerAdapter(images);
        viewPager.setAdapter(adapter);

        // Iniciar o auto-scroll
        handler = new Handler();
        startAutoScroll();
    }

    private void startAutoScroll() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewPager.getCurrentItem() == viewPager.getAdapter().getItemCount() - 1) {
                    viewPager.setCurrentItem(0, true);
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }
                handler.postDelayed(this, PAGE_DELAY);
            }
        }, PAGE_DELAY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null); // Parar o auto-scroll ao pausar
    }

    @Override
    protected void onResume() {
        super.onResume();
        startAutoScroll(); // Reiniciar o auto-scroll ao retomar
    }
}
