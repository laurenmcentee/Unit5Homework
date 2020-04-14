package com.example.rvexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvAWDProgram;

    String[] s1;
    String[] s2;
    int[] images = {R.drawable.kingdomhearts1, R.drawable.kingdomhearts2,
            R.drawable.animalcrossing, R.drawable.sms,
            R.drawable.ff7, R.drawable.hzd,
            R.drawable.ff15, R.drawable.overwatch,
            R.drawable.destiny, R.drawable.smashbros
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAWDProgram = findViewById(R.id.rvAWDProgram);

        s1 = getResources().getStringArray(R.array.game_titles);
        s2 = getResources().getStringArray(R.array.game_descriptions);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        rvAWDProgram.setAdapter(myAdapter);
        rvAWDProgram.setLayoutManager(new LinearLayoutManager(this));
    }
}
