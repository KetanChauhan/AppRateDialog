AppRateDialog
====
AppRateDialog is an android library to show Rate this app dialog in android app.  

#### Screenshot

#### Features
- Material design dialog.
- Rate, Never and Remind later options.
- Dialog will be shown after given number of app usage or given number of days.
- No need to keep track when to show dialog. Library will track this and show dialog when needed.
- Dialog title, message and button texts can be customized.
- Lightweight library. Easy to use.

## Install
You can include this library in your project using dependency
```
dependencies {
    implementation 'com.swastik.appratedialog:appratedialog:1.1.1'
}
```

## Usage
### Configuration
Add following import statements
```
import com.swastik.appratedialog.AppRateDialog;
import com.swastik.appratedialog.OnDialogShouldNotShowListener;
import com.swastik.appratedialog.OnRateDialogClosedListener;
```

Initialize AppRateDialog in onCreate method of your activity  
```
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
                .setOnRateDialogClosedListener(new OnRateDialogClosedListener() {
                    @Override
                    public void onRateDialogClosed() {
                        Toast.makeText(MainActivity.this,"Rate dialog closed",Toast.LENGTH_SHORT).show();
                        MainActivity.this.finish();
                    }
                })
                .setOnDialogShouldNotShowListener(new OnDialogShouldNotShowListener() {
                    @Override
                    public void onDialogShouldNotShow() {
                        Toast.makeText(MainActivity.this,"Not to show dialog",Toast.LENGTH_SHORT).show();
                        MainActivity.this.finish();
                    }
                })
                .monitor();
    }

    @Override
    public void onBackPressed() {
        
        //super.onBackPressed();
    }
}
```

Show dialog by using following statement:
```
AppRateDialog.showDialogIfTimeToShowDialog(MainActivity.this);
```
This will show dialog if necessary.

### Usage type
This library can be used in two ways:
1. Library will keep track of app usage and will show dialog when required.
Show dialog using this statement
```
AppRateDialog.showDialogIfTimeToShowDialog(MainActivity.this);
```

2. Always show dialog when called.(Ex. always show dialog when button clicked)
Show dialog using this statement
```
AppRateDialog.showDialog(MainActivity.this);
```


