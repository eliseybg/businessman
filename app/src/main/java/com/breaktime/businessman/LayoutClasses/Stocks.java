package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.breaktime.businessman.StocksCreating.GetPoints;
import com.breaktime.businessman.StocksCreating.MyView;
import com.breaktime.businessman.R;

public class Stocks extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        changeLayoutStructure();
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

    public void changeLayoutStructure() {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });

        }
    }

    public void openMoney(View view) {
        Intent intent = new Intent(this, MoneyActivity.class);
        startActivity(intent);
    }
}
