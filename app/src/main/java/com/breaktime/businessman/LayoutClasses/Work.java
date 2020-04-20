package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;
import com.breaktime.businessman.SaveInfo.SavePersonInfo;

public class Work extends AppCompatActivity {
    String PREFS_FILE = "PersonInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        new HideNavigation(getWindow());
        setPerson();
    }

    public void setPerson(){
        SavePersonInfo savePersonInfo = new SavePersonInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        TextView name = findViewById(R.id.name);
        name.setText(savePersonInfo.getName());
        ImageView imageView = findViewById(R.id.imagine_photo);
        imageView.setImageResource(savePersonInfo.getImagine());
    }

    public void menu(View view){
        onBackPressed();
    }
}