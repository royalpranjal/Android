package com.pranjal.devicestatus;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private KeyguardManager myKM;
    private NotificationManager notificationManager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        getSupportActionBar().hide();
        textView.setText("You have 5 seconds. You may lock the device to check");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean check = checkScreenLocked();
                if(check){
                    Notification not = new Notification
                            .Builder(MainActivity.this)
                            .setContentTitle("Locked device")
                            .setContentText("Your device was locked")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setPriority(Notification.PRIORITY_MAX)
                            .setDefaults(Notification.DEFAULT_VIBRATE)
                            .setAutoCancel(false)
                            .build();

                    notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    // getSystemService(Class) is used to retrieve an Accessibility Manager for giving the user feedback for
                    // UI events through registered event listeners

                    // hide the notification after it is selected
                    not.flags |= Notification.FLAG_AUTO_CANCEL;
                    notificationManager.notify(0, not);
                    textView.setText("Your device was locked");
                }
                else{
                    textView.setText("Device is not locked");
                }
            }
        }, 5000);

    }

    public boolean checkScreenLocked() {
        myKM = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);
        if (myKM.inKeyguardRestrictedInputMode()) {
            //it is locked
            return true;
        }
        return false;
    }
}
