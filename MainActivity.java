package com.example.dinorunstartmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startbtn = (Button) findViewById(R.id.startbtn);
        Button instructions = (Button) findViewById(R.id.instbtn);
        Button highscores = (Button) findViewById(R.id.hsbtn);
        Button easy = (Button) findViewById(R.id.easybtn);
        Button hard = (Button) findViewById(R.id.difbtn);
        Button levelback = (Button) findViewById(R.id.backbtn);
        Button inback = (Button) findViewById(R.id.backbtn2);
    }

        public void start(View V){
            setContentView(R.layout.selectpage);
            //startActivity(new Intent(MainActivity.this, MyOtherActivity.class));
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