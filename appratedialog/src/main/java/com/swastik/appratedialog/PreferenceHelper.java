package com.swastik.appratedialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Date;

public class PreferenceHelper {
    private static SharedPreferences mPreferences;
    private static Context context;
    private static PreferenceHelper sInstance;

    private static final String IS_FIRST_TIME = "appratedialog_is_first_time";
    private static final String USED_COUNT = "appratedialog_app_used_count";
    private static final String LAST_USED_DATETIME = "appratedialog_app_last_used_datetime";
    private static final String IS_RATED = "appratedialog_is_rated";
    private static final String IS_NEVER_SHOW_DIALOG = "appratedialog_is_never_show_dialog";

    private static final String TICKETS = "tsitcek";

    public PreferenceHelper(final Context context) {
        this.context = context;
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static final PreferenceHelper getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new PreferenceHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public void addAppUsedCount(){
        int old_value = getAppUsedCount();
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(USED_COUNT, old_value + 1);
        editor.apply();
    }

    public void setAppUsedCount(int count){
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(USED_COUNT, count);
        editor.apply();
    }

    public int getAppUsedCount(){
        return mPreferences.getInt(USED_COUNT, 0);
    }

    public void setIsFirstTime(boolean isFirstTime){
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(IS_FIRST_TIME, isFirstTime);
        editor.apply();
    }

    public boolean isFirstTime(){
        return mPreferences.getBoolean(IS_FIRST_TIME,true);
    }

    public void setIsRated(boolean isRated){
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(IS_RATED, isRated);
        editor.apply();
    }

    public boolean isRated(){
        return mPreferences.getBoolean(IS_RATED,false);
    }

    public void setIsNeverShowDialog(boolean isNeverShowDialog){
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(IS_NEVER_SHOW_DIALOG, isNeverShowDialog);
        editor.apply();
    }

    public boolean isNeverShowDialog(){
        return mPreferences.getBoolean(IS_NEVER_SHOW_DIALOG,false);
    }

    public void setLastUsedDatetime(long datetime){
        final SharedPreferences.Editor editor2 = mPreferences.edit();
        editor2.putLong(LAST_USED_DATETIME, datetime);
        editor2.apply();
    }

    public long getLastUsedDatetime(){
        return mPreferences.getLong(LAST_USED_DATETIME,java.util.Calendar.getInstance().getTime().getTime());
    }
}
