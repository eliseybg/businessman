package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;
import com.breaktime.businessman.SaveInfo.SaveGameInfo;
import com.breaktime.businessman.SaveInfo.SavePersonInfo;

public class CreatePerson extends AppCompatActivity {
    private static int arrowCounter = 0;
    private boolean isBoy = true, isGirl;
    private LinearLayout LinerLBoy, LinerLGirl;
    ImageView imageView;
    int girlPhotos[] = {R.drawable.girl_person1, R.drawable.girl_person2, R.drawable.girl_person3, R.drawable.girl_person4, R.drawable.girl_person5};
    int boyPhotos[] = {R.drawable.boy_person1, R.drawable.boy_person2, R.drawable.boy_person3, R.drawable.boy_person4, R.drawable.boy_person5};
    String PREFS_FILE = "PersonInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);
        new HideNavigation(getWindow());
        setListeners();
    }

    public void saveInfo(String name, String country, int imagine, String gender){
        SavePersonInfo savePersonInfo = new SavePersonInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        savePersonInfo.setName(name);
        savePersonInfo.setCountry(country);
        savePersonInfo.setImagine(imagine);
        savePersonInfo.setGender(gender);
        savePersonInfo.activeSharedPreferences();
        new SaveGameInfo(getSharedPreferences("gameInfo", MODE_PRIVATE)).setLoanInterest();
        new SaveGameInfo(getSharedPreferences("gameInfo", MODE_PRIVATE)).setDepositInterest();
    }

    public void leftArrow(View view){
        arrowCounter--;
        if(arrowCounter < 0)
            arrowCounter = boyPhotos.length - 1;
        setImage();
    }

    public void rightArrow(View view){
        arrowCounter++;
        if(arrowCounter > boyPhotos.length - 1)
            arrowCounter = 0;
        setImage();
    }

    public void setImage(){
        if(isBoy) {
            imageView.setBackground(null);
            imageView.setImageResource(boyPhotos[arrowCounter]);
        }
        if(isGirl) {
            imageView.setBackground(null);
            imageView.setImageResource(girlPhotos[arrowCounter]);
        }
    }

    public void setListeners(){
        LinerLBoy = findViewById(R.id.linear_boy);
        LinerLGirl = findViewById(R.id.linear_girl);
        imageView = findViewById(R.id.imageView);
    }

    public void setGirl(View view){
        isBoy = false;
        isGirl = true;
        arrowCounter = 0;
        LinerLBoy.setBackgroundColor(Color.parseColor("#F6F6F6"));
        LinerLGirl.setBackgroundColor(Color.GRAY);
        setImage();
    }

    public void setBoy(View view){
        isBoy = true;
        isGirl = false;
        arrowCounter = 0;
        LinerLGirl.setBackgroundColor(Color.parseColor("#F6F6F6"));
        LinerLBoy.setBackgroundColor(Color.GRAY);
        setImage();
    }

    public void menu(View view){
        onBackPressed();
    }

    public void startGame(View view){
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextCountry= findViewById(R.id.editTextCountry);
        String name = editTextName.getText().toString().trim();
        String country = editTextCountry.getText().toString().trim();
        if(name.length() != 0 && country.length() != 0) {
            int image = 0;
            String gender = "";
            if(isBoy) {
                gender = "boy";
                image = boyPhotos[arrowCounter];
            }
            if(isGirl) {
                gender = "girl";
                image = girlPhotos[arrowCounter];
            }
            saveInfo(name, country, image, gender);
            onBackPressed();
            Intent intent = new Intent(this, PlayGame.class);
            startActivity(intent);
        }
        else Toast.makeText(this, "Add name and country", Toast.LENGTH_SHORT).show();
    }

//    в бд картику, имя, страну
}