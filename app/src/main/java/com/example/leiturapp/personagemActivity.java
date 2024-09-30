package com.example.leiturapp;

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

public class personagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Declaracoes */
        ScrollView personagensTela =  findViewById(R.id.personagemScrollView);

        /* Personagem - show text */
        showText(findViewById(R.id.personagem1Card), findViewById(R.id.personagem1),findViewById(R.id.personagemLayout1),personagensTela );
        showText(findViewById(R.id.personagem2Card), findViewById(R.id.personagem2),findViewById(R.id.personagemLayout2),personagensTela );
        showText(findViewById(R.id.personagem3Card), findViewById(R.id.personagem3),findViewById(R.id.personagemLayout3),personagensTela );
        showText(findViewById(R.id.personagem4Card), findViewById(R.id.personagem4),findViewById(R.id.personagemLayout4),personagensTela );
        /* Personagem - close text */
        closeText(findViewById(R.id.voltarImgPersonagem1) , findViewById(R.id.voltarPersonagem1),findViewById(R.id.personagemLayout1), personagensTela );
        closeText(findViewById(R.id.voltarImgPersonagem2) , findViewById(R.id.voltarPersonagem2),findViewById(R.id.personagemLayout2), personagensTela );
        closeText(findViewById(R.id.voltarImgPersonagem3) , findViewById(R.id.voltarPersonagem3),findViewById(R.id.personagemLayout3), personagensTela );
        closeText(findViewById(R.id.voltarImgPersonagem4) , findViewById(R.id.voltarPersonagem4),findViewById(R.id.personagemLayout4), personagensTela );
    }

    /* Personagem - show text function */
    public void showText(Button a,ImageButton x, ConstraintLayout y, ScrollView z) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.VISIBLE);
                z.setOnTouchListener((n, event) -> true);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.VISIBLE);
                z.setOnTouchListener((n, event) -> true);
            }
        });
    }

    /* Personagem - close text function */
    public void closeText(ImageButton a , Button x, ConstraintLayout y, ScrollView z) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.GONE);
                z.setOnTouchListener((n, event) -> false);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.GONE);
                z.setOnTouchListener((n, event) -> false);
            }
        });
    }

}