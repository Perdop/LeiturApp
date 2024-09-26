package com.example.myapplication;

import android.os.Bundle;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist); // Certifique-se de que esse é o layout correto

        ratingBar = findViewById(R.id.ratingBar);
        viewPager = findViewById(R.id.viewPager);

        // Configura o adapter para o ViewPager
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(adapter);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            // Aqui você pode implementar o que deve acontecer ao mudar a nota
        });
    }
}
