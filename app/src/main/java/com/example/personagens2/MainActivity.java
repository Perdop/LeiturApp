package com.example.personagens2;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
        /* Personagem - show text */
        showText(findViewById(R.id.personaBtn),findViewById(R.id.personaLayout1) );
        showText(findViewById(R.id.personaBtn2),findViewById(R.id.personaLayout2) );
        showText(findViewById(R.id.personaBtn3),findViewById(R.id.personaLayout3) );
        showText(findViewById(R.id.personaBtn4),findViewById(R.id.personaLayout4) );
        /* Personagem - close text */
        closeText(findViewById(R.id.personaLayoutBtn1),findViewById(R.id.personaLayout1));
        closeText(findViewById(R.id.personaLayoutBtn2),findViewById(R.id.personaLayout2));
        closeText(findViewById(R.id.personaLayoutBtn3),findViewById(R.id.personaLayout3));
        closeText(findViewById(R.id.personaLayoutBtn4),findViewById(R.id.personaLayout4));
    }

    /* Personagem - show text function */
    public void showText(ImageButton x, RelativeLayout y) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.VISIBLE);
            }
        });
    }
    /* Personagem - close text function */
    public void closeText(Button x, RelativeLayout y) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setVisibility(View.GONE);
            }
        });
    }

}