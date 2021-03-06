package com.swastik.appratedialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

public class AppRateDialog {
    private static AppRateDialog rateDialogInstance;
    private Context context;

    private Options options;
    private RateManager rateManager;

    public AppRateDialog(Context context) {
        this.context = context;
        this.options = new Options(context);
        this.rateManager = new RateManager(context);
    }

    public static AppRateDialog with(Context context){
        if(rateDialogInstance==null){
            rateDialogInstance = new AppRateDialog(context);
        }
        return rateDialogInstance;
    }

    public static boolean showDialogIfTimeToShowDialog(Activity activity){
        if(!activity.isFinishing()){
            Log.d("AppRateDialog","Check if to show dialog.");
            return rateDialogInstance.showDialogIfRequired(activity);
        }else {
            Log.d("AppRateDialog","Cannot show AppRateDialog, because acivity has finished.");
            return false;
        }
    }

    private boolean showDialogIfRequired(Activity activity){
        if(rateManager.isTimeToShowRateDialog() || options.isDebug()){
            Log.d("AppRateDialog","show");
            rateDialogInstance.showDialog(activity);
            return true;
        }else {
            Log.d("AppRateDialog","not to show dialog");
            OnDialogShouldNotShowListener dialogShouldNotShowListener = options.getDialogShouldNotShowListener();
            if(dialogShouldNotShowListener!=null){
                dialogShouldNotShowListener.onDialogShouldNotShow();
            }
            return false;
        }
    }

    public static boolean showDialogDefinitely(Activity activity){
        if(!activity.isFinishing()){
            Log.d("AppRateDialog","Check if to show dialog.");
            Log.d("AppRateDialog","Show dialog definitely.");
            rateDialogInstance.showDialog(activity);
            return true;
        }else {
            Log.d("AppRateDialog","Cannot show AppRateDialog, because acivity has finished.");
            return false;
        }
    }

    private void showDialog(Activity activity){
        Dialog dialog = DialogManager.createDialog(activity,options,rateManager);
        dialog.show();
    }

    public AppRateDialog setTitle(String title){
        options.setTitleString(title);
        return rateDialogInstance;
    }
    public AppRateDialog setTitle(int titleId){
        options.setTitleStringId(titleId);
        return rateDialogInstance;
    }

    public AppRateDialog setMessage(String message){
        options.setMessageString(message);
        return rateDialogInstance;
    }
    public AppRateDialog setMessage(int messageId){
        options.setMessageStringId(messageId);
        return rateDialogInstance;
    }


    public AppRateDialog setRateButtonString(String str){
        options.setRateButtonString(str);
        return rateDialogInstance;
    }
    public AppRateDialog setRateButtonString(int strId){
        options.setRateButtonStringId(strId);
        return rateDialogInstance;
    }

    public AppRateDialog setRemindButtonString(String str){
        options.setRemindButtonString(str);
        return rateDialogInstance;
    }
    public AppRateDialog setRemindButtonString(int strId){
        options.setRemindButtonStringId(strId);
        return rateDialogInstance;
    }

    public AppRateDialog setNeverButtonString(String str){
        options.setNeverButtonString(str);
        return rateDialogInstance;
    }
    public AppRateDialog setNeverButtonString(int strId){
        options.setNeverButtonStringId(strId);
        return rateDialogInstance;
    }

    public AppRateDialog isShowRemindButton(boolean isShow){
        options.setShowRemindButton(isShow);
        return rateDialogInstance;
    }
    public AppRateDialog isShowNeverButton(boolean isShow){
        options.setShowNeverButton(isShow);
        return rateDialogInstance;
    }

    public AppRateDialog setNoOfUseInterval(int count){
        options.setUsedCountThreshold(count);
        rateManager.setUsedCountThreshold(count);
        return rateDialogInstance;
    }

    public AppRateDialog setUsageDaysInterval(int interval){
        options.setUsedDaysInterval(interval);
        rateManager.setUsedDaysInterval(interval);
        return rateDialogInstance;
    }

    public AppRateDialog isCancellable(boolean isCancellable){
        options.setCancellable(isCancellable);
        return rateDialogInstance;
    }

    public AppRateDialog isDebug(boolean isDebug){
        options.setDebug(isDebug);
        return rateDialogInstance;
    }

    /*public AppRateDialog isToFinishActivity(boolean isToFinishActivity){
        options.setToFinishActivity(isToFinishActivity);
        return rateDialogInstance;
    }*/

    public AppRateDialog setOnRateDialogClosedListener(OnRateDialogClosedListener rateDialogClosedListener){
        options.setRateDialogClosedListener(rateDialogClosedListener);
        return rateDialogInstance;
    }

    public AppRateDialog setOnDialogShouldNotShowListener(OnDialogShouldNotShowListener dialogShouldNotShowListener){
        options.setDialogShouldNotShowListener(dialogShouldNotShowListener);
        return rateDialogInstance;
    }

    public void monitor(){
        rateManager.monitor();
    }
}
