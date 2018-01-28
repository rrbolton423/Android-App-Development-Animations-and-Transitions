package com.example.android.java;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Declare ImageView to hold the animation
    private ImageView imageView;

    // Declare an AnimationDrawable object
    private AnimationDrawable monkeyAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to ImageView
        imageView = (ImageView) findViewById(R.id.animation);

        // Make sure ImageView reference doesn't return null
        if (imageView == null) throw new AssertionError();

        // I will make the ImageView visible when I start the animation,
        // However, when the app starts up, make the ImageView invisible
        imageView.setVisibility(View.INVISIBLE);

        // Attach Animation to the ImageView
        // The background is what's displaying the animation
        imageView.setBackgroundResource(R.drawable.monkey_animation);

        // Get a reference to the monkey animation
        monkeyAnimation = (AnimationDrawable) imageView.getBackground();

        // Make the animation occur once and not repeat
        // I do this when setting up the animation, not starting it
        monkeyAnimation.setOneShot(true);

    }

    // Method executed when the user presses the start button
    public void onStartBtnClick(View v) {

        // Make the ImageView visible
        imageView.setVisibility(View.VISIBLE);

        // Find out whether the animation is actually running
        if (monkeyAnimation.isRunning()) {

            // Stop the animation
            monkeyAnimation.stop();
        }

        // Start the animation
        monkeyAnimation.start();

    }

    // Method executed when the user presses the stop button
    public void onStopBtnClick(View v) {

        // Stop the animation
        monkeyAnimation.stop();
    }

}