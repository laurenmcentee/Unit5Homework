package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowScores extends AppCompatActivity {

    TextView textViewScores;
    Button buttonBackToHome;

    Integer guessesMade;
    Integer gamesPlayed;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scores);

        textViewScores = findViewById(R.id.textViewScores);
        buttonBackToHome = findViewById(R.id.buttonBackToHome);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        if(extras != null)
        {
            if(extras.containsKey("guessesMade"))
            {
                guessesMade = extras.getInt("guessesMade", 0);
            }
            if(extras.containsKey("gamesPlayed"))
            {
                gamesPlayed = extras.getInt("gamesPlayed", 0);
            }

            result = "\n\t Guesses Made: " + guessesMade + "\n\n";
            result += "\n\t Games Played: " + gamesPlayed + "\n\n";

            textViewScores.setText(result);
        }

        buttonBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}
