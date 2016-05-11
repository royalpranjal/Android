package pranjal.complexlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private List<GOT> characters = new ArrayList<GOT>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList();
        populateListView();
    }

    private void populateList() {
        characters.add(new GOT("John", "Lord Commander", 2010, R.drawable.john));
        characters.add(new GOT("Denereys", "Mother of Dragons", 2010, R.drawable.khalesi));
        characters.add(new GOT("Cersei", "Bitch", 2010, R.drawable.cersei));
        characters.add(new GOT("Jamie", "King's Slayer", 2010, R.drawable.jamie));
        characters.add(new GOT("Tyrion", "Tits & Wines", 2010, R.drawable.tyrion));
        characters.add(new GOT("Arya", "A girl has no name", 2010, R.drawable.arya));
        characters.add(new GOT("Drogo", "Khal", 2010, R.drawable.khaldrogo));
        characters.add(new GOT("Eddard", "The most honourable man", 2010, R.drawable.eddard));
        characters.add(new GOT("Margaery", "The sexy", 2012, R.drawable.margaery));
        characters.add(new GOT("Bran", "Worf", 2010, R.drawable.bran));
        characters.add(new GOT("Melissandre", "The red woman", 2011, R.drawable.melisandre));
        characters.add(new GOT("Missandei", "The hot woman", 2014, R.drawable.missandei));
        characters.add(new GOT("Daario", "The horny", 2015, R.drawable.daario));
    }

    private void populateListView() {
        ArrayAdapter<GOT> adapter = new myListAdapter();
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);
    }

    private class myListAdapter extends ArrayAdapter<GOT>{

        public myListAdapter() {
            super(MainActivity.this, R.layout.list_item, characters);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //return super.getView(position, convertView, parent); ---> default
            //inflating the view if it is empty
            View currentView = convertView;
            if(currentView == null){
                currentView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            }

            GOT currentCharacter = characters.get(position);

            ImageView imageView = (ImageView)currentView.findViewById(R.id.list_item_imageView);
            imageView.setImageResource(currentCharacter.getIconID());

            TextView name = (TextView)currentView.findViewById(R.id.textViewName);
            name.setText(currentCharacter.getName());

            TextView description = (TextView)currentView.findViewById(R.id.textViewDescription);
            description.setText(currentCharacter.getDescription());

            TextView date = (TextView)currentView.findViewById(R.id.textViewYear);
            date.setText("" + currentCharacter.getDate()); // we need to convert it to string


            return currentView;
        }
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
