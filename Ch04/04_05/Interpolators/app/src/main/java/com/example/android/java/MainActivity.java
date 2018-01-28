package com.example.android.java;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);

        // Have a reference to the canvas where I want to draw the animation
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {
        // An Interpolator is a class that modifies an animation using a set
        // of mathematical calculations. Lets say that instead of an object following a
        // path consistently for a requested duration, that you instead want the animation to speed
        // up or slow down at the beginning or end, or perhaps, you want an object to overshoot
        // its target and then slingshot back into place. These are all possible with
        // interpolators. The Android SDK includes a number of pre-defined interpolators,
        // and you can also create your own.

        // Set up the basic animation

        // Get the height of the screen
        int screenHeight = canvas.getHeight();

        // Get the Y coordinate of where I want the image to animate to
        // The goal is to set the bottom of the animation, so that the
        // bottom of the image lands at the bottom of the canvas.
        // I don't want it to go off the screen.
        // TargetY is the distance of how far the image has to go down, without completely being
        // off of the screen
        int targetY = screenHeight - imageView.getHeight();

        // Create an object animator passing
        // 1. Reference to the object I'm animating
        // 2. The name of the property I'm animating
        // 3. The starting value
        // 4. The ending value
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY
        ).setDuration(1000); // Set the duration of the animation

        // Let's say that I really wanted this to be a linear animation.
        // I can do that by using the class "LinearInterpolator"
        // The animation will now run consistently from start to end.
//        animator.setInterpolator(new LinearInterpolator());

        // Anticipating the animation, by first backing up to get a running start,
        // and then I'm overshooting the animation at the end, and bouncing back into place.
        // animator.setInterpolator(new AnticipateOvershootInterpolator());

        // Makes the animation bounce
        animator.setInterpolator(new BounceInterpolator());

        // Start the animation
        animator.start();

        // Interpolators give you a very easy way to modify the behavior of your
        // animations, and when you define your animations using the ObjectAnimator
        // class, it's very easy to add the predefined interpolators to your animation
        // that are included in the Android SDK.
    }
}