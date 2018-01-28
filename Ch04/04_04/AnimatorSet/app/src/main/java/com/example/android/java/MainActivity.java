package com.example.android.java;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // With the AnimatorSet class, you can choose to play the animation simultaneously
    // or sequentially, one after the other, and you can implement delays, override durations,
    // and do other things to affect the individual animations within the set.

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
    }

    public void onButtonClick(View v) {

        // Wrap the 2 animator objects in a AnimatorSet
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView,
                "scaleX", 1f, 2f)
                .setDuration(1000);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,
                "scaleY", 1f, 2f)
                .setDuration(1000);

        // After declaring the two animator objects, I'll declare my AnimatorSet object,
        // instantiating it with a no args constructor.
        AnimatorSet set = new AnimatorSet();

        // Call playTogether() method, which allows me to pass in multiple animator objects
        // as independent arguments, allowing the animations to play simultaneously
//        set.playTogether(animatorX, animatorY);

        // If I want the animations to play the animations one after another,
        // I can instead call playSequentially(), executing the animations in
        // the order in which they were provided in the method as arguments.
        set.playSequentially(animatorX, animatorY);

        // Override the duration time of the set animation, making it 3 seconds
        set.setDuration(3000);

        // Start the animation
        set.start();


    }

}