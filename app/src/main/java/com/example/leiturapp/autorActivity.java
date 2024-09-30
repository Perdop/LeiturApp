package com.example.leiturapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.List;

public class autorActivity extends AppCompatActivity {

    private ViewPager2 viewPager;

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
    }
}


