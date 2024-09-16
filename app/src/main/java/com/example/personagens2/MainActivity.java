package com.example.personagens2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        /* Declaracoes */
        ScrollView pesonagensTela =  findViewById(R.id.personagemScrollView);

        /* Personagem - show text */
        showText(findViewById(R.id.personagem1),findViewById(R.id.personagemLayout1),pesonagensTela );
        /* Personagem - close text */
        closeText(findViewById(R.id.voltarPersonagem1),findViewById(R.id.personagemLayout1), pesonagensTela );
    }

    /* Personagem - show text function */
    public void showText(ImageButton x, ConstraintLayout y, ScrollView z) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.VISIBLE);
                z.setOnTouchListener((n, event) -> true);
            }
        });
    }

    /* Personagem - close text function */
    public void closeText(Button x, ConstraintLayout y, ScrollView z) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.GONE);
                z.setOnTouchListener((n, event) -> false);
            }
        });
    }

}