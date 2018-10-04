package com.example.abdullahi.funaabpost_graduatehandbook.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.abdullahi.funaabpost_graduatehandbook.R;

public class HandbookPreferences {

    public static int getProgramID(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String preferenceVal = preferences.getString(context.getString(R.string.pref_choose_program_key)
                , context.getString(R.string.pref_program_pgd_value));
        return Integer.parseInt(preferenceVal);
    }

    public static int getFontSize(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String preferenceVal = preferences.getString(context.getString(R.string.pref_choose_font_key)
                , context.getString(R.string.pref_font_normal_value));
        int value = Integer.parseInt(preferenceVal);
        return getSize(value);
    }

     private static int getSize(int prefValue){
        int size = 0;
        switch (prefValue){
            case 1:
                size = 16;
                break;
            case 2:
                size = 20;
                break;
            case 3:
                size = 25;
                break;
            case 4:
                size = 30;
                break;
        }

        return size;
    }

}
