package com.example.myapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myapplication.Adapter.MainPageViewPagerAdapter;
import com.example.myapplication.Fragment.AlarmFragment;
import com.example.myapplication.Fragment.CommunityFragment;
import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.ProfileFragment;
import com.example.myapplication.Fragment.TimeLineFragment;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout contentFrame;
    ViewPager container;
    HomeFragment homeFragment;
    TimeLineFragment timelineFragment;
    AlarmFragment alarmFragment;
    CommunityFragment communityFragment;
    ProfileFragment profileFragment;
    FloatingActionButton fab;
    public ArrayList<Fragment> fragments;
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBottomNavigationView();
        setFrameConstraint();
        generateFragment();

    }
    private void generateFragment(){
        homeFragment = HomeFragment.newInstance(this);
        timelineFragment = TimeLineFragment.newInstance(this);
        alarmFragment = AlarmFragment.newInstance(this);
        communityFragment = CommunityFragment.newInstance(this);
        profileFragment = ProfileFragment.newInstance(this);
        fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(timelineFragment);
//        fragments.add(communityFragment);
        fragments.add(alarmFragment);
        fragments.add(profileFragment);
        container = findViewById(R.id.container);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (communityFragment.isAdded()){
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.remove(communityFragment);
                    transaction.addToBackStack(null);
                    communityFragment = CommunityFragment.newInstance(MainActivity.this);
                    transaction.commit();
                }
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.content_fragment_layout, communityFragment);
                transaction.commit();
                bottomNavigationView.getMenu().getItem(2).setChecked(true);

            }
        });
        container.setAdapter(new MainPageViewPagerAdapter(getSupportFragmentManager(),this,fragments));
        container.setOffscreenPageLimit(3);
        container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("po",position+"");
                if(position < 2) {
                    bottomNavigationView.getMenu().getItem(position).setChecked(true);
                }else{
                    bottomNavigationView.getMenu().getItem(position+1).setChecked(true);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void setBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.lightgray)));
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(myOnNavigationItemSelectedListener);
    }
    private void setFrameConstraint(){
        contentFrame = findViewById(R.id.content_fragment_layout);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) contentFrame.getLayoutParams();
        params.bottomMargin = 210;
        contentFrame.setLayoutParams(params);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener myOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (communityFragment.isAdded()){
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(communityFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            Log.e("onNavi",item.getItemId()+"");
            switch (item.getItemId()) {
                case R.id.bottomIconHome:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_layout,fragments.get(0)).commit();
                    container.setCurrentItem(0);
                    return true;
                case R.id.bottomIconTimeLine:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_layout,timelineFragment).commit();
                    container.setCurrentItem(1);
                    return true;
                case R.id.bottomIconAlarm:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_layout,alarmFragment).commit();
                    container.setCurrentItem(2);
                    return true;
                case R.id.bottomIconGroup:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_layout,communityFragment).commit();
                    container.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };
}