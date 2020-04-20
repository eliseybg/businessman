package com.breaktime.businessman.SaveInfo;

import android.content.SharedPreferences;

public class SaveGameInfo {
    SharedPreferences sharedPreferences;

    String PREF_MONEY = "money";
    String PREF_HAPPINESS = "happiness";
    String PREF_HEALTH = "health";



    String PREF_BANK_CREDIT = "credit";
    String PREF_BANK_CREDIT_SIZE = "creditSize";
    String PREF_BANK_CREDIT_INTEREST = "creditInterest";
    String PREF_BANK_CREDIT_LINE = "creditLine";
    String PREF_BANK_DEPOSIT = "deposit";
    String PREF_BANK_DEPOSIT_SIZE = "depositSize";
    String PREF_BANK_DEPOSIT_INTEREST = "depositInterest";

    public SaveGameInfo(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setMoney(int money) {
        String placeToSave = PREF_MONEY;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, money);
        prefEditor.apply();
    }

    public int getMoney() {
        return sharedPreferences.getInt(PREF_MONEY, 10000);
    }

    public void setHappiness(int money) {
        String placeToSave = PREF_HAPPINESS;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, money);
        prefEditor.apply();
    }

    public int getHappiness() {
        return sharedPreferences.getInt(PREF_HAPPINESS, 100);
    }

    public void setHealth(int money) {
        String placeToSave = PREF_HEALTH;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, money);
        prefEditor.apply();
    }

    public int getHealth() {
        return sharedPreferences.getInt(PREF_HEALTH, 100);
    }

    public void setCredit(int credit){
        String placeToSave = PREF_BANK_CREDIT;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, credit);
        prefEditor.apply();
    }

    public int getCredit(){
        return sharedPreferences.getInt(PREF_BANK_CREDIT, 0);
    }

    public void setLoanSize(int creditSize){
        String placeToSave = PREF_BANK_CREDIT_SIZE;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, creditSize);
        prefEditor.apply();
    }

    public int getLoanSize(){
        return sharedPreferences.getInt(PREF_BANK_CREDIT_SIZE, 40000);
    }

    public void setLoanInterest(){
        String placeToSave = PREF_BANK_CREDIT_INTEREST;
        int creditInterest = (int)(Math.random() * 12 + 5);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, creditInterest);
        prefEditor.apply();
    }

    public int getLoanInterest(){
        return sharedPreferences.getInt(PREF_BANK_CREDIT_INTEREST, 5);
    }


    public void setCreditLine(int creditLine){
        String placeToSave = PREF_BANK_CREDIT_LINE;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, creditLine);
        prefEditor.apply();
    }

    public int getCreditLine(){
        return sharedPreferences.getInt(PREF_BANK_CREDIT_LINE, 0);
    }

    public void setDeposit(int deposit){
        String placeToSave = PREF_BANK_DEPOSIT;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, deposit);
        prefEditor.apply();
    }

    public int getDeposit(){
        return sharedPreferences.getInt(PREF_BANK_DEPOSIT, 0);
    }

    public void setDepositSize(int depositSize){
        String placeToSave = PREF_BANK_DEPOSIT_SIZE;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, depositSize);
        prefEditor.apply();
    }

    public int getDepositSize(){
        return sharedPreferences.getInt(PREF_BANK_DEPOSIT_SIZE, 40000);
    }

    public void setDepositInterest(){
        String placeToSave = PREF_BANK_DEPOSIT_INTEREST;
        int depositInterest = (int)(Math.random() * 6 + 3);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, depositInterest);
        prefEditor.apply();
    }

    public int getDepositInterest(){
        return sharedPreferences.getInt(PREF_BANK_DEPOSIT_INTEREST, 3);
    }

}
