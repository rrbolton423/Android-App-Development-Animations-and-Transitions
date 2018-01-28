package com.example.android.java;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

        // In order to animate this sort of object, call the animate() method
        // from the View object. It returns a ViewPropertyAnimator object.
        imageView.animate()
                .scaleX(2)
                .scaleY(2)
                .rotationX(180)
                .rotationY(180)
                .translationX(200)
                .translationY(200)
                .setDuration(2000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart: ");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("Animation", "onAnimationEnd: ");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

}