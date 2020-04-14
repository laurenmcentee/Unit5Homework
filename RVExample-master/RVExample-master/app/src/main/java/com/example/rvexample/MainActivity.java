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
    int[] images = {R.drawable.ahtml5, R.drawable.bcss3,
            R.drawable.cjavascript, R.drawable.djquery,
            R.drawable.ebootstrap, R.drawable.fcsharp,
            R.drawable.gsql, R.drawable.haspnet,
            R.drawable.ijava, R.drawable.jandroid
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAWDProgram = findViewById(R.id.rvAWDProgram);

        s1 = getResources().getStringArray(R.array.it_languages);
        s2 = getResources().getStringArray(R.array.it_language_semesters);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        rvAWDProgram.setAdapter(myAdapter);
        rvAWDProgram.setLayoutManager(new LinearLayoutManager(this));
    }
}
