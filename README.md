AppRateDialog
====
AppRateDialog is an android library to show Rate this app dialog in android app.  

#### Screenshot
<img src="https://github.com/KetanChauhan/AppRateDialog/blob/master/screenshots/screenshot1.jpg" alt="Screenshot" width="360" height="640"/>

#### Features
- Material design dialog.
- Rate, Never and Remind later options.
- Dialog will be shown after given number of app usage or given number of days.
- No need to keep track when to show dialog. Library will track this and show dialog when needed.
- Dialog title, message and button texts can be customized.
- Lightweight library. Easy to use.

## Install
You can include this library in your project using dependency
```gradle
dependencies {
    implementation 'com.swastik.appratedialog:appratedialog:1.1.1'
}
```

## Usage
### Configuration
Add following import statements
```java
import com.swastik.appratedialog.AppRateDialog;
import com.swastik.appratedialog.OnDialogShouldNotShowListener;
import com.swastik.appratedialog.OnRateDialogClosedListener;
```

Initialize AppRateDialog in onCreate method of your activity  
```java
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
}
```

Show dialog by using following statement:
```java
AppRateDialog.showDialogIfTimeToShowDialog(MainActivity.this);
```
This will show dialog if necessary.

### Usage type
This library can be used in two ways:
1. Library will keep track of app usage and will show dialog when required.
Show dialog using this statement
```java
AppRateDialog.showDialogIfTimeToShowDialog(MainActivity.this);
```

2. Always show dialog when called.(Ex. always show dialog when button clicked)
Show dialog using this statement
```java
AppRateDialog.showDialogDefinitely(MainActivity.this);
```

### Methods and Parameters
Method | Use | Type | Default Value
-------|-----|------|--------------
`setTitle(String title)` or `setTitle(int titleStringId)` | Specifies Title of Rate dialog | optional | "Rate"
`setMessage(String message)` or `setMessage(int messageStringId)` | Specifies Message of Rate dialog | optional | "Enjoying? Rate this app. Thanks for your support!"
`setRateButtonString(String str)` or `setRateButtonString(int strStringId)` | Specifies Rate button(Positive button) string | optional | "Rate"
`setRemindButtonString(String str)` or `setRemindButtonString(int strStringId)` | Specifies Remind button(Neutral button) string | optional | "No"
`setNeverButtonString(String str)` or `setNeverButtonString(int strStringId)` | Specifies Never button(Negative button) string | optional | "Not Now!"
`isShowRemindButton(boolean isShow)`  | Specifies if Remind button should show or not| optional | `true`
`isShowNeverButton(boolean isShow)`  | Specifies if Never button should show or not| optional | `true`
`setNoOfUseInterval(int count)`  | Specifies number of app usage interval when dialog should show | optional | `3`
`setUsageDaysInterval(int interval)` | Specifies number of days interval when dialog should show | optional | `3`
`isCancellable(boolean isCancellable)` | Specifies is dialog cancellable or not | optional | `false`
`isDebug(boolean isDebug)` | This method is useful while development. If `isDebug` is `true`, Rate dialog will be shown every time. In production release, it should be false. | optional | `false`
`setOnRateDialogClosedListener(OnRateDialogClosedListener rateDialogClosedListener)` | Specifies listener which should be called when Rate dialod is closed.(Dialog will be considered closed when Rate, Never or Remind button is pressed or dialog is cancelled) | optional | `null`
`setOnDialogShouldNotShowListener(OnDialogShouldNotShowListener dialogShouldNotShowListener)` | Specifies listener which should be called when Rate dialod is not shown. (This listener will be called only if Rate dialog is not shown.) | optional | `null`
`monitor()` | Monitors app uasge count | required | -

### Sample
Refer a sample app [here](https://github.com/KetanChauhan/AppRateDialog/tree/master/app)

### Contribute
Contribute to make this library better. Issues and Pull requests are welcomed.

## Author
Ketan Chauhan  
Email: chauhanketan73@gmail.com  
Find my android apps on [PlayStore](https://play.google.com/store/apps/dev?id=5259598937394408605) or on [swastikapps.rf.gd](http://www.swastikapps.rf.gd/)

## Lisence
```
Copyright 2018 Ketan Chauhan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
