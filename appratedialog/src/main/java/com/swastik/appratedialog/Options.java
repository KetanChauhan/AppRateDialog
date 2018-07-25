package com.swastik.appratedialog;

import android.content.Context;

public class Options {
    private Context context;

    //options
    private int usedCountThreshold = 3;
    private int usedDaysInterval = 3;
    private boolean isCancellable = false;
    private boolean isDebug = false;
    private boolean isToFinishActivity = false;

    //title and message
    private String titleString = null;
    private String messageString = null;
    private int titleStringId = R.string.appratedialog_title;
    private int messageStringId = R.string.appratedialog_message;

    //buttons
    private String rateButtonString = null;
    private String remindButtonString = null;
    private String neverButtonString = null;
    private int rateButtonStringId = R.string.appratedialog_rate;
    private int remindButtonStringId = R.string.appratedialog_remind;
    private int neverButtonStringId = R.string.appratedialog_never;

    private boolean isShowRemindButton = true;
    private boolean isShowNeverButton = true;

    public Options(Context context) {
        this.context = context;
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

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        isCancellable = cancellable;
    }

    public String getTitle() {
        if(titleString==null){
            return context.getString(titleStringId);
        }else {
            return titleString;
        }
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
    }

    public String getMessage() {
        if(messageString==null){
            return context.getString(messageStringId);
        }else {
            return messageString;
        }
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public void setTitleStringId(int titleStringId) {
        this.titleStringId = titleStringId;
    }

    public void setMessageStringId(int messageStringId) {
        this.messageStringId = messageStringId;
    }

    public String getRateButtonString() {
        if(rateButtonString==null){
            return context.getString(rateButtonStringId);
        }else {
            return rateButtonString;
        }
    }

    public void setRateButtonString(String rateButtonString) {
        this.rateButtonString = rateButtonString;
    }

    public String getRemindButtonString() {
        if(remindButtonString==null){
            return context.getString(remindButtonStringId);
        }else {
            return remindButtonString;
        }
    }

    public void setRemindButtonString(String remindButtonString) {
        this.remindButtonString = remindButtonString;
    }

    public String getNeverButtonString() {
        if(neverButtonString==null){
            return context.getString(neverButtonStringId);
        }else {
            return neverButtonString;
        }
    }

    public void setNeverButtonString(String neverButtonString) {
        this.neverButtonString = neverButtonString;
    }

    public void setRateButtonStringId(int rateButtonStringId) {
        this.rateButtonStringId = rateButtonStringId;
    }

    public void setRemindButtonStringId(int remindButtonStringId) {
        this.remindButtonStringId = remindButtonStringId;
    }

    public void setNeverButtonStringId(int neverButtonStringId) {
        this.neverButtonStringId = neverButtonStringId;
    }

    public boolean isShowRemindButton() {
        return isShowRemindButton;
    }

    public void setShowRemindButton(boolean showRemindButton) {
        isShowRemindButton = showRemindButton;
    }

    public boolean isShowNeverButton() {
        return isShowNeverButton;
    }

    public void setShowNeverButton(boolean showNeverButton) {
        isShowNeverButton = showNeverButton;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    public boolean isToFinishActivity() {
        return isToFinishActivity;
    }

    public void setToFinishActivity(boolean toFinishActivity) {
        isToFinishActivity = toFinishActivity;
    }
}
