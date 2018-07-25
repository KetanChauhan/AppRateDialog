package com.swastik.appratedialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppRateDialog.with(MainActivity.this)
                .setTitle("Rate")
                .setMessage("Enjoying? Rate this app. Thanks for your support!")
                .setRateButtonString("Rate")
                .setRemindButtonString("Not Now!")
                .setNeverButtonString("Never")
                .setNoOfUseInterval(5)
                .setUsageDaysInterval(4)
                //.isDebug(true)
                .isCancellable(false)
                .isToFinishActivity(true)
                .monitor();
    }

    @Override
    public void onBackPressed() {
        AppRateDialog.showDialogIfTimeToShowDialog(MainActivity.this);
        //super.onBackPressed();
    }
}
