package pranjal.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/*
    We can use shared preferences for the following:-
    1)To check if the user is using the app for the first time
    2)Check when the app was last updated
    3)Remember user credentials
    4)Remember user settings
    5)Remembering what was the user's last location

 */
public class MainActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (EditText)findViewById(R.id.editTextUsername);
        password = (EditText)findViewById(R.id.editTextPassword);

    }

    public void save(View view){
        // we use shared Preferences when we have multiple files...in that case, we need to specify the name
        // if we have only one file then we use getPreferences ( int mode )
        // if we have multiple files then we use getSharedPreferences( String name, int mode)
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        // getting a reference to a shared preferences object
        // the key-value pairs will be stored inside an XML file - Data
        // private mode specifies that only our app can modify the file

        SharedPreferences.Editor editor = sharedPreferences.edit();
        // the editor will enable us to edit the value in the key-value pair

        editor.putString("name", username.getText().toString());
        // we are getting the text object from the username field & then converting it to string
        editor.putString("password", password.getText().toString());

        editor.commit();
        // committing the changes

        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_LONG).show();
        // defining the context, message to be displayed & the length of the toast
    }

    public void newActivity(View view){
        Toast.makeText(this, "New Activity", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, LoadActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
