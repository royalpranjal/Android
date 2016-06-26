package com.pranjal.swipetabs.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pranjal.swipetabs.Adapter.ViewPagerAdapter;
import com.pranjal.swipetabs.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        // view page can animate animate slide screens automatically

        final TabLayout.Tab home = tabLayout.newTab();
        final TabLayout.Tab info = tabLayout.newTab();
        final TabLayout.Tab sports = tabLayout.newTab();

        home.setText("Home");
        info.setText("Info");
        sports.setText("Sports");

        tabLayout.addTab(home, 0);
        tabLayout.addTab(info, 1);
        tabLayout.addTab(sports, 2);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}
