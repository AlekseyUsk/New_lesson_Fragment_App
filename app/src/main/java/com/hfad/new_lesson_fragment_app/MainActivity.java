package com.hfad.new_lesson_fragment_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_main);

        if (savedInstanceState == null) {
            GunsListFragment gunsListFragment = GunsListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.gun, gunsListFragment).commit();
        }
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