package com.breaktime.businessman.SaveInfo;

import android.content.SharedPreferences;

import com.breaktime.businessman.R;

public class SavePersonInfo {
    SharedPreferences sharedPreferences;
    String PREF_SHARED_PREFERENCES = "sharedPreferences";
    String PREF_NAME = "name";
    String PREF_IMAGINE = "imagine";
    String PREF_COUNTRY = "country";
    String PREF_GENDER = "gender";

    public SavePersonInfo(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void activeSharedPreferences() {
        String placeToSave = PREF_SHARED_PREFERENCES;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putBoolean(placeToSave, true);
        prefEditor.apply();
    }

    public boolean getActiveSharedPreferences() {
        return sharedPreferences.getBoolean(PREF_SHARED_PREFERENCES, false);
    }

    public void setName(String name) {
        String placeToSave = PREF_NAME;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(placeToSave, name);
        prefEditor.apply();
    }

    public String getName() {
        return sharedPreferences.getString(PREF_NAME, "Player");
    }

    public void setImagine(int imagineId) {
        String placeToSave = PREF_IMAGINE;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, imagineId);
        prefEditor.apply();
    }

    public int getImagine() {
        return sharedPreferences.getInt(PREF_IMAGINE, R.drawable.boy_person1);
    }

    public void setGender(String gender) {
        String placeToSave = PREF_GENDER;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(placeToSave, gender);
        prefEditor.apply();
    }

    public String getGender() {
        return sharedPreferences.getString(PREF_GENDER, "");
    }

    public void setCountry(String country) {
        String placeToSave = PREF_COUNTRY;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(placeToSave, country);
        prefEditor.apply();
    }

    public String getCountry() {
        return sharedPreferences.getString(PREF_COUNTRY, "None");
    }

    public void clear() {
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.clear();
        prefEditor.apply();
    }
}
