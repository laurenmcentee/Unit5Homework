package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TotalActivity extends AppCompatActivity {


    int novices = 0;
    int semipros = 0;
    int experts = 0;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        //widgets
        EditText editTextTotals;
        Button buttonBack;

        editTextTotals = findViewById(R.id.editTextTotals);
        buttonBack = findViewById(R.id.buttonBack);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null)
        {
            if(extras.containsKey("novices"))
            {
                novices =+ extras.getInt("novices", 0);
            }
            if(extras.containsKey("semipros"))
            {
                semipros =+ extras.getInt("semipros", 0);
            }
            if(extras.containsKey("experts"))
            {
                experts =+ extras.getInt("experts", 0);
            }

            result = "\n\t Novices " + novices + "\n\n";
            result += "\n\t SemiPros " + semipros + "\n\n";
            result += "\n\t Experts " + experts + "\n\n";

            editTextTotals.setText(result);
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
