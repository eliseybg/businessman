package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;

public class MoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        new HideNavigation(getWindow());

    }

    public void menu(View view){
        onBackPressed();
    }

    public void add(View view) {
        Button add = findViewById(R.id.add);

        if(true){
            add.setSelected(true);
            add.setClickable(false);
        }
    }

    public void instagram(View view) {
        Button instagram = findViewById(R.id.instagram);

        if(false){
            instagram.setSelected(true);
            instagram.setClickable(false);
        }
    }

    public void rate(View view) {
        Button rate = findViewById(R.id.rate);

        if(false){
            rate.setSelected(true);
            rate.setClickable(false);
        }
    }
}