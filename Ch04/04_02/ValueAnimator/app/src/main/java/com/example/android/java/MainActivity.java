package com.example.android.java;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScrollView mScroll;
    private TextView mLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Initialize the logging components
        mScroll = (ScrollView) findViewById(R.id.scrollLog);
        mLog = (TextView) findViewById(R.id.tvLog);
        mLog.setText("");

    }

    public void onRunBtnClick(View v) {
        // The ValueAnimator doesn't animate visual objects. Instead, the class figures
        // out the changes in a value over some duration,
        // and reports those changes to an updateListener object.
        // It's up to me to the developer to listen for the updates and react.

        // Create an instance of the ValueAnimator class
        // ofFloat() needs at least 2 values, which will serve as the starting
        // and ending values for the animation
        ValueAnimator animator = ValueAnimator
                .ofFloat(1f, 20f) // starting and ending values for animation
                .setDuration(2000); // 2000 milliseconds = 2 seconds

        // Before running the animation, listen for updates
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                displayMessage(
                        // This will return an integer values representing the number of
                        // milliseconds since the animation started.
                        "timestamp: " + animation.getCurrentPlayTime() +
                        // Value of the animation at this specific timestamp
                        ", value: " + animation.getAnimatedValue());
            }
        });

        // Set a repeat on the animation, in a infinite loop
        animator.setRepeatCount(ValueAnimator.INFINITE);

        // For each animation, it will go forward, and then back
//        animator.setRepeatMode(ValueAnimator.REVERSE);

        // Start the animation
        animator.start();
    }

    public void onClearBtnClick(View v) {
        mLog.setText("");
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    public void displayMessage(String message) {
        mLog.append(message + "\n");
        mScroll.scrollTo(0, mScroll.getBottom());
    }
}