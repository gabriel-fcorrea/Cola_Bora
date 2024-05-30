package com.litha.colabora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class TimelineActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView btnMenu;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_layout);

        drawerLayout = findViewById(R.id.drawerLayout_timeline);
        navigationView = findViewById(R.id.navMenu_timeline);
        btnMenu = findViewById(R.id.imgMenu_timeline);
        bottomNavigationView = findViewById(R.id.bottomNavigation_timeline);

        navigationView.setCheckedItem(R.id.timeline);

        btnMenu.setOnClickListener(view -> {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView);
            } else {
                drawerLayout.openDrawer(navigationView);
            }
        });

        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    int id = menuItem.getItemId();

                    if (id == R.id.exit) {
                        startActivity(new Intent(TimelineActivity.this, LoginActivity.class));
                        finish();
                    }

                    drawerLayout.closeDrawers();
                    return true;
                }
        );

        // Exibir o fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FeedFragment())
                    .commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id2 = item.getItemId();

            if (id2 == R.id.bottom_item1) {
                selectedFragment = new FeedFragment();
            } else if (id2 == R.id.bottom_item2) {
                selectedFragment = new LoadingFragment();
            } else if (id2 == R.id.bottom_item3) {
                selectedFragment = new ConquestsFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
    }
}
