package com.swastik.appratedialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import java.util.List;

public class RateManager {
    private PreferenceHelper preferenceHelper;
    public int usedCountThreshold = 3;
    public int usedDaysInterval = 3;
    private static final String GOOGLE_PLAY_LINK = "https://play.google.com/store/apps/details?id=";
    private static final String GOOGLE_PLAY_APP_PACKAGE = "com.android.vending";

    public RateManager(Context context) {
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
        Log.d("AppRateDialog","noOfUsageCount:"+String.valueOf(preferenceHelper.getAppUsedCount()));
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

    public void rateOnStore(Activity activity){
        String packageName = activity.getPackageName();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(GOOGLE_PLAY_LINK + packageName));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if(isPackageExists(activity,GOOGLE_PLAY_APP_PACKAGE)){
            intent.setPackage(GOOGLE_PLAY_APP_PACKAGE);
        }
        Log.d("AppRateDialog","Redirected to link "+GOOGLE_PLAY_LINK + packageName);

        activity.startActivity(intent);
    }

    private boolean isPackageExists(Context context, String targetPackage) {
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if (packageInfo.packageName.equals(targetPackage)){
                return true;
            }
        }
        return false;
    }
}
