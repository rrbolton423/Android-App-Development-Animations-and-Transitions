package com.example.android.java;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    // As with other types of Animations, you can listen for property animation
    // events by adding listener objects. You do this with the implementations of
    // interfaces before you start the animation.

    private ImageView imageView;
    private RelativeLayout canvas;

    // Create Tag for logging
    public static final String TAG = "AnimationEvents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());

        // Add a AnimatorUpdateListener on the animator to listen
        // to find out where you are in the animation, and what the current value is
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                // Will tell me the current value of the Y-property as the animation is running.
                Log.i(TAG, "onAnimationUpdate: " + animation.getAnimatedValue());
            }
        });

        animator.setRepeatCount(2);

        // Add a AnimatorListener on the animation object to listen for when
        // the animation starts, ends, cancels, or repeats
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i(TAG, "onAnimationRepeat: ");
            }
        });

        animator.start();
    }

}