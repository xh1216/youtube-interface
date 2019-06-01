package com.example.android.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mTopToolbar = findViewById(R.id.top_toolbar);
        setSupportActionBar(mTopToolbar);

        BottomNavigationView navigation = findViewById(R.id.bottom_nav_view);
        navigation.setOnNavigationItemSelectedListener(this);

        FragmentManager fm = getSupportFragmentManager();   //ensure stay in same fragment after rotate
        Fragment fragment = fm.findFragmentById(R.id.main_container);

        if (fragment == null) {
            fragment = new VideoListFragment();
            fm.beginTransaction()
                    .add(R.id.main_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar
        getMenuInflater().inflate(R.menu.top_toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.app_bar_account:
                Intent intent = new Intent(this, AccountActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new VideoListFragment();
                break;

            case R.id.navigation_trending:
                fragment = new TrendingFragment();
                break;

            case R.id.navigation_subscriptions:
                fragment = new SubscriptionsFragment();
                break;

            case R.id.navigation_inbox:
                fragment = new InboxFragment();
                break;

            case R.id.navigation_library:
                fragment = new LibraryFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}