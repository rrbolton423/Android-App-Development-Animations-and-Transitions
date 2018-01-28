package com.example.david.transitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    // TAG for logging
    public static final String TAG = "MainActivity";

    // Use to track which scene I am currently displaying
    int mCurrentScene = 1;

    // Declare a couple of Scene objects
    private Scene mScene1, mScene2;

    // Declare a reference to a View Group
    // This will be a reference to the frame layout in the main layout file,
    // and that's where I'm going to be containing the scenes.
    private ViewGroup mSceneRoot;

    // Declare a TransitionManager object
    private TransitionManager mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference to the container for the scenes
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        // Get the reference to the scenes ...
        // Pass the container for the scene, the scene itself, and the context of the app
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, this);
        mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene2, this);

        // Instantiate TransitionManager, passing the transition layout file, and the container
        mManager = TransitionInflater.from(this)
                .inflateTransitionManager(R.transition.manager, mSceneRoot);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_transition) {
            runTransition();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void runTransition() {

        // If the current scene is 1 ...
        if (mCurrentScene == 1) {

            // The TransitionManager's "go()" method uses the default
            // animation / transition, which is a simple fade
            TransitionManager.go(mScene2);

            // Set the current scene to 2
            mCurrentScene = 2;

        } else { // If the current scene is 2 ...

            // Our custom mManager object's "transitionTo()" method
            // follows the train of all the XML definitions defined
            // in the transitionManager XML file
            mManager.transitionTo(mScene1);

            // Set the current scene to 1
            mCurrentScene = 1;
        }
    }

}
