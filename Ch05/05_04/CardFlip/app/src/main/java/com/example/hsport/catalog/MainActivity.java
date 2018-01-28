package com.example.hsport.catalog;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ItemListFragment.ListEventHandler {

    public static final String PRODUCT_ID = "PRODUCT_ID";
    private List<Product> products = DataProvider.productList;
    private AboutFragment aboutFragment;
    private boolean mShowingAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Display list fragment
        ListFragment fragment = new ItemListFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();

//        Display data
        ProductListAdapter adapter = new ProductListAdapter(
                this, R.layout.list_item, products);
        fragment.setListAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                viewAbout();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

        Product product = products.get(position);
        intent.putExtra(PRODUCT_ID, product.getProductId());

        startActivity(intent);
    }

    private void viewAbout() {

        if (mShowingAbout) {
            getFragmentManager().popBackStack();
            mShowingAbout = false;
            return;
        }

        // The steps for using property animations when you're working with fragments
        // is to define your ObjectAnimator objects in XML,
        // and then run the animations as part of the your fragment transaction.

        aboutFragment = new AboutFragment();
        getFragmentManager()
                .beginTransaction()
                // call setCustomsAnimations and pass in references to your 4 animations
                // The setCustomAnimations() method has two versions ...
                // Version 1 takes only 2 animations, but that's how you would use it if
                // you're not using the backstack.
                // If you're using the backstack, you need four animations.
                // 1 for enter, 1 for exit, and 1 for pop enter, and 1 for pop exit.
                // The pop animations happen when you return to the original fragment.
                .setCustomAnimations(
                        // Flips About Fragment card in from the right
                        R.animator.card_flip_right_in,
                        // Flips About Fragment card back out to the right
                        R.animator.card_flip_right_out,
                        // Flips List Fragment card card in from the left (Pop enter) Return to OG fragment
                        R.animator.card_flip_left_in,
                        // Flips List Fragment card back out to the left (Pop exit) Leave OG fragment
                        R.animator.card_flip_left_out)
                .replace(R.id.fragment_container, aboutFragment)
                .addToBackStack(null)
                .commit();
        mShowingAbout = true;
    }

    @Override
    public void onBackPressed() {
        if (mShowingAbout) {
            getFragmentManager().popBackStack();
            mShowingAbout = false;
        } else {
            super.onBackPressed();
        }
    }
}
