package com.example.dinorunstartmenu;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView dino;
    ImageView cactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startbtn = (Button) findViewById(R.id.startbtn);
        AppConstants.initialization(this.getApplicationContext());
        startbtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void instructions(View V){
        setContentView(R.layout.instructionspage);
        //startActivity(new Intent(MainActivity.this, MyOtherActivity.class));
    }

    public void back(View V){
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(MainActivity.this, MyOtherActivity.class));
    }


}

