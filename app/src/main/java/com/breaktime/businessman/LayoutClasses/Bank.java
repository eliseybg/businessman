package com.breaktime.businessman.LayoutClasses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.breaktime.businessman.Navigation.HideNavigation;
import com.breaktime.businessman.R;
import com.breaktime.businessman.SaveInfo.SaveGameInfo;

public class Bank extends AppCompatActivity {
    String PREFS_FILE = "gameInfo";
    int money, loan, loanSize, deposit, depositSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        new HideNavigation(getWindow());
        setInfo();
    }

    public void takeCredit(View view) {
        if (loan == 0)
            showDialogTakeCredit(getLayoutInflater().inflate(R.layout.dialog_take_loan, null));
        else Toast.makeText(this, "You already have a loan", Toast.LENGTH_SHORT).show();
    }

    public void returnCredit(View view) {
        if (loan != 0 && money != 0)
            showDialogReturnCredit(getLayoutInflater().inflate(R.layout.dialog_return_loan, null));
        if (loan == 0 && money != 0)
            Toast.makeText(this, "You do not have a loan", Toast.LENGTH_SHORT).show();
        if(money == 0)
            Toast.makeText(this, "You do not have money", Toast.LENGTH_SHORT).show();
    }

    public void makeDeposit(View view) {
        if (deposit != depositSize && money != 0)
            showDialogGiveDeposit(getLayoutInflater().inflate(R.layout.dialog_give_deposit, null));
        if (deposit == depositSize && money != 0)
            Toast.makeText(this, "You have reached the deposit limit", Toast.LENGTH_SHORT).show();
        if(money == 0)
            Toast.makeText(this, "You do not have money", Toast.LENGTH_SHORT).show();
    }

    public void takeDeposit(View view) {
        if (deposit != 0)
            showDialogTakeDeposit(getLayoutInflater().inflate(R.layout.dialog_take_deposit, null));
        else Toast.makeText(this, "You do not have a deposit", Toast.LENGTH_SHORT).show();
    }

    AlertDialog alertAnswer;

    void showDialogTakeCredit(final View mView) {
        mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Button btnCancel = mView.findViewById(R.id.cancel);
        Button btnTake = mView.findViewById(R.id.take);
        final SeekBar seekBarLoan = mView.findViewById(R.id.seekBarLoan);
        final TextView textViewCreditSize = mView.findViewById(R.id.creditSize);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertAnswer.cancel();
            }
        });
        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = Integer.parseInt(textViewCreditSize.getText().toString());
                loan += size;
                money += size;
                TextView loanSize = findViewById(R.id.your_loan_size);
                loanSize.setText(loan + " $");
                TextView moneyTextView = findViewById(R.id.money);
                moneyTextView.setText(money + "");
                alertAnswer.cancel();
                saveInfo();
            }
        });

        seekBarLoan.setMax(loanSize);
        seekBarLoan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                textViewCreditSize.setText(seekBar.getProgress() + "");
            }
        });

        builder.setView(mView);
        builder.setCancelable(false);
        alertAnswer = builder.create();
        alertAnswer.setCanceledOnTouchOutside(true);
        alertAnswer.show();
    }

    void showDialogReturnCredit(final View mView) {
        mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Button btnCancel = mView.findViewById(R.id.cancel);
        Button btnTake = mView.findViewById(R.id.take);
        final SeekBar seekBarLoan = mView.findViewById(R.id.seekBarLoan);
        final TextView textViewCreditSize = mView.findViewById(R.id.creditSize);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertAnswer.cancel();
            }
        });
        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int loanReturn = Integer.parseInt(textViewCreditSize.getText().toString());
                money -= loanReturn;
                loan -= loanReturn;
                TextView loanSize = findViewById(R.id.your_loan_size);
                loanSize.setText(loan + " $");
                TextView moneyTextView = findViewById(R.id.money);
                moneyTextView.setText(money + "");
                alertAnswer.cancel();
                saveInfo();
            }
        });

        if (loan > money)
            seekBarLoan.setMax(money);
        else
            seekBarLoan.setMax(loan);
        seekBarLoan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                textViewCreditSize.setText(seekBar.getProgress() + "");
            }
        });

        builder.setView(mView);
        builder.setCancelable(false);
        alertAnswer = builder.create();
        alertAnswer.setCanceledOnTouchOutside(true);
        alertAnswer.show();
    }

    void showDialogGiveDeposit(final View mView) {
        mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Button btnCancel = mView.findViewById(R.id.cancel);
        Button btnTake = mView.findViewById(R.id.take);
        final SeekBar seekBarLoan = mView.findViewById(R.id.seekBarLoan);
        final TextView textViewCreditSize = mView.findViewById(R.id.creditSize);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertAnswer.cancel();
            }
        });
        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int depositGive = Integer.parseInt(textViewCreditSize.getText().toString());
                money -= depositGive;
                deposit += depositGive;
                TextView depositSize = findViewById(R.id.your_deposit_size);
                depositSize.setText(deposit + " $");
                TextView moneyTextView = findViewById(R.id.money);
                moneyTextView.setText(money + "");
                alertAnswer.cancel();
                saveInfo();
            }
        });

        if ((depositSize - deposit) > money)
            seekBarLoan.setMax(money);
        else
            seekBarLoan.setMax(depositSize - deposit);
        seekBarLoan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                textViewCreditSize.setText(seekBar.getProgress() + "");
            }
        });

        builder.setView(mView);
        builder.setCancelable(false);
        alertAnswer = builder.create();
        alertAnswer.setCanceledOnTouchOutside(true);
        alertAnswer.show();
    }

    void showDialogTakeDeposit(final View mView) {
        mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Button btnCancel = mView.findViewById(R.id.cancel);
        Button btnTake = mView.findViewById(R.id.take);
        final SeekBar seekBarLoan = mView.findViewById(R.id.seekBarLoan);
        final TextView textViewCreditSize = mView.findViewById(R.id.creditSize);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertAnswer.cancel();
            }
        });
        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int depositReturn = Integer.parseInt(textViewCreditSize.getText().toString());
                money += depositReturn;
                deposit -= depositReturn;
                TextView loanSize = findViewById(R.id.your_deposit_size);
                loanSize.setText(loan + " $");
                TextView moneyTextView = findViewById(R.id.money);
                moneyTextView.setText(money + "");
                alertAnswer.cancel();
                saveInfo();
            }
        });

        seekBarLoan.setMax(deposit);
        seekBarLoan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                textViewCreditSize.setText(seekBar.getProgress() + "");
            }
        });

        builder.setView(mView);
        builder.setCancelable(false);
        alertAnswer = builder.create();
        alertAnswer.setCanceledOnTouchOutside(true);
        alertAnswer.show();
    }

    public void saveInfo() {
        SaveGameInfo saveGameInfo = new SaveGameInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        saveGameInfo.setMoney(money);
        saveGameInfo.setCredit(loan);
        saveGameInfo.setDeposit(deposit);
    }


    public void setInfo() {
        SaveGameInfo saveGameInfo = new SaveGameInfo(getSharedPreferences(PREFS_FILE, MODE_PRIVATE));
        TextView moneyTextView = findViewById(R.id.money);
        moneyTextView.setText(saveGameInfo.getMoney() + "");
        TextView loanSizeTextView = findViewById(R.id.your_loan_size);
        loanSizeTextView.setText(saveGameInfo.getCredit() + " $");
        TextView loanYouCanTakeSizeTextView = findViewById(R.id.loan_you_can_take_size);
        loanYouCanTakeSizeTextView.setText(saveGameInfo.getLoanSize() + " $");
        TextView loanInterest = findViewById(R.id.loan_interest_size);
        loanInterest.setText(saveGameInfo.getLoanInterest() + " %");
        TextView depositTextView = findViewById(R.id.your_deposit_size);
        depositTextView.setText(saveGameInfo.getDeposit() + " $");
        TextView depositSizeTextView = findViewById(R.id.deposit_you_can_invest);
        depositSizeTextView.setText(saveGameInfo.getDepositSize() + " $");
        TextView depositInterestTextView = findViewById(R.id.deposit_interest_size);
        depositInterestTextView.setText(saveGameInfo.getDepositInterest() + " %");
        money = saveGameInfo.getMoney();
        loan = saveGameInfo.getCredit();
        loanSize = saveGameInfo.getLoanSize();
        deposit = saveGameInfo.getDeposit();
        depositSize = saveGameInfo.getDepositSize();
    }

    public void menu(View view) {
        onBackPressed();
    }

    public void openMoney(View view) {
        Intent intent = new Intent(this, MoneyActivity.class);
        startActivity(intent);
    }
}