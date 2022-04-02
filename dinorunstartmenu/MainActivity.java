package com.example.dinorunstartmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView dino;
    ImageView cactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startbtn = (Button) findViewById(R.id.startbtn);
        Button instructions = (Button) findViewById(R.id.instbtn);
        Button highscores = (Button) findViewById(R.id.hsbtn);
        Button levelback = (Button) findViewById(R.id.backbtn);
        Button inback = (Button) findViewById(R.id.backbtn2);
        AppConstants.initialization(this.getApplicationContext());
        startbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
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

