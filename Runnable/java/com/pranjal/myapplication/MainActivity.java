package com.pranjal.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Initial stage");
        Toast.makeText(MainActivity.this, "This is the first toast", Toast.LENGTH_SHORT).show();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                textView.setText("Delayed stage");
                Toast.makeText(MainActivity.this, "This is the delayed toast after 5 seconds", Toast.LENGTH_SHORT).show();
            }
        }, 5000);
    }
}
