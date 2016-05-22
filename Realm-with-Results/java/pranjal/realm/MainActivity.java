package pranjal.realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import pranjal.realm.API.githubAPI;
import pranjal.realm.Database.User;
import pranjal.realm.Model.githubModel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.github.com";
    TextView id, followers;
    EditText username;

    private Realm realm;

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (TextView)findViewById(R.id.textViewId);
        followers = (TextView)findViewById(R.id.textViewFollowers);
        username = (EditText)findViewById(R.id.editTextUsername);
        user = username.getText().toString().trim();

        // Realm
        realm = Realm.getInstance(this);
    }

    protected void Save(View v){
        // Retrofit
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        githubAPI api = adapter.create(githubAPI.class);

        api.getFeed(user, new Callback<githubModel>(){
            @Override
            public void success(githubModel githubModel, Response response) {
                realm.beginTransaction();
                User userTab = realm.createObject(User.class);
                userTab.setId(githubModel.getId().toString().trim());
                userTab.setFollowers(githubModel.getFollowers());
                userTab.setName(githubModel.getLogin().toString().trim());
                realm.commitTransaction();
                /*
                cancel a transaction by realm.cancelTransaction()
                 */

                Toast.makeText(MainActivity.this, "Save Successful", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Id : " + userTab.getId() + "\n"
                + "Followers : " + userTab.getFollowers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void Retrieve(View v){
        RealmResults<User> results = realm.where(User.class).findAll();

        User u = results.get(0);
        id.setText(u.getId());
        followers.setText(u.getFollowers());
        Toast.makeText(MainActivity.this, "Retrieve Successful", Toast.LENGTH_LONG).show();
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
