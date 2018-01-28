package com.example.android.java;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // The ValueAnimator class does the hard work of calculating changes over time,
    // but it doesn't directly animate visual objects. You can animate visual objects
    // with this little amount of code from the ObjectAnimator class, a sub class of
    // ValueAnimator.
    // For most animations, you don't need a listener. You just provide a reference to
    // the object you want to animate, and the name of the property you want to change.
    // All of the mechanics of the animation are then handled for you.

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
    }

    // Make the ImageView expand to double in size when I click the button
    public void onButtonClick(View v) {

        // Declare an instance of the ObjectAnimator class
        ObjectAnimator animatorX =
                // Call the ofFloat() method, passing in the object to animate,
                // and then pass in a String representing the property I want to affect.
                // So I'm starting with a  scale of one or 100% of the declared size,
                // and then expanding to twice that size.
                ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 2f)
                .setDuration(1000); // 1 second

        // Now that the the animator object is declared, start it
        animatorX.start();

        // Declare an instance of the ObjectAnimator class
        ObjectAnimator animatorY =
                // Call the ofFloat() method, passing in the object to animate,
                // and then pass in a String representing the property I want to affect.
                // So I'm starting with a  scale of one or 100% of the declared size,
                // and then expanding to twice that size.
                ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 2f)
                        .setDuration(1000); // 1 second

        // Now that the the animator object is declared, start it
        animatorY.start();

        // Both animations are ran simultaneously, the java code is executing in a single thread,
        // so the animations don't actually start until the method execution is complete.
        // Then they do run simultaneously resulting in changing both the horizontal and
        // vertical scale at the same time.

        // Both animations run simultaneously, but it isn't immediately obvious from reading the
        // code that it will. There's a better way of managing multiple simultaneous
        // animations using the "AnimatorSet" class.

    }

}