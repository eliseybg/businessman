package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.breaktime.businessman.StocksCreating.GetPoints;
import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.StocksCreating.MyView;
import com.breaktime.businessman.R;

public class Settings extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        new HideNavigation(getWindow());
        linearLayout = findViewById(R.id.linearLayout);
        createPoints();
    }

    public void createPoints(){
        String pointsX = "";
        String pointsY = "";
        int coordinateX = 0;
        int coordinateY = 0;
        for(int i = 0; i < 8; i++){
            coordinateX += 90;
            pointsX += coordinateX + "  ";
            coordinateY += (int)(Math.random() * 180 - 90);
            pointsY += (coordinateY + 400) + "  ";
        }
        GetPoints getPoints = new GetPoints(pointsX, pointsY);
        MyView view = new MyView(this, getPoints.getPoints());
        linearLayout.addView(view);
    }

    public void menu(View view){
        onBackPressed();
    }
}