package com.litha.colabora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class TimelineActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_layout);

        drawerLayout = findViewById(R.id.drawerLayout_timeline);
        navigationView = findViewById(R.id.navMenu_timeline);
        btnMenu = findViewById(R.id.imgMenu_timeline);

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

                    if(id == R.id.exit){
                        startActivity(new Intent(TimelineActivity.this, LoginActivity.class));
                        finish();
                    }

                    drawerLayout.closeDrawers();
                    return true;
                }
        );


    }
}