package com.swastik.appratedialog;

import android.content.Context;
import android.util.Log;

public class RateManager {
    private Context context;
    private PreferenceHelper preferenceHelper;
    public int usedCountThreshold = 3;
    public int usedDaysInterval = 3;

    public RateManager(Context context) {
        this.context = context;
        this.preferenceHelper = PreferenceHelper.getInstance(context);
    }

    public int getUsedCountThreshold() {
        return usedCountThreshold;
    }

    public void setUsedCountThreshold(int usedCountThreshold) {
        this.usedCountThreshold = usedCountThreshold;
    }

    public int getUsedDaysInterval() {
        return usedDaysInterval;
    }

    public void setUsedDaysInterval(int usedDaysInterval) {
        this.usedDaysInterval = usedDaysInterval;
    }

    public boolean isTimeToShowRateDialog(){
        Log.d("DDDDDDD","count "+String.valueOf(preferenceHelper.getAppUsedCount()));
        if(preferenceHelper.isRated() || preferenceHelper.isNeverShowDialog()){
            return false;
        }

        boolean isToShow = preferenceHelper.getAppUsedCount()>=(usedCountThreshold);
        if(isToShow){
            return true;
        }

        long current = java.util.Calendar.getInstance().getTime().getTime();
        long threshold = preferenceHelper.getLastUsedDatetime()+usedDaysInterval*24*60*60*1000;
        isToShow = current>=threshold;
        return isToShow;
    }

    public void monitor(){
        if(preferenceHelper.isFirstTime()){
            resetUsedTimesCounter();
            preferenceHelper.setIsFirstTime(false);
        }
        preferenceHelper.addAppUsedCount();
    }

    public void setRated(){
        preferenceHelper.setIsRated(true);
    }

    public void resetUsedTimesCounter(){
        preferenceHelper.setAppUsedCount(0);
        preferenceHelper.setLastUsedDatetime(java.util.Calendar.getInstance().getTime().getTime());
    }

    public void setNeverShow() {
        preferenceHelper.setIsNeverShowDialog(true);
    }
}
