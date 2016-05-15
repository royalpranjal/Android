package pranjal.fragmentbasic;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragment my_fragment = new MyFragment();
        // making an object of the class

        FragmentManager my_fragment_manager = getFragmentManager();
        // getting a reference to the fragment manager

        // In fragments, we first begin the transaction,
        // add a fragment & then commit it

        FragmentTransaction my_fragment_transaction = my_fragment_manager.beginTransaction();
        // my fragment manager controls the transactions

        my_fragment_transaction.add(R.id.main_relative_layout, my_fragment, "my_fragment");
        // adding the fragment to the relative layout
        // adding a tag so that it can be identified by this tag later

        my_fragment_transaction.commit();



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
