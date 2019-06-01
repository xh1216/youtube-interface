package com.example.android.youtube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AccountActivity extends AppCompatActivity {

    String[] accountNav = {"Your channel", "Time watched", "Paid membership", "Switch account", "Turn on Incognito", "Setting", "Help & Feedback"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Toolbar mAccountToolbar = findViewById(R.id.account_toolbar);
        setSupportActionBar(mAccountToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Account");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

        ArrayAdapter mArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item_account_listview, accountNav);
        ListView mListView = findViewById(R.id.account_list_view);
        mListView.setAdapter(mArrayAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
