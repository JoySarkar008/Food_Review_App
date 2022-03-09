package com.share.food_review;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CardView recycle_card;
    private TextView mTextMessage;
    private Button loginpageviewbutton;
    private Button profileView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_restaurents:
                    mTextMessage.setText(R.string.title_resturents);
                    return true;
                case R.id.navigation_category:
                    mTextMessage.setText(R.string.title_category);
                    return true;
                case R.id.navigation_user:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle_card = findViewById(R.id.recycle_card);
        recycle_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard_details_view();
            }
        });

        profileView = findViewById(R.id.profile);

        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loginpageviewbutton = findViewById(R.id.loginpageviewbutton);

        loginpageviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void openProfile() {
        Intent intent = new Intent(this, profile.class);
        intent.putExtra("profile", "invisible");
        startActivity(intent);
    }

    private void openLogin() {
        Intent intent= new Intent(this,Login.class);
        intent.putExtra("login" , "invisible");
        startActivity(intent);
    }

    private void openCard_details_view() {
        Intent intent= new Intent(this,Card_details_view.class);
        intent.putExtra("recycle_card" , "invisible");
        startActivity(intent);
    }

}
