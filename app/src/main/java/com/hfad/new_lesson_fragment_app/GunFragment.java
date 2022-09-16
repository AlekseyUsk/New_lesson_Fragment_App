package com.hfad.new_lesson_fragment_app;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

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
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), view);// создал popup меню
                requireActivity().getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());// заинфлейтил в это меню коркас меню
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_popup_clear: {
                                imageView.setImageAlpha(0);
                                return true;
                            }
                            case R.id.action_popup_exit: {
                                requireActivity().finish();
                                return true;
                            }
                        }
                        return false;
                    }
                });
                popupMenu.show();// вызвал меню
                return false;
            }
        });
    }
}