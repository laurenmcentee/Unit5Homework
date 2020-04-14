package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // CONSTANTS
    final int MINGUESS = 1;
    final int MAXGUESS = 100;
    final String OORMESSAGE = "Guess must be between 1 and 100";
    final String TOLOW = "To Low try Again";
    final String TOHIGH = "To High try Again";

    // VARIABLES
    int input = 0;
    int guessAccumulator = 0;
    int guesses = 0;
    int gamesPlayed = 0;
    int novices = 0;
    int semipros = 0;
    int experts = 0;

    Random rand = new Random();
    int secretNumber = rand.nextInt(101);

    //Widgets
    EditText editTextGuess;
    EditText editTextResult;
    Button buttonCalculate;
    Button buttonClear;
    Button buttonNewGame;
    Button buttonRank;
    Button buttonShowTotals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShowTotals = findViewById(R.id.buttonShowTotals);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClear     = findViewById(R.id.buttonClear);
        editTextGuess   = findViewById(R.id.editTextGuess);
        editTextResult  = findViewById(R.id.editTextResult);
        buttonNewGame   = findViewById(R.id.buttonNewGame);
        buttonRank = findViewById(R.id.buttonRank);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //consider adding a separate method for game

                //get input from user and parse
                input = Integer.parseInt(editTextGuess.getText().toString());

             //guess is out of range
             if(input < MINGUESS || input > MAXGUESS)
             {
                 Toast toast = Toast.makeText(getApplicationContext(),
                         OORMESSAGE, Toast.LENGTH_LONG);
                 toast.show();
                 editTextGuess.setText("");
                 editTextGuess.requestFocus();
             }
             //guess if to low
             else if (input < secretNumber)
             {
                 Toast toast = Toast.makeText(getApplicationContext(),
                         TOLOW, Toast.LENGTH_LONG);
                 toast.show();
                 ++guessAccumulator;
             }
             //guess is too high
             else if (input > secretNumber)
             {
                 Toast toast = Toast.makeText(getApplicationContext(),
                         TOHIGH, Toast.LENGTH_LONG);
                 toast.show();
                 ++guessAccumulator;
             }
             //guess is correct
             else
             {
                 guesses += guessAccumulator;
                 String guessesMade = String.valueOf(guesses);
                 gamesPlayed += 1;

                 //display results
                 String output = "You guessed the secret number " + secretNumber + ", in " + guessesMade + " Guesses";
                 editTextResult.setText(output);

                 //enable rank button
                 buttonRank.setEnabled(true);
             }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextGuess.setText(" ");
                editTextResult.requestFocus();
            }
        });

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // new random number
                secretNumber = rand.nextInt(101);
                //clear accumulator
                guessAccumulator = 0;
                editTextGuess.setText("");
                editTextResult.setText("");
                editTextGuess.requestFocus();
            }
        });


        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RankActivity.class);
                intent.putExtra("guesses", guesses);
                startActivityForResult(intent, 1);
            }
        });

        buttonShowTotals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle extras = new Bundle();
                extras.putInt("novices", novices);
                extras.putInt("semipros", semipros);
                extras.putInt("experts", experts);
                Intent intent = new Intent(getApplicationContext(), TotalActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }//end of oncreate

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                 novices = data.getIntExtra("numberOfNovices", 0);
                 semipros = data.getIntExtra("numberOfSemipros", 0);
                 experts = data.getIntExtra("numberOfExperts", 0);
            }
        }
    }
} // end of class
