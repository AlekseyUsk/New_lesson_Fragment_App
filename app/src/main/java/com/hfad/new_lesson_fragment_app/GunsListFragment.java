package com.hfad.new_lesson_fragment_app;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GunsListFragment extends Fragment {

    public static GunsListFragment newInstance() {
        GunsListFragment fragment = new GunsListFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guns_list_, container, false);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] gun = getResources().getStringArray(R.array.gun);

        for (int i = 0; i < gun.length; i++) {
            String gunName = gun[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(35f);
            textView.setText(gunName);

            ((LinearLayout) view).addView(textView);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Gun gun = new Gun(finalI);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        GunFragment gunFragment = new GunFragment().newInstance(gun);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.detail_gun, gunFragment).commit();
                    } else {
                        GunFragment gunFragment = new GunFragment().newInstance(gun);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.gun, gunFragment).addToBackStack("").commit();
                    }
                }
            });
        }

    }
}