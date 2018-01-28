package com.example.android.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
    }

    public void onButtonClick(View v) {

        // Create an Animation object, passing the context
        // and the animation resource file we created
        Animation animation =
                AnimationUtils.loadAnimation(this, R.anim.grow);

        // Add a listener to the animation
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            // Listens to when the animation ends
            @Override
            public void onAnimationEnd(Animation animation) {
                // When the animation is complete, save the new state
                imageView.setScaleX(2);
                imageView.setScaleY(2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // Call the start animation method on the ImageView, passing the animation object
        imageView.startAnimation(animation);
    }

    public void onShrinkBtnClick(View v) {
    }

}