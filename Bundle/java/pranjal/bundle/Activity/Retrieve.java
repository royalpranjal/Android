package pranjal.bundle.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pranjal.bundle.R;
import pranjal.bundle.Utils.Constants;

public class Retrieve extends AppCompatActivity {

    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        name = (TextView) findViewById(R.id.textViewName);
        email = (TextView) findViewById(R.id.textViewEmail);
    }

    public void retrieve(View view){
        name.setText(getIntent().getExtras().getString(Constants.KEY_NAME));
        email.setText(getIntent().getExtras().getString(Constants.KEY_EMAIL));
    }
}
