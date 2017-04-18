package info.rishi.learnc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import info.rishi.fragments.programs.Basics;
import info.rishi.fragments.programs.Arrays;
import info.rishi.fragments.programs.Conversions;
import info.rishi.fragments.programs.Extras;
import info.rishi.fragments.programs.FileHandling;
import info.rishi.fragments.programs.Functns;
import info.rishi.fragments.programs.Looping;
import info.rishi.fragments.programs.Matrix;
import info.rishi.fragments.programs.Numbers;
import info.rishi.fragments.programs.Patterns;
import info.rishi.fragments.programs.Pointrs;
import info.rishi.fragments.programs.Recursn;
import info.rishi.fragments.programs.Strctrs;
import info.rishi.fragments.programs.Strng;

public class ProgramActivity extends AppCompatActivity {

    private TabLayout tabLayout1;
    private ViewPager viewPager1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();

        getSupportActionBar().setTitle(i.getExtras().getString("title"));

        viewPager1 = (ViewPager) findViewById(R.id.viewpager1);
        setupViewPager(viewPager1);

        tabLayout1 = (TabLayout) findViewById(R.id.tabs1);
        tabLayout1.setupWithViewPager(viewPager1);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setupViewPager(ViewPager viewPager1) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Basics(), "BASICS");
        adapter.addFrag(new Numbers(), "NUMBERS");
        adapter.addFrag(new Patterns(), "PATTERNS");
        adapter.addFrag(new Conversions(),"CONVERSIONS");
        adapter.addFrag(new Recursn(),"RECURSION");
        adapter.addFrag(new Arrays(), "ARRAY");
        adapter.addFrag(new Matrix(), "MATRIX");
        adapter.addFrag(new Strng(), "STRINGS");
         // adapter.addFrag(new Functns(),"FUNCTIONS");
        adapter.addFrag(new Pointrs(), "POINTERS");
        adapter.addFrag(new Strctrs(), "STRUCTURES");
        adapter.addFrag(new FileHandling(), "FILE HANDLING");
        adapter.addFrag(new Extras(),"EXTRAS");

        //adapter.addFrag(new Looping(),"LOOP");

        viewPager1.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itm = item.getItemId();
        switch (itm){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
