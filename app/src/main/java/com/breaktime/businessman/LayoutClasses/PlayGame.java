package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;
import com.breaktime.businessman.SaveInfo.SaveGameInfo;

public class PlayGame extends AppCompatActivity {
    static int counter = 0;
    String PREFS_FILE = "gameInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        new HideNavigation(getWindow());
        setHealthAndHappiness();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setMoney();
    }

    public void setMoney(){
        SaveGameInfo saveGameInfo = new SaveGameInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        TextView money = findViewById(R.id.money);
        money.setText(String.valueOf(saveGameInfo.getMoney()));
    }

    public void setHealthAndHappiness(){
        SaveGameInfo saveGameInfo = new SaveGameInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        ProgressBar progressBarHappiness = findViewById(R.id.happiness_progress_bar);
        int happiness = saveGameInfo.getHappiness();
        progressBarHappiness.setProgress(happiness);
        if(happiness >= 60) {
            progressBarHappiness.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }
        if(happiness > 20 && happiness < 60) {
            progressBarHappiness.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        }
        if(happiness <= 20) {
            progressBarHappiness.setProgressTintList(ColorStateList.valueOf(Color.RED));
        }
        ProgressBar progressBarHealth = findViewById(R.id.health_progress_bar);

        int health = saveGameInfo.getHealth();
        progressBarHealth.setProgress(health);
        if(health >= 60) {
            progressBarHealth.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }
        if(health > 20 && health < 60) {
            progressBarHealth.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        }
        if(health <= 20) {
            progressBarHealth.setProgressTintList(ColorStateList.valueOf(Color.RED));
        }
    }

    public void openWork(View view){
        Intent intent = new Intent(this, Work.class);
        startActivity(intent);
    }

    public void openStocks(View view){
        Intent intent = new Intent(this, Stocks.class);
        startActivity(intent);
    }

    public void openBank(View view){
        Intent intent = new Intent(this, Bank.class);
        startActivity(intent);
    }

    public void openCasino(View view){
        Intent intent = new Intent(this, Casino.class);
        startActivity(intent);
    }

    public void openBusiness(View view){
        Intent intent = new Intent(this, Business.class);
        startActivity(intent);
    }

    public void openNews(View view){
        Intent intent = new Intent(this, News.class);
        startActivity(intent);
    }

    public void openBalance(View view){
        Intent intent = new Intent(this, Balance.class);
        startActivity(intent);
    }

    public void openShop(View view){
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
    }

    public void openStudy(View view){
        Intent intent = new Intent(this, Study.class);
        startActivity(intent);
    }

    public void openHouse(View view){
        Intent intent = new Intent(this, House.class);
        startActivity(intent);
    }

    public void openCar(View view){
        Intent intent = new Intent(this, Car.class);
        startActivity(intent);
    }

    public void openOffers(View view){
        Intent intent = new Intent(this, Offers.class);
        startActivity(intent);
    }

    public void openHealth(View view){
        Intent intent = new Intent(this, Health.class);
        startActivity(intent);
    }

    public void openRejoice(View view){
        Intent intent = new Intent(this, Rejoice.class);
        startActivity(intent);
    }

    public void openPerson(View view){
        Intent intent = new Intent(this, Person.class);
        startActivity(intent);
    }

    public void openFines(View view){
        Intent intent = new Intent(this, Fines.class);
        startActivity(intent);
    }

    public void arrowPressed(View view){
        counter++;
        setGrid();
    }

    public void nextStep(View view){

    }

    public void setGrid(){
        if(counter % 2 == 1){
            findViewById(R.id.grid1).setVisibility(View.GONE);
            findViewById(R.id.grid2).setVisibility(View.VISIBLE);
        }
        else {
            findViewById(R.id.grid1).setVisibility(View.VISIBLE);
            findViewById(R.id.grid2).setVisibility(View.GONE);
        }
    }

    public void openMenu(View v) {
        onBackPressed();
    }

    public void openMoney(View view) {
        Intent intent = new Intent(this, MoneyActivity.class);
        startActivity(intent);
    }
}