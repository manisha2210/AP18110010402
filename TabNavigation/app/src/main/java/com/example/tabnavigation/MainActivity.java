package com.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    ViewPager v;
    TabLayout tab;
    private int[] tabIcons = {
            R.drawable.ic_tab_contacts,
            R.drawable.ic_tab_favourite,
            R.drawable.ic_tab_call
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v=findViewById(R.id.pager);
        v.setAdapter(new TabAdapter(getSupportFragmentManager()));
        tab=findViewById(R.id.tab);
        tab.setupWithViewPager(v);
        Icons();
    }
    private void Icons() {
        tab.getTabAt(0).setIcon(tabIcons[0]);
        tab.getTabAt(1).setIcon(tabIcons[1]);
        tab.getTabAt(2).setIcon(tabIcons[2]);
    }

    class TabAdapter extends FragmentPagerAdapter{

        public TabAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Chats();
                case 1:
                    return new Status();
                case 2:
                    return new Calls();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chats";
                case 1:
                    return "Status";
                case 2:
                    return "Calls";
            }
            return super.getPageTitle(position);
        }

    }
}