package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RankActivity extends AppCompatActivity {

    int numberOfNovices = 0;
    int numberOfSemipros = 0;
    int numberOfExperts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

             //constants and variables
            final String novice = "Novice";
            final String semipro = "Semi-Pro";
            final String expert = "Expert";
            int guessesMade = 0;

            //widgets
            ImageView imageViewRank;
            TextView textViewRank;
            Button buttonBack;

            buttonBack = findViewById(R.id.buttonBack);
            textViewRank = findViewById(R.id.textViewRank);
            imageViewRank = findViewById(R.id.imageViewRank);


             Intent intent = getIntent();
             guessesMade = intent.getIntExtra("guesses", 0);


             if (guessesMade > 1 && guessesMade <= 5)
            {
                imageViewRank.setImageResource(R.drawable.expert);
                textViewRank.setText(expert);
                numberOfExperts++;

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Wohoo! you're an Expert!", Toast.LENGTH_LONG);
                toast.show();
            }
            else if (guessesMade >= 6 && guessesMade <= 10)
            {
                imageViewRank.setImageResource(R.drawable.semiopro);
                textViewRank.setText(semipro);
                numberOfSemipros++;

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Cool you're a Semi-Pro!", Toast.LENGTH_LONG);
                toast.show();
            }
            else if (guessesMade > 10)
            {
                imageViewRank.setImageResource(R.drawable.novice);
                textViewRank.setText(novice);
                numberOfNovices++;

                Toast toast = Toast.makeText(getApplicationContext(),
                        "You're a Novice", Toast.LENGTH_LONG);
                toast.show();
            }
            else
             {
                 Toast toast = Toast.makeText(getApplicationContext(),
                         "Sorry. There was an Error. Try Playing a New Game.", Toast.LENGTH_LONG);
                 toast.show();
             }



        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent resultIntent = new Intent();
                resultIntent.putExtra("numberOfNovices", numberOfNovices);
                resultIntent.putExtra("numberOfSemipros", numberOfSemipros);
                resultIntent.putExtra("numberOfExperts", numberOfExperts);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
