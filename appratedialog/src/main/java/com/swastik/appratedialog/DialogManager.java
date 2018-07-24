package com.swastik.appratedialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class DialogManager {

    public static Dialog createDialog(final Activity activity, final Options options, final RateManager rateManager){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle(options.getTitle());
        builder.setMessage(options.getMessage());
        builder.setCancelable(options.isCancellable());

        builder.setPositiveButton(options.getRateButtonString(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int whichButton) {
                rateManager.setRated();
                if(options.isToFinishActivity()){
                    activity.finish();
                }
            }
        });
        if(options.isShowNeverButton()){
            builder.setNegativeButton(options.getNeverButtonString(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    rateManager.setNeverShow();
                    if(options.isToFinishActivity()){
                        activity.finish();
                    }
                }
            });
        }
        if(options.isShowRemindButton()){
            builder.setNeutralButton(options.getRemindButtonString(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    rateManager.resetUsedTimesCounter();
                    if(options.isToFinishActivity()){
                        activity.finish();
                    }
                }
            });
        }

        return builder.create();
    }


}
