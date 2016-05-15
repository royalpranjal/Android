package pranjal.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoadActivity extends AppCompatActivity {

    TextView username, password;
    private static final String DEFAULT = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (TextView)findViewById(R.id.textViewUSernameLoad);
        password = (TextView)findViewById(R.id.textViewPasswordLoad);
    }

    public void Load(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        // getting a reference to the shared preferences object in private mode on file Data

        String name = sharedPreferences.getString("name", DEFAULT);
        String passowrd = sharedPreferences.getString("password", DEFAULT);

        username.setText(name);
        password.setText(passowrd);

        if(name.equals(DEFAULT) || passowrd.equals(DEFAULT)){
            Toast.makeText(LoadActivity.this, "No Data was found", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(LoadActivity.this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void Home(View view){
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoadActivity.this, MainActivity.class);
        startActivity(i);
    }

}
