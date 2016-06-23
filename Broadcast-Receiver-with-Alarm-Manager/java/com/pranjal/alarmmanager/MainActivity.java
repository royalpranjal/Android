package com.pranjal.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer i = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        textView = (TextView) findViewById(R.id.textView);
        repeatedTask();
    }

    public void repeatedTask(){
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                i++;
                Toast.makeText(MainActivity.this, "Repeated toast : " + i, Toast.LENGTH_SHORT).show();
                textView.setText("Repeated : " + i);
            }
        };

        //Register the receiver in the manifest also

        // intent filters specify the types of intent that the broadcasts, activity & services can respond to
        IntentFilter filter = new IntentFilter("com.pranjal.alarmmanager");
        // registering the receiver so that we can send broadcasts that match the filter we have set
        this.registerReceiver(receiver, filter);

        Intent intent = new Intent("com.pranjal.alarmmanager");
        // getBroadcast(context, request code, intent, flags)
        // retrieving a pending intent that will perform the broadcast
        // Pending intent is a description of an intent & the action that should be performed with it
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

        // Alarm Manager allows us to schedule the application
        AlarmManager alarmManager = (AlarmManager)(this.getSystemService(Context.ALARM_SERVICE));
        // Schedule a repeating alarm by specifying the operation to be performed with it
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, 0, 60000, pendingIntent);
        // ELAPSED_REALTIME_WAKEUP wakes up the device if it goes off
    }
}
