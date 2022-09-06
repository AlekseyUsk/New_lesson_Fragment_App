package com.hfad.new_lesson_fragment_app;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GunFragment extends Fragment {

    public static final String ARG_GUN = "gun";
    private Gun gun;

    public static GunFragment newInstance(Gun gun) {
        GunFragment fragment = new GunFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_GUN, gun);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gun, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gun = getArguments().getParcelable(ARG_GUN);
        ImageView imageView = view.findViewById(R.id.imageView);
        TypedArray images = getResources().obtainTypedArray(R.array.gun_images);
        imageView.setImageResource(images.getResourceId(gun.getIndex(), R.drawable.pistol));
       // Gun defaultGun = new Gun(0);
    }
}