package com.example.urvish.demo.Activity;

import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.urvish.demo.Fragment.DemoFragment;
import com.example.urvish.demo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Collapsing_toolbar extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
//    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        toolbar = findViewById(R.id.abc);
        tabLayout = findViewById(R.id.tab_view);
//        viewPager = findViewById(R.id.view_pager);
        setSupportActionBar(toolbar);

        Fragment_adapter fragment_adapter = new Fragment_adapter(getSupportFragmentManager());
        fragment_adapter.add_fragment(new DemoFragment(), "ONE");
        fragment_adapter.add_fragment(new DemoFragment(), "TWO");
        fragment_adapter.add_fragment(new DemoFragment(), "THREE");
//        viewPager.setAdapter(fragment_adapter);
//        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


        }
        return true;
    }

    public class Fragment_adapter extends FragmentStatePagerAdapter {

        ArrayList<String> fragment_title = new ArrayList<>();
        ArrayList<Fragment> fragment_list = new ArrayList<>();

        public Fragment_adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragment_list.get(position);
        }

        @Override
        public int getCount() {
            return fragment_list.size();
        }

        public void add_fragment(Fragment fragment, String title) {
            fragment_title.add(title);
            fragment_list.add(fragment);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragment_title.get(position);
        }
    }
}
