package pranjal.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificationBHEJ(View view){
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int)System.currentTimeMillis(), intent, 0);
        // an object is returned to the pending intent. Each pending intent has a base intent
        // 0 if for the flags for the pending intent

        Notification not = new Notification
                .Builder(this)
                .setContentTitle("Test Notification")
                .setContentText("This is a text notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE   )
                .setContentIntent(pIntent)
                .setAutoCancel(false)
                .addAction(R.mipmap.ic_launcher, "Call", pIntent)
                .addAction(R.mipmap.ic_launcher, "Call", pIntent)
                .addAction(R.mipmap.ic_launcher, "Call", pIntent)
                .build();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // getSystemService(Class) is used to retrieve an Accessibility Manager for giving the user feedback for
        // UI events through registered event listeners

        // hide the notification after it is selected
        not.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, not);
    }
}
