package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;

public class Balance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        new HideNavigation(getWindow());
    }

    public void menu(View view){
        onBackPressed();
    }

    public void openMoney(View view) {
        Intent intent = new Intent(this, MoneyActivity.class);
        startActivity(intent);
    }
}