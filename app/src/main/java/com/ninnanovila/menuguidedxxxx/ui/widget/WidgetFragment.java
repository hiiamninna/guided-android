package com.ninnanovila.menuguidedxxxx.ui.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ninnanovila.menuguidedxxxx.R;

public class WidgetFragment extends Fragment {

    public static final String FULL_NAME = "full_name";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_widget, container, false);
        final TextInputEditText firstNameInput = root.findViewById(R.id.firstname);
        final TextInputEditText lastNameInput = root.findViewById(R.id.lastname);

        final TextInputLayout firstNameLayout= root.findViewById(R.id.firstname_layout);
        final TextInputLayout lastNameLayout = root.findViewById(R.id.lastname_layout);
        MaterialButton sendButton = root.findViewById(R.id.send_btn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = String.valueOf(firstNameInput.getText());
                String last = String.valueOf(lastNameInput.getText());
                if (first.isEmpty()||last.isEmpty()){
                    firstNameLayout.setError("Please fill correctly.");
                    lastNameLayout.setError("Please fill correctly.");
                }else {
                    final String fullName = first + " " + last;
                    Bundle bundle = new Bundle();
                    bundle.putString(FULL_NAME, fullName);
                    Navigation.findNavController(v).navigate(R.id.action_nav_widget_to_nav_dialog, bundle);
                }
            }
        });
        return root;
    }
}