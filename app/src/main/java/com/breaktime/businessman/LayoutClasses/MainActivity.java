package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;
import com.breaktime.businessman.SaveInfo.SavePersonInfo;

public class MainActivity extends AppCompatActivity {
    String PREFS_FILE = "PersonInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HideNavigation(getWindow());

    }

    AlertDialog alertAnswer;
    Context context = this;
    void showDialog(View mView) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Button btnCancel = mView.findViewById(R.id.back);
        Button btnNewGame = mView.findViewById(R.id.newGame);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertAnswer.cancel();
            }
        });
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CreatePerson.class);
                startActivity(intent);
                alertAnswer.cancel();
            }
        });

        builder.setView(mView);
        builder.setCancelable(false);
        alertAnswer = builder.create();
        alertAnswer.show();
    }

    public void newGame(View v) {
        if(!getPreviousGame()) {
            Intent intent = new Intent(this, CreatePerson.class);
            startActivity(intent);
        }
        else {
            View mView = getLayoutInflater().inflate(R.layout.dialog_new_game, null);
            showDialog(mView);
        }
    }

    public boolean getPreviousGame(){
        SavePersonInfo savePersonInfo = new SavePersonInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        return savePersonInfo.getActiveSharedPreferences();
    }

    public void resumeGame(View v) {
        if(getPreviousGame()) {
            Intent intent = new Intent(this, PlayGame.class);
            startActivity(intent);
        }
        else {
            View mView = getLayoutInflater().inflate(R.layout.dialog_continue, null);
            showDialog(mView);
        }
    }

    public void openSettings(View v) {

    }

    public void exit(View v) {
        finish();
    }
}
