package com.example.david.viewpager.transformers;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by romellbolton on 1/26/18.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {

    // As the user swipes from side to side, each time something changes in
    // the position of the user's touch, the transformPage() method will be called.
    // It's up to the developer to look at the page's position and other state and change it.

    private static final float MIN_SCALE = 0.75f;

    public static final String TAG = "PageTransformer";

    // The ViewPagerTransformations are executed by looking at the current state
    // of the page and then changing it each time the transformPage() method is
    // called.
    public void transformPage(View view, float position) {

        Log.i(TAG, "transformPage: ");

        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}