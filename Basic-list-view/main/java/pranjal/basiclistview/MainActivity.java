package pranjal.basiclistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        listItemOnClickListener();

    }

    private void populateListView() {
        // creating the list
        String[] items = {"blue", "red", "green", "pink", "blue", "red", "green", "pink",
                "blue", "red", "green", "pink", "blue", "red", "green", "pink",
                "blue", "red", "green", "pink", "blue", "red", "green", "pink",
                "blue", "red", "green", "pink", "blue", "red", "green", "pink",
                "blue", "red", "green", "pink", "blue", "red", "green", "pink",
                "blue", "red", "green", "pink", "blue", "red", "green", "pink"};


        // creating the adaptor which'll store the items in the list
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                this,                   // Context
                R.layout.list_item_,     // Where to display the item
                items                   // From where to get the items
        );

        // putting the items onto the list
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(listAdapter);
    }

    private void listItemOnClickListener() {
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // we have chosen onItemClick because we want to chose wat happens when we click the
            // item in the list & not the complete list

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // It passes the parent, the view where the listItem is there, the position & its ID
                TextView textView = (TextView) view;
                String message = "#" + (position+1) + " " + textView.getText().toString();

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
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
