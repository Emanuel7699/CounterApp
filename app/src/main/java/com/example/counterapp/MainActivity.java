package com.example.counterapp;

import static com.google.android.material.color.utilities.MaterialDynamicColors.background;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView welcome_text, counter_text, stop_text;
    Button btn;
    int Counter = 0;
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        counter_text = findViewById(R.id.counter_text);
        welcome_text = findViewById(R.id.welcome_text);
        stop_text = findViewById(R.id.stop_text);


        //Adding the Functionalities
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_text.setText("" + increaseCounter());
                if (Counter%10==0) {
                    Toast.makeText(MainActivity.this, "You have reached number: " + Counter, Toast.LENGTH_SHORT).show();
                    counter_text.setTextColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                }
                if (Counter==100){
                    stop_text.setText("STOP PLEASE");
                }
            }
        });

    }

    public int increaseCounter() {
        return ++Counter;
    }
}