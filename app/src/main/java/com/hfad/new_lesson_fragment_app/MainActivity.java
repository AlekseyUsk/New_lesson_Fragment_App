package com.hfad.new_lesson_fragment_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_drawer_fragment_activity);

        if (savedInstanceState == null) {
            GunsListFragment gunsListFragment = GunsListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.gun, gunsListFragment).commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);//нашел toolbar в макете и установил(достал из XML)
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.burger_open, R.string.burger_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings: {
                getSupportFragmentManager().beginTransaction().replace(R.id.gun, new AboutFragment()).addToBackStack("").commit();
                return true;
            }
            case R.id.action_exit: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * @param - КОСТЫЛЬ симулировал нажатие назад (тут для красоты)
     */
    @Override
    protected void onResume() {
        super.onResume();
        //ищем фрагмент который сидит в контейнере gun
        Fragment backStackFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.gun);
        //если такой есть, и он является GunFragment
        if (backStackFragment != null && backStackFragment instanceof GunFragment) {
            onBackPressed();  // то стимулируем нажатие кнопки onBackPressed - НАЗАД
        }
    }
}