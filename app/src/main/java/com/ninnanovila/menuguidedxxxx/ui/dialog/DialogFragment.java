package com.ninnanovila.menuguidedxxxx.ui.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.google.android.material.button.MaterialButton;
import com.ninnanovila.menuguidedxxxx.R;
import com.ninnanovila.menuguidedxxxx.ui.widget.WidgetFragment;

public class DialogFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dialog, container, false);

        final TextView fullNameText = root.findViewById(R.id.fullname_tv);
        final MaterialButton exitButton = root.findViewById(R.id.exit_btn);

        String fullName;
        if (getArguments() != null) {
            fullName = getArguments().getString(WidgetFragment.FULL_NAME);
        }else {
            fullName = "KEY IS NULL";
        }
        fullNameText.setText(fullName);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Are you sure to exit?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (getActivity()!=null){
                                    getActivity().finishAndRemoveTask();
                                }
                            }
                        })
                        .show();
            }
        });

        return root;
    }
}