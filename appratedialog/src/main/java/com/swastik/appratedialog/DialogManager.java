package com.swastik.appratedialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;

public class DialogManager {

    public static Dialog createDialog(final Activity activity, final Options options, final RateManager rateManager){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle(options.getTitle());
        builder.setMessage(options.getMessage());
        builder.setCancelable(options.isCancellable());

        builder.setPositiveButton(options.getRateButtonString(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int whichButton) {
                Log.d("AppRateDialog","Rate button clicked.");
                rateManager.rateOnStore(activity);
                rateManager.setRated();
                if(options.isToFinishActivity()){
                    Log.d("AppRateDialog","Finishing activity...");
                    activity.finish();
                }
            }
        });
        if(options.isShowNeverButton()){
            builder.setNegativeButton(options.getNeverButtonString(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.d("AppRateDialog","Never button clicked.");
                    rateManager.setNeverShow();
                    if(options.isToFinishActivity()){
                        Log.d("AppRateDialog","Finishing activity...");
                        activity.finish();
                    }
                }
            });
        }
        if(options.isShowRemindButton()){
            builder.setNeutralButton(options.getRemindButtonString(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.d("AppRateDialog","Remind button clicked.");
                    rateManager.resetUsedTimesCounter();
                    if(options.isToFinishActivity()){
                        Log.d("AppRateDialog","Finishing activity...");
                        activity.finish();
                    }
                }
            });
        }
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.d("AppRateDialog","Dialog dismissed.");
                if(options.isToFinishActivity()){
                    Log.d("AppRateDialog","Finishing activity...");
                    activity.finish();
                }
            }
        });

        return builder.create();
    }
}
