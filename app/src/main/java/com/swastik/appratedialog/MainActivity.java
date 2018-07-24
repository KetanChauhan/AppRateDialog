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
                .setMessage("rate this app")
                .setRateButtonString("Rate")
                .setRemindButtonString("Remind")
                .setNeverButtonString("Never")
                //.isDebug(true)
                .isToFinishActivity(true)
                .monitor();
    }

    @Override
    public void onBackPressed() {
        AppRateDialog.showDialogIfTimeToShowDialog(MainActivity.this);
        //super.onBackPressed();
    }
}
