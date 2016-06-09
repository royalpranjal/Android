package pranjal.bundle.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import pranjal.bundle.R;
import pranjal.bundle.Utils.Constants;

public class MainActivity extends AppCompatActivity {

    private EditText name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmail);

        name.setHint("Enter your name");
        email.setHint("Enter your email");
    }

    public void save(View view){
        Bundle passToNextActivity = new Bundle();
        passToNextActivity.putString(Constants.KEY_NAME, name.getText().toString());
        passToNextActivity.putString(Constants.KEY_EMAIL, email.getText().toString());

        Intent toNewActivity = new Intent(MainActivity.this, Retrieve.class);
        toNewActivity.putExtras(passToNextActivity);
        startActivity(toNewActivity);
    }

}
