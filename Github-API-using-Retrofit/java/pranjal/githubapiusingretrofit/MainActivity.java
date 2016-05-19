package pranjal.githubapiusingretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pranjal.githubapiusingretrofit.API.GithubAPI;
import pranjal.githubapiusingretrofit.Model.GithubModel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txt;
    EditText edt;
    String BaseURL = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.buttonRetrieve);
        txt = (TextView)findViewById(R.id.textViewRetrieve);
        edt = (EditText)findViewById(R.id.editTextUsername);

    }

    public void Retrieve(View v){
        String user = edt.getText().toString();

        // creating an adapter for retrofit with base URL
        RestAdapter adapter = new RestAdapter
                .Builder()
                .setEndpoint(BaseURL)
                .build();

        // creating a service for our adaptor with out GET class
        GithubAPI api = adapter.create(GithubAPI.class);

        Toast.makeText(MainActivity.this, "Adapter Created", Toast.LENGTH_SHORT).show();

        api.getFeed(user, new Callback <GithubModel>() {
            @Override
            public void success(GithubModel githubModel, Response response){
                // getting JSON object from the server to our POJO class or Model class
                txt.setText("Github name : " + githubModel.getName()
                + " Github email : " + githubModel.getEmail());
                Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                txt.setText(error.getMessage());
                Toast.makeText(MainActivity.this,"Failure", Toast.LENGTH_LONG).show();
            }
        });
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
