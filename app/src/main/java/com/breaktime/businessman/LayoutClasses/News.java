package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        new HideNavigation(getWindow());
    }

    public void menu(View view){
        onBackPressed();
    }
}