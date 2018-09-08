package com.example.abdullahi.funaabpost_graduatehandbook.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.abdullahi.funaabpost_graduatehandbook.R;

public class Program {

    public static int getProgramID(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String preferenceVal = preferences.getString(context.getString(R.string.pref_choose_program_key)
                , context.getString(R.string.pref_program_pgd_value));
        return Integer.parseInt(preferenceVal);
    }


}
