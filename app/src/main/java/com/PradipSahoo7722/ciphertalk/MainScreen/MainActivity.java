package com.PradipSahoo7722.ciphertalk.MainScreen;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.PradipSahoo7722.ciphertalk.Adapters.FragmentsAdapter;
import com.PradipSahoo7722.ciphertalk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {



//    ActivityMainBinding

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SearchView searchView;
    TabLayout tabLayout;
    ViewPager2 viewpager2;
    FloatingActionButton cameraBtn, messageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setContentView(R.layout.activity_main);
        /**
         * Set up hooks
         */
        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.mainScreen_Toolbar);
        searchView = findViewById(R.id.search_bar);
        tabLayout = findViewById(R.id.tab_layout);
        viewpager2 = findViewById(R.id.view_pager);
        cameraBtn = findViewById(R.id.favCamera);
        messageBtn = findViewById(R.id.favMessageStart);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerSlideAnimationEnabled(true);
        toggle.syncState();

        toolbar.setTitle(getString(R.string.app_name));

        FragmentsAdapter adapter = new FragmentsAdapter(getSupportFragmentManager(), getLifecycle());
        viewpager2.setAdapter(adapter);

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                changeFavIcon(position);
            }
        });

        tabLayout.addTab(tabLayout.newTab().setText("CHATS"));
        tabLayout.addTab(tabLayout.newTab().setText("GROUPS"));
        tabLayout.addTab(tabLayout.newTab().setText("STORIES"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

    private void changeFavIcon(final int index) {
//        favCamera.hide();
//        favMessageStart.hide();
        cameraBtn.hide();
        messageBtn.hide();

        new Handler().postDelayed(() -> {
            switch (index) {
                case 0:
                case 2:
                    cameraBtn.setImageDrawable(getDrawable(R.drawable.ic_baseline_photo_camera_24));
                    break;
                case 1:
                    messageBtn.setImageDrawable(getDrawable(R.drawable.ic_baseline_create_24));
                    break;
            }
//            favCamera.show();
//            favMessageStart.show();
            cameraBtn.show();
            messageBtn.show();
        }, 400);

    }
}