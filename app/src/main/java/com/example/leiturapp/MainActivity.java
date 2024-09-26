package com.example.leiturapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonHistoria, buttonAutor, buttonPersonagens, buttonTimeline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonHistoria = findViewById(R.id.button);
        buttonAutor = findViewById(R.id.button2);
        buttonPersonagens = findViewById(R.id.button3);
        buttonTimeline = findViewById(R.id.button4);

        goToScreen(findViewById(R.id.button3), personagemActivity.class);
        goToScreen(findViewById(R.id.button4), timelineActivity.class);
        goToScreen(findViewById(R.id.button2), autorActivity.class);
        goToScreen(findViewById(R.id.button), historiaActivity.class);
    }

    /* Home - Go to the screen function */
    public void goToScreen(Button a, Class<?> activityClass) {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(),activityClass );
                startActivity(intent);
            }
        });
    }
}