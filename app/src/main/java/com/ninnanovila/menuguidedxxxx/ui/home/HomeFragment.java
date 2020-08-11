package com.ninnanovila.menuguidedxxxx.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ninnanovila.menuguidedxxxx.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView h1Text = root.findViewById(R.id.h1_tv);
        final TextView h2Text = root.findViewById(R.id.h2_tv);
        final TextView h3Text = root.findViewById(R.id.h3_tv);
        final TextView h4Text = root.findViewById(R.id.h4_tv);
        final TextView h5Text = root.findViewById(R.id.h5_tv);
        final TextView h6Text = root.findViewById(R.id.h6_tv);
        final TextView s1Text = root.findViewById(R.id.s1_tv);
        final TextView s2Text = root.findViewById(R.id.s2_tv);
        final TextView b1Text = root.findViewById(R.id.b1_tv);
        final TextView b2Text = root.findViewById(R.id.b2_tv);
        final TextView btnText = root.findViewById(R.id.btn_tv);
        final TextView captionText = root.findViewById(R.id.caption_tv);
        final TextView overlineText = root.findViewById(R.id.over_line_tv);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                h1Text.setText(s);
                h2Text.setText(s);
                h3Text.setText(s);
                h4Text.setText(s);
                h5Text.setText(s);
                h6Text.setText(s);
                b1Text.setText(s);
                b2Text.setText(s);
                s1Text.setText(s);
                s2Text.setText(s);
                btnText.setText(s);
                captionText.setText(s);
                overlineText.setText(s);
            }
        });
        return root;
    }
}