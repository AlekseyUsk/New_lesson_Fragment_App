package com.hfad.new_lesson_fragment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_main);

        if (savedInstanceState == null) {
            GunsListFragment gunsListFragment = new GunsListFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.gun, gunsListFragment).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GunFragment gunFragment = new GunFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.detail_gun, gunFragment).commit();
            }
        }

    }
}