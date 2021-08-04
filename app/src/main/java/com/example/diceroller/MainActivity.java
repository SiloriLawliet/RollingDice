package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    ImageView imageView;
    Random randomNumber = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.cardView);
        imageView = findViewById(R.id.image);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinDice(view);
            }
        });


    }
    public void spinDice(View view){
        float pivoitX = (float)imageView.getWidth()/2;
        float pivoitY = (float)imageView.getHeight()/2;
        Animation rotate = new RotateAnimation(0f,1440f,pivoitX,pivoitY);
        rotate.setDuration(2000);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                cardView.setOnClickListener(null);
                changeDice(view);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       spinDice(view);
                    }
                });
                changeDice(view);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cardView.startAnimation(rotate);
    }

    public void changeDice(View view) {
        int randomNum = randomNumber.nextInt(6) + 1;


        switch (randomNum) {
            case 1:
                imageView.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.dice6);
                break;
        }

    }
}